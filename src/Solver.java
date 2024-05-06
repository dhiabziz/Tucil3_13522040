import java.util.Scanner;
public class Solver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean stop = false;
        String startword, endword;
        while(!stop){
            System.out.println("Start word: ");
            startword = scanner.nextLine();
            System.out.println("End word: ");
            endword = scanner.nextLine();

            if(startword.length() != endword.length()){
                System.out.println("\nLength of startword and endword is different!");
            }else{
                stop = true;
                System.out.println("Oke!");
            }
            
        }

        scanner.close();   
    }
}