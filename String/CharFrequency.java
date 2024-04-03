/*
Most optimized code to find frequency of all alphabet in any string.
Or with little modification we can get frequency of any specific character or specific characters.
*/
import java.util.*;
class CharFrequency {
    public static void main(String[] args) {
        String s = "aa>//ab1!.baa c+c\\cd";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                if(c>='a'&&c<='z' || c>='A'&&c<='Z'){
                    map.put(c,1);
                }
            }
    
        }
        
        map.forEach((k,v)->System.out.println(k+" "+v));
    }
}
