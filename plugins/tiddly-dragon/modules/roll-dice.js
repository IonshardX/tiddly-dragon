/*\
title: $:/plugins/ionshard/tiddly-dragon/macros/roll-dice.js
type: application/javascript
module-type: macro

Macro to roll dice based on a notation
See: https://en.wikipedia.org/wiki/Dice_notation
<<roll-dice notation:"4d20-L">>

\*/
(function(){

    /*jslint node: true, browser: true */
    /*global $tw: false */
    "use strict";

    var lib = require("$:/plugins/ionshard/tiddly-dragon/library/dice-roller.js");

    exports.name = "roll-dice";

    exports.params = [
        {name: "notation"}
    ];

    exports.run = function(notation) {
        var roll = new lib.DiceRoll(notation);
        return roll.toString();
    };
})();

