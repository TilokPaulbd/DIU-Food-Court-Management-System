package src.Base;

import java.util.HashMap;
import java.util.Map;

public class SalesReport {
    private int totalOrders;
    private double totalSalesAmount;
    private Map<String,Integer>itemSales;

    public SalesReport(){
        this.totalOrders=0;
        this.totalSalesAmount=0.0;
        this.itemSales=new HashMap<>();
    }

    public void updateFromOrder(Order order){
        totalOrders++;
        totalSalesAmount+=order.calculateTotal();

        for(OrderItem item: order.getItems()){
            String itemName = item.getItem().getName();
            int quantety=item.getQuantety();

            int currentSales = itemSales.getOrDefault(itemName, 0);
            int updatedSales = currentSales + quantety;
            itemSales.put(itemName, updatedSales);
        }
    }

    public int getTotalOrder(){
        return totalOrders;
    }
    public double getTotalSateAmount(){
        return totalSalesAmount;
    }
    public Map<String,Integer>getItemSales(){
        return itemSales;
    }

    public void printReport() {
       System.out.println("📊 Daily Sales Summary");
       System.out.println("────────────────────────────────────");
       System.out.println("🧾 Total Orders Placed: " + totalOrders);
       System.out.printf("💰 Total Revenue: %.2f BDT\n", totalSalesAmount);
       System.out.println("🍔 Items Sold Today:");

       if (itemSales.isEmpty()) {
          System.out.println("  ⛔ No items were sold yet.");
        } else {
          for (Map.Entry<String, Integer> entry : itemSales.entrySet()) {
            System.out.println("  • " + entry.getKey() + " → " + entry.getValue() + " pcs");
            }
        }

       System.out.println("────────────────────────────────────");
       System.out.println("✅ End of Report");
}


}
