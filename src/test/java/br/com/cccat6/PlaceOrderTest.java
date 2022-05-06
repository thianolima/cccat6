package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class PlaceOrderTest {

    @Test
    public void shouldPlaceOrder(){
        ItemRepository itemRepository = new ItemRepositoryMemory();
        itemRepository.save(new Item(1l, "Guitar", 1000, new Dimension(100, 30, 10), 3));
        itemRepository.save(new Item(2l, "Amplify", 5000, new Dimension(50, 50, 50), 20));
        itemRepository.save(new Item(3l, "Cable", 30, new Dimension(10, 10, 10), 1));
        OrderRepository orderRepository = new OrderRepositoryMemory();
        PlaceOrder placeOrder = new PlaceOrder(itemRepository, orderRepository);
        PlaceOrderInput input = PlaceOrderInput.builder()
                .cpf("085.227.570-62")
                .orderItems(Arrays.asList(
                        new PlaceOrderItemInput(1l, 1.0),
                        new PlaceOrderItemInput(2l, 1.0),
                        new PlaceOrderItemInput(3l, 3.0)))
                .build();
        PlaceOrderOutput output = placeOrder.execute(input);
        Assertions.assertEquals(output.getTotal(),6350.0);
    }
}
