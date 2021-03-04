//import 와 같은 역할
var express = require('express');
var app = express();
//main.js 객체 가져와서 router에
var bodyParser = require('body-parser');
var session = require('express-session');
var fs = require('fs');

//HTML 위치 지정
app.set('views', __dirname + '/views');
//ejs 엔진을 이용해서 HTML을 랜더링 하도록 지정
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

var server = app.listen(3000, () => {

    console.log('Server has started')

});

app.use(express.static('public'));

app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(session({
    
    secret: '@#@$MyOrthography#@$#$',
    resave: false,
    saveUninitialized: true

}));


var router = require('./router/main')(app, fs);