package src.Base;

public class Notfication {
    public static void notifyNewOrder(String orderId){
        System.out.println("🔔 New Order Placed: " + orderId);
        System.out.println("📢 Staff, please check the order queue for preparation.");
    }

    public static void NotifyOrderReady(String orderId){
        System.out.println("✅ Order Ready: " + orderId);
        System.out.println("📣 Please notify the customer to collect their food.");
    }

    public static void notifyMessage(String message){
        System.out.println("📬 Notification: " + message);
    }
}
