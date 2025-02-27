package tdd;

public class CircularQueueImpl implements CircularQueue {

    private static final int SIZE = 10;
    private final int[] queue = new int[SIZE];
    private int startIndex;
    private int index;
    private int elementsCount;

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private int restartIfAtEnd(int index) {
        return index == SIZE ? 0 : index;
    }

    @Override
    public void enqueue(int value) {
        index = restartIfAtEnd(index);
        int previousIndex = index;
        queue[index++] = value;
        elementsCount++;
        if (elementsCount != 0 && previousIndex == startIndex) {
            startIndex = restartIfAtEnd(startIndex + 1);
        }
    }

    @Override
    public int dequeue() {
        startIndex = restartIfAtEnd(startIndex);
        elementsCount--;
        return queue[startIndex++];
    }
}
