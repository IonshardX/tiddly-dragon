#!/bin/bash

cd plugins/tiddly-dragon/import
lein clean
lein cljsbuild once min
cd ..
(cat wrappers/import.beg.txt; cat import/resources/public/js/compiled/tiddly_dragon_import.js; cat wrappers/import.end.txt;) > modules/import.js
git submodule update
(cat wrappers/dice-roller.beg.txt; cat rpg-dice-roller/dice-roller.js;) > modules/dice-roller.js
