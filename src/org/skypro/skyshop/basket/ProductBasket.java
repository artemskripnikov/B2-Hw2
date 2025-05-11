package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int MAX_PRODUCTS = 5;
private final Product[] products = new Product[MAX_PRODUCTS];
private int productCount = 0;

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым.");
        }
        if (productCount >= MAX_PRODUCTS) {
            throw new IllegalStateException("Корзина переполнена");
        }
        products[productCount++] = product;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPriceOfProduct();
            
        }
        return total;
    }

    public void printContents() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            System.out.println(product.getNameOfProduct() + ": " + product.getPriceOfProduct());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProductByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < productCount; i++) {
            if (productName.equalsIgnoreCase(products[i].getNameOfProduct())) {
                return true;
            }
        }
        return false;
    }

    public void clearAllProducts() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }
}
