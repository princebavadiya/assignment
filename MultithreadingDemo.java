class NumberThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("NumberThread: " + i);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("NumberThread interrupted.");
        }
    }
}

class AlphabetThread extends Thread {
    @Override
    public void run() {
        try {
            for (char ch = 'A'; ch <= 'E'; ch++) {
                System.out.println("AlphabetThread: " + ch);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("AlphabetThread interrupted.");
        }
    }
}

class MessageThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("MessageThread: Hello from thread!");
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("MessageThread interrupted.");
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        AlphabetThread alphabetThread = new AlphabetThread();
        MessageThread messageThread = new MessageThread();

        numberThread.start();
        alphabetThread.start();
        messageThread.start();

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("MainThread: Task " + i);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("MainThread interrupted.");
        }
    }
}
