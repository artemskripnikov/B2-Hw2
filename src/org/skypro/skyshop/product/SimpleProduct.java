package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceOfProduct;

    public SimpleProduct(String nameOfProduct, int priceOfProduct) {
        super(nameOfProduct);
        if (priceOfProduct <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0");
        }
        this.priceOfProduct = priceOfProduct;
    }


    @Override
    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Имя продукта: " + getNameOfProduct() + " стоимость: "+ getPriceOfProduct();
    }
}

