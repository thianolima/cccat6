package br.com.cccat6;

import lombok.Getter;

@Getter
public class OrderItem {
    private double quantity;
    private Item item;
    private double price;

    public OrderItem(double quantity, Item item, double price){
        this.item = item;
        setQuantity(quantity);
        setPrice(price);
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new RuntimeException("Preço inválido!");
        }
        this.price = price;
    }

    public void setQuantity(double quantity){
        if(quantity <= 0){
            throw new RuntimeException("Quantidade inválida!");
        }
        this.quantity = quantity;
    }

    public double getTotal(){
        return this.price * this.quantity;
    }
}
