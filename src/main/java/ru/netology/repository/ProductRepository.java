package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {  //Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров)
    private Product[] items = new Product[0];

    public void save(Product item) { //сохранять items
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() { //получать все сохранённые Product'ы
        return items;
    }

    public void removeById(int id) { //удалять по id
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
