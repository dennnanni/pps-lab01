package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private int[] stack = new int[100];
    private int index;

    @Override
    public void push(int value) {
        stack[index++] = value;
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }
}
