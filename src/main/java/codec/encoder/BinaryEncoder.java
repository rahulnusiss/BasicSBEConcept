package codec.encoder;


import templates.Order;


import java.nio.ByteBuffer;

//POJO initially
public class BinaryEncoder {

    public static byte[] encode(Order order,ByteBuffer buffer) {
        buffer.putInt(order.getMessageId());
        buffer.putInt(order.getField1());
        buffer.put((byte) (order.isField2() ? 1 : 0));
        buffer.putDouble(order.getField3());
        return buffer.array();
    }


}



