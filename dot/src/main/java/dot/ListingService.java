package dot;

import dot.listing.listinghandler.Listing;
import dot.listing.listinghandler.GetListingDataForUserRequest;
import dot.listing.listinghandler.GetListingDataForUserResponse;
import dot.listing.listinghandler.ListingHandlerGrpc.ListingHandlerImplBase;
 
import dot.user.userhandler.GetUserDataResponse;
import dot.user.userhandler.UserContactInfo;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;

import io.grpc.stub.StreamObserver;

import dot.UserDataClient;

/**
   * Our implementation of UserData service.
   *
   * <p>See hello.proto for details of the methods.
   */
public class ListingService extends ListingHandlerImplBase {

  final static String USER_DATA_SERVER_TARGET = "localhost:8981";

   ListingService() {}

  @Override
  public void getListingDataForUser(GetListingDataForUserRequest request, StreamObserver<GetListingDataForUserResponse> responseObserver){
    System.out.println("get LISTING DATA called");

    UserContactInfo contactInfo;
    try{
      contactInfo = getContactInfoFromUserId(request);
    } catch(Exception e){
      contactInfo = UserContactInfo.getDefaultInstance();
    }


    responseObserver.onNext(GetListingDataForUserResponse
      .newBuilder()
      .setUserContactInfo(contactInfo)
      .build());
    responseObserver.onCompleted();

  }

  private UserContactInfo getContactInfoFromUserId(GetListingDataForUserRequest getListingRequest) throws Exception{
    ManagedChannel channel = ManagedChannelBuilder.forTarget(USER_DATA_SERVER_TARGET).usePlaintext(true).build();
    UserContactInfo contactInfo;
    try {
      UserDataClient client = new UserDataClient(channel);
       contactInfo = client.getUserData(getListingRequest.getUserId()).getUsers(0).getContactInfo();
    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }

    return contactInfo;

  }

}