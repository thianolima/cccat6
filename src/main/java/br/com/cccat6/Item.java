package br.com.cccat6;

public class Item {
    private Long idItem;
    private double price;
    private String description;
    private Dimension dimension;
    private double weight;

    public Item(Long idItem, String description, double price, Dimension dimension, double weight){
        this.idItem = idItem;
        this.dimension = dimension;
        setPrice(price);
        setDescription(description);
        setWeight(weight);
    }

    public Item(Long idItem, String description, double price){
        this.idItem = idItem;
        setPrice(price);
        setDescription(description);
    }

    private void setPrice(double price) {
        if(price <= 0){
            throw new RuntimeException("Preço inválido!");
        }
        this.price = price;
    }

    private void setDescription(String description) {
        if(description.trim().isEmpty()){
            throw new RuntimeException("Descrição inválida!");
        }
        this.description = description;
    }

    private void setWeight(double weight) {
        if(weight <= 0){
            throw new RuntimeException("Peso inválido!");
        }
        this.weight = weight;
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

    public Long getIdItem() {
        return this.idItem;
    }
}
