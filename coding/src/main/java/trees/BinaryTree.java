package trees;

public class BinaryTree {

    public static void main(String[] args){
        Node head = new Node(3);
        head.left = new Node(5);
        head.right = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        System.out.println(checkBST(head));
    }

    static boolean checkBST(Node root) {
        if(root == null){
            return true;
        }

        boolean left = true;
        if(root.left != null ){
            if(root.data > root.left.data){
                left = checkBST(root.left);
            }else{
                return false;
            }
        }

        boolean right = true;
        if(root.right != null ){
            if(root.data < root.right.data){
                right = checkBST(root.right);
            }else{
                return false;
            }
        }

        return left && right;
    }

}
