package Trees;

public class InorderPredAndSucc {

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        if (root == null)
            return;
        Node node = root;
        while (node != null) {
            if (node.data == key)
                break;
            if (key < node.data) {
                suc[0] = node;
                node = node.left;
            } else {
                pre[0] = node;
                node = node.right;
            }
        }

        Node temp = findpre(node);
        pre[0] = temp != null ? temp : pre[0];
        temp = findsuc(node);
        suc[0] = temp != null ? temp : suc[0];

    }

    static Node findpre(Node node) {
        if (node == null || node.left == null)
            return null;
        node = node.left;
        while (node.right != null)
            node = node.right;
        return node;
    }

    static Node findsuc(Node node) {
        if (node == null || node.right == null)
            return null;
        node = node.right;
        while (node.left != null)
            node = node.left;
        return node;
    }

}
