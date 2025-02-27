package tdd;

public class CircularQueueImpl implements CircularQueue {

    private final int[] queue = new int[10];
    private int startIndex;
    private int index;
    private int elementsCount;

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private int restart(int index) {
        return index == 10 ? 0 : index;
    }

    @Override
    public void enqueue(int value) {
        index = restart(index);
        int previousIndex = index;
        queue[index++] = value;
        elementsCount++;
        if (elementsCount != 0 && previousIndex == startIndex) {
            startIndex = restart(startIndex + 1);
        }
    }

    @Override
    public int dequeue() {
        startIndex = restart(startIndex);
        elementsCount--;
        return queue[startIndex++];
    }
}
