package Workshop;

public class SmartArray {
    private final static int INITIAL_CAPACITY = 8;
    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(int element) {
        if (this.size == elements.length) {
            this.elements = resize();
        }
        this.elements[this.size] = element;
        this.size++;
    }

    private int[] resize() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        return newElements;
    }

    public int get(int index) {
        isValidIndex(index);
        return this.elements[index];
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        isValidIndex(index);
        int removed = this.elements[index];
        if (this.size - 1 - index >= 0)
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
        this.elements[this.size - 1] = 0;
        this.size--;
        return removed;
    }

    private void isValidIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size" + this.size);
        }
    }
}
