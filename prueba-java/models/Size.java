package models;

// Clase para representar un size
public class Size {
    public int id;
    public int productId;
    public boolean backSoon;
    public boolean special;

    public Size(int id, int productId, boolean backSoon, boolean special) {
        this.id = id;
        this.productId = productId;
        this.backSoon = backSoon;
        this.special = special;
    }
}
