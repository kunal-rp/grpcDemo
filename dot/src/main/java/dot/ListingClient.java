package dot;

import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Message;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import dot.listing.listinghandler.GetListingDataForUserRequest;
import dot.listing.listinghandler.GetListingDataForUserResponse;
import dot.listing.listinghandler.ListingHandlerGrpc;
import dot.listing.listinghandler.ListingHandlerGrpc.ListingHandlerBlockingStub;
import dot.listing.listinghandler.ListingHandlerGrpc.ListingHandlerStub;

/**
 * Sample client code that makes gRPC calls to the server.
 */
public class ListingClient {
  private static final Logger logger = Logger.getLogger(ListingClient.class.getName());

  private final ListingHandlerBlockingStub blockingStub;
  private final ListingHandlerStub asyncStub;

  private Random random = new Random();
  private TestHelper testHelper;

  /** Construct client for accessing Greeter server using the existing channel. */
  public ListingClient(Channel channel) {
    blockingStub = ListingHandlerGrpc.newBlockingStub(channel);
    asyncStub = ListingHandlerGrpc.newStub(channel);
  }

  public void getListingData(){
	  
    GetListingDataForUserResponse response = GetListingDataForUserResponse.getDefaultInstance();
    try {
      response = blockingStub.getListingDataForUser(GetListingDataForUserRequest.getDefaultInstance());
      if (testHelper != null) {
        testHelper.onMessage(response);
      }
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      if (testHelper != null) {
        testHelper.onRpcError(e);
      }
    }
     System.out.println(response);
  }


  private void info(String msg, Object... params) {
    logger.log(Level.INFO, msg, params);
  }

  private void warning(String msg, Object... params) {
    logger.log(Level.WARNING, msg, params);
  }


  /**
   * Only used for unit test, as we do not want to introduce randomness in unit test.
   */
  @VisibleForTesting
  void setRandom(Random random) {
    this.random = random;
  }

  /**
   * Only used for helping unit test.
   */
  @VisibleForTesting
  interface TestHelper {
    /**
     * Used for verify/inspect message received from server.
     */
    void onMessage(Message message);

    /**
     * Used for verify/inspect error received from server.
     */
    void onRpcError(Throwable exception);
  }

  @VisibleForTesting
  void setTestHelper(TestHelper testHelper) {
    this.testHelper = testHelper;
  }
}