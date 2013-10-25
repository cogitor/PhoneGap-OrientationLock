cordova.define("orientationLock", function(require, exports, module) {
    var exec = require('cordova/exec');
    
    var OrientationLock = function() {};

    OrientationLock.prototype.lock = function(orientation, win, fail) {
        return exec(
                function (args) { if(win !== undefined) { win(args); } }, 
                function (args) { if(fail !== undefined) { fail(args); } }, 
                "OrientationLock", 
                "lock", 
                [orientation]); 
    };

    OrientationLock.prototype.unlock = function(win, fail) {
        return exec(
                function (args) { if(win !== undefined) { win(args); } }, 
                function (args) { if(fail !== undefined) { fail(args); } },
                "OrientationLock", 
                "unlock", 
                []);    
    };

    var orientationLock = new OrientationLock();
    module.exports = orientationLock;
});

if (!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.orientationLock) {
    window.plugins.orientationLock = cordova.require("orientationLock");
}
