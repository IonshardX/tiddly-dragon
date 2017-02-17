(ns tiddly-dragon-import.tags.item
  (:require [tiddly-dragon-import.tiddler :as tiddler]))

(def type-map {"A" "Arrow"
               "G" "Grimoire"
               "HA" "Heavy Armor"
               "LA" "Light Armor"
               "M" "Melee Weapon"
               "MA" "Medium Armor"
               "P" "Potion"
               "R" "Ranged Weapon"
               "RD" "Rod"
               "RG" "Ring"
               "S" "Shield"
               "SC" "Scroll"
               "ST" "Staff"
               "W" "Wonderous Item"
               "WD" "Wand"
               "$" "Currency"})

(def dmgtype-map {"B" "Bludgeoning"
                  "P" "Piercing"
                  "S" "Slashing"})

(defmethod tiddler/prepare :item
  [entity]
  (assoc entity :_type (get type-map (:type entity))
                :_modifier (:modifier entity)
                :dmgType (get dmgtype-map (:dmgType entity))))

(defmethod tiddler/->tags :item
  [entity]
  [(tiddler/base-tag entity)
   (:_type entity)
   (:rarity entity)])
