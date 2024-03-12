// We have two array give and we have to merge them while sorting 

import java.util.*;
public class twosorted{
    private static void createarray(int[] array){
        Random r = new Random();
        for (int i =0; i<array.length; i++){
            array[i] = r.nextInt(99);
        }
    }
    private static List<Integer> sortmerge(int[] a1,int[]a2){
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(a1[0]);
        
         
        for (int i=1; i<a1.length; i++){ 
            for(int j=0; j<ans.size(); j++){
                
                if (a1[i]<ans.get(j)){
                    ans.add(j,a1[i]);
                    break;
                } 
                if (a1[i] > ans.get(ans.size()-1)){
                    ans.add(a1[i]);
                }
            }
             
        }
        for (int i=0; i<a2.length; i++){ 
            for(int j=0; j<ans.size(); j++){
                
                if (a2[i]<ans.get(j)){
                    ans.add(j,a2[i]);
                    break;
                } 
                if (a2[i] > ans.get(ans.size()-1)){
                    ans.add(a2[i]);
                }
            }
             
        }
        

        return ans;
    }
    public static void main(String[] args){
        int[] a1 = new int[8];
        int[] a2 = new int[8];
        createarray(a1);
        createarray(a2);
        List<Integer> ans = sortmerge(a1,a2);
        System.out.println("a1 = " +Arrays.toString(a1));
        System.out.println("a2 = " +Arrays.toString(a2));
        System.out.println("ans = " +ans);
        System.out.println(ans.size());

    }
}
