package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private int[] stack = new int[100];
    private int index;
    private int max;

    @Override
    public void push(int value) {
        stack[index++] = value;
        if (value > max) {
            max = value;
        }
    }

    @Override
    public int pop() {
        if (index == 0) {
            throw new IllegalStateException();
        }
        int returnValue = stack[--index];
        if (returnValue == max) {
            max = peek();
            for (int i = 0; i < index; i++) {
                if (stack[i] > max) {
                    max = stack[i];
                }
            }
        }
        return returnValue;
    }

    @Override
    public int peek() {
        return stack[index - 1];
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
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
