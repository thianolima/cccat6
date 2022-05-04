package br.com.cccat6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private CPF cpf;
    private Coupon coupon;
    private List<OrderItem> orderItems;
    private LocalDate create;
    private Freight freight;

    public Order(CPF cpf){
        this.cpf = cpf;
        this.create = LocalDate.now();
        this.orderItems = new ArrayList<>();
        this.freight = new Freight();
    }

    public void addItem(Item item, double quantity){
        this.freight.addItem(item, quantity);
        this.orderItems.add(new OrderItem(quantity, item));
    }

    public double getTotal(){
        double total = orderItems.stream().collect(Collectors.summingDouble(OrderItem::getTotal));
        total-= (coupon != null)?coupon.getDiscount(total):0;
        total+= freight.getTotal();
        return total;
    }

    public double getFreight () {
        return this.freight.getTotal();
    }

    public void addCoupon(Coupon coupon){
        if(coupon.isExpired(this.create)){
            throw new RuntimeException("Cupom expirado!");
        }
        this.coupon = coupon;
    }
}
