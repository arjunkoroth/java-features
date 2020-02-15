package arjun.learning.beans;

/**
 *
 * @author Arjun
 */
public class Product {
    public int Id;
    public String name;
    public int price;

    public Product(int Id, String name, int price) {
        this.Id = Id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + Id + ", name=" + name + ", price=" + price + '}';
    }
    
}
