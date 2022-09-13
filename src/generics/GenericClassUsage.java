package generics;
class Test<T>{
    T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
class Pair<K,V>{
    K k;
    V v;
    Pair(K k, V v){
        this.k=k;
        this.v=v;
    }
    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
public class GenericClassUsage {

    public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        return p1.getK().equals(p2.getK()) && p1.getV().equals(p2.getV());
    }
    public static boolean comp(Pair<Number, Number> p){

        return true;
    }
    public static void main(String []args ){
        Test<String> ts = new Test();
        ts.setT("Hello World");
        System.out.println(ts.getT());
        Test<Integer> ti = new Test<>();
        ti.setT(96);
        System.out.println(ti.getT());
        System.out.println(GenericClassUsage.compare(new Pair<String, Integer>("String here",12), new Pair<String, Integer>("String here",13)));

        //comp(new Pair<Integer,Integer>(3,4));


    }

}
