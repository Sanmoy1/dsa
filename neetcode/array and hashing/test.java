import java.util.*;
public class test {
    //provide me with an example for getordefault function in hashmap
    static void getordefault() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.put("h", 8);
        map.put("i", 9);
        map.put("j", 10);
        map.put("k", 11);
        System.out.println(map.getOrDefault("b", 0));
        System.out.println("Map entries: " + map.entrySet());
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        System.out.println("Entry List: " + entryList);
    }
    public static void main(String[] args) {
        
        test.getordefault();
    }

}
