package org.skypro.skyshop.product.Exeption;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Не найдено подходящих результатов для запроса: '" + searchQuery + "'");
    }
}
