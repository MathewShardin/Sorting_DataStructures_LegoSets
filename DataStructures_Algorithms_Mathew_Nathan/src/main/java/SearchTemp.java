public class SearchTemp {
    public static <T extends Swappable, E extends Comparable> E binarySearch(T coll, E key) {
        T collection = SortingTemp.bubbleSort(coll);

        int left = 0;
        int right = collection.size() - 1;

        int mid = left + (right - left) / 2;;
        while (left <= right) {
            mid = left + (right - left) / 2;

            int cmp = key.compareTo(collection.get(mid));
            if (cmp == 0) {
                return (E) collection.get(mid);
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //If not found return closest value
        return (E) collection.get(mid+1);
    }

    public static <T extends Swappable> LegoSet binarySearchLegoSetByName(String name, T collection) {
        LegoSet setTemp = new LegoSet(name, 0, 0);
        LegoSet setOut = SearchTemp.binarySearch(collection, setTemp);
        return setOut;
    }

    public static <T extends Swappable,E extends Comparable> E jumpSearch (T collection, E key){
        collection = SortingTemp.sort(collection);
        int collectionSize = collection.size();
        int prev = 0;
        //Square root of size of collection for number of steps. Much more efficient than hardcoding int
        int forward = (int)Math.floor(Math.sqrt(collectionSize));
        while (prev < collectionSize && collection.get(prev).compareTo(key) < 0){
            prev += forward;
        }
        int back = prev - forward;
        while (back <= prev && collection.get(back).compareTo(key) < 0){
            back++;
        }
        if (back >= prev && collection.get(back).compareTo(key) != 0){
            //does not exist
            return null;
        }
        else{
            return (E) collection.get(back);
        }
    }

    public static <T extends Swappable> LegoSet jumpSearchLegoSetByName(String name, T collection) {
        LegoSet setTemp = new LegoSet(name, 0, 0);
        LegoSet setOut = SearchTemp.jumpSearch(collection, setTemp);
        return setOut;
    }
}
