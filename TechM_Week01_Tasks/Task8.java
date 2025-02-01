import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Task8 {
    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private static TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);
        
        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized root value: " + deserialized.val);
    }
}
