package br.com.cccat6;

public class OrderItem {
    private double quantity;
    private Item item;
    private double price;

    public OrderItem(double quantity, Item item){
        this.item = item;
        this.price = item.getPrice();
        setQuantity(quantity);
    }

    private void setQuantity(double quantity){
        if(quantity <= 0){
            throw new RuntimeException("Quantidade inválida!");
        }
        this.quantity = quantity;
    }

    public double getTotal(){
        return this.price * this.quantity;
    }
}
