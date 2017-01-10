#!/bin/bash

cd plugins/tiddly-dragon/import
lein clean
lein cljsbuild once min
cd ..
(cat import/support/wrapper.beg.txt; cat import/resources/public/js/compiled/tiddly_dragon_import.js; cat import/support/wrapper.end.txt;) > modules/import.js

