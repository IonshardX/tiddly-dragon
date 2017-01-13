(ns tiddly-dragon-import.tags.monster
  (:require [tiddly-dragon-import.tiddler :as tiddler]
            [clojure.string :as st]))

(def headers {:action "Actions"
              :trait "Traits"
              :reaction "Reactions"
              :legendary "Legendary Actions"})

(def text-tags [:trait :action :reaction :legendary])

(def size-map {"G" "Gargantuan"
               "H" "Huge"
               "L" "Large"
               "M" "Medium"
               "S" "Small"
               "T" "Tiny"})

(defn extract-parts
  [s]
  (->> (st/split s #"[\(\),]")
       (map st/trim)
       (remove empty?)))

(defn extract-type
  [t]
  (let [[type subtype source] (map tiddler/title-case (extract-parts t))]
    (if source
      [type subtype source]
      [type nil subtype])))

(defn sub-tag->text
  [sub-tag]
  (str "!!! " (:name sub-tag) "\n"
       (st/replace (:text sub-tag)
                   #"([A-Z][A-Za-z ]*:)"
                   "''$1''")
       "\n\n"))

(defn text-tag-string
  [entity tag]
  (when-let [sub-tags (tag entity)]
    (apply str "!! " (headers tag) "\n"
           (map sub-tag->text sub-tags))))

(defmethod tiddler/prepare :monster
  [entity]
  (let [[type subtype source] (-> entity :type extract-type)
        [hp hd] (-> entity :hp extract-parts)]
    (assoc entity
           :_type type
           :subtype subtype
           :source source
           :size (get size-map (:size entity))
           :hp hp
           :hd hd)))

(defmethod tiddler/->text :monster
  [entity]
  (->> text-tags
       (map (partial text-tag-string entity))
       (apply str)))

(defmethod tiddler/->tags :monster
  [entity]
  [(tiddler/base-tag entity)
   (:_type entity)
   (:subtype entity)
   (:source entity)
   (str "CR " (:cr entity))])

