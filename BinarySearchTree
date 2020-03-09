public class MyBST{
    static Node root=null;
    class Node{
        int data;
        Node right;
        Node left;
        Node(int d){
            data=d;
            right=null;
            left=null;
        }
    }
    public void addNode(int d){
        Node currentNode=new Node(d);
        if(root == null){
            root=currentNode;
        }else{
            Node n=root;
            Node parent=root;
            while(n != null){
                if(n.data>d){
                    parent=n;
                    n=n.left;
                }else{
                    parent=n;
                    n=n.right;
                }
            }
            if(parent.data>d){
                parent.left=currentNode;
            }else{
                parent.right=currentNode;
            }
        }
    }
    
     public void printInorder(Node node){ 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    }
    
     public void printPreorder(Node node){ 
        if (node == null) 
            return; 
  
        System.out.print(node.data + " "); 
        /* first recur on left child */
        printPreorder(node.left); 
  
        /* then print the data of node */
  
        /* now recur on right child */
        printPreorder(node.right); 
    }
    
    
    
    
     public void printPostorder(Node node){ 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printPostorder(node.left); 
  
        /* then print the data of node */
  
        /* now recur on right child */
        printPostorder(node.right); 
        System.out.print(node.data + " "); 
    }
    public int hieghtOfTree(Node n){
        if(n==null){
            return 0;
        }else{
            int lDepth=hieghtOfTree(n.left);
            int rDepth=hieghtOfTree(n.right);
            if(lDepth>rDepth){
                return(lDepth+1);
            }else
                return(rDepth+1);
        }
    }
    public static void main(String[] args){
        MyBST mll=new MyBST();
        mll.addNode(20);
        mll.addNode(15);
        mll.addNode(35);
        mll.addNode(14);
        mll.addNode(16);
        mll.addNode(12);
        mll.addNode(9);
        mll.addNode(13);
        System.out.println("Inorder-->");
        mll.printInorder(root);
        System.out.println("\nPreorder-->");
        mll.printPreorder(root);
        System.out.println("\nPostorder-->");
        mll.printPostorder(root);
        int h=mll.hieghtOfTree(root);
        System.out.println("\nHeight:" + h);
    }
}
