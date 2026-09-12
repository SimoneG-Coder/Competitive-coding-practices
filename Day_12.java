//4 Types of queues- linear queue, priority queue, circular queue, circular queue
//modulo used in circular queue
// Design Circulr queue problem no:622 leetcode

//types of dequeue

class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor: initialize queue with given capacity
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert element into circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Delete element from circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Get front item
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    // Get last item
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
}
