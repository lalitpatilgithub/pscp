
package pscp;

public class CircularQueue {
    int [] array;
    int front, rear, size, capacity;

    public CircularQueue(int cap){
        this.capacity = cap;
        this.array = new int[cap];
        this.front = -1 ;
        this.rear = -1;
        this.size = 0;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        for (int i: queue.array) {
            System.out.println(i);
        }
    }

    public void dequeue() {

        if(front==-1)
            System.out.println("Can not dequeue further as empty....");
        else{
            array[front] =0;
            if(front==rear) {
                front = -1;
                rear = -1;
            }else if(front==capacity-1){
                front=0;
            }
            else {
                front++;
            }
            System.out.println("element dequeued");
        }

    }

    public void enqueue(int element) {
        if((front==0 && rear==capacity-1) || rear+1==front){
            System.out.println("CQ full...");
            return;
        }
        if(rear==-1){
            rear =0;
            front =0;
        }else if(rear==capacity-1){
            rear=0;
        }else{
            rear++;
        }
        array[rear] = element ;
    }
}
