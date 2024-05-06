public class SimpulStar extends Simpul {
    private int g;
    private int h;

    public SimpulStar(String word){
        super(word);
        this.g = 0;
        this.h = 0;
    }

    public SimpulStar(String word, int g, int h, Simpul parent){
        super(word, g+h, parent);
        this.g = g;
        this.h = h;
    }   

    public int getG(){
        return this.g;
    }

    public int getH(){
        return this.h;
    }
}
