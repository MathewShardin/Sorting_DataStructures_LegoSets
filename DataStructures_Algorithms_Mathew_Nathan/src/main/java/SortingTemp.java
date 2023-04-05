public class SortingTemp {

    public static <T extends Swappable> T bubbleSort(T collection) {
        int size = collection.size();
        T collectionOut = collection;

        for (int a = size; a > 1; a--) {
            for (int i = 0; i < a - 1; i++) {
                // Swap elements if an element
                if (collectionOut.get(i).compareTo(collectionOut.get(i + 1)) > 0) {
                    collectionOut.swap(i, i + 1);
                }
            }
        }
        return collectionOut;
    }

    public static <T extends Swappable> int partition(T collection, int low, int high) {
        Comparable pivot = collection.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (collection.get(j).compareTo(pivot) <= 0) {
                i++;
                collection.swap(i, j);
            }
        }
        collection.swap(i + 1, high);
        return i + 1;
    }

    public static <T extends Swappable> void quickSort(T collection, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(collection, low, high);
            quickSort(collection, low, partitionIndex - 1);
            quickSort(collection, partitionIndex + 1, high);
        }
    }

    public static <T extends Swappable> void sort (T collection) {
        if (collection == null || collection.size() <= 1) {
            return;
        }
        quickSort(collection, 0, collection.size() - 1);
    }
}
