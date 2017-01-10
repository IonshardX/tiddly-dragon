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

(defn extract-type
  [t]
  (map tiddler/title-case (st/split t #", ")))

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
  (let [[type source] (-> entity :type extract-type)]
    (assoc entity
           :_type type
           :source source
           :size (get size-map (:size entity)))))

(defmethod tiddler/->text :monster
  [entity]
  (->> text-tags
       (map (partial text-tag-string entity))
       (apply str)))

(defmethod tiddler/->tags :monster
  [entity]
  [(tiddler/base-tag entity)
   (:_type entity)
   (str "CR " (:cr entity))])
