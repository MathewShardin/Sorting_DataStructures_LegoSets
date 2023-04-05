public class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        checkCapacity();
        this.elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.elements[index];
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--size] = null;
    }

    private void checkCapacity() {
        if (size == elements.length) {
            Object[] newCapacity = new Object[(elements.length*3)/2+1];
            System.arraycopy(elements, 0, newCapacity, 0, elements.length);
            this.elements = newCapacity;
        }
    }
}
