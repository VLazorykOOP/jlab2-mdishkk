public class DynamicQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public DynamicQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean search(int target) {
        Node current = front;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.print("Queue after enqueue: ");
        queue.display();
        
        try {
            int removed = queue.dequeue();
            System.out.println("Dequeued element: " + removed);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Queue after dequeue: ");
        queue.display();

        int searchElement = 20;
        if (queue.search(searchElement)) {
            System.out.println("Element " + searchElement + " found in the queue.");
        } else {
            System.out.println("Element " + searchElement + " not found in the queue.");
        }

        searchElement = 40;
        if (queue.search(searchElement)) {
            System.out.println("Element " + searchElement + " found in the queue.");
        } else {
            System.out.println("Element " + searchElement + " not found in the queue.");
        }
    }
}
