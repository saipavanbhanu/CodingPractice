package multithreading.problems;

public class OrderedPrinting {
    int count;
    OrderedPrinting(){
        count = 1;
    }
    public void printFirst(){
        synchronized (this){
            System.out.println("First");
            count++;
            notifyAll();
        }

    }
    public void printSecond(){
        synchronized (this){
            while(count != 2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Second");
            count++;
            notifyAll();
        }

    }
    public void printThird(){
        synchronized (this){
            while(count != 3){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Third");
        }
    }

    public static void main(String[] args) {
        OrderedPrinting op = new OrderedPrinting();
        OrderedPrintingThread first = new OrderedPrintingThread("first", op);
        OrderedPrintingThread second = new OrderedPrintingThread("second", op);
        OrderedPrintingThread third = new OrderedPrintingThread("third", op);

        first.start();
        second.start();
        third.start();
        try{
            first.join();
            third.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread finished");
    }
}

class OrderedPrintingThread extends Thread{
    String name;
    OrderedPrinting obj;
    OrderedPrintingThread(String name, OrderedPrinting obj){
        this.name = name;
        this.obj = obj;
    }
    @Override
    public void run() {
        if("first".equals(name)){
            obj.printFirst();
        }else if("second".equals(name)){
            obj.printSecond();
        }else{
            obj.printThird();
        }
    }
}