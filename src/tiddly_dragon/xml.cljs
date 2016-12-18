(ns tiddly-dragon.xml
  (:require [tubax.core :refer [xml->clj]]
            [tubax.helpers :as th]))

(def xml-data (atom nil))

(defn ->name
  [entity]
  (-> entity
      (th/find-first {:tag :name})
      th/text))

(defn ->text
  [entity]
  (->> (th/find-all entity {:tag :text})
       (map th/text)
       (map #(str % "\n"))
       (apply str)))

(defmulti ->map :tag)

(defmethod ->map :default
  [entity]
  {:name (->name entity)
   :text (->text entity)
   :tag (:tag entity)})

(defn find-spells
  [xml]
  (->> {:tag :spell}
       (th/find-all xml)
       (map ->map)))

(defn get-data
  ([] (get-data @xml-data))
  ([xml]
   (->> xml
        xml->clj
        th/children
        (mapv ->map))))

(defn parse
  [xml]
  (reset! xml-data xml)
  (get-data xml))
