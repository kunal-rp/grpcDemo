  
'use strict';

const grpc = require('grpc');
const implementation = require('./clientimpl');

const PROTO_PATH = 'proto/userhandler.proto';
const PORT = 8980;

var protoLoader = require('@grpc/proto-loader');
var packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {keepCase: true,
     longs: String,
     enums: String,
     defaults: true,
     oneofs: true
    });
var userhandler = grpc.loadPackageDefinition(packageDefinition).userhandler;
var client = new userhandler.UserHandler('localhost:8980',
                                       grpc.credentials.createInsecure());


for(var i = 0; i < 1000; i++){
	implementation.getUserData(client);
}
