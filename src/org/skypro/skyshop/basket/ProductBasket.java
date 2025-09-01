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
        if (!productsMap.containsKey(name)) {
            productsMap.put(name, new ArrayList<>());
        }
        productsMap.get(name).add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getPriceOfProduct();
            }
        }
        return total;
    }

    public void printContents() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        int totalItems = 0;

        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
                totalItems++;
            }
        }
        System.out.println("Итого (" + totalItems + " товаров): " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
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


