package arjun.learning;

import arjun.learning.beans.MethodReference;
import arjun.learning.beans.Product;
import arjun.learning.interfaces.ReadableInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Arjun
 */
public class Java8features {

    private static void testLamdaexpression() {
        ReadableInterface rd = (str) -> {
            System.out.println("STR-->" + str);
        };
        rd.read("str");

        List<String> list = new ArrayList<String>();
        list.add("HP Laptop");
        list.add("Keyboard");
        list.add("Arjun");
        // Comaprable
        Collections.sort(list);
        list.forEach(name -> {
            System.out.println(name);
        });

        List<Product> productList = new ArrayList<Product>() {
            {
                add(new Product(10, "R15", 170000));
                add(new Product(20, "MT15", 170000));
                add(new Product(10, "Dominar", 250000));
                add(new Product(10, "RS200", 170000));
            }
        };
        // Comparator
        Collections.sort(productList, (prod1, prod2) -> {
            return prod1.name.compareTo(prod2.name);
        });
        productList.forEach(product -> {
            System.out.println(product.toString());
        });
        // Filter data
        Stream<Product> filtered = productList.stream()
                .filter(p->p.price > 200000);
        filtered.forEach(product->{
            System.out.println(product.toString());
        });
    }
    
    public static void methodReference(){
        ReadableInterface rd = MethodReference::sayHello;
        rd.read("hello");
    }

    public static void main(String[] args) {
        methodReference();
    }
}
