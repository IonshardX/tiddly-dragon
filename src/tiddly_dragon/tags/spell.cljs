(ns tiddly-dragon.tags.spell
  (:require [tiddly-dragon.tiddler :as tiddler]
            [clojure.string :as st]))

(def school-map {"A" "Abjuration"
                 "C" "Conjuration"
                 "D" "Divination"
                 "EN" "Enchantment"
                 "EV" "Evocation"
                 "I" "Illusion"
                 "N" "Necromancy"
                 "T" "Transmutation"})

(defmethod tiddler/prepare :spell
  [entity]
  (update entity :school school-map))

(defmethod tiddler/->tags :spell
  [entity]
  [(tiddler/base-tag entity)
   (st/split (:classes entity) #", ")
   (str "Level " (:level entity))])
