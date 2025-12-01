public class segment_tree {
    static int[] arr;     // original array
    static int[] tree;    // segment tree

    // -------- BUILD FUNCTION ----------
    static void build(int idx, int start, int end) {// idx= current index
        if (start == end) {
            tree[idx] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * idx, start, mid);
        build(2 * idx + 1, mid + 1, end);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    // -------- UPDATE FUNCTION ----------
    static void update(int idx, int start, int end, int pos, int newVal) {
        if (start == end) {
            tree[idx] = newVal;
            arr[pos] = newVal; // also update array
            return;
        }
        int mid = (start + end) / 2;

        if (pos <= mid)
            update(2 * idx, start, mid, pos, newVal);
        else
            update(2 * idx + 1, mid + 1, end, pos, newVal);

        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    // -------- QUERY FUNCTION ----------
    static int query(int idx, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // no overlap
        }
        if (l <= start && end <= r) {
            return tree[idx]; // complete overlap
        }
        int mid = (start + end) / 2;
        int left = query(2 * idx, start, mid, l, r);
        int right = query(2 * idx + 1, mid + 1, end, l, r);
        return left + right;
    }

    
    public static void main(String[] args) {
           // sample array
        arr = new int[]{2, 4, 5, 7, 8};

        int n = arr.length;

        // segment tree size = 4 * n  (safe size)
        tree = new int[4 * n];

        // build the tree
        build(1, 0, n - 1);

        System.out.println("Initial Segment Tree Built.");

        // Example Query: sum of range [1, 3]
        int ans1 = query(1, 0, n - 1, 1, 3);
        System.out.println("Query(1,3) = " + ans1); // 4 + 5 + 7 = 16

        // Example Update: update index 2 to value 10
        update(1, 0, n - 1, 2, 10);
        System.out.println("Updated index 2 → 10");

        // Query again after update
        int ans2 = query(1, 0, n - 1, 1, 3);
        System.out.println("Query(1,3) after update = " + ans2); // 4 + 10 + 7 = 21
    }
}   