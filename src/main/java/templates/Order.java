package templates;

import java.nio.ByteOrder;

public class Order {

    public static final ByteOrder BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    int messageId = 1;
    int field1 = 100;
    boolean field2 = true;
    double field3 = 3.14;

    public Order(int messageId, int field1, boolean field2, double field3) {
        this.messageId = messageId;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public boolean isField2() {
        return field2;
    }

    public void setField2(boolean field2) {
        this.field2 = field2;
    }

    public double getField3() {
        return field3;
    }

    public void setField3(double field3) {
        this.field3 = field3;
    }

    // Constructor, getters, and setters
}