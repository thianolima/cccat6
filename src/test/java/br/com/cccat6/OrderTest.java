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
    public void shouldValidateTotalAndWithoutFreight(){
        Order order = new Order(new CPF("085.227.570-62"));
        order.addItem(new Item("box of capsule coffe", 15.00), 1.0);
        order.addItem(new Item("indian pale ale box", 10.00), 2.0);
        order.addItem(new Item("box of donuts", 15.00), 1.0);
        Assertions.assertEquals(order.getTotal(), 50.0);
    }

    @Test
    public void shouldValidateTotalWithCoupomAndWithoutFreight(){
        Order order = new Order(new CPF("085.227.570-62"));
        order.addCoupon(new Coupon("10%", 10.0, LocalDate.now()));
        order.addItem(new Item("box of capsule coffe", 15.00), 1.0);
        order.addItem(new Item("indian pale ale box", 10.00), 2.0);
        order.addItem(new Item("box of donuts", 15.00), 1.0);
        Assertions.assertEquals(order.getTotal(), 45.0);
    }

    @Test
    public void shouldValidateCoupomExpiredDate(){
        Order order = new Order(new CPF("085.227.570-62"));
        Coupon coupon = new Coupon("10%", 10.0, LocalDate.now().minusMonths(1));
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> order.addCoupon(coupon));
        assertThat(exception).hasMessage("Cupom expirado!");
    }

    @Test
    public void shouldValidateFreightWithoutCoupon(){
        Order order = new Order(new CPF("085.227.570-62"));
        order.addItem(new Item("guitar", 1000.0, new Dimension(100, 30, 10), 3),1);
        order.addItem(new Item("amplify", 5000.0, new Dimension(50, 50, 50), 20),1);
        order.addItem(new Item("cable", 30.0, new Dimension(10, 10, 10), 1),3);
        Assertions.assertEquals(order.getTotal(), 6350.0);
        Assertions.assertEquals(order.getFreight(), 260.0);
    }
}
