// provide me with the example for usage of treemap where i can see the order is sorted


import java.util.*;

public class test{

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        
        hashMap.put("banana", 2);
        hashMap.put("apple", 1);
        hashMap.put("orange", 3);
        hashMap.put("pear", 4);
        hashMap.put("kiwi", 5);
        
        System.out.println("HashMap with String keys:");
        System.out.println(hashMap);
        
        // For comparison
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("banana", 2);
        treeMap.put("apple", 1);
        treeMap.put("orange", 3);
        treeMap.put("pear", 4);
        treeMap.put("kiwi", 5);
        
        System.out.println("\nTreeMap with String keys (alphabetically sorted):");
        System.out.println(treeMap);
    }
}