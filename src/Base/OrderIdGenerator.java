package src.Base;

public class OrderIdGenerator {
    private int LastIdNumber;

    public OrderIdGenerator(int startId){
        this.LastIdNumber=startId;
    }

    public String getNextOrderId() {
        LastIdNumber++;
        return formatOrderId(LastIdNumber);
    }

    private String formatOrderId(int idNumber) {
        return String.format("ORD-%d", idNumber);
    }
    public int getLastIdNumber() {
        return LastIdNumber;
    }
}
