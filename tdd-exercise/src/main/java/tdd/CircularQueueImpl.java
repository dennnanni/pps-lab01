package tdd;

public class CircularQueueImpl implements CircularQueue {

    private final int[] queue = new int[10];
    private int startIndex;
    private int index = 0;

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public void enqueue(int value) {
        if (index == 10) {
            index = 0;
        }
        queue[index++] = value;
    }

    @Override
    public int dequeue() {
        return queue[startIndex++];
    }
}
