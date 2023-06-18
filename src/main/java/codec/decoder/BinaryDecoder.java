package codec.decoder;

import templates.Order;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static templates.Order.BYTE_ORDER;


//POJO initially
public class BinaryDecoder {

    public static Order decode(ByteBuffer buffer) {
        int messageId = buffer.getInt();
        int field1 = buffer.getInt();
        boolean field2 = buffer.get() != 0;
        double field3 = buffer.getDouble();
        return new Order(messageId, field1, field2, field3);
    }


}

