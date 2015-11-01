package org.netlight.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.netlight.messaging.MessagePromise;

import java.net.SocketAddress;
import java.util.Collection;

/**
 * @author ahmad
 */
public final class NetLightChannelContext implements ChannelContext {

    private static final long serialVersionUID = 5593016923444804597L;

    private final String id;
    private final ChannelHandlerContext channelHandlerContext;
    private final RichChannelHandler channelHandler;

    public NetLightChannelContext(String id, ChannelHandlerContext channelHandlerContext, RichChannelHandler channelHandler) {
        this.id = id;
        this.channelHandlerContext = channelHandlerContext;
        this.channelHandler = channelHandler;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public ChannelHandlerContext channelHandlerContext() {
        return channelHandlerContext;
    }

    @Override
    public Channel channel() {
        return channelHandlerContext.channel();
    }

    @Override
    public RichChannelHandler channelHandler() {
        return channelHandler;
    }

    @Override
    public SocketAddress remoteAddress() {
        return channelHandlerContext.channel().remoteAddress();
    }

    @Override
    public void sendMessage(MessagePromise promise) {
        channelHandler.sendMessage(channelHandlerContext, promise);
    }

    @Override
    public void sendMessages(Collection<MessagePromise> promises) {
        channelHandler.sendMessages(channelHandlerContext, promises);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj instanceof NetLightChannelContext && id.equals(((NetLightChannelContext) obj).id);
    }

}
