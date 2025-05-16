package org.skypro.skyshop.product;

public abstract  class Product {
    private final String nameOfProduct;


    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;

    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public abstract int getPriceOfProduct();
    public abstract boolean isSpecial();

    @Override
    public abstract String toString();
}
