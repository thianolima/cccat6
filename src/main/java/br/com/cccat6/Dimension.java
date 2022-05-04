package br.com.cccat6;

public class Dimension {
    private double height;
    private double width;
    private double depht;

    public Dimension(double height, double width, double depht){
        this.height = isValidHeight(height);
        this.width = isValidWidth(width);
        this.depht = isValidDepht(depht);
    }

    private double isValidHeight(double height) {
        if(height <= 0){
            throw new RuntimeException("Altura inválida!");
        }
        return height;
    }

    private double isValidWidth(double width) {
        if(width <= 0){
            throw new RuntimeException("Largura inválida!");
        }
        return width;
    }

    private double isValidDepht(double depht) {
        if(depht <= 0){
            throw new RuntimeException("Profundidade inválida!");
        }
        return depht;
    }

    public double getVolume(){
        return (this.depht/100) * (this.height/100) * (this.width/100);
    }
}
