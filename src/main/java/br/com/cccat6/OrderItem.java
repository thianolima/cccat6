package br.com.cccat6;

public class OrderItem {
    private double quantity;
    private Item item;
    private double price;

    public OrderItem(double quantity, Item item){
        this.item = item;
        this.quantity = isValidQuantity(quantity);
        this.price = item.getPrice();
    }

    private double isValidQuantity(double quantity){
        if(quantity <= 0){
            throw new RuntimeException("Quantidade inválida!");
        }
        return quantity;
    }

    public double getTotal(){
        return this.price * this.quantity;
    }
}
