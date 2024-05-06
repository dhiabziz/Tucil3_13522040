import java.util.Scanner;
public class Solver{
    public static void main(String[] args){
        //Inisialisasi variabel
        Scanner scanner = new Scanner(System.in);
        Boolean inputvalid = false;
        Boolean stopvalid = false;
        Boolean algorithmValid = false;
        Boolean stopGame = false;
        Integer algorithm = null;
        String startword = null;
        String endword = null;
        String filepath = null;
        Integer play = null;
        Kamus kamus = null;
        Result res = null;
        long startTime = 0;
        long endTime = 0;

    
        //Menerima inputan kata
        while(!inputvalid){
            System.out.print("Start word: ");
            startword = scanner.nextLine();
            System.out.print("End word: ");
            endword = scanner.nextLine();

            if(startword.length() != endword.length()){
                //Apabila panjang dua kata berbeda, maka tidak valid
                System.out.println("Length of startword and endword is different!");
            }else{
                //Pembuatan dictionary berdasarkan panjang kata
                filepath = "resources\\" +  startword.length() + "-letter-words.txt";
                kamus = new Kamus(filepath);
                startword = startword.toUpperCase();
                endword = endword.toUpperCase();

                if(!kamus.isValid(startword) || !kamus.isValid(endword)){
                    //Apabila setidaknya salah satu dari kata inputan tidak terdapat di kamus, maka tidak valid
                    System.out.println("Your words isn't valid! Try again please!");
                }
                else{
                    //Stop meminta input
                    inputvalid = true;
                }
            }
            
        }
        
        //Menerima jenis algoritma
        while(!algorithmValid){
            System.out.print("Choose an algorithm:\n1. UCS\n2. Greedy BFS\n3. A*\nYour choice (1/2/3): ");
            algorithm = scanner.nextInt();
            
            if(algorithm == 1){
                startTime = System.nanoTime();
                res = UCS.solve(startword, endword, kamus);
                endTime = System.nanoTime();
                algorithmValid = true;
            }
            else if(algorithm == 2){
                startTime = System.nanoTime();
                res = GreedyBFS.solve(startword, endword, kamus);
                endTime = System.nanoTime();
                algorithmValid = true;
            }
            else if(algorithm == 3){
                startTime = System.nanoTime();
                res = Astar.solve(startword, endword, kamus);
                endTime = System.nanoTime();
                algorithmValid = true;
            }
            else{
                System.out.println("Your input is invalid! Try again please!");
            }
        }

        System.out.println("Node visited: " + res.getCount());
        double miliseconds = (double) (endTime - startTime)/1000000;
        System.out.println("Time: " + miliseconds + "ms");
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