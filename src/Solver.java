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
                System.out.println("Length of startword and endword is different!");
            }else{
                filepath = "resources\\" +  startword.length() + "-letter-words.txt";
                kamus = new Kamus(filepath);
                startword = startword.toUpperCase();
                endword = endword.toUpperCase();

                if(!kamus.isValid(startword) || !kamus.isValid(endword)){
                    System.out.println("Your words isn't valid");
                }
                else{
                    stop = true;
                    System.out.println("Your words is valid!");
                }
            }
            
        }

        scanner.close();   
    }
}