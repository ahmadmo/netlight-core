package org.netlight.encoding;

import org.netlight.messaging.Message;
import org.netlight.util.serialization.*;

/**
 * @author ahmad
 */
public final class StandardMessageSerializers {

    private StandardMessageSerializers() {
    }

    public static final BinaryObjectSerializer<Message> JAVA = new JavaSerializer<>(Message.class);
    public static final BinaryObjectSerializer<Message> KRYO = new KryoSerializer<>(Message.class);
    public static final TextObjectSerializer<Message> JSON = new JSONSerializer<>(Message.class);

}