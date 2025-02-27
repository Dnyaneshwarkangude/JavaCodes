Given a string S consisting of only 0s and 1s .you are required to compute the coeffient of the string ,
firstly count the number of all 0s between two consecutive 1s,ltes say that number is a.count the number of 
all 1s between two consecutive 0s let's say that number is b The string coefficient will be a+b

"10001101001010" --- input
a=3+0+1+2+1 =7
b=0+0+2+1+0+1+1=5
a+b=12 ---output


Code : 

 class Main {
    public static void main(String[] args) {
        String s = "01011001110";
        int a = 0 , b = 0;
        int index_a = 0 , index_b = 0;
        for (int i=1; i<=s.length(); i++){
            if(s.charAt(i-1) == '1'){
                if (index_a == 0 ){
                    index_a = i;
                    continue;
                }
                a = a + (i - index_a - 1);
                index_a = i;
            }
            
            if(s.charAt(i-1) == '0'){
                if (index_b == 0 ){
                    index_b = i;
                    continue;
                }
                b = b + (i - index_b - 1);
                index_b = i;
            }
        }
        System.out.println("last a+b = " + (a+b));
    }
}
