package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String nameOfProduct, int basePrice, int discountPercent) {
        super(nameOfProduct);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public int getPriceOfProduct() {
        return basePrice * ( 100 - discountPercent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Имя продукта со скидкой: " + getNameOfProduct() + " стоимость: " + getPriceOfProduct() + " скидка" + "(" + discountPercent + "%)";
    }
}
