package src.Base;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderId;
    private String studentName;
    private String studentId;
    private LocalDateTime orderTime;
    private List<OrderItem>items;
    private boolean isPrepared;

    public Order(String studentName,String studentId){
        //this.orderId=OrderIdGenerator.generateOrderId();
        this.studentName=studentName;
        this.studentId=studentId;
        this.orderTime=LocalDateTime.now();
        this.items=new ArrayList<>();
        this.isPrepared=false;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean isPrepared) {
        this.isPrepared = isPrepared;
    }

    public void addItem(MenuItem item,int quantiy){
        for(OrderItem io : items){
            if(io.getItem().getId()==item.getId()){
                io.incrementQuantity(quantiy);
                return;
            }
        }
        items.add(new OrderItem(item, quantiy));
    }
    
    
    public double calculateTotal() {
        double total = 0;
        for (OrderItem oi : items) {
            total += oi.getTotalPrice();
        }
        return total;
    }
   
    public String toFileString() {
    String itemLines = "";
    for (OrderItem oi : items) {
        itemLines = itemLines + "    • " + oi.toString() + "\n";
    }

        return "\n========== McOrder Receipt ==========\n" +
           "🧾 Order ID    : " + orderId + "\n" +
           "👤 Student     : " + studentName + " (" + studentId + ")\n" +
           "🕒 Time        : " + orderTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a")) + "\n" +
           "\n🍔 Items Ordered:\n" +
           itemLines +
           "\n💰 Total Bill  : " + String.format("%.2f", calculateTotal()) + " BDT\n" +
           "🍽️ Status      : " + (isPrepared ? "✅ Ready for Pickup" : "⏳ Preparing") + "\n" +
           "=====================================\n";
    }

    public String toString() {
        return "Order ID: " + orderId +
               " | Student: " + studentName +
               " (" + studentId + ")" +
               " | Total: " + calculateTotal() + " BDT";
    }
}
