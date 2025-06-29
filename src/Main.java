import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.Exeption.BestResultNotFound;

public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Молоко", 200));
        searchEngine.add(new DiscountedProduct("Сыр", 115, 20));
        searchEngine.add(new FixPriceProduct("Хлеб"));
        searchEngine.add(new Article("Выбор молочных продуктов", "Как выбрать хорошее молоко"));
        searchEngine.add(new SimpleProduct("Яйца", 90));
        searchEngine.add(new DiscountedProduct("Молоко цельное", 140, 15));
        try {
            searchEngine.add(new DiscountedProduct("", 60, 5));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            searchEngine.add(new SimpleProduct("Пельмени", 0));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Результаты поиска по 'молоко' : ");
        Searchable[] results = searchEngine.search("молоко");

        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }

        SearchEngine searchEngine1 = new SearchEngine(5);
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

    }
}





