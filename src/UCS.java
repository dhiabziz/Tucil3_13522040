import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UCS {
    public Result solve(String startword, String endword, Kamus kamus){
        PriorityQueue<Simpul> q = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Simpul(startword));
        int count = 0;

        while(!q.isEmpty()){
            Simpul currSimpul = q.remove();
            String currWord = currSimpul.getWord();
            visited.add(currWord);

            count++;

            if(currWord == endword){
                return new Result(currSimpul.findPath(), count);
            }else{
                for(int i = 0; i<currWord.length(); i++){
                    for(char c = 'a'; c<= 'z'; c++){
                        String tetangga = currWord.substring(0, i) + c + currWord.substring(i+1);
                        if(kamus.isValid(tetangga) && !visited.contains(tetangga)){
                            q.add(new Simpul(tetangga, currSimpul.getCost() + 1, currSimpul));
                        }
                    }
                }
            }
        }

        return new Result(null, count);

    }
}
