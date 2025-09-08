package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым.");
        }
        String name = product.getName().toLowerCase();
        productsMap.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPriceOfProduct)
                .sum();
    }

    public void printContents() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        int totalItems = getTotalItemCount();
        int specialCount = getSpecialCount();

        System.out.println("Итого (" + totalItems + "товаров): " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    private int getTotalItemCount() {
        return productsMap.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    private int getSpecialCount() {
        return (int) productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean containsProductByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            return false;
        }
        return productsMap.containsKey(productName.toLowerCase());
    }


    public void clearAllProducts() {
        productsMap.clear();
    }


    public List<Product> removeAllProductsByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            return new ArrayList<>();
        }
        List<Product> removed = productsMap.remove(productName.toLowerCase());
        return removed != null ? removed : new ArrayList<>();
    }
}


