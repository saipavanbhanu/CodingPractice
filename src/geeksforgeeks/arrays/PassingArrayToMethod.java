package geeksforgeeks.arrays;

public class PassingArrayToMethod {
    public static void main(String []args){
        int arr[] = m1(10);
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = i;
        }

        for(int i =0; i<arr.length; i++)
            System.out.println(i);

        int count = 0, size = 3;
        int arr2d[][] = m2(size);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr2d[i][j] = ++count;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(arr2d[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(arr.getClass());
        System.out.println(arr2d.getClass());

    }

    public static int[] m1(int size){
        return new int[size];
    }

    public static int[][] m2(int size){
        return new int[size][size];
    }

}
