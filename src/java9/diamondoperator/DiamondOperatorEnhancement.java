package java9.diamondoperator;

class MyGenClass<T>{
    T obj;
    public MyGenClass(T obj){
        this.obj = obj;
    }
    public T getObj(){
        return obj;
    }
    public void process(){
        System.out.println("Processing obj");
    }
}
public class DiamondOperatorEnhancement {
    public static void main(String [] args){
        MyGenClass<String> c1 = new MyGenClass<String>("Bhanu"){
            public void process(){
                System.out.println("Processing obj "+getObj());
            }
        };
        c1.process();
        MyGenClass<String> c2 = new MyGenClass<>("Sai"){
            public void process(){
                System.out.println("Processing obj "+getObj());
            }
        };
        c2.process();
    }
}
