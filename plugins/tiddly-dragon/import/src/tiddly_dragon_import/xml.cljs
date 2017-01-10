(ns tiddly-dragon-import.xml
  (:require [tubax.core :refer [xml->clj]]
            [tubax.helpers :as th]
            [clojure.string :as st]))

(declare tag-parsers)

(def xml-data (atom nil))

(defn first-tag
  [tag xml]
  (->> {:tag tag}
       (th/find-first xml)
       th/text))

(defn all-tags
  [tag xml]
  (->> {:tag tag}
       (th/find-all xml)
       (mapv th/text)))

(defn join-text
  ([tag xml] (join-text "\n" tag xml))
  ([seperator tag xml]
   (->> xml
        (all-tags tag)
        (st/join seperator))))

(defn ->classes
  [tag xml]
  (all-tags tag xml))

(defn base-entity
  [xml]
  {:name (first-tag :name xml)
   :text (join-text :text xml)
   :tag (:tag xml)})

(defn parse-tag
  [xml m tag-parser]
  (let [[tag parser] (if (sequential? tag-parser) tag-parser [tag-parser first-tag])
        value (parser tag xml)]
    (if (not-empty value)
      (assoc m tag value)
      m)))

(defn add-tag
  [tag xml]
  (assoc xml :tag tag))

(defn ->map
  [xml]
  (->> xml
       :tag
       (get tag-parsers)
       (reduce (partial parse-tag xml) {})
       (add-tag (:tag xml))))

(defn subtag
  [tag xml]
  (->> {:tag tag}
       (th/find-all xml)
       (mapv ->map)))

(defn get-data
  ([] (get-data @xml-data))
  ([xml]
   (->> xml
        xml->clj
        th/children
        (map ->map)
        (filterv not-empty))))

(defn parse
  [xml]
  (reset! xml-data xml)
  (get-data xml))

(def tag-parsers {:spell [:name :level :ritual :school :time :range :components :duration :classes [:text join-text] [:roll (partial join-text ", ")]]
                  :monster [:name :size :type :alignment :ac :hp :speed
                            :str :dex :con :int :wis :cha
                            :save :skill
                            :resist :vulnerable :immune :conditionImmune
                            :senses :passive :languages :cr
                            [:trait subtag]
                            [:action subtag]
                            [:reaction subtag]
                            [:legendary subtag]
                            :spells
                            :description]
                  :trait [:name [:text join-text] :attack]
                  :action [:name [:text join-text] :attack]
                  :reaction [:name [:text join-text] :attack]
                  :legendary [:name [:text join-text] :attack]
                  :item [:name [:text join-text] [:modifier join-text] :ac :property :type
                         :dmg2 :dmg1 :strength :weight :roll :dmgType :rarity :stealth :range]})

