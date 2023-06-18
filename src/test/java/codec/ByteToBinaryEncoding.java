package codec;


import org.junit.Test;

public class ByteToBinaryEncoding {

    @Test
    public void justByteToBinaryExample() {
        // Use unsigned
        // Define your message structure
        int messageId = 1;
        int field1 = 100;
        boolean field2 = true;
        double field3 = 3.14;

        // Encode the message
        byte[] encodedData = new byte[32];

        // '>>>' for unsigned, use '>>' for signed
        // Encoding messageId(int) (4 bytes)
        encodedData[0] = (byte) (messageId >>> 24);
        encodedData[1] = (byte) (messageId >>> 16);
        encodedData[2] = (byte) (messageId >>> 8);
        encodedData[3] = (byte) messageId;

        // Encoding field1(int) (4 bytes)
        encodedData[4] = (byte) (field1 >>> 24);
        encodedData[5] = (byte) (field1 >>> 16);
        encodedData[6] = (byte) (field1 >>> 8);
        encodedData[7] = (byte) field1;

        // Encoding field2 boolean (1 byte)
        encodedData[8] = (byte) (field2 ? 1 : 0);

        // Encoding field3 long (8 bytes)
        long field3Bits = Double.doubleToRawLongBits(field3);
        encodedData[9] = (byte) (field3Bits >>> 56);
        encodedData[10] = (byte) (field3Bits >>> 48);
        encodedData[11] = (byte) (field3Bits >>> 40);
        encodedData[12] = (byte) (field3Bits >>> 32);
        encodedData[13] = (byte) (field3Bits >>> 24);
        encodedData[14] = (byte) (field3Bits >>> 16);
        encodedData[15] = (byte) (field3Bits >>> 8);
        encodedData[16] = (byte) field3Bits;

        // Decode the message

        // Decoding messageId (4 bytes)
        int decodedMessageId =
                ((encodedData[0] & 0xFF) << 24) |
                        ((encodedData[1] & 0xFF) << 16) |
                        ((encodedData[2] & 0xFF) << 8) |
                        (encodedData[3] & 0xFF);

        // Decoding field1 (4 bytes)
        int decodedField1 =
                ((encodedData[4] & 0xFF) << 24) |
                        ((encodedData[5] & 0xFF) << 16) |
                        ((encodedData[6] & 0xFF) << 8) |
                        (encodedData[7] & 0xFF);

        // Decoding field2 (1 byte)
        boolean decodedField2 = encodedData[8] != 0;

        // Decoding field3 (8 bytes)
        long dField3Bits =
                ((encodedData[9] & 0xFFL) << 56) |
                        ((encodedData[10] & 0xFFL) << 48) |
                        ((encodedData[11] & 0xFFL) << 40) |
                        ((encodedData[12] & 0xFFL) << 32) |
                        ((encodedData[13] & 0xFFL) << 24) |
                        ((encodedData[14] & 0xFFL) << 16) |
                        ((encodedData[15] & 0xFFL) << 8) |
                        (encodedData[16] & 0xFFL);
        double decodedField3 = Double.longBitsToDouble(dField3Bits);

        // Print the decoded values
        System.out.println("Decoded Message ID: " + decodedMessageId);
        System.out.println("Decoded Field 1: " + decodedField1);
        System.out.println("Decoded Field 2: " + decodedField2);
        System.out.println("Decoded Field 3: " + decodedField3);
    }
}


