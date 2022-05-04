package br.com.cccat6;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private double price;
    private String description;
    private double depht;
    private double height;
    private double width;
    private double weight;

    public Item(String description, double price){
        setPrice(price);
        setDescription(description);
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new RuntimeException("Preço inválido!");
        }
        this.price = price;
    }

    public void setDescription(String description) {
        if(description.trim().isEmpty()){
            throw new RuntimeException("Descrição inválida!");
        }
        this.description = description;
    }

    public double getVolume(){
        return (this.depht/100) * (this.height/100) * (this.width/100);
    }

    public double getDensity(){
        return weight / getVolume();
    }
}
