#!/bin/bash
rm -rf output
scripts/build.sh
tiddlywiki --build index
git checkout tiddlers/\$__StoryList.tid
git checkout gh-pages
git pull
cp output/index.html .
git add .
git commit
git push origin gh-pages
git checkout master
