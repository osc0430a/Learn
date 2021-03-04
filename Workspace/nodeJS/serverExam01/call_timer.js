var module = require('./custom_module_timer');

module.timer.on('tick', (time) => {

    var time = new Date();
    console.log('Time: ' + time);

});

