(ns tiddly-dragon-import.core
  (:require [tiddly-dragon-import.tiddler :as tiddler]
            [tiddly-dragon-import.tags.item]
            [tiddly-dragon-import.tags.monster]
            [tiddly-dragon-import.tags.spell]
            [tiddly-dragon-import.xml :as xml]
            [clojure.string :as st]))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(defn js->json
  [ds]
  (.stringify js/JSON ds))

(defn- save-file
  [filename content]
  (let [lnk (js/document.getElementById "file-export-link")
        blob (js/Blob. (js/Array. content) {:type "application/json"})]
    (set! (.-href lnk) (.createObjectURL js/URL blob))
    (set! (.-download lnk) filename)
    (.click lnk)))

(defn convert-xml
  [xml]
  (->> xml
       xml/parse
       (map tiddler/->tiddler)
       clj->js))

(defn convert-file
  [filename e]
  (->> e
       .-target
       .-result
       convert-xml
       js->json
       (save-file (str filename ".json"))))


(defn import-file
  [file-input]
  (let [rdr (js/FileReader.)
        first-file (aget (.-files file-input) 0)
        filename (-> first-file .-name (st/split ".") first)]
    (set! (.-onload rdr) (partial convert-file filename))
    (.readAsText rdr first-file))
  (set! (.-value file-input) "")
  (js/console.log "File Imported"))
