cordova.define("com.berheley.main.plugins.OnlineUpdate.OnlineUpdate", function(require, exports, module) { 
	var exec = require("cordova/exec");
	var OnlineUpdate ={
	};
	OnlineUpdate.down = function(array) {
	    exec(null, null, "OnlineUpdate", "exportJjyxbg", array);
	};
	module.exports = OnlineUpdate;
});
