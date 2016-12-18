(ns tiddly-dragon.xml-sample)

(def spell-data
  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<compendium version=\"5\">
<!--Spell Attack rolls assume PROF added to roll, not applicable for Ranged while engaged in Melee range-->
<!--replaced \":\" as intro to list with \".\", and as in-line text with \" - \"-->
<!--after bold w/ : is implemented in app, check \"x - x:\" (e.g. \"Reincarnate\")-->
<!--after bold w/ : is implemented in app, check stats table from \"Animate Objects\"-->
<!--after bold w/ : is implemented in app, check \"Storm of Vengeance\"-->
	<spell>
		<name>Acid Splash</name>
		<level>0</level>
		<school>C</school>
		<time>1 action</time>
		<range>60 feet</range>
		<components>V, S</components>
		<duration>Instantaneous</duration>
		<classes>Sorcerer, Wizard, Fighter (Eldritch Knight), Rogue (Arcane Trickster)</classes>
		<text>You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.</text>
		<text />
		<text>This spells damage increases by 1d6 when you reach 5th Level (2d6), 11th level (3d6) and 17th level (4d6).</text>
		<roll>1d6</roll>
		<roll>2d6</roll>
		<roll>3d6</roll>
		<roll>4d6</roll>
	</spell>
	<spell>
		<name>Aid</name>
		<level>2</level>
		<school>A</school>
		<time>1 action</time>
		<range>30 feet</range>
		<components>V, S, M (a tiny strip of white cloth)</components>
		<duration>8 hours</duration>
		<classes>Cleric, Paladin</classes>
		<text>Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.</text>
		<text />
		<text>At Higher Levels: When you cast this spell using a spell slot of 3rd level or higher, a target's hit points increase by an additional 5 for each slot level above 2nd.</text>
	</spell>
	<spell>
		<name>Alarm</name>
		<level>1</level>
		<school>A</school>
		<ritual>YES</ritual>
		<time>1 minute</time>
		<range>30 feet</range>
		<components>V, S, M (a tiny bell and a piece of fine silver wire)</components>
		<duration>8 hours</duration>
		<classes>Ranger, Wizard, Fighter (Eldritch Knight)</classes>
		<text>You set an alarm against unwanted intrusion. Choose a door, a window, or an area within range that is no larger than a 20-foot cube. Until the spell ends, an alarm alerts you whenever a tiny or larger creature touches or enters the warded area. When you cast the spell, you can designate creatures that won't set off the alarm. You also choose whether the alarm is mental or audible.</text>
		<text />
		<text>A mental alarm alerts you with a ping in your mind if you are within 1 mile of the warded area. This ping awakens you if you are sleeping.</text>
		<text />
		<text>An audible alarm produces the sound of a hand bell for 10 seconds within 60 feet.</text>
	</spell>
	<spell>
		<name>Alter Self</name>
		<level>2</level>
		<school>T</school>
		<time>1 action</time>
		<range>Self</range>
		<components>V, S</components>
		<duration>Concentration, up to 1 hour</duration>
		<classes>Sorcerer, Wizard</classes>
		<text>You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. While the spell lasts, you can end one option as an action to gain the benefits of a different one.</text>
		<text />
		<text>Aquatic Adaptation: You adapt your body to an aquatic environment, sprouting gills, and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed.</text>
		<text />
		<text>Change Appearance: You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also don't appear as a creature of a different size than you, and your basic shape stays the same, if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again.</text>
		<text />
		<text>Natural Weapons: You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with you unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.</text>
		<roll>1d6+1</roll>
	</spell>
	<spell>
		<name>Animal Friendship</name>
		<level>1</level>
		<school>EN</school>
		<time>1 action</time>
		<range>30 feet</range>
		<components>V, S, M (a morsel of food)</components>
		<duration>24 hours</duration>
		<classes>Bard, Cleric (Nature), Druid, Ranger</classes>
		<text>This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast's Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell's duration. If you or one of your companions harms the target, the spell ends.</text>
		<text />
		<text>At Higher Levels: When you cast this spell using a 2nd level spell slot or higher, you can affect one additional beast for each slot level above 1st.</text>
	</spell>
</compendium>
")

(def monster-data
  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<compendium version=\"5\">
	<monster>
		<name>Air Elemental</name>
		<size>L</size>
		<type>elemental, monster manual</type>
		<alignment>neutral</alignment>
		<ac>15</ac>
		<hp>90 (12d10+24)</hp>
		<speed>fly 90 ft. (hover)</speed>
		<str>14</str>
		<dex>20</dex>
		<con>14</con>
		<int>6</int>
		<wis>10</wis>
		<cha>6</cha>
		<resist>lightning, thunder, bludgeoning, piercing, and slashing from nonmagical weapons</resist>
		<immune>poison</immune>
		<conditionImmune>exhaustion, grappled, paralyzed, petrified, poisoned, prone, restrained, unconscious</conditionImmune>
		<senses>darkvision 60 ft.</senses>
		<passive>10</passive>
		<languages>Auran</languages>
		<cr>5</cr>
		<trait>
			<name>Air Form</name>
			<text>The elemental can enter a hostile creature's space and stop there. It can move through a space as narrow as 1 inch wide without squeezing.</text>
		</trait>
		<action>
			<name>Multiattack</name>
			<text>The elemental makes two slam attacks.</text>
		</action>
		<action>
			<name>Slam</name>
			<text>Melee Weapon Attack: +8 to hit, reach 5 ft., one target. Hit: 14 (2d8 + 5) bludgeoning damage.</text>
			<attack>Slam|8|2d8+5</attack>
		</action>
		<action>
			<name>Whirlwind (Recharge 4-6)</name>
			<text>Each creature in the elemental's space must make a DC 13 Strength saving throw. On a failure, a target takes 15 (3d8 + 2) bludgeoning damage and is flung up 20 feet away from the elemental in a random direction and knocked prone. If a thrown target strikes an object, such as a wall or floor, the target takes 3 (1d6) bludgeoning damage for every 10 feet it was thrown. If the target is thrown at another creature, that creature must succeed on a DC 13 Dexterity saving throw or take the same damage and be knocked prone.</text>
			<text>If the saving throw is successful, the target takes half the bludgeoning damage and isn't flung away or knocked prone.</text>
		</action>
	</monster>
	<monster>
		<name>Air Elemental Myrmidon</name>
		<size>M</size>
		<type>elemental, elemental evil</type>
		<alignment>neutral</alignment>
		<ac>18 (plate)</ac>
		<hp>117 (18d8+36)</hp>
		<speed>30 ft., fly 30 ft.</speed>
		<str>18</str>
		<dex>14</dex>
		<con>14</con>
		<int>9</int>
		<wis>10</wis>
		<cha>10</cha>
		<resist>lightning, thunder, bludgeoning, piercing, and slashing from nonmagical weapons</resist>
		<immune>poison</immune>
		<conditionImmune>paralyzed, petrified, poisoned, prone</conditionImmune>
		<senses>darkvision 60 ft.</senses>
		<passive>10</passive>
		<languages>Auran, one language of its creator's choice</languages>
		<cr>7</cr>
		<trait>
			<name>Magic Weapons</name>
			<text>The myrmidon's weapon attacks are magical.</text>
		</trait>
		<action>
			<name>Multiattack</name>
			<text>The myrmidon makes three flail attacks.</text>
		</action>
		<action>
			<name>Flail</name>
			<text>Melee Weapon Attack: +7 to hit, reach 5 ft., one target. Hit: 8 (1d8 + 4) bludgeoning damage.</text>
			<attack>Flail|7|1d8+4</attack>
		</action>
		<action>
			<name>Lightning Strike (Recharge 6)</name>
			<text>The myrmidon makes one flail attack. If the attack hits, it deals an extra 18 (4d8) lightning damage, and the target must succeed on a DC 14 Constitution saving throw or be stunned until the end of the myrmidon's next turn.</text>
			<attack>Lightning Strike|7|1d8+4+4d8</attack>
		</action>
	</monster>
	<monster>
		<name>Allosaurus</name>
		<size>L</size>
		<type>beast, monster manual</type>
		<alignment>unaligned</alignment>
		<ac>15 (natural armor)</ac>
		<hp>60 (6d10+18)</hp>
		<speed>60 ft.</speed>
		<str>19</str>
		<dex>13</dex>
		<con>17</con>
		<int>2</int>
		<wis>12</wis>
		<cha>5</cha>
		<skill>Perception +5</skill>
		<passive>15</passive>
		<cr>2</cr>
		<trait>
			<name>Pounce</name>
			<text>If the allosaurus moves at least 30 ft. straight toward a creature and then hits it with a claw attack on the same turn, that target must succeed on a DC 13 Strength saving throw or be knocked prone. If the target is prone, the allosaurus can make one bite attack against it as a bonus action.</text>
		</trait>
		<action>
			<name>Bite</name>
			<text>Melee Weapon Attack: +6 to hit, reach 5 ft., one target. Hit: 15 (2d10 + 4) piercing damage.</text>
			<attack>Bite|6|2d10+4</attack>
		</action>
		<action>
			<name>Claw</name>
			<text>Melee Weapon Attack: +6 to hit, reach 5 ft., one target. Hit: 8 (1d8 + 4) slashing damage.</text>
			<attack>Claw|6|1d8+4</attack>
		</action>
	</monster>
	<monster>
		<name>Ankylosaurus</name>
		<size>H</size>
		<type>beast, monster manual</type>
		<alignment>unaligned</alignment>
		<ac>15 (natural armor)</ac>
		<hp>68 (8d12+16)</hp>
		<speed>30 ft.</speed>
		<str>19</str>
		<dex>11</dex>
		<con>15</con>
		<int>2</int>
		<wis>12</wis>
		<cha>5</cha>
		<passive>11</passive>
		<cr>3</cr>
		<action>
			<name>Tail</name>
			<text>Melee Weapon Attack: +7 to hit, reach 10 ft., one target. Hit: 18 (4d6 + 4) bludgeoning damage. If the target is a creature, it must succeed on a DC 14 Strength saving throw or be knocked prone.</text>
			<attack>Tail|7|4d6+4</attack>
		</action>
	</monster>
</compendium>")
