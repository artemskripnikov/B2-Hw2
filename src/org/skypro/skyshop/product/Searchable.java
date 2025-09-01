package org.skypro.skyshop.product;

public interface Searchable extends Comparable<Searchable> {
    String getSearchTerm();

    String getContentType();

    String getName();

   default String getStringRepresentation() {
       return getName() + " - " + getContentType();
   }

    @Override
    default int compareTo(Searchable other) {
        int lengthCompare = Integer.compare(other.getName().length(), this.getName().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return this.getName().compareTo(other.getName());
    }
}
