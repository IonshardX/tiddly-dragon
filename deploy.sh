#!/bin/bash
rm -rf deploy
mkdir deploy
lein clean
lein cljsbuild once min
cp -r resources/public/* deploy/
git checkout gh-pages
cp -r deploy/* .
git add .
git commit
git push origin gh-pages
git checkout master
