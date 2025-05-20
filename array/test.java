//an hashset example

import java.util.HashSet;
import java.util.Set;   

public class test {
    public static void main(String[] args) {
        int arr[] = { 100,2,10,200,1,5};
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
         set.add(i);   
         System.out.println(set);
        }
        
        System.out.println(set);
    }
}