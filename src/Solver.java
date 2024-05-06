import java.util.Scanner;
public class Solver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean inputvalid = false;
        Boolean algorithmValid = false;
        Integer algorithm = null;
        String startword = null;
        String endword = null;
        String filepath = null;
        Kamus kamus = null;
        Result res = null;

        while(!inputvalid){
            System.out.print("Start word: ");
            startword = scanner.nextLine();
            System.out.print("End word: ");
            endword = scanner.nextLine();

            if(startword.length() != endword.length()){
                System.out.println("Length of startword and endword is different!");
            }else{
                filepath = "resources\\" +  startword.length() + "-letter-words.txt";
                kamus = new Kamus(filepath);
                startword = startword.toUpperCase();
                endword = endword.toUpperCase();

                if(!kamus.isValid(startword) || !kamus.isValid(endword)){
                    System.out.println("Your words isn't valid! Try again please!");
                }
                else{
                    inputvalid = true;
                }
            }
            
        }
        
        while(!algorithmValid){
            System.out.print("Choose an algorithm:\n1. UCS\n2.Greedy BFS\n3.A*\nYour choice (1/2/3): ");
            algorithm = scanner.nextInt();
            if(algorithm == 1){
                res = UCS.solve(startword, endword, kamus);
                algorithmValid = true;
            }
            else if(algorithm == 2){
                res = GreedyBFS.solve(startword, endword, kamus);
                algorithmValid = true;
            }
            else if(algorithm == 3){
                res = Astar.solve(startword, endword, kamus);
                algorithmValid = true;
            }
            else{
                System.out.println("Your input is invalid! Try again please!");
            }
        }

        System.out.println("Node visited: " + res.getCount());
        if(res.getPath() == null){
            System.out.println("Path: Not Found");
        }else{
            System.out.println("Path:");
            for(int i = 0; i<res.getPath().size(); i++){
                System.out.println((i+1) + ". " + res.getPath().get(i));
            }
        }
        scanner.close();   
    }
}