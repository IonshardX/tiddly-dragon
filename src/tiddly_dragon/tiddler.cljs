(ns tiddly-dragon.tiddler
  (:require [clojure.string :as st]))

(defn title-case
  [s]
  (st/join " " (map st/capitalize (st/split s #"[ -_]"))))

(defmulti prepare :tag)

(defmethod prepare :default
  [entity]
  entity)

(defmulti ->title :tag)

(defmethod ->title :default
  [entity]
  (:name entity))

(defn kw->tag
  [kw]
  (-> kw
      name
      title-case))

(defn tagify
  [tag]
  (str "[[" tag "]]"))

(defn base-tag
  [entity]
  (-> entity :tag kw->tag))

(defn stringify-tabs
  [tags]
  (->> tags
       flatten
       set
       (map st/trim)
       (map tagify)
       (st/join " ")))

(defmulti ->tags :tag)

(defmethod ->tags :default
  [entity]
  (base-tag entity))

(defmulti ->text :tag)

(defmethod ->text :default
  [entity]
  (:text entity))

(defn ->tiddler
  [entity]
  (-> entity
      prepare
      (assoc :title (->title entity)
             :tags (stringify-tabs (->tags entity))
             :text (->text entity)
             :type "text/vnd.tiddlywiki")))
