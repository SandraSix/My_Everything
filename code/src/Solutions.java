//import java.util.Stack;
//
//public class Solutions {
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node) {    //入队
//        int num=0;
//        if (stack2.empty()){
//            stack2.push(node);
//            num++;
//        }else {
//            while (stack2.empty()){
//                int geshu=stack2.size();
//                for (int i=0;i<geshu;i++){
//                    stack1.push(stack2.pop());
//                }
//                stack1.push(node);
//            }
//            while (stack1.empty()){
//                int geshu=stack1.size();
//                for (int i=0;i<geshu;i++){
//                    stack2.push(stack1.pop());
//                }
//            }
//        }
//    }
//
//    public int pop() {              //出队
//        if (stack2.empty()){
//            return -1;
//        }else {
//            return stack2.pop();
//        }
//    }
//}


class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Solutions {
     static void Mirror(TreeNode root) {
        if (root.left!=null&&root.right!=null){
            Mirror(root.left);
            Mirror(root.right);
        }else if (root.left!=null){
            root.right=new TreeNode(root.left.val);
        }else if (root.right!=null){
            root.left=new TreeNode(root.right.val);
        }else {
            root=root;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        Mirror(root);
        System.out.println(root.left.val);
        System.out.println(root.right.val);

    }
}