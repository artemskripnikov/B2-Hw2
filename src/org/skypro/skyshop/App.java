package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket1 = new ProductBasket();
        Product milk = new SimpleProduct("Молоко", 200);
        Product cheese = new DiscountedProduct("Сыр", 115,20);
        Product bread = new FixPriceProduct("Хлеб");
        Product eggs = new SimpleProduct("Яйца", 50);
        Product sugar = new SimpleProduct("Сахар", 130);
        Product salt = new SimpleProduct("Соль", 95);
        System.out.println("1. Добавление продукта в корзину:");
        basket1.addProduct(new SimpleProduct("Молоко", 200));
        System.out.println("Добавлено: " + milk.getNameOfProduct());
        System.out.println("2. Добавление в корзину:");
        try {
            basket1.addProduct(cheese);
            basket1.addProduct(bread);
            basket1.addProduct(eggs);
            basket1.addProduct(sugar);
            System.out.println("Добавлено 4 продукта");
            basket1.addProduct(salt);
            System.out.println("Добавлено: " + salt.getNameOfProduct());
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("3. Печать содержимого корзины:");
        basket1.printContents();
        System.out.println("4. Получение стоимости корзины:");
        System.out.println("Общая стоимость: " + basket1.getTotalPrice() + " руб.");

        System.out.println("5. Поиск товара, который есть в корзине:");
        String searchName = "хлеб";
        System.out.println("Есть ли '" + searchName + "' в корзине? " +
                basket1.containsProductByName(searchName));

        System.out.println("6. Поиск товара, которого нет в корзине:");
        searchName = "колбаса";
        System.out.println("Есть ли '" + searchName + "' в корзине? " +
                basket1.containsProductByName(searchName));

        System.out.println("7. Очистка корзины:");
        basket1.clearAllProducts();
        System.out.println("Корзина очищена");

        System.out.println("8. Печать пустой корзины:");
        basket1.printContents();

        System.out.println("9. Получение стоимости пустой корзины:");
        System.out.println("Общая стоимость: " + basket1.getTotalPrice() + " руб.");

        System.out.println("10. Поиск в пустой корзине:");
        searchName = "молоко";
        System.out.println("Есть ли '" + searchName + "' в корзине? " +
                basket1.containsProductByName(searchName));

    }
}
