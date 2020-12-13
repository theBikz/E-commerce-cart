package com.ecom;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DisplayProduct {
    public void show () {
        var brands = new Brands();

        // constructor initialising
        var product1 = new Product("Shoe1",brands.ADIDAS,1900,4.2);

        // adding Product using method
        product1.addProduct("Shoe 2",brands.PUMA,2500,4.6);
        product1.addProduct("Shoe 3",brands.NIKE,2900,4.3);
        product1.addProduct("Shoe 4",brands.NIKE,3500,4.9);

        // adding Products to List
        List<Product> products = List.of
                (
                        new Product("Shoe 1",brands.NIKE,2010,3.8),
                        new Product("Shoe 2",brands.PUMA,1900,4.2),
                        new Product("Shoe 3",brands.ADIDAS,1500,4.9),
                        new Product("Shoe 4",brands.BENETTON,1400,3.9),
                        new Product("Shoe 5",brands.DENIM,2900,4.4),

                        new Product("Mobile 1",brands.APPLE,29000,4.6),
                        new Product("Mobile 2",brands.VIVO,13000,4.4),
                        new Product("Mobile 3",brands.HUAWEI,25000,2.1),
                        new Product("Mobile 4",brands.SAMSUNG,17000,3.8),
                        new Product("Mobile 5",brands.SAMSUNG,14000,3.3),

                        new Product("Shirt 1",brands.LOUIS_PHILLIPE,2900,4.2),
                        new Product("Shirt 2",brands.PARK_AVENUE,2900,3.8),
                        new Product("Shirt 3",brands.PETER_ENGLAND,1900,4.5),
                        new Product("Shirt 4",brands.VAN_HEUSAN,3400,3.4),
                        new Product("Shirt 5",brands.LOUIS_PHILLIPE,1890,4.1)

                );

        Predicate<Product> isHighRated = m -> m.getRating() >= 4.5;

        //Names of products greater than Price 2000
        System.out.println("Products above 2500");
        products.stream()
                .filter(m-> m.getPrice() > 2500)
                .forEach(m-> System.out.println(m.getTitle()));

        //Product with highest Rating
        var maxRating = products.stream()
                .max(Comparator.comparing(Product::getRating))
                .get();
        System.out.print("Product with highest rating = ");
        maxRating.displayItem();

        //Product with lowest Rating
        var minRating = products.stream()
                .min(Comparator.comparing(Product::getRating))
                .get();
        System.out.print("Product with Lowest rating = ");
        minRating.displayItem();

        //Display as key value (Name = Price)
        var res =  products.stream()
                .collect(Collectors.toMap(m -> m.getTitle(), m -> m.getPrice()));
        System.out.println(res);

        // returns true if all item rating are above 4.5 here it returns false
        var highRated = products.stream()
                .allMatch(isHighRated);
        System.out.println(highRated);

        //Get Distinct Items
        System.out.println("ALL Brands Available");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        //Products with price higher than 20000
        System.out.println("Products with Price More than 20000");
        products.stream()
                .filter(m -> m.getPrice() >20000)
                .forEach(m-> m.displayItem());
    }
}
