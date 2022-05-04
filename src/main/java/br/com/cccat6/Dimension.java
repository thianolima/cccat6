package br.com.cccat6;

public class Dimension {
    private double height;
    private double width;
    private double depht;

    public Dimension(double height, double width, double depht){
        setHeight(height);
        setWidth(width);
        setDepht(depht);
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new RuntimeException("Altura inválida!");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new RuntimeException("Largura inválida!");
        }
        this.width = width;
    }

    private void setDepht(double depht) {
        if(depht <= 0){
            throw new RuntimeException("Profundidade inválida!");
        }
        this.depht = depht;
    }

    public double getVolume(){
        return (this.depht/100) * (this.height/100) * (this.width/100);
    }
}
