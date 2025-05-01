import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    
    public static int comeon(List<List<Integer>> arr)
    {
        return 0;
    }
    public static void main(String[] args) {
        List<List<Integer>> arr=new ArrayList<>();
         arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        for (List<Integer> i: arr){
            System.out.println(i);
        }
    }
}