package br.com.cccat6;

public interface ItemRepository {
    Item findById(long idItem);
    void save(Item item);
}
