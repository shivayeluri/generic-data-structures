package dataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class Stack<T> {
//    private int[] arr;
    ArrayList<T> arr;
    private int top;
    private final int capacity;

    public Stack(int size) {
//        arr = new int[size];
        arr = new ArrayList<T>(size);
        capacity = size;
        top = -1;
    }

    public void operations() {
        System.out.println(" ");
        System.out.println("Choose one operation");
        System.out.print("1. Push\n2. Pop\n3. Is-empty\n4. Is-full\n5. Print-Stack\n6. stop");
        System.out.println(" ");
        int counter = 0;

        try{
            while(counter == 0)  {
                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.println("select operation");
                int option = sc.nextInt();
                if (option > 0 && option < 7) {
                    switch (option) {
                        case 1 -> {
                            System.out.println("What you want to insert : ");
                            String pushInput = sc.next();
                            push((T) pushInput);
                            printStack();
                        }
                        case 2 -> {
                            pop();
                            printStack();
                        }
                        case 3 -> System.out.println(isEmpty());
                        case 4 -> System.out.println(isFull());
                        case 5 -> printStack();
                        case 6 -> {
                            counter = 6;
                            System.exit(-1);
                        }
                    }
                } else {
                    System.out.println("please enter 1-6 only");
                }
            }
        }catch (Exception e){
            System.out.println("If your selecting stack operations, Please chose between 1 - 6 only !");
            System.out.println("If you entering input data or index value, Please make sure that you have entered numbers only !");
            operations();
        }
    }

    public void push(T x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
            printStack();
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr.add(++top,x);
        System.out.println("After inserting : ");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        System.out.println("Deleted :"+ arr.get(0));
        arr.remove(0);
        top--;

    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Your stack is empty");
        } else {
            for(int i = 0; i <= top; ++i) {
                T value = arr.get(i);
                System.out.print("" + value + ", ");
            }
        }

    }
}
