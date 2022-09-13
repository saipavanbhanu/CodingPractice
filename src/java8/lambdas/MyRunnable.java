package java8.lambdas;
class MyRunnableWithLambda{
    public void m1(){
        Thread t = new Thread(() -> {
           for(int i = 0; i < 4; i++){
               System.out.println("Child Thread");
           }
        });
        t.start();
        for(int i = 0; i < 4; i++){
            System.out.println("Main Thread");
        }
    }
}
public class MyRunnable {
    public static void main(String []args){
        MyRunnableWithLambda obj = new MyRunnableWithLambda();
        obj.m1();
        System.out.println("-----------------------------------------------------------");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 4 ; i++){
                    System.out.println("Child Thread2");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        for(int i = 0; i < 4; i++){
            System.out.println("Main Thread2");
        }

    }
}
