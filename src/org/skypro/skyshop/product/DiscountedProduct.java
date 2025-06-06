package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String nameOfProduct, int basePrice, int discountPercent) {
        super(nameOfProduct);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0!");
        }
        if (discountPercent < 0 && discountPercent > 100) {
            throw new IllegalArgumentException(" процент должен быть числом в диапазоне от 0 до 100 включительно!");
        }
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
