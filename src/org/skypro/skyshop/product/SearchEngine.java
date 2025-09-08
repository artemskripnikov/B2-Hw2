package org.skypro.skyshop.product;

import org.skypro.skyshop.product.Exeption.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();


    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Set<Searchable> search(String query) {

        if (query == null || query.trim().isEmpty()) {
            return new TreeSet<>();
        }

        String lowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>()));
    }


    public Searchable findBestMatch(String searchQuery) throws BestResultNotFound {
        Set<Searchable> results = search(searchQuery);

        if (results.isEmpty()) {
            throw new BestResultNotFound(searchQuery);
        }

        String lowerQuery = searchQuery.toLowerCase();

        return results.stream()
                .max((item1, item2) -> {
                    int count1 = countSubstringOccurrences(item1.getSearchTerm().toLowerCase(), lowerQuery);
                    int count2 = countSubstringOccurrences(item2.getSearchTerm().toLowerCase(), lowerQuery);
                    return Integer.compare(count1, count2);
                })
                .orElseThrow(() -> new BestResultNotFound(searchQuery));
    }

    private int countSubstringOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }
        return count;
    }
}








