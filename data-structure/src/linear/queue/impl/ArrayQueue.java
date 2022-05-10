package linear.queue.impl;

public class ArrayQueue implements Queue {

    private int front;
    private int rear;
    private int queueSize;
    private char queueArr[];

    public ArrayQueue(int queueSize) {
        front = -1;
        rear = -1;
        this.queueSize = queueSize;
        queueArr = new char[this.queueSize];
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        return (front == rear); //front, rear 포인터가 같은 경우 데이터가 없는 상태이므로 true 아닌 경우 false return
    }

    @Override
    public boolean isFull() {
        // rear 포인터가 큐의 마지막 인덱스와 동일한 경우 true 아닌 경우 false return
        return (rear == this.queueSize-1);
    }

    //큐에 데이터 삽입
    @Override
    public void enqueue(char item) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            queueArr[++rear] = item;
            System.out.println("Inserted : " + item);
        }
    }

    @Override
    public char dequeue() {
        if (isEmpty()) {
            System.out.println("Deleting Fail Queue is Empty");
            return 0;
        } else {
            System.out.println("Deleted Item : " + queueArr[front+1]);

            // front 포인터는 삭제할 위치에 있는 상태이므로 다음과 같이 (front + 1) % size 로 설정.
            // front + 1 로 설정하면 front 포인터가 마지막 요소에 위치했을 경우,
            // ArrayOutOfBoundException이 발생하기 때문에 (front + 1) % size 로 설정해줌.
            // ex) 큐의 size가 5일 때 (index 범위는 0 ~ 4)
            // index of front 3: (3 + 1) % 5 = 4
            // index of front 4: (4 + 1) % 5 = 0
            front = (front + 1) % this.queueSize;

            return queueArr[front];
        }
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("Peeking fail Queue is Empty");
            return 0;
        } else {
            // front 포인터는 삭제한 위치에 있으므로 +1을 해줘서 첫번째 요소를 추출하도록 지정.
            System.out.println("Peeked Item : " + queueArr[front+1]);
            return queueArr[front+1];
        }
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("Queue is Already Empty");
        } else {
            front = -1;
            rear = -1;
            queueArr = new char[this.queueSize];
            System.out.println("Queue is Clear");
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.print("Queue elements : ");
            // front 포인터는 -1 또는 삭제된 요소의 위치에 있기 때문에,
            // +1 위치를 시작점으로 지정.
            for (int i = front+1; i<=rear; i++) {
                System.out.print(queueArr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int queueSize = 5;
        ArrayQueue arrQueue = new ArrayQueue(queueSize);

        arrQueue.enqueue('A');
        arrQueue.printQueue();

        arrQueue.enqueue('B');
        arrQueue.printQueue();

        arrQueue.enqueue('C');
        arrQueue.printQueue();

        arrQueue.enqueue('D');
        arrQueue.printQueue();

        arrQueue.enqueue('E');
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.peek();
        arrQueue.printQueue();

        arrQueue.clear();
        arrQueue.printQueue();
    }
}

