import java.util.Scanner;

class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head; // Head node of the list

    // Insert node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Node inserted at end.");
    }

    // Insert node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Node inserted at beginning.");
    }

    // Insert node at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position! Position should be >= 1.");
            return;
        }

        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Node inserted at position " + position);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Node inserted at position " + position);
    }

    // Delete node by value
    public void deleteNode(int key) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            System.out.println("Node deleted.");
            return;
        }

        // Search for the key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }

        prev.next = temp.next;
        System.out.println("Node deleted.");
    }

    // Display the linked list
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class LinkedListMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice, data, position;

        do {
            System.out.println("\n*** Singly Linked List Menu ***");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete a Node");
            System.out.println("5. Display List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert at beginning: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    data = scanner.nextInt();
                    list.deleteNode(data);
                    break;
                case 5:
                    list.displayList();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
