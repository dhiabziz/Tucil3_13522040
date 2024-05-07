import java.util.HashSet;
import java.util.PriorityQueue;

public class Astar {
    public static Result solve(String startword, String endword, Kamus kamus){
        PriorityQueue<SimpulStar> q = new PriorityQueue<>(); //Penyimpanan simpul yang akan diekspan
        HashSet<String> visited = new HashSet<>(); //Agar node yang sama tidak dikunjungi lagi
        q.add(new SimpulStar(startword));
        int count = 0; //Menghitung node yang dikunjungi

        while(!q.isEmpty()){
            SimpulStar currSimpul = q.remove(); //Ambil simpul dengan cost terendah
            String currWord = currSimpul.getWord();

            count++;
            if(currWord.equals(endword)){
                //Apabila sudah sama dengan endword, maka iterasi dihentikan
                return new Result(currSimpul.findPath(), count);
            }else{
                for(int i = 0; i<currWord.length(); i++){
                    for(char c = 'A'; c<= 'Z'; c++){ //Dicoba berbagai kombinasi huruf untuk mencari child
                        String tetangga = currWord.substring(0, i) + c + currWord.substring(i+1);
                        
                        if(kamus.isValid(tetangga) && !visited.contains(tetangga)){ //Apabila terdapat dikamus dan belum pernah dikunjungi, maka child dibuat menjadi simpul
                            visited.add(tetangga);
                            q.add(new SimpulStar(tetangga, currSimpul.getG() + 1, Simpul.Distance(tetangga, endword), currSimpul));
                        }
                    }
                }
            }
        }
        
        return new Result(null, count);

    }
}
