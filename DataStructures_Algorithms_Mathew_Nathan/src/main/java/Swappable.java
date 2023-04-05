public interface Swappable<T extends Comparable<T>> {
    void swap(int firstIndex, int secondIndex);

    int size();

    T get(int index);


}
