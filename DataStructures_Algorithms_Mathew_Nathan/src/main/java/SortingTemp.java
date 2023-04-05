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
}
