(ns tiddly-dragon.template
  (:require [clojure.java.io :refer (resource)]))

(defmacro deft
  "Read template from file in resources/"
  [symbol-name html-name]
  (let [content (slurp (resource html-name))]
    `(def ~symbol-name
       ~content)))
