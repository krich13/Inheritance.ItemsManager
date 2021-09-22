package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldFindBookByName() { //поиск книги по названию
        ProductManager ProductManager = new ProductManager(new ProductRepository()); //нужно создать объект репозитория
        Product firstBook = new Book(1, "Martin Eden", 600, "Jack London");
        ProductManager.add(firstBook);
        Product secondBook = new Book(1, "The Iron Heel", 600, "Jack London");
        ProductManager.add(secondBook);
        ProductManager.searchBy("Martin Eden");
        Product[] expected = new Product[]{firstBook};
        Product[] actual = ProductManager.searchBy("Martin Eden");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindBookByAuthor() { //поиск книги по автору
        ProductManager ProductManager = new ProductManager(new ProductRepository());
        Product firstBook = new Book(1, "Martin Eden", 600, "Jack London");
        ProductManager.add(firstBook);
        Product secondBook = new Book(1, "The Iron Heel", 600, "Jack London");
        ProductManager.add(secondBook);
        ProductManager.searchBy("Martin Eden");
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = ProductManager.searchBy("Jack London");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindSmartphoneByProducer() { //поиск смартфона по производителю
        ProductManager ProductManager = new ProductManager(new ProductRepository());
        Product firstSmartphone = new Smartphone(1, "Nokia78", 20000, "China");
        ProductManager.add(firstSmartphone);
        Product secondSmartphone = new Smartphone(1, "Nokia98", 20000, "Vietnam");
        ProductManager.add(secondSmartphone);
        ProductManager.searchBy("China");
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = ProductManager.searchBy("China");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindSmartphoneByName() { //поиск смартфона по имени
        ProductManager ProductManager = new ProductManager(new ProductRepository());
        Product firstSmartphone = new Smartphone(1, "Nokia78", 20000, "China");
        ProductManager.add(firstSmartphone);
        Product secondSmartphone = new Smartphone(1, "Samsung98", 20000, "Vietnam");
        ProductManager.add(secondSmartphone);
        ProductManager.searchBy("Nokia78");
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = ProductManager.searchBy("Nokia78");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductByNameIfFiltersDoNotSuit() { //не должен искать продукт, если фильтры не подходят
        ProductManager ProductManager = new ProductManager(new ProductRepository());
        Product firstSmartphone = new Smartphone(1, "Nokia78", 20000, "China");
        ProductManager.add(firstSmartphone);
        Product secondSmartphone = new Smartphone(1, "Samsung98", 20000, "Vietnam");
        ProductManager.add(secondSmartphone);
        ProductManager.searchBy("Xuawei");
        Product[] expected = new Product[]{};
        Product[] actual = ProductManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductIfItIsAnotherInstance() {
        ProductManager ProductManager = new ProductManager(new ProductRepository());
        Product product = new Product();
        ProductManager.add(product);
        ProductManager.searchBy("Xuawei");
        Product[] expected = new Product[]{};
        Product[] actual = ProductManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }
}