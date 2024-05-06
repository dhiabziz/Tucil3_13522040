import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

public class Kamus {
    private HashSet<String> dictionary = new HashSet<>();
    FileReader f;
    public Kamus(String filepath){
        try{
           f = new FileReader(filepath);
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + filepath);
        }

        BufferedReader b = new BufferedReader(f);
        String line = null;
        try{
            line = b.readLine();
        } catch(Exception e){
            System.out.println("Error while reading file");
        }

        while(line != null){
            this.dictionary.add(line);

            try{
                line = b.readLine();
            } catch(Exception e){
                System.out.println("Error while reading file");
            }

        }
        

        try{
            b.close();
        }catch(Exception e){
            System.out.println("Error when closing the file reader");
        }
        
    }

    public boolean isValid(String word){
        return this.dictionary.contains(word);
    }
}
