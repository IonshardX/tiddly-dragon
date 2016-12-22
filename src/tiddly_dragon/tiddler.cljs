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

(defmulti ->tags :tag)

(defn kw->tag
  [kw]
  (-> kw
      name
      title-case))

(defn tagify
  [tag]
  (str "[[" tag "]]"))

(defmethod ->tags :default
  [entity]
  [(-> entity :tag kw->tag tagify)])

(defmulti ->text :tag)

(defmethod ->text :default
  [entity]
  (:text entity))

(defn ->tiddler
  [entity]
  (-> entity
      prepare
      (assoc :title (->title entity)
             :tags (->tags entity)
             :text (->text entity)
             :type "text/vnd.tiddlywiki")))
