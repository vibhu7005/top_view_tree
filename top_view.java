//bottom view of the tree 
import java.util.*;
class Node
{
    int data;
    int hd;
    Node left;
    Node right;
    public Node(int data,int hd)
    {
        this.data=data;
        this.hd=hd;
        left=null;
        right=null;
    }
}
public class Main 
{
    Queue<Node>queue=new LinkedList<Node>();
    Node createTree(Node root,int data,int hd)
    {
        if(root==null)
        return new Node(data,hd);
        if(root.data>data)
        root.right=createTree(root.right,data,hd+1);
        else
        root.left=createTree(root.left,data,hd-1);
        return root;
    }
    void topview(Node root,int arr[],int l,int r)
    {
        Queue<Node>queue=new LinkedList<Node>();
        queue.add(root);
        while(queue.size()!=0)
        {
            Node temp=queue.poll();
            if(temp.left!=null)
            queue.add(temp.left);
            if(temp.right!=null)
            queue.add(temp.right);
            arr[temp.hd+50]=temp.data;
            if(l>temp.hd+50)
            l=temp.hd+50;
            if(r<temp.hd+50)
            r=temp.hd+50;
        }
        for(int i=l;i<=r;i++)
        System.out.println(arr[i]);
    }
    void preorder(Node root)
    {
        if(root==null)
        return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[]args)
    {
        Main obj=new Main();
        Node root=null;
        root=obj.createTree(root,7,0);
        root=obj.createTree(root,8,0);
        root=obj.createTree(root,1,0);
        root=obj.createTree(root,2,0);
        root=obj.createTree(root,3,0);
        root=obj.createTree(root,4,0);
        int arr[]=new int[100];
        for(int i=0;i<100;i++)
        arr[i]=-1;
        int l=99,r=0;
        obj.topview(root,arr,l,r);
        
    }
}
