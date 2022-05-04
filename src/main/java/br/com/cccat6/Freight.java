package br.com.cccat6;

public class Freight {

    private double total = 0.0;

    private static int DISTANCE = 1000;
    private static int FACTOR = 100;
    private static int MININUM_VALUE = 10;

    public void addItem(Item item, double quantity){
        this.total += calculate(item) * quantity;
    }

    private double calculate(Item item){
        return item.getVolume() * this.DISTANCE * (item.getDensity()/this.FACTOR);
    }

    public double getTotal(){
        return (this.total > 0 && this.total < this.MININUM_VALUE) ? this.MININUM_VALUE : this.total;
    }
}
