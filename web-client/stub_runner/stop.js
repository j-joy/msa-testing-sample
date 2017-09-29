let fs = require('fs');
let process = require('process');

fs.readFile('.pid', 'utf8', function (err, data) {
    if(err) throw err;
    process.kill(data);
});