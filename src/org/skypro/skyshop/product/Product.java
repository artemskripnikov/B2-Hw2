package org.skypro.skyshop.product;

public abstract  class Product implements Searchable {
    private final String nameOfProduct;


    public Product(String nameOfProduct) {
        if (nameOfProduct == null || nameOfProduct.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return nameOfProduct.equalsIgnoreCase(nameOfProduct);
    }

    @Override
    public int hashCode() {
        return nameOfProduct.toLowerCase().hashCode();
    }
}
