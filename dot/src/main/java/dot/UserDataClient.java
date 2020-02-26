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

import dot.user.userhandler.GetUserDataRequest;
import dot.user.userhandler.GetUserDataResponse;
import dot.user.userhandler.UserHandlerGrpc;
import dot.user.userhandler.UserHandlerGrpc.UserHandlerBlockingStub;
import dot.user.userhandler.UserHandlerGrpc.UserHandlerStub;

/**
 * Sample client code that makes gRPC calls to the server.
 */
public class UserDataClient {
  private static final Logger logger = Logger.getLogger(UserDataClient.class.getName());

  private final UserHandlerBlockingStub blockingStub;
  private final UserHandlerStub asyncStub;

  private Random random = new Random();
  private TestHelper testHelper;

  /** Construct client for accessing Greeter server using the existing channel. */
  public UserDataClient(Channel channel) {
    blockingStub = UserHandlerGrpc.newBlockingStub(channel);
    asyncStub = UserHandlerGrpc.newStub(channel);
  }

  public void getUserData(){
	   handleRequest(GetUserDataRequest.getDefaultInstance());
  }

  public GetUserDataResponse getUserData(int user_id){
    return handleRequest(GetUserDataRequest.newBuilder().setId(user_id).build());
  }

  private GetUserDataResponse handleRequest(GetUserDataRequest request){

    GetUserDataResponse response = GetUserDataResponse.getDefaultInstance();
    try {
      response = blockingStub.getUserData(request);
      if (testHelper != null) {
        testHelper.onMessage(response);
      }
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      if (testHelper != null) {
        testHelper.onRpcError(e);
      }
    }

    return response;
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