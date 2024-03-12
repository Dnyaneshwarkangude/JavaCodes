import java.util.*;
public class quicksort {
    public static void main(String[] args) {

        Random ran = new Random();
        int [] arr = new int[8];

        for (int i=0;i<arr.length;i++){
            arr[i] = ran.nextInt(99);
        }

        System.out.println("Before : " +Arrays.toString(arr));
        quick(arr,0,arr.length-1);
        System.out.println("After : "+Arrays.toString(arr));
    }
    private static void quick(int[] array,int lowIndex,int highIndex){
        if (lowIndex>=highIndex){
            return;
        }
        int pivot = highIndex;
        int lp = partition(array,pivot,lowIndex,highIndex);

        quick(array,lowIndex,lp-1);
        quick(array,lp+1,highIndex);
    }

    private static int partition(int[] array,int pivot, int lowIndex, int highIndex){

        int lp = lowIndex;
        int rp = highIndex;
        while (lp<rp){
            while(array[lp]<=array[pivot] && lp<rp){
                lp ++;
            }
            while(array[rp]>=array[pivot] && lp<rp){
                rp--;
            }
            swapp(array,lp,rp);
        }
        swapp(array,lp,pivot);
        return lp;
    }

    private static void swapp(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
