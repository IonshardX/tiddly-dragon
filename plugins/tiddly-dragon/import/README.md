# Tiddly Dragon

Tiddly Dragon is a simple webapp for converting DnDAppFiles XML into importable TiddlyWiki JSON files

## Overview

Using Tiddlywiki is a great way to manage a D&D campaign, this tool is to allow you to import wikified versions of the rules for Dungeons and Dragon's 5th Edition.

## Usage

1. Visit the [DnDAppFiles repo][appfiles] and download the desired XML file.
2. Visit [the tool page here][tool] and select that file.
3. The tool will automatically download a JSON file.
4. Visit your Tiddly Wiki and drag and drop that JSON file into it and import the tiddlers.

[appfiles]: (https://github.com/ceryliae/DnDAppFiles)
[tool]: (http://ionshard.com/tiddly-dragon/)

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2016 Victor Ling

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
