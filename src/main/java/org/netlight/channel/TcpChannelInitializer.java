package org.netlight.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import org.netlight.encoding.EncodingProtocol;

import java.util.Objects;

/**
 * @author ahmad
 */
public final class TcpChannelInitializer extends ChannelInitializer<Channel> {

    private final EncodingProtocol protocol;
    private final RichChannelHandler channelHandler;

    public TcpChannelInitializer(EncodingProtocol protocol, RichChannelHandler channelHandler) {
        Objects.requireNonNull(protocol);
        this.protocol = protocol;
        this.channelHandler = channelHandler;
    }

    @Override
    public void initChannel(Channel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast("decoder", protocol.decoder());
        p.addLast("encoder", protocol.encoder());
        p.addLast("handler", channelHandler);
    }

    public EncodingProtocol getProtocol() {
        return protocol;
    }

    public RichChannelHandler getChannelHandler() {
        return channelHandler;
    }

}
