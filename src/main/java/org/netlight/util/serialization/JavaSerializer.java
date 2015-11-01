package org.netlight.util.serialization;

import java.io.*;
import java.util.Objects;

/**
 * @author ahmad
 */
public final class JavaSerializer<I extends Serializable> implements BinaryObjectSerializer<I> {

    private final Class<I> inputType;

    public JavaSerializer(Class<I> inputType) {
        Objects.requireNonNull(inputType);
        this.inputType = inputType;
    }

    @Override
    public byte[] serialize(I obj) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public I deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (I) objectInputStream.readObject();
        }
    }

    @Override
    public Class<I> getInputType() {
        return inputType;
    }

}
