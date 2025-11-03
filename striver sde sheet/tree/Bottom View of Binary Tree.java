/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

import java.util.*;

class Solution {
    // DFS-based bottom view: track deepest node seen at each HD
    static class Info { int depth; int val; Info(int d, int v){depth=d; val=v;} }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Info> map = new HashMap<>(); // hd -> (depth, val)
        dfs(root, 0, 0, map);

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int hd : keys) {
            res.add(map.get(hd).val);
        }
        return res;
    }

    private void dfs(Node node, int hd, int depth, Map<Integer, Info> map) {
        if (node == null) return;
        Info cur = map.get(hd);
        if (cur == null || depth >= cur.depth) {
            map.put(hd, new Info(depth, node.data));
        }
        dfs(node.left, hd - 1, depth + 1, map);
        dfs(node.right, hd + 1, depth + 1, map);
    }
}