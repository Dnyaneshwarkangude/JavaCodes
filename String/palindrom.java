// Find given string is palindrom or not
// Most optimized code is at last of this file.

import java.util.Scanner;

public class palindrom {
    public static void main(String args[]){
        System.out.print("Enter string : ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        
        if (palin(str)){
            System.out.println("String is palindrom .");
        }else{System.out.println("String is not palindrom.");}
    }
    static boolean palin(String s){
        String rever="";
        char ch;

        for (int i=0; i < s.length(); i++){
            ch = s.charAt(i);
            rever = ch + rever;
        }
        
        if (s.equals(rever)){
            return true;
        }
        else {
            return false;
        }
    }
}

// Optimized code:
import java.util.*;
class palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        StringBuilder revs = new StringBuilder(s); 
        if(revs.reverse().toString().equals(s)){
            System.out.println("String is pallindrom.");
        }
        else{
            System.out.println("String is not pallindrom.");
        }
    }
}
