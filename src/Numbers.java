import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true){
            if (!in.hasNextInt()) break;
            list.add(in.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                boolean b = isPrime(o1);
                if (b == isPrime(o2)) {
                    return Integer.compare(o1, o2);
                } else if (b) return -1;
                return 1;
            }
        });
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static boolean isPrime(int a){
        if (a == 0) return true;
        for(int i = 2; i <= Math.sqrt(a); i++){
            if (a % i == 0) return false;
        }
        return true;
    }
}
