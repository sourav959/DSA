import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}

public class PreOrder {
    static Node buildTree(String str){
        String[] strings=str.split(" ");
        Node root=new Node(Integer.parseInt(strings[0]));

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(queue.size()>0 && i< strings.length){
            Node curNode=queue.peek();
            queue.remove();
            if(!strings[i].equals("N")){
                curNode.left=new Node(Integer.parseInt(strings[i]));
                queue.add(curNode.left);
            }
            i++;
            if(i>= strings.length)
                break;
            if(!strings[i].equals("N")){
                curNode.right=new Node(Integer.parseInt(strings[i]));
                queue.add(curNode.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Node root=buildTree(str);
        List<Integer> preOrderList=getPreOrderList(root);
        for(int x:preOrderList)
            System.out.print(x+" ");
    }

    private static List<Integer> getPreOrderList(Node root) {
        List<Integer> ans=new ArrayList<>();
        getPreOrderListAns(root,ans);
        return ans;
    }

    private static void getPreOrderListAns(Node root, List<Integer> ans) {
        if(root==null)
            return;
        ans.add(root.data);
        getPreOrderListAns(root.left,ans);
        getPreOrderListAns(root.right,ans);
    }
}
