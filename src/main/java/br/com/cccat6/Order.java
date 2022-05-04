package br.com.cccat6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private CPF cpf;
    private Coupon coupon;
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public Order(CPF cpf){
        this.cpf = cpf;
    }

    public void addItem(double quantity, Item item){
        this.orderItems.add(new OrderItem(quantity, item, item.getPrice()));
    }

    public double getTotal(){
        double total = orderItems.stream().collect(Collectors.summingDouble(OrderItem::getTotal));
        total-= (coupon != null)?coupon.getDiscount(total):0;
        return total;
    }

    public void addCoupon(Coupon coupon){
        if(coupon.isExpired()){
            throw new RuntimeException("Cupom expirado!");
        }
        this.coupon = coupon;
    }
}
