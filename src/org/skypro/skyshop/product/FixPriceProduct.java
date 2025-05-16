package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIXED_PRICE = 500;

    public FixPriceProduct(String nameOfProduct) {
        super(nameOfProduct);
    }

    @Override
    public int getPriceOfProduct() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Имя продукта c фиксированной ценой: " + getNameOfProduct() + " Фиксированная цена: " + FIXED_PRICE;
    }
}
