package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class})
public class CoupomTest {

    @Test
    public void shouldValidateWrongPercent(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Coupon("150%",150.0, LocalDate.now()));
        assertThat(exception).hasMessage("Porcentual inválido!");
    }

    @Test
    public void shouldValidateWrongCode(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Coupon("",150.0, LocalDate.now()));
        assertThat(exception).hasMessage("Codigo inválido!");
    }

    @Test
    public void shouldCreateCoupon(){
        Coupon coupon = new Coupon("20%",20.0, LocalDate.now());
        Assertions.assertEquals(coupon.getDiscount(100.00),20.0);
    }

    @Test
    public void shouldCreateCouponExpired(){
        Coupon coupon = new Coupon("20%",20.0, LocalDate.now().minusMonths(1));
        Assertions.assertTrue(coupon.isExpired());
    }
}
