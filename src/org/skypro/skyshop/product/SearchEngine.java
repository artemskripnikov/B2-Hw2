package org.skypro.skyshop.product;

import org.skypro.skyshop.product.Exeption.BestResultNotFound;

import java.util.*;

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
        Set<Searchable> resultSet = new TreeSet<>();

        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                resultSet.add(item);
            }
        }
        return resultSet;
    }




    public Searchable findBestMatch(String searchQuery) throws BestResultNotFound {
        Set<Searchable> results = search(searchQuery);

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






