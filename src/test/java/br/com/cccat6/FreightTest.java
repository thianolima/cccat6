package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class FreightTest {

    @Test
    public void shouldCalculateFreight() {
        Freight freight = new Freight();
        freight.addItem(new Item("guitar", 100.0, new Dimension(100, 30, 10), 3),1);
        freight.addItem(new Item("amplify", 500.0, new Dimension(50, 50, 50), 20),1);
        freight.addItem(new Item("cable", 30.0, new Dimension(10, 10, 10), 1),3);
        Assertions.assertEquals(260.0, freight.getTotal());
    }
}
