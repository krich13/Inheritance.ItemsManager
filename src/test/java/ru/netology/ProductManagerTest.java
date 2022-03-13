package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager productManager = new ProductManager(new ProductRepository());
    Product firstBook = new Book(1, "Martin Eden", 600, "Jack London");
    Product secondBook = new Book(1, "The Iron Heel", 600, "Jack London");
    Product firstSmartphone = new Smartphone(1, "Nokia78", 20000, "China");
    Product secondSmartphone = new Smartphone(1, "Nokia98", 20000, "Vietnam");
    Product product = new Product();

    @BeforeEach
    public void setUp() { //настройка до тестов
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(firstSmartphone);
        productManager.add(secondSmartphone);
        productManager.add(product);
    }

    @Test
    void shouldFindBookByName() { //поиск книги по названию
        Product[] expected = new Product[]{firstBook};
        Product[] actual = productManager.searchBy("Martin Eden");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindBookByAuthor() { //поиск книги по автору
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = productManager.searchBy("Jack London");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindSmartphoneByProducer() { //поиск смартфона по производителю
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = productManager.searchBy("China");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindSmartphoneByName() { //поиск смартфона по имени
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = productManager.searchBy("Nokia78");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductByNameIfFiltersDoNotSuit() { //не должен искать продукт, если фильтры не подходят
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindProductIfItIsAnotherInstance() {
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Xuawei");
        assertArrayEquals(actual, expected);
    }
}
