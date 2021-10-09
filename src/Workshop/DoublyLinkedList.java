package Workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.next = head;
            this.head.prev = newNode;
        } else {
            tail = newNode;
        }
        this.head = newNode;
        size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        tail = newNode;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty List.");
        }
        int result = this.head.value;
        this.head = this.head.next;
        if (this.size > 1) {
            this.head.prev = null;
        }
        this.size--;
        if (isEmpty()) {
            this.head = this.tail = null;
        }
        return result;
    }

    public int removeLast() {
        if (this.size < 2) {
            removeFirst();
        }
        int result = this.tail.value;
        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;
        return result;
    }

    public int get(int index) {
        checkIndex(index);
        int result = 0;
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.value;
        } else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            result = currentNode.value;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("the index" + index + "is out of bounds");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
//        int[] array = new int[this.size];
//        int counter = 0;
//        Node currentNode = this.head;
//        while (currentNode != null) {
//            array[counter] = currentNode.value;
//            currentNode = currentNode.next;
//            counter++;
//        }
//        return array;
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }
}
