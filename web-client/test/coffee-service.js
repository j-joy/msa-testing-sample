var assert = require('assert');
const request = require('supertest');

var deliveryCoffeService = 'http://localhost:8080'


describe('File APIs', function() {
    describe('GET /folders', function() {
        it('should return folder id', function(done) {
            request(deliveryCoffeService)
                .get('/coffees')
                // .set('Content-Type', 'application/json')
                .expect(200, [
                    {name:'Americano'},
                    {name:'Caffee Latte'},
                    {name:'Esspresso'}
                ], done);

        });
    });
});