package org.skypro.skyshop.product;

public abstract  class Product implements Searchable {
    private final String nameOfProduct;


    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;

    }


    public abstract int getPriceOfProduct();
    public abstract boolean isSpecial();

    @Override
    public abstract String toString();

    @Override
    public String getSearchTerm() {
        return nameOfProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }
}
