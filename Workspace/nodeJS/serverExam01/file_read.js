var fs = require('fs');

fs.readFile('home.js', 'utf-8', (err, data) => {

    console.log('01 readAsync: %s', data);

});

var data = fs.readFileSync('home.js', 'utf-8');
console.log('02 readSync: %s', data);