
import java.util.*;

public class Str {
    public static void main(String[] args) {
        Map<Character, String> str = new TreeMap<Character, String>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        });

        for (Map.Entry<Character,String> entry: str.entrySet()) {

           getLastChar(entry.getValue());
        }
    }
    public static Character getLastChar(String s){
        int l = s.length();
        return(s.charAt(l));
    }


}


