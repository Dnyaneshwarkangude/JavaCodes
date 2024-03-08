// Frequency of each character in string

import java.util.Scanner;

public class frequencyInString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (int i =0 ; i<str.length(); i++){
            int count = 1;
            boolean flag=true ;
            for ( int j = i+1; j<str.length() ; j++){
                if (str.charAt(i) == str.charAt(j)){
                    ++count;
                }
            }
            for (int k = 0; k<i; k++){
                if (str.charAt(i) == str.charAt(k)){
                    flag = false;
                }
            }
            if (flag){
                System.out.println(str.charAt(i)+ ":"+count);
            }
             
        }
    }
}
