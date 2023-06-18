package main;

import codec.decoder.BinaryDecoder;
import codec.encoder.BinaryEncoder;
import templates.Order;

import java.io.IOException;
import java.nio.ByteBuffer;

import static templates.Order.BYTE_ORDER;

public class AppMain {

    private static final ByteBuffer buffer = ByteBuffer.allocate(32).order(BYTE_ORDER);

    public static void main(String arg[]) throws IOException {

        // Order 1
        Order order1 = new Order(1,2,true,13.5);
        performCodecOperation(order1);

        // Order 2
        Order order2 = new Order(1478,700,false,99.87);
        performCodecOperation(order2);

        // Order 3
        Order order3 = new Order(91112,87009,true,0.07);
        performCodecOperation(order3);


    }

    private static void performCodecOperation(Order order) {
        byte[] encodedOrder = BinaryEncoder.encode(order, buffer);

        buffer.flip();

        Order decodedOrder = BinaryDecoder.decode(buffer);

        System.out.println();
        System.out.println(decodedOrder.getMessageId());
        System.out.println(decodedOrder.getField1());
        System.out.println(decodedOrder.isField2());
        System.out.println(decodedOrder.getField3());

        resetBuffer();
    }

    private static void resetBuffer() {
        buffer.clear();
    }
}
