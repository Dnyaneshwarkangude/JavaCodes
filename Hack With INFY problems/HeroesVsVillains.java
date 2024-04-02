/*
There is a battle between heroes and villains going on. You have M heroes, all of them have the same health H. There are N villains, health of the ith villain is Vi.
When a hero, with health H battles a villain with health Vi, one of the three scenarios can happen:
if H > Vi: The villain is defeated and the health of the hero is decreased by Vi
if H < Vi: The villain wins, his health is not affected and the hero is no longer able to fight.
if H = Vi: Both of them are considered defeated and neither can fight.
The heroes start fighting villains one by one in the same order, first villain 1 then villain 2 and so on. It is might be possible that before defeating all the villains, all 
the heroes are defeated. Therefore, to ensure the victory of the heroes, you want to remove some villains from the front.

Your task is to find the minimum number of villains you need to remove from the front such that the victory of the heroes is guaranteed.
Note: If in the last battle, both the hero and villain are defeated and no more heroes or villains remain, it would still be considered a victory since all the villains are defeated.

Parameters:
N :: INTEGER
The first line contains an integer, N, denoting the number of villains
N :: 1 -> 2*10^5 M :: INTEGER
The next line contains an integer, M, denoting the number of heroes
M :: 1 -> 2*10^5 H :: INTEGER
The next line contains an integer, H, denoting the health of each of the heroes
H :: 1 -> 10^9
array :: INTEGER ARRAY
Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the health of each of the villains.
array[i] :: 1 -> 10^9 

*/

import java.util.*;

class HeroesVsVillains{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int H = sc.nextInt();
      ArrayList<Integer> array = new ArrayList<Integer>();
      for(int i=0; i<N; i++){
          array.add(sc.nextInt());
      }
      sc.close();
      System.out.println("Number of hero:"+M+" and each HP-"+H);
      System.out.println("villains: " +array);

      int count = 0;
      if(checkVictory(M,H,array)){
            System.out.println("victory....");
            System.out.println("villains remove from frontline = "+count);
        }
        else{
            for(int i=0; i<N; i++){
                array.remove(0);
                count++;
                if(checkVictory(M,H,array)){
                    System.out.println("victory....");
                    System.out.println("villains remove from frontline = "+count);
                    break;
                }
            }
        } 
        
    }
    
    static boolean checkVictory(int M, int H, ArrayList<Integer> list){
        ArrayList<Integer> array =new ArrayList<Integer>(list);   
        for(int h=1; h<=M; h++){
            int temp_H = H; 
            for(int v=0; v<array.size();v++){ 
                if(array.get(v)<=temp_H){
                    temp_H = temp_H - array.get(v);
                    array.remove(v);
                    v--; 
                }
                else{
                    break;
                }
            }
        }
        if(array.isEmpty()){
            return true;
        }
        else{
            return false;
        }
        
    }
}
