package org.netlight.messaging;

/**
 * @author ahmad
 */
public interface MessagePromise extends MessageFuture {

    MessagePromise setSuccess();

    MessagePromise setSuccess(boolean success);

    MessagePromise setCancellable(boolean cancellable);

    MessagePromise setFailure(Throwable cause);

    MessagePromise setResponse(Message response);

    @Override
    MessagePromise addListener(MessageFutureListener listener);

    @Override
    MessagePromise removeListener(MessageFutureListener listener);

}
