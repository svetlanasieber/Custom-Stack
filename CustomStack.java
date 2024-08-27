package CustomStack;

import java.util.function.Consumer;

public class CustomStack {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;

    }

    public void push(int element) {
        this.enshureCapacity();
        this.data[this.size] = element;
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    private void enshureCapacity() {
        if (this.size == this.capacity) {
            resize();
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }

        this.data = temp;
    }

    public int pop() {
        this.enshureStacIsNotEmpty();
        int itemToremove = this.data[size - 1];
        data[size - 1] = 0;
        this.size--;
        return itemToremove;
    }

    private void enshureStacIsNotEmpty() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("The stack is empty!");
        }
    }

    public int peek() {
        return this.data[size - 1];
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
