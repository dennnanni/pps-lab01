package tdd;

public class CircularQueueImpl implements CircularQueue {

    private final int[] queue = new int[10];
    private int index = 0;

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public void add(int value) {
        if (index == 10) {
            index = 0;
        }
        queue[index++] = value;
    }
}
