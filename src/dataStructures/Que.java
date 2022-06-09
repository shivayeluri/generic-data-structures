package dataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class Que<T> {
    int SIZE;
//    T[] items;
    ArrayList<T> items;
    int front;
    int rear;

    public Que(int size) {
        SIZE = size;
//        items = new T[];
        items = new ArrayList<T>(SIZE);
        front = -1;
        rear = -1;
    }

    public void operation() {
        System.out.println(" ");
        System.out.println("Choose one operation");
        System.out.print("1. enqueue\n2. dequeue\n3. print\n4. quit");
        System.out.println(" ");
        int counter = 0;

        try {
            while (counter != 4) {
                Scanner sc = new Scanner(System.in);
                System.out.println("select operation");
                int option = sc.nextInt();
                if (option > 0 && option < 5) {
                    switch (option) {
                        case 1 -> {
                            Scanner sc1 = new Scanner(System.in);
                            System.out.println("what you want to enqueue");
                            String input = sc1.nextLine();
                            enQueue((T) input);
                            display();
                        }
                        case 2 -> deQueue();
                        case 3 -> display();
                        case 4 -> {
                            display();
                            counter = 4;
                            System.exit(-1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("If your selecting queue operations, Please chose between 1 - 4 only !");
//            System.out.println("If you entering input data or index value, Please make sure that you have entered numbers only !");
            operation();
//            e.printStackTrace();
        }
    }

    boolean isQueFull() {
        return front == 0 && rear == SIZE - 1;
    }

    boolean isQueEmpty() {
        return front == -1;
    }

    void enQueue(T element) {
        if (isQueFull()) {
            System.out.println("Queue is full");
            System.exit(-1);
        } else {
            if (front == -1) {
                front = 0;
            }

            ++rear;
            items.add(rear, element);
            System.out.println("Insert " + element);
        }

    }

    void deQueue() {
        if (isQueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            T element = items.get(rear);
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                --rear;
            }

            System.out.println("" + element + " Deleted");
        }

    }

    void display() {
        if (isQueEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");

            for (int i = rear; i >= front; --i) {
                T value = items.get(i);
                System.out.print("" + value + "  ");
            }

            System.out.println("\nRear index-> " + rear);
        }

    }
}
