package ru.netology.domain;

public class Book extends Product {
    private String author;

    public String getAuthor() {
        return author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price); //super отвечает за вызов конструктора родителя, обращения к полям родителя, если они не приватные
        this.author = author;
    }
}
