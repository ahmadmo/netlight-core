package org.netlight.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.netlight.messaging.MessagePromise;

import java.util.Collection;

/**
 * @author ahmad
 */
public interface RichChannelHandler extends ChannelHandler {

    void sendMessage(ChannelHandlerContext ctx, MessagePromise promise);

    void sendMessages(ChannelHandlerContext ctx, Collection<MessagePromise> promises);

}
