package java9.trywithresources;
class MyResource implements AutoCloseable {
    MyResource(){
        System.out.println("Resource Creation.");
    }
    public void doProcess(){
        System.out.println("Resource processing...");
    }
    public void close(){
        System.out.println("Resource closing.");
    }
}
public class TryWithResources {
    public static void preJdk7(){
        MyResource r = new MyResource();
        try{
            r.doProcess();
        }catch (Exception e){
            System.out.println("Handling "+e);
        }finally {
            if(r != null ){
                r.close();
            }
        }
    }
    public static void jdk7(){
        try(MyResource r = new MyResource()){
            r.doProcess();
        }catch (Exception e){
            System.out.println("Handling "+e);
        }
    }
    public static void jdk9(){
        MyResource r = new MyResource();
        try(r){
            r.doProcess();
        }catch (Exception e ){
            System.out.println("Handling "+e);
        }
    }
    public static void main(String [] args){
        System.out.println("Pre JDK 7");
        preJdk7();
        System.out.println("JDK 7");
        jdk7();
        System.out.println("JDK 9");
        jdk9();
    }
}
