package models;

// Clase para representar un producto
public class Product {
    public int id;
    public int sequence;

    public Product(int id, int sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public int getId() {
        return id;
    }
}