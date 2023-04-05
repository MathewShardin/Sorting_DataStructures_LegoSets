public class SearchTemp {
    public static <T extends Swappable, E extends Comparable> E binarySearch(T collection, E key) {
        T collectionOut = SortingTemp.bubbleSort(collection);

        int left = 0;
        int right = collection.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = key.compareTo(collection.get(mid));
            if (cmp == 0) {
                return (E) collection.get(mid);
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //If not found
        return null;
    }

    public static <T extends Swappable> LegoSet binarySearchLegoSetByName(String name, T collection) {
        LegoSet setTemp = new LegoSet(name, 0, 0);
        LegoSet setOut = SearchTemp.binarySearch(collection, setTemp);
        return setOut;
    }

}
