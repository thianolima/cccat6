package br.com.cccat6;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryMemory implements ItemRepository{

    private List<Item> items;

    public ItemRepositoryMemory(){
        this.items = new ArrayList<>();
    }

    @Override
    public Item findById(long idItem) {
        return items.stream().filter(item -> item.getIdItem() == idItem).findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado!"));
    }

    @Override
    public void save(Item item) {
        this.items.add(item);
    }
}
