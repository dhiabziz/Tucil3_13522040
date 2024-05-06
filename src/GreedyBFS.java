import java.util.HashSet;

public class GreedyBFS {
    public static Result solve(String startword, String endword, Kamus kamus){
        HashSet<String> visited = new HashSet<>();
        Simpul currSimpul = new Simpul(startword);
        int count = 0;
        boolean found = false;

        while(!found){
            String greedString;
            int minCost;
            String currWord = currSimpul.getWord();
            count++;
            if(currWord.equals(endword)){
                System.out.println("Reach result!");
                return new Result(currSimpul.findPath(), count);
            }else{
                greedString = null;
                minCost = 9999;
                for(int i = 0; i<currWord.length(); i++){
                    for(char c = 'A'; c<= 'Z'; c++){
                        String tetangga = currWord.substring(0, i) + c + currWord.substring(i+1);
                        if(kamus.isValid(tetangga) && !visited.contains(tetangga)){
                            visited.add(tetangga);
                            //System.out.print(tetangga);
                            int cost = Simpul.Distance(tetangga, endword);
                            if(cost<minCost){
                                minCost = cost;
                                greedString = tetangga;
                            }
                        }

                    }
                }

                if (greedString == null){
                    break;
                }
                else{
                    currSimpul = new Simpul(greedString, minCost, currSimpul);
                }

            }
        }
        
        return new Result(null, count);

    }
}
