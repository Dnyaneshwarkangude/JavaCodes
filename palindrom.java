// Find given string is palindrom or not


import java.util.Scanner;

public class palindrom {
    public static void main(String args[]){
        System.out.print("Enter string : ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
    
        
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
