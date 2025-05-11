package org.skypro.skyshop.product;

public class Product {
    private final String nameOfProduct;
    private  final int priceOfProduct;

    public Product(String nameOfProduct, int priceOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }
}
