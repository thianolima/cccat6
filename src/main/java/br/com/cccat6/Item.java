package br.com.cccat6;

public class Item {
    private double price;
    private String description;
    private Dimension dimension;
    private double weight;

    public Item(String description, double price, Dimension dimension, double weight){
        this.price = isValidPrice(price);
        this.description = isValidDescription(description);
        this.dimension = dimension;
        this.weight = isValidWeight(weight);
    }

    public Item(String description, double price){
        this.price = isValidPrice(price);
        this.description = isValidDescription(description);
    }

    private double isValidPrice(double price) {
        if(price <= 0){
            throw new RuntimeException("Preço inválido!");
        }
        return price;
    }

    public String isValidDescription(String description) {
        if(description.trim().isEmpty()){
            throw new RuntimeException("Descrição inválida!");
        }
        return description;
    }

    public double isValidWeight(double weight) {
        if(weight <= 0){
            throw new RuntimeException("Peso inválido!");
        }
        return weight;
    }

    public double getDensity(){
        return (this.dimension != null && this.weight > 0) ? weight / dimension.getVolume() : 0;
    }

    public double getVolume(){
        return (dimension != null) ? dimension.getVolume() : 0;
    }

    public double getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }
}
