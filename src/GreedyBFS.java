import java.util.HashSet;

public class GreedyBFS {
    public static Result solve(String startword, String endword, Kamus kamus){
        HashSet<String> visited = new HashSet<>(); //Agar simpul yang sama tidak dikunjungi dua kali
        Simpul currSimpul = new Simpul(startword); 
        int count = 0;
        boolean found = false;

        while(!found){
            String greedString;
            int minCost;
            String currWord = currSimpul.getWord();
            count++;
            if(currWord.equals(endword)){ //Apabila sudah sama dengan end word, maka iterasi selesai
                System.out.println("Reach result!");
                return new Result(currSimpul.findPath(), count);
            }else{
                greedString = null;
                minCost = 9999;
                for(int i = 0; i<currWord.length(); i++){//Pencarian child dengan mencoba berbagai kombinasi kata
                    for(char c = 'A'; c<= 'Z'; c++){
                        String tetangga = currWord.substring(0, i) + c + currWord.substring(i+1);
                        if(kamus.isValid(tetangga) && !visited.contains(tetangga)){
                            //Apabila terdapat di kamus dan belum pernah dikunjungi, maka dapat menjadi alternatif solusi
                            visited.add(tetangga);
                            int cost = Simpul.Distance(tetangga, endword);
                            if(cost<minCost){ 
                                //Child yang dipilih hanyalah yang memiliki cost terendah
                                minCost = cost;
                                greedString = tetangga;
                            }
                        }
                    }
                }

                if (greedString == null){ 
                    //Apabila tidak ada child yang mampu menggantikan inisialisasi variabel, artinya pencarian tidak dapat dilanjutkan
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
