const { spawn } = require('child_process');
var request = require('requestretry');


const port = '8080';
const title = `coffee-delivery`
var ids = `--stubrunner.ids=jjoy.msa-testing-sample:${title}:+:stubs:${port}`;

var runner = 'stub-runner-boot-1.1.3.RELEASE.jar';
var repository = '--stubrunner.repositoryRoot=http://mynexus@#@#:8081/repository/maven-snapshots/';
var workoffline = '--stubrunner.workOffline=true';

const subprocess = spawn('java', ['-jar', runner, ids, workoffline], {
    stdio: 'ignore',
    detached: true
});
const sb = subprocess.unref();

request({
    url: `http://localhost:${port}/__admin/mappings`,
    maxAttempts: 10,
    retryDelay: 1000
}, function (err, res) {
    if (res) { console.log(`${title} stub started on port ${port}. (pid: ${subprocess.pid})`);}
    if (err) { console.log(`fail to start ${title} stub on port ${port}.`);}
});