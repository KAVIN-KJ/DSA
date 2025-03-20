// package Trees;

import java.util.*;


class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

public class VerticalOrderTraversal {
    class Tuple {
        Node node;
        int vertical;
        int level;

        Tuple(Node n, int v, int l) {
            node = n;
            vertical = v;
            level = l;
        }
    }
        public List<List<Integer>> findVertical(Node root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple temp = q.poll();
            Node node = temp.node;
            int vertical = temp.vertical;
            int level = temp.level;
            map.putIfAbsent(vertical, new ArrayList<>());
            map.get(vertical).add(new int[]{node.data, level});
            if (node.left != null) {
                q.add(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<int[]> nodes : map.values()) {
            Collections.sort(nodes, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1]; 
            });
            List<Integer> verticalLine = new ArrayList<>();
            for (int[] p : nodes) {
                verticalLine.add(p[0]);
            }
            ans.add(verticalLine);
        }

        return ans;
    }
}
