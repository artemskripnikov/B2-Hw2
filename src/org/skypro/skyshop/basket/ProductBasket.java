package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым.");
        }
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPriceOfProduct();
        }
        return total;
    }

    public void printContents() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            return false;
        }
        for (Product product : products) {
            if (productName.equalsIgnoreCase(product.getNameOfProduct())) {
                return true;
            }
        }
        return false;
    }

    public void clearAllProducts() {
        products.clear();
        }


public List<Product> removeAllProductsByName(String name) {
    List<Product> removedProducts = new ArrayList<>();
    if (name == null || name.trim().isEmpty()) {
        return removedProducts;
    }

    Iterator<Product> iterator = products.iterator();
    while (iterator.hasNext()) {
        Product product = iterator.next();
        if (name.equalsIgnoreCase(product.getName())) {
            removedProducts.add(product);
            iterator.remove();
        }
    }
    return removedProducts;
   }
}


