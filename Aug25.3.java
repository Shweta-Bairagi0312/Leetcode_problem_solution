class MyCircularQueue {
    int[]queue;
    int size;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        queue = new int[k+1];
        size = k+1;
        front = 0;
        rear = 0;

        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = (rear+1)%size;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        int val = queue[front];
        front = (front+1)%size;
        return true;
        
    }
    
    public int Front() {
       if(isEmpty()) return -1;
       return queue[front];
        
    }
    
    public int Rear() {
       if(isEmpty()) return -1;
       return queue[(rear-1+size)%size];

        
    }
    
    public boolean isEmpty() {
        return rear == front;
        
    }
    
    public boolean isFull() {
        return (rear+1)%size == front;
        
    }
}
