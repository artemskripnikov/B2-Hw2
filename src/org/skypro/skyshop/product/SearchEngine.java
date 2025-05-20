package org.skypro.skyshop.product;

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
    }



