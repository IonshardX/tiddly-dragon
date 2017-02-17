(ns tiddly-dragon-import.tiddler
  (:require [clojure.string :as st]))

(def global-tag "[[TiddlyDragon]] ")

(defn title-case
  [s]
  (->> (st/split s #"[ _]")
       (map st/capitalize)
       (st/join " ")))

(defmulti prepare :tag)

(defmethod prepare :default
  [{:keys [type] :as entity}]
  (if type
    (assoc entity :_type (:type entity))
    entity))

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
       (remove nil?)
       set
       (map st/trim)
       (map tagify)
       (st/join " ")))

(defmulti ->tags :tag)

(defmethod ->tags :default
  [entity]
  [(base-tag entity)])

(defmulti ->text :tag)

(defmethod ->text :default
  [entity]
  (:text entity))

(defn ->tiddler
  [xml]
  (let [entity (prepare xml)]
    (assoc entity
           :title (->title entity)
           :tags (->> entity ->tags stringify-tabs (str global-tag))
           :text (->text entity)
           :type "text/vnd.tiddlywiki"
           :modifier "")))
