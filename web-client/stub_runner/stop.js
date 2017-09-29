const fs = require('fs');
const process = require('process');

fs.readFile('.pid', 'utf8', function (err, data) {
    if(err) throw err;
    process.kill(data);
});