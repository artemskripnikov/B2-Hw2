package org.skypro.skyshop.product;

import org.skypro.skyshop.product.Exeption.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (currentIndex >= searchables.length) {
            throw new IllegalStateException("Хранилище переполненно");
        }
        searchables[currentIndex++] = searchable;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;
        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        String lowerQuery = query.toLowerCase();
        for (Searchable item : searchables) {
            if (item == null) continue;

            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results[foundCount++] = item;

                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }


    public Searchable findBestMatch(String searchQuery) throws BestResultNotFound {
        if (searchQuery == null || searchQuery.isBlank()) {
            throw new BestResultNotFound(searchQuery);
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;
        String lowerSearch = searchQuery.toLowerCase();

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            int occurrences = countSubstringOccurrences(searchTerm, lowerSearch);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(searchQuery);
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0 ) {
            return 0;
        }
        while ((index = text.indexOf(substring, index)) != -1 ) {
            count++;
            index += substringLength;
        }
        return count;
    }
}






