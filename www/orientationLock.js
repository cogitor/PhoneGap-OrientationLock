function OrientationLock() {}

OrientationLock.prototype.lock = function(orientation, win, fail) {
    return cordova.exec(
            function (args) { if(win !== undefined) { win(args); } }, 
            function (args) { if(fail !== undefined) { fail(args); } }, 
            "OrientationLock", 
            "lock", 
            [orientation]);    
};

OrientationLock.prototype.unlock = function(win, fail) {
    return cordova.exec(
            function (args) { if(win !== undefined) { win(args); } },
            function (args) { if(fail !== undefined) { fail(args); } },
            "OrientationLock", 
            "unlock", 
            []);	
};

//PhoneGap.addConstructor(function() {
//    PhoneGap.addPlugin('OrientationLock', new OrientationLock());
//});

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.OrientationLock) {
    window.plugins.OrientationLock = new OrientationLock();
}

