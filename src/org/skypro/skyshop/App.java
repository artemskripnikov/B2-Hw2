package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Молоко", 200));
        searchEngine.add(new DiscountedProduct("Сыр", 115, 20));
        searchEngine.add(new FixPriceProduct("Хлеб"));
        searchEngine.add(new Article("Выбор молочных продуктов", "Как выбрать хорошее молоко"));

        System.out.println("Результаты поиска по 'молоко' : ");
        Searchable[] results = searchEngine.search("молоко");

        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }
}
