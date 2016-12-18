(ns tiddly-dragon.core
  (:require [tiddly-dragon.tiddler :as tiddler]
            [tiddly-dragon.xml :as xml]))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(defn clj->json
  [ds]
  (.stringify js/JSON (clj->js ds)))

(defn- save-file
  [filename content]
  (let [lnk (js/document.getElementById "file-export-link")
        blob (js/Blob. (js/Array. content) {:type "application/json"})]
    (set! (.-href lnk) (.createObjectURL js/URL blob))
    (set! (.-download lnk) filename)
    (.click lnk)))

(defn convert-file
  [e]
  (->> e
       .-target
       .-result
       xml/parse
       (map tiddler/->tiddler)
       clj->json
       (save-file "TODO.json")))

(defn import-file
  [file-input]
  (let [rdr (js/FileReader.)
        first-file (aget (.-files file-input) 0)]
    (set! (.-onload rdr) convert-file)
    (.readAsText rdr first-file))
  (set! (.-value file-input) "")
  (js/console.log "File Imported"))
