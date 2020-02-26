package dot.user.userhandler;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Handles all things user
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.1.2)",
    comments = "Source: userhandler.proto")
public class UserHandlerGrpc {

  private UserHandlerGrpc() {}

  public static final String SERVICE_NAME = "userhandler.UserHandler";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dot.user.userhandler.GetUserDataRequest,
      dot.user.userhandler.GetUserDataResponse> METHOD_GET_USER_DATA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "userhandler.UserHandler", "getUserData"),
          io.grpc.protobuf.ProtoUtils.marshaller(dot.user.userhandler.GetUserDataRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(dot.user.userhandler.GetUserDataResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserHandlerStub newStub(io.grpc.Channel channel) {
    return new UserHandlerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserHandlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserHandlerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static UserHandlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserHandlerFutureStub(channel);
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static abstract class UserHandlerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getUserData(dot.user.userhandler.GetUserDataRequest request,
        io.grpc.stub.StreamObserver<dot.user.userhandler.GetUserDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USER_DATA, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_USER_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                dot.user.userhandler.GetUserDataRequest,
                dot.user.userhandler.GetUserDataResponse>(
                  this, METHODID_GET_USER_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class UserHandlerStub extends io.grpc.stub.AbstractStub<UserHandlerStub> {
    private UserHandlerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserHandlerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserHandlerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserHandlerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getUserData(dot.user.userhandler.GetUserDataRequest request,
        io.grpc.stub.StreamObserver<dot.user.userhandler.GetUserDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USER_DATA, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class UserHandlerBlockingStub extends io.grpc.stub.AbstractStub<UserHandlerBlockingStub> {
    private UserHandlerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserHandlerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserHandlerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserHandlerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public dot.user.userhandler.GetUserDataResponse getUserData(dot.user.userhandler.GetUserDataRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USER_DATA, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class UserHandlerFutureStub extends io.grpc.stub.AbstractStub<UserHandlerFutureStub> {
    private UserHandlerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserHandlerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserHandlerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserHandlerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dot.user.userhandler.GetUserDataResponse> getUserData(
        dot.user.userhandler.GetUserDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USER_DATA, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_DATA = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserHandlerImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(UserHandlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_DATA:
          serviceImpl.getUserData((dot.user.userhandler.GetUserDataRequest) request,
              (io.grpc.stub.StreamObserver<dot.user.userhandler.GetUserDataResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UserHandlerDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dot.user.userhandler.Userhandler.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserHandlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserHandlerDescriptorSupplier())
              .addMethod(METHOD_GET_USER_DATA)
              .build();
        }
      }
    }
    return result;
  }
}
