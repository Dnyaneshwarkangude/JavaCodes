/*
Today you decided to go the gym. You currently have E energy. There are N exercises in the gym. Each of these exercises drains
Ai amount of energy from your body.

You feel tired if your energy reaches 0 or below. Calculate the minimum number of exercises you have to perform such that you
become tired. Every unique exercise can only be performed at most 2 times as others also have to use the machines.

If performing all the exercises does not make you feel tired, return -1.

Parameters :
the first line contains an integer E,denoting the Energy.
the next line contains an integer N,denoting the number of exercises.
A :: Integer Array
Each line i of the N subsequent lines contains an integer describing the amount of energy drained by ith exercise.

Input: Case# 1
6
2
1
2
    Output : 4
Input : Case# 2
10
2
1
2
    Output: -1
*/

import java.util.*;

class Exercise{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            A.add(sc.nextInt());
        }
        Collections.sort(A);
        sc.close();
        
        int count = 0;
        for(int i = A.size()-1; i>=0 ; i--){
            if(E >= A.get(i)*2){
                E -= A.get(i)*2;
                count+=2;
            }
            else if(E >=A.get(i)){
                E -= A.get(i);
                count++;
            }
            
        }
        
        if (E>0){
            System.out.println(-1);
        }
        else{
            System.out.println(count);
        }
        
    }
}
