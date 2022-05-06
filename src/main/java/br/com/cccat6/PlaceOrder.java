package br.com.cccat6;

public class PlaceOrder {

    ItemRepository itemRepository;
    OrderRepository orderRepository;

    public PlaceOrder(ItemRepository repository, OrderRepository orderRepository){
        this.itemRepository = repository;
        this.orderRepository = orderRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input){
        CPF cpf = new CPF(input.getCpf());
        Order order = new Order(cpf);
        input.getOrderItems().forEach(placeOrderItemInput -> {
            Item item = itemRepository.findById(placeOrderItemInput.getIdItem());
            order.addItem(item, placeOrderItemInput.getQuantity());
        });
        orderRepository.save(order);
        return new PlaceOrderOutput(order.getTotal());
    }
}
