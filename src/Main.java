import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.Exeption.BestResultNotFound;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Молоко", 200));
        searchEngine.add(new DiscountedProduct("Сыр", 115, 20));
        searchEngine.add(new FixPriceProduct("Хлеб"));
        searchEngine.add(new Article("Выбор молочных продуктов", "Как выбрать хорошее молоко"));
        searchEngine.add(new SimpleProduct("Яйца", 90));
        searchEngine.add(new DiscountedProduct("Молоко цельное", 140, 15));
        System.out.println("Все товары со словом 'молоко': ");
        List<Searchable> milkResults = searchEngine.search("молоко");
        for (Searchable item : milkResults) {
            System.out.println(item.getStringRepresentation());
        }
        try {
            searchEngine.add(new DiscountedProduct("", 60, 5));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            searchEngine.add(new SimpleProduct("Пельмени", 0));
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        try {
            System.out.println("Результаты поиска по 'молоко' : ");
            Searchable bestMilk = searchEngine.findBestMatch("молоко");
            System.out.println(bestMilk.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println("Поиск несуществующего товара:");
            searchEngine.findBestMatch("колбаса");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        SearchEngine searchEngine1 = new SearchEngine();
        searchEngine1.add(new SimpleProduct("Молоко натуральное коровье молоко", 80));
        searchEngine1.add(new SimpleProduct("Молоко пастеризованное", 90));
        searchEngine1.add(new SimpleProduct("Сыр Российский", 120));
        searchEngine1.add(new Article("Молоко и молочные продукты", "Статья о молоке"));

        try {
            Searchable result1 = searchEngine1.findBestMatch("молоко");
            System.out.println("Найден: " + result1.getName());
            Searchable result2 = searchEngine1.findBestMatch("хлеб");
        } catch (BestResultNotFound f) {
            System.err.println(f.getMessage());
        }

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new SimpleProduct("Банан", 30));
        basket.addProduct(new DiscountedProduct("Яблоко", 50, 40));
        basket.addProduct(new SimpleProduct("Апельсин", 70));

        List<Product> removedApples = basket.removeAllProductsByName("яблоко");
        System.out.println("Удаленные продукты:");
        for (Product product : removedApples) {
            System.out.println(product);
        }

        System.out.println("Корзина после удаления:");
        basket.printContents();

        System.out.println("Удаляем несуществующий продукт");
        List<Product> removedPears = basket.removeAllProductsByName("Груша");
        if (removedPears.isEmpty()) {
            System.out.println("Список пуст: таких продуктов нет в корзине.");
        }

        basket.printContents();

    }
}





