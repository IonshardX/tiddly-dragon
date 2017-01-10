/*\
title: $:/plugins/ionshard/tiddly-dragon/action-rolldice.js
type: application/javascript
module-type: widget

Action widget to set a single field or index on a tiddler to the result of a dice roll.

\*/
(function(){

    /*jslint node: true, browser: true */
    /*global $tw: false */
    "use strict";

    var lib = require("$:/plugins/ionshard/tiddly-dragon/dice-roller.js");

    var Widget = require("$:/core/modules/widgets/widget.js").widget;

    var RollDiceWidget = function(parseTreeNode,options) {
        this.initialise(parseTreeNode,options);
    };

    /*
      Inherit from the base widget class
    */
    RollDiceWidget.prototype = new Widget();

    /*
      Render this widget into the DOM
    */
    RollDiceWidget.prototype.render = function(parent,nextSibling) {
        this.computeAttributes();
        this.execute();
    };

    /*
      Compute the internal state of the widget
    */
    RollDiceWidget.prototype.execute = function() {
        this.actionTiddler = this.getAttribute("$tiddler",this.getVariable("currentTiddler"));
        this.actionField = this.getAttribute("$field", "text");
        this.actionIndex = this.getAttribute("$index");
        this.actionNotation = this.getAttribute("$notation");
        this.actionTimestamp = this.getAttribute("$timestamp","yes") === "yes";
    };

    /*
      Refresh the widget by ensuring our attributes are up to date
    */
    RollDiceWidget.prototype.refresh = function(changedTiddlers) {
        var changedAttributes = this.computeAttributes();
        if(changedAttributes["$tiddler"] || changedAttributes["$field"] || changedAttributes["$index"] || changedAttributes["$notation"]) {
            this.refreshSelf();
            return true;
        }
        return this.refreshChildren(changedTiddlers);
    };

    /*
      Invoke the action associated with this widget
    */
    RollDiceWidget.prototype.invokeAction = function(triggeringWidget,event) {
        var options = {};
        options.suppressTimestamp = !this.actionTimestamp;
        if((typeof this.actionField == "string") || (typeof this.actionIndex == "string")  || (typeof this.actionNotation == "string")) {
            var roll = new lib.DiceRoll(this.actionNotation);
            this.wiki.setText(this.actionTiddler,this.actionField,this.actionIndex,roll.toString(),options);
        }
        return true; // Action was invoked
    };

    exports["action-rolldice"] = RollDiceWidget;

})();

