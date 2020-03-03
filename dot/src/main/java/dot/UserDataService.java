package dot;

import dot.user.userhandler.User;
import dot.user.userhandler.Location;
import dot.user.userhandler.UserContactInfo;
import dot.user.userhandler.GetUserDataRequest;
import dot.user.userhandler.GetUserDataResponse;
import dot.user.userhandler.UserHandlerGrpc.UserHandlerImplBase;

import io.grpc.stub.StreamObserver;

/**
   * Our implementation of UserData service.
   *
   * <p>See hello.proto for details of the methods.
   */
  public class UserDataService extends UserHandlerImplBase {

    UserDataService() {}

    @Override
    public void getUserData(GetUserDataRequest request, StreamObserver<GetUserDataResponse> responseObserver){
      System.out.println("get uesr data called");
      responseObserver.onNext(GetUserDataResponse.newBuilder().addUsers(
        User.newBuilder().setName("KUNAL PUROHNIT 3").setCity("SV").setId(request.getId()).setUserLocation(
          Location.newBuilder().setLatitude(101).build()).setContactInfo(
          UserContactInfo.newBuilder().setPhoneNumber(12345).build()).build()
        ).build());
      responseObserver.onCompleted();

    }
  }