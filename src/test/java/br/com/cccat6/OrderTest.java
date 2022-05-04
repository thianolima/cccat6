package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class OrderTest {

    @Test
    public void shouldValidateWrongCPF(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new Order(new CPF("111.111.111-11")));
        assertThat(exception).hasMessage("CPF inválido!");
    }

    @Test
    public void shouldValidateTotal(){
        Order order = new Order(new CPF("085.227.570-62"));
        order.addItem(1.0, new Item("box of capsule coffe", 15.00));
        order.addItem(2.0, new Item("indian pale ale box", 10.00));
        order.addItem(1.0, new Item("box of donuts", 15.00));
        Assertions.assertEquals(order.getTotal(), 50.0);
    }

    @Test
    public void shouldValidateTotalWithCoupom(){
        Order order = new Order(new CPF("085.227.570-62"));
        order.addCoupon(new Coupon("10%", 10.0, LocalDate.now()));
        order.addItem(1.0, new Item("box of capsule coffe", 15.00));
        order.addItem(2.0, new Item("indian pale ale box", 10.00));
        order.addItem(1.0, new Item("box of donuts", 15.00));
        Assertions.assertEquals(order.getTotal(), 45.0);
    }

    @Test
    public void shouldValidateCoupomExpiredDate(){
        Order order = new Order(new CPF("085.227.570-62"));
        Coupon coupon = new Coupon("10%", 10.0, LocalDate.now().minusMonths(1));
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> order.addCoupon(coupon));
        assertThat(exception).hasMessage("Cupom expirado!");
    }
}
