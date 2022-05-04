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
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new Item("coke", -2.00));
        assertThat(exception).hasMessage("Preço inválido!");
    }

    @Test
    public void shouldValidateWrongDescription(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new Item("", 2.00));
        assertThat(exception).hasMessage("Descrição inválida!");
    }

    @Test
    public void shouldCreateItem(){
        Item item = new Item("coke", 2.00);
        Assertions.assertEquals(item.getDescription(), "coke");
        Assertions.assertEquals(item.getPrice(), 2.00);
    }
}
