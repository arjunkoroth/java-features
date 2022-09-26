package features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import features.beans.Product;

public class CollectionAndStream {
    public CollectionAndStream() {
        List<Product> productList = new ArrayList<Product>() {
            {
                add(new Product(10, "R15", 170000));
                add(new Product(20, "MT15", 170000));
                add(new Product(10, "Dominar", 250000));
                add(new Product(10, "RS200", 170000));
            }
        };
        System.out.println("\nGet list of prices from a product list");
        System.out.println("---------------------------------------\n");
        List<Integer> productPriceList = productList.stream()
                .map(p -> p.price)
                .collect(Collectors.toList());
        System.out.println(productPriceList);

        System.out.println("\nGet products with price greater than a specific value");
        System.out.println("--------------------------------------------------------\n");
        List<Product> pList = productList.stream()
                .filter(p -> p.price >= 250000)
                .collect(Collectors.toList());
        System.out.println(pList);

        System.out.println("\nGet a list of values greater than a specific value");
        System.out.println("--------------------------------------------\n");
        List<Integer> pL = productList.stream()
                .filter(p -> p.price >= 250000)
                .map(p -> p.price)
                .collect(Collectors.toList());
        System.out.println(pL);

        System.out.println("\nGet sum of values from a list");
        System.out.println("--------------------------------\n");
        Integer priceSum = productList.stream()
                .collect(Collectors.summingInt(p -> p.price));
        System.out.println("priceSum==" + priceSum);


        System.out.println("\nGet maximum value from a list");
        System.out.println("--------------------------------\n");
        Product maxP = productList.stream()
                .max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println("Maximum Price==" + maxP.toString());

        System.out.println("\nGet minimum value from a list");
        System.out.println("--------------------------------\n");
        Product minP = productList.stream()
                .max((p1, p2) -> p1.price < p2.price ? 1 : -1).get();
        System.out.println("Minimum Price==" + minP.toString());

        System.out.println("\nConvert a list to map");
        System.out.println("------------------------\n");
        Map<String, Integer> prodMap = productList.stream()
                .collect(Collectors.toMap(p -> p.name, p -> p.price));

        System.out.println("\nIterate over a map");
        System.out.println("------------------------\n");
        prodMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        System.out.println("\nSort a map (by Value)");
        System.out.println("-----------------------\n");
        prodMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        System.out.println("\nSort a list in reverse");
        System.out.println("------------------------\n");
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
        new CollectionAndStream();
    }
}
