import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class NormStr {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder(o1);
                StringBuilder sb2 = new StringBuilder(o2);

                return sb1.reverse().toString().compareTo(sb2.reverse().toString());
            }
        });

        set.addAll(Arrays.asList(args));
        System.out.println(set);
    }
}
