public class OrderItem {
    private MenuItem item;
    private int quantety;

    public OrderItem(MenuItem item,int quantety){
        this.item=item;
        this.quantety=quantety;
    }

    public int getQuantity(){
        return quantety;
    }

    public void setQuantity(int quantety){
        this.quantety=quantety;
    }
    
    public void incrementQuantity(int amount){
        this.quantety+=amount;
    }

    public double getTotalPrice(){
        return item.getPrice()*quantety;
    }

    public String toString() {
        return item.getName() + " x" + quantety + " = " + getTotalPrice() + " BDT";
    }
}
