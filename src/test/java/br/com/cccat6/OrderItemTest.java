package br.com.cccat6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class OrderItemTest {

    @Test
    public void shouldValidateWrongPrice(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new OrderItem(1.0, new Item("coke", 2.00),-1.0));
        assertThat(exception).hasMessage("Preço inválido!");
    }

    @Test
    public void shouldValidateWrongQuantity(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new OrderItem(0.0, new Item("coke", 2.00),1.0));
        assertThat(exception).hasMessage("Quantidade inválida!");
    }

}
