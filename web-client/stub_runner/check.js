let request = require('requestretry');

const port = '8080';
const title = 'coffee-delivery'

request({
    url: `http://localhost:${port}/__admin/mappings`,
    maxAttempts: 10,
    retryDelay: 1000
}, function (err, res) {
    if (res) { console.log(`${title} stub started on port ${port}`);}
    if (err) { console.log(`fail to start ${title} stub on port ${port}`);}
});