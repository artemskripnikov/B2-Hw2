package org.skypro.skyshop.product;

import org.skypro.skyshop.product.Exeption.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();


    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        if (query == null || query.trim().isEmpty()) {
            return results;
        }

        String lowerQuery = query.toLowerCase();
        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results.add(item);
            }
        }
        return results;
    }




    public Searchable findBestMatch(String searchQuery) throws BestResultNotFound {
        List<Searchable> results = search(searchQuery);

        if (results.isEmpty()) {
            throw new BestResultNotFound(searchQuery);
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;
        String lowerSearch = searchQuery.toLowerCase();

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            int occurrences = countSubstringOccurrences(searchTerm, lowerSearch);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
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






