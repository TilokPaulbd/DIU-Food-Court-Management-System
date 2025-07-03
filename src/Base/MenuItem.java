package src.Base;
public class MenuItem {

    private String id;
    private String name;
    private String category;
    private double price;
    private int totalSold;

    public MenuItem(String id,String name,String category,double price){
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
        this.totalSold=0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void incrementSales(int quantety){
        this.totalSold+=quantety;
    }
    
    public String toString() {
        return "[id=" + id + ", name=" + name + ", category=" + category + ", price=" + price +" BDT"+ ", totalSold="
                + totalSold + " BDT"+"]";
    }
   
}