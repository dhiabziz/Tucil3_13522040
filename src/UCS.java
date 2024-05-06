import java.util.HashSet;
import java.util.PriorityQueue;

public class UCS {
    public static Result solve(String startword, String endword, Kamus kamus){
        PriorityQueue<Simpul> q = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Simpul(startword));
        int count = 0;

        while(!q.isEmpty()){
            Simpul currSimpul = q.remove();
            String currWord = currSimpul.getWord();

            count++;
            if(currWord.equals(endword)){
                System.out.println("Reach result!");
                return new Result(currSimpul.findPath(), count);
            }else{
                for(int i = 0; i<currWord.length(); i++){
                    for(char c = 'A'; c<= 'Z'; c++){
                        String tetangga = currWord.substring(0, i) + c + currWord.substring(i+1);
                        /*
                        try{
                            Thread.sleep(300);
                        }catch(Exception e){
                            System.out.println("Hehe");
                        }
                        */
                        if(kamus.isValid(tetangga) && !visited.contains(tetangga)){
                            //System.out.print(tetangga);
                            visited.add(tetangga);
                            q.add(new Simpul(tetangga, currSimpul.getCost() + 1, currSimpul));
                        }
                    }
                }

    



            }
        }
        
        return new Result(null, count);

    }
}
