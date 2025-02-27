package tdd;

public class CircularQueueImpl implements CircularQueue {

    public static final int SIZE = 10;
    private final int[] queue = new int[SIZE];
    private int startIndex;
    private int index;
    private int elementsCount;

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public boolean isFull() {
        return elementsCount == SIZE;
    }

    private int restartIfAtEnd(int index) {
        return index == SIZE ? 0 : index;
    }

    @Override
    public void enqueue(int value) {
        index = restartIfAtEnd(index);
        queue[index++] = value;
        if (isFull()) {
            startIndex = restartIfAtEnd(startIndex + 1);
        } else {
            elementsCount++;
        }
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        startIndex = restartIfAtEnd(startIndex);
        elementsCount--;
        return queue[startIndex++];
    }

    @Override
    public int getElementsCount() {
        return elementsCount;
    }
}
