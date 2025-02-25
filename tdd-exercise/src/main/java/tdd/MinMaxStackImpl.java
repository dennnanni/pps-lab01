package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private int[] stack = new int[100];
    private int index;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    @Override
    public void push(int value) {
        if (index == 100) {
            throw new IllegalStateException();
        }
        stack[index++] = value;
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
    }

    private void computeMax() {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < index; i++) {
            if (stack[i] > max) {
                max = stack[i];
            }
        }
    }

    private void computeMin() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int returnValue = stack[--index];
        if (returnValue == max) {
            computeMax();
        }
        if (returnValue == min) {
            computeMin();
        }
        return returnValue;
    }

    @Override
    public int peek() {
        if (index == 0) {
            throw new IllegalStateException();
        }
        return stack[index - 1];
    }

    @Override
    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return min;
    }

    @Override
    public int getMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return max;
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
