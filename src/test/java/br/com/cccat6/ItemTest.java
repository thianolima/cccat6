package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class ItemTest {

    @Test
    public void shouldValidateWrongPrice(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new Item(1l, "coke", -2.00));
        assertThat(exception).hasMessage("Preço inválido!");
    }

    @Test
    public void shouldValidateWrongDescription(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new Item(1l,"", 2.00));
        assertThat(exception).hasMessage("Descrição inválida!");
    }

    @Test
    public void shouldValidateWrongWeight(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Item(1l,"coke", 2.00, new Dimension(1.0, 1.0, 1.0), 0.0));
        assertThat(exception).hasMessage("Peso inválido!");
    }

    @Test
    public void shouldCreateItem(){
        Item item = new Item(1l,"coke", 2.00);
        Assertions.assertEquals("coke", item.getDescription());
        Assertions.assertEquals(2.00, item.getPrice());
    }

    @Test
    public void shouldCreateItemWithDensityValid(){
        Dimension dimension = new Dimension(100.0, 30.0, 10.0);
        Item item = new Item(1l,"coke", 2.00, dimension, 3.0);
        Assertions.assertEquals(100, item.getDensity());
    }
}
