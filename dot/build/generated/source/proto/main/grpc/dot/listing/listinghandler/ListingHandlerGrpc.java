package dot.listing.listinghandler;

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
    comments = "Source: listinghandler.proto")
public class ListingHandlerGrpc {

  private ListingHandlerGrpc() {}

  public static final String SERVICE_NAME = "listinghandler.ListingHandler";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<dot.listing.listinghandler.GetListingDataForUserRequest,
      dot.listing.listinghandler.GetListingDataForUserResponse> METHOD_GET_LISTING_DATA_FOR_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "listinghandler.ListingHandler", "getListingDataForUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(dot.listing.listinghandler.GetListingDataForUserRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(dot.listing.listinghandler.GetListingDataForUserResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ListingHandlerStub newStub(io.grpc.Channel channel) {
    return new ListingHandlerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ListingHandlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ListingHandlerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ListingHandlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ListingHandlerFutureStub(channel);
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static abstract class ListingHandlerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getListingDataForUser(dot.listing.listinghandler.GetListingDataForUserRequest request,
        io.grpc.stub.StreamObserver<dot.listing.listinghandler.GetListingDataForUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LISTING_DATA_FOR_USER, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_LISTING_DATA_FOR_USER,
            asyncUnaryCall(
              new MethodHandlers<
                dot.listing.listinghandler.GetListingDataForUserRequest,
                dot.listing.listinghandler.GetListingDataForUserResponse>(
                  this, METHODID_GET_LISTING_DATA_FOR_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class ListingHandlerStub extends io.grpc.stub.AbstractStub<ListingHandlerStub> {
    private ListingHandlerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ListingHandlerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListingHandlerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ListingHandlerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getListingDataForUser(dot.listing.listinghandler.GetListingDataForUserRequest request,
        io.grpc.stub.StreamObserver<dot.listing.listinghandler.GetListingDataForUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LISTING_DATA_FOR_USER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class ListingHandlerBlockingStub extends io.grpc.stub.AbstractStub<ListingHandlerBlockingStub> {
    private ListingHandlerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ListingHandlerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListingHandlerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ListingHandlerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public dot.listing.listinghandler.GetListingDataForUserResponse getListingDataForUser(dot.listing.listinghandler.GetListingDataForUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LISTING_DATA_FOR_USER, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Handles all things user
   * </pre>
   */
  public static final class ListingHandlerFutureStub extends io.grpc.stub.AbstractStub<ListingHandlerFutureStub> {
    private ListingHandlerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ListingHandlerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListingHandlerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ListingHandlerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dot.listing.listinghandler.GetListingDataForUserResponse> getListingDataForUser(
        dot.listing.listinghandler.GetListingDataForUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LISTING_DATA_FOR_USER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LISTING_DATA_FOR_USER = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ListingHandlerImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ListingHandlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LISTING_DATA_FOR_USER:
          serviceImpl.getListingDataForUser((dot.listing.listinghandler.GetListingDataForUserRequest) request,
              (io.grpc.stub.StreamObserver<dot.listing.listinghandler.GetListingDataForUserResponse>) responseObserver);
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

  private static final class ListingHandlerDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dot.listing.listinghandler.Listinghandler.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ListingHandlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ListingHandlerDescriptorSupplier())
              .addMethod(METHOD_GET_LISTING_DATA_FOR_USER)
              .build();
        }
      }
    }
    return result;
  }
}
