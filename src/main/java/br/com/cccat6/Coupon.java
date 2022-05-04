package br.com.cccat6;

import java.time.LocalDate;

public class Coupon {
    private String code;
    private double percent;
    private LocalDate expirationDate;

    public Coupon(String code, double percent, LocalDate expirationDate){
        setCode(code);
        setPercent(percent);
        setExpirationDate(expirationDate);
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCode(String code) {
        if(code.trim().isEmpty()){
            throw new RuntimeException("Codigo inválido!");
        }
        this.code = code;
    }

    public void setPercent(double percent){
        if(!(percent >= 0 && percent <= 100)){
            throw new RuntimeException("Porcentual inválido!");
        }
        this.percent = percent;
    }

    public double getDiscount(double totalOrder){
        return (totalOrder/100) * percent;
    }

    public boolean isExpired(LocalDate today){
        return this.expirationDate.isBefore(today);
    }
}
