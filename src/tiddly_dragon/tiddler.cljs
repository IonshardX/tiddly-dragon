(ns tiddly-dragon.tiddler
  (:require [clojure.set :as set]))

(def example-tiddler {:text "This is the text of the tiddler"
                      :title "Tiddler Title"
                      :tags "[[a tag]]"
                      :type "text/vnd.tiddlywiki"
                      :field "field value"})

(defn name->title
  [entity]
  (set/rename-keys entity {:name :title}))

(defmulti ->tiddler :tag)

(defmethod ->tiddler :default
  [entity]
  (->> entity
       name->title))
