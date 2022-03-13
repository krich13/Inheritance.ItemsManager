package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) { //конструктор
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item); //умеет добавлять items в репозиторий
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; //создаем новую переменную типа массив и говорим, что там 0 ячеек
        for (Product item : repository.findAll()) { //для каждого элемента массива Продакт применяется метод найти все
            if (matches(item, text)) { //при условии, что метод совпадение выполняется, создается новый репо видом Продакт и он на одну ячейку больше
                Product[] temporaryProductsList = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) { //копируем всё из result в tmp
                    temporaryProductsList[i] = result[i];
                }
                temporaryProductsList[temporaryProductsList.length - 1] = item; //в последнюю ячейку кладем новый элемент
                result = temporaryProductsList;
            }
        }
        return result;
    }

    public static boolean matches(Product item, String search) {
        if (item instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) item; // поместим его в переменную типа Book, чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }

        if (item instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) item; // поместим его в переменную типа Smartphone чтобы пользоваться методами класса Smartphone
            if (smartphone.getProducer().contains(search)) { // проверим есть ли поисковое слово в данных о поставщике
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
