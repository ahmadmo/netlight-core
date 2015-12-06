package org.netlight.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.Objects;

/**
 * @author ahmad
 */
public final class HttpChannelInitializer extends ChannelInitializer<Channel> {

    private final RichChannelHandler channelHandler;

    public HttpChannelInitializer(RichChannelHandler channelHandler) {
        Objects.requireNonNull(channelHandler);
        this.channelHandler = channelHandler;
    }

    @Override
    public void initChannel(Channel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast("codec", new HttpServerCodec());
        p.addLast("deflater", new HttpContentCompressor());
        p.addLast("aggregator", new HttpObjectAggregator(1024 * 1024));
        p.addLast("handler", channelHandler);
    }

    public RichChannelHandler getChannelHandler() {
        return channelHandler;
    }

}
