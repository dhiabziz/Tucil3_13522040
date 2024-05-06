import java.util.ArrayList;

public class Simpul implements Comparable<Simpul>{
    private int cost;
    private String word;
    private Simpul parent;

    public Simpul(String word){
        this.word = word;
        this.cost = 0;
        this.parent = null;
    }

    public Simpul(String word, int cost, Simpul parent){
        this.word = word;
        this.cost = cost;
        this.parent = parent;

    }

    public ArrayList<String> findPath(){
        ArrayList<String> p = new ArrayList<>();
        Simpul s = this.parent;
        p.addFirst(this.word);
        while(s!=null){
            p.addFirst(s.word);
            s = s.getParent();
        }

        return p;
    }

    public int getCost(){
        return this.cost;
    }

    public String getWord(){
        return this.word;
    }

    public Simpul getParent(){
        return parent;
    }

    @Override
    public int compareTo(Simpul other){
        return Integer.compare(this.getCost(), other.getCost());
    }

    public static int Distance(Simpul p , Simpul q){
        int d = 0;
        for(int i = 0; i<p.word.length(); i++){
            if(p.word.charAt(i) != q.word.charAt(i)){
                d++;
            }
        }
        return d;
    }
}
