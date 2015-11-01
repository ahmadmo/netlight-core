package org.netlight.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.netlight.messaging.MessagePromise;

import java.io.Serializable;
import java.net.SocketAddress;
import java.util.Collection;

/**
 * @author ahmad
 */
public interface ChannelContext extends Serializable {

    String id();

    ChannelHandlerContext channelHandlerContext();

    Channel channel();

    RichChannelHandler channelHandler();

    SocketAddress remoteAddress();

    void sendMessage(MessagePromise promise);

    void sendMessages(Collection<MessagePromise> promises);

}
