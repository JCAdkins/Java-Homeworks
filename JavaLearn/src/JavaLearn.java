/* This is my learning project for Java*/

/*By Jordan Adkins*/

class Guess {

public static void main(String args[]){
        int e, result;
        
        for(int i = 0; i < 10; i++){
            result = 1;
            e = i;
            while(e > 0){
                result *= 2;
                e--;
            }
        
         System.out.println("2 to the " + i + " power is " + result);

}
}
}