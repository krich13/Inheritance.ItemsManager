package ru.netology.domain;

public class Smartphone extends Product {
    private String producer;

    public String getProducer() {
        return producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price); //super отвечает за вызов конструктора родителя, обращения к полям родителя, если они не приватные
        this.producer = producer;
    }
}
