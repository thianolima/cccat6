package br.com.cccat6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class OrderItemTest {

    @Test
    public void shouldValidateWrongQuantity(){
        Item item = new Item("coke", 2.00, new Dimension(1.0,1.0,1.0),1.0);
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new OrderItem(0.0, item));
        assertThat(exception).hasMessage("Quantidade inválida!");
    }

}
