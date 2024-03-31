// To retrieve number from string 
// if number is anywhere in the string
// or get possible number from distributed digits in string.

import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        try{
            a = Integer.valueOf(s);
        }
        catch(Exception e){
            System.out.println(e);
            for (int i=0 ; i<s.length(); i++){
                if((int)s.charAt(i)>=(int)'0' && 
                    (int)s.charAt(i)<=(int)'9'){
                        if((int)s.charAt(i)>(int)'0'){
                            a = a*10 + ((int)s.charAt(i)-48);
                        }
                        else{
                            a = a*10;
                        }
                    }
            }
            
        }
         
        System.out.println("Number = " + a);
        
    }
}
