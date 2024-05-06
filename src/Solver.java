import java.util.Scanner;
public class Solver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean stop = false;
        String startword, endword, filepath;
        Kamus kamus;

        while(!stop){
            System.out.println("Start word: ");
            startword = scanner.nextLine();
            System.out.println("End word: ");
            endword = scanner.nextLine();

            if(startword.length() != endword.length()){
                System.out.println("\nLength of startword and endword is different!");
            }else{
                stop = true;
                filepath = "resources\\" +  startword.length() + "-letter-words.txt";
                kamus = new Kamus(filepath);
                System.out.println("Tes1");
                String tes = "EAT";
                if(kamus.isValid(tes)){
                    System.out.println("Aman!");
                }
                else{
                    System.out.println("Tes2");
                }
            }
            
        }

        scanner.close();   
    }
}