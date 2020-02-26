const fs = require('fs');
const grpc = require('grpc');

module.exports = {
    getUserData: function (client) {
        const time = Date.now();
        const md = new grpc.Metadata();
        md.add("username", 'Alexis');
        md.add("password", "12345");

        client.getUserData({ id:1 }, md, function (err, response) {
            if (err)
                console.log(err);
            else
               console.log(Date.now() - time)
        });
    }
}