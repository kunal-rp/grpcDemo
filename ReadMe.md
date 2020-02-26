Example of grpc w/ Java server and JS client

Things to Know:
1) Server and client do NOT share proto
-Each have their own proto, adding update to one msg on the client means updating the same on server
-If one is updated and the other is not, that additional mesasge is not viewable to the client/server
-If the message is added(same name) but has different field number, the field is present in request, but will be default

2)Dot is the name of product

RUNNING EVERYTHING -----------------------------
Microservices are basicaclly software as a sevice

In current setup, two micro services run on two seperate servers. Look @ runApp in build.gradle
-"gradle -Pm=c runApp" to run UserData Server 8981
-"gradle -Pm=c -Pl=t runApp" to run Listing Server 8982
-"gralde runApp" to run runClient

User Data server will just return some static user data w/ contact info
UserDataClient shows how to call service on java, for client or server. 

dotClient makes call to UserData server and gets the static user data

WHAT ABOUT CALLING MICROSERVICES FROM ANOTHER MICROSERVICE?
Use the Client in a service file !

Look @ ListingService ; notice how we instantiate UserDataClient.
ASSUMPTION is made that the port passed in channel is where the sever serving the UserDataService is.

We make call to get static user data, get contact info, return in the listing data response

COPYING THE BOILERPLATE TO ANOTHER PROJECT -----------------------------

Server:
1) gradle init, update gradle build file
-Just copy the gradle.build file to project

2) within src add java and proto dir
-update proto with messages needed

3) build the project (gradle clean build)

4)in java folder create server file
-copy and update all imports for the msg constructors
-will need to define service in same/other file that will handle request and response of server method
-copy the implementation of the '...Server' for the blocking and unblocking stubs


5) run server, see if everything works!
*NOTE* There is a client file that references same proto as server, this is just to show how java client would work, clients would be in different dir

Client:
1) Create dir , node init

2) Add in dependencies
-gRPC
-google-protobuf
-@gRPC/proto-loader

3)add in proto file
-copy from server ideally

4)create client
-client implementation will hold methods passed client and make the call to the service method on server
-client will create client by parsing proto file (w/service), specifiying url , inistantiation implementation, and making call 
