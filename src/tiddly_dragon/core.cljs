(ns tiddly-dragon.core
  (:require ))

(enable-console-print!)

(println "This text is printed from src/tiddly-dragon/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(defn clj->json
  [ds]
  (.stringify js/JSON (clj->js ds)))

(def example-tiddler {:text "This is the text of the tiddler"
                      :title "Tiddler Title"
                      :tags "[[a tag]]"
                      :type "text/vnd.tiddlywiki"
                      :field "field value"})

(defn- save-file
  [filename content]
  (let [lnk (js/document.getElementById "file-export-link")
        blob (js/Blob. (js/Array. content) {:type "application/json"})]
    (set! (.-href lnk) (.createObjectURL js/URL blob))
    (set! (.-download lnk) filename)
    (.click lnk)))
