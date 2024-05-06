import java.util.ArrayList;

public class Result {
    private ArrayList<String> path;
    private int count;

    public Result(ArrayList<String> path, int count){
        this.path = path;
        this.count = count;
    }

    public ArrayList<String> getPath(){
        return this.path;
    }

    public int getCount(){
        return this.count;
    }
    
}
