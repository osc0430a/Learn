var main_page = (res, sess) => {

    res.render('index', {
        title: 'MY HOMEPAGE',
        length: 5,
        name: sess.name,
        username: sess.username
    });

}

var list_page = (fs, res) => {

    fs.readFile("./data/user.json", 'utf8', (err, data) => {

        console.log(data);
        res.end(data);

    });

}

var guest_page = (fs, res, username) => {

    fs.readFile("./data/user.json", 'utf8', (err, data) => {

        var users = JSON.parse(data);
        res.json(users[username]);

    });

}

var input_validTest = (req, res) => {

    var result = {};

    if (!req.body["password"] || !req.body["name"]) {
        result["success"] = 0;
        result["err"] = "invalid";
        res.json(result);
        return false;
    }

    return true;

}

var find_user = (res, username, users) => {

    var result = {};

    if (!users[username]) {

        result["success"] = 0;
        result["error"] = "not found";
        res.json(result);
        return false;

    }

    return true;

}

var duplicateTest = (res, username, result) => {

    if (users[username]) {

        result["success"] = 0;
        result["err"] = "duplicate";
        res.json(result);
        return false;

    }

    return true;

}

var write_JSON = (res, fs, users) => {

    var result = {};

    fs.writeFile(
        "./data/user.json",
        JSON.stringify(users, null, '\t'),
        'utf8',
        (err, data) => {

            result = {
                "success": 1
            };
            res.json(result);

        }
    );

}

var add_user = (req, res, fs, username) => {

    fs.readFile("./data/user.json", 'utf8', (err, data) => {

        var user = JSON.parse(data);

        if (!duplicateTest(res, username, result)) 
            return false;
        
        users[username] = req.body;

        write_JSON(res, fs, user);

    });

    return true;

}

var delete_user = (req, res, fs, username) => {

    var result = {};

    fs.readFile("./data/user.json", "utf8", (err, data) => {
        var users = JSON.parse(data);

        if (!find_user(res, username, users)) 
            return false;
        
        delete users[username];

        write_JSON(res, fs, users);

    })

    return true;

}

var update_user = (req, res, fs, username) => {

    fs.readFile("./data/user.json", 'utf8', (err, data) => {

        var users = JSON.parse(data);

        users[username] = req.body;

        write_JSON(res, fs, users);

    });

}


var match_password = (users, username, sess, password) => {   
    
    var result = {}; 
        
    if (users[username]["password"] == password) {

        result["success"] = 1;
        sess.username = username;
        sess.name = users[username]["name"];
        res.redirect("/");

    } else {

        result["success"] = 0;
        result["err"] = "incorrect";
        res.json(result);

    }

}


var user_login = (req, res, fs, sess) => {

    fs.readFile("./data/user.json", "utf8", (err, data) => {

        var users = JSON.parse(data);
        var username = req.params.username;
        var password = req.params.password;

        if (!find_user(res, username, users)) 
            return false;

        match_password(users, username, sess, password);

        return true;

    });

}

module.exports = (app, fs) => {

    app.get('/', (req, res) => {

        var sess = req.session;
        main_page(res, sess);

    });

    app.get('/list', (req, res) => {

        list_page(fs, res);

    });

    app.get('/getUser/:username', (req, res) => {

        var username = req.params.username;

        guest_page(fs, res, username);

    });

    app.post('/addUser/:username', (req, res) => {

        var username = req.params.username;

        input_validTest(req, res);

        if (!add_user(req, res, fs, username)) 
            return;

        }
    );

    app.put('/updateUser/:username', (req, res) => {

        var username = req.params.username;

        input_validTest(req, res);

        update_user(req, res, fs, username);

    });

    app.delete('/deleteUser/:username', (req, res) => {

        var username = req.params.username;

        if (!delete_user(req, res, fs, username)) 
            return;

        }
    )

    app.get("/login/:username/:password", (req, res) => {

        var sess = req.session;

        if (!user_login(req, res, fs, sess)) 
            return;

        }
    );

    app.get("/logout", (req, res) => {

        sess = req.session;
        if (sess.username) {
            req
                .session
                .destroy((err) => {
                    if (err) {
                        console.log(err);
                    } else {
                        res.redirect("/");
                    }
                });
        } else {

            res.redirect("/");

        }

    });

}