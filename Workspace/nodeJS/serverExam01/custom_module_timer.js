var EventEmitter = require('events');
var sec = 3;

exports.timer = new EventEmitter();

setInterval( () => {

    exports.timer.emit('tick');

}, sec * 1000 );