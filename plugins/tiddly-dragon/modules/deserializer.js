/*\
title: $:/plugins/ionshard/tiddly-dragon/tiddlerdeserializers/deserializer.js
type: application/javascript
module-type: tiddlerdeserializer
Tiddly Dragon deserializer to allow importing DnDAppFiles
See: https://github.com/ceryliae/DnDAppFiles
\*/
(function(){

    /*jslint node: true, browser: true */
    /*global $tw: false */
    "use strict";

    var td_import = require("$:/plugins/ionshard/tiddly-dragon/library/import.js");

    exports["text/xml"] = function(text,fields) {
        return td_import.core.convert_xml(text);
    };
})();

