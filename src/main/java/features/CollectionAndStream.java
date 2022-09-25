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
}
