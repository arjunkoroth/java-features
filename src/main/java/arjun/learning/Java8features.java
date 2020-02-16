package arjun.learning;

import arjun.learning.beans.MethodReference;
import arjun.learning.beans.Product;
import arjun.learning.interfaces.ReadableInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
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
                .filter(p -> p.price > 200000);
        filtered.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    public static void methodReference() {
        // Method reference to a static method
        ReadableInterface rdStatic = MethodReference::sayHello;
        rdStatic.read("arjun");
        // Method reference to an instance method
        ReadableInterface rdInstance = new MethodReference()::sayHelloInstance;
        rdInstance.read("arjun");
        // Method reference to a constructor.
        ReadableInterface rdConstructor = MethodReference::new;
        rdConstructor.read("Arjun");
    }

    public static void optioanlMethodExamples() {
        String[] str = new String[10];
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index  
        // It returns an empty instance of Optional class   
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        // It returns a non-empty Optional  
        Optional<String> value = Optional.of(str[5]);
        // If value is present, it returns an Optional otherwise returns an empty Optional  
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
        // It returns value of an Optional. if value is not present, it throws an NoSuchElementException    
        System.out.println("Getting value: " + value.get());
        // It returns hashCode of the value  
        System.out.println("Getting hashCode: " + value.hashCode());
        // It returns true if value is present, otherwise false  
        System.out.println("Is value present: " + value.isPresent());
        // It returns non-empty Optional if value is present, otherwise returns an empty Optional  
        System.out.println("Nullable Optional: " + Optional.ofNullable(str[5]));
        // It returns value if available, otherwise returns specified value,  
        System.out.println("orElse: " + value.orElse("Value is not present"));
        System.out.println("orElse: " + empty.orElse("Value is not present"));
        value.ifPresent(System.out::println);   // printing value by using method reference  
    }

    private static void stringJoiners() {
        // Joiner with a delimeter.
        StringJoiner joiner1 = new StringJoiner(",");
        joiner1.add("A");
        joiner1.add("B");
        joiner1.add("C");
        System.out.println(joiner1);
        // Joiner with delimiter, prefix and suffix.
        StringJoiner joiner2 = new StringJoiner(":", "[", "]");
        joiner2.add("D");
        joiner2.add("E");
        joiner2.add("F");
        System.out.println(joiner2);
        // Merger one joiner with another
        StringJoiner merger = joiner1.merge(joiner2);
        System.out.println(merger);
        // Length
        System.out.println("Length--" + merger.length());
    }

    private static void collectorAndStream() {
        List<Product> productList = new ArrayList<Product>() {
            {
                add(new Product(10, "R15", 170000));
                add(new Product(20, "MT15", 170000));
                add(new Product(10, "Dominar", 250000));
                add(new Product(10, "RS200", 170000));
            }
        };
        List<Integer> productPriceList = productList.stream()
                .map(p -> p.price)
                .collect(Collectors.toList());
        System.out.println(productPriceList);

        List<Product> pList = productList.stream()
                .filter(p -> p.price >= 250000)
                .collect(Collectors.toList());
        System.out.println(pList);

        List<Integer> pL = productList.stream()
                .filter(p -> p.price >= 250000)
                .map(p -> p.price)
                .collect(Collectors.toList());
        System.out.println(pL);

        Integer priceSum = productList.stream()
                .collect(Collectors.summingInt(p -> p.price));
        System.out.println("priceSum==" + priceSum);

        productList.stream()
                .filter(p -> p.price >= 250000)
                .forEach(p -> {
                    System.out.println(p.toString());
                });
        //Max and Min
        Product maxP = productList.stream()
                .max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Maximum Price==" + maxP.toString());

        Product minP = productList.stream()
                .max((p1, p2) -> p1.price < p2.price ? 1 : -1).get();
        System.out.println("Minimum Price==" + minP.toString());

        Map<String, Integer> prodMap = productList.stream()
                .collect(Collectors.toMap(p -> p.name, p -> p.price));
        prodMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        
        prodMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
        
        List<String> list = new ArrayList<String>() {
            {
                add("A");
                add("C");
                add("B");
                add("D");
            }
        };
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        collectorAndStream();
    }

}
