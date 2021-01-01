import java.util.Stack;
import java.util.*;
public class MyClass {
    
    private TreeNode root;
    public class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data)
        {
            this.data=data;
            //System.out.println("ho gya");
        }
    }
    public void createtree()
    {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(11);
        TreeNode t3=new TreeNode(12);
        TreeNode t4=new TreeNode(13);
        TreeNode t5=new TreeNode(14);
        TreeNode t6=new TreeNode(15);
        TreeNode t7=new TreeNode(16);
        root=t1;
        t1.left=t2;
        t1.right=t3;                                                          // 13-11-1-12
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        
    }
    public void preordertraverse(TreeNode root)
    {
        if(root==null)
        return;
        System.out.println(root.data+" ");
        preordertraverse(root.left);
        preordertraverse(root.right);
        
    }
    
    public void preordertraverseByiteration(TreeNode root)
    {
        if(root==null)
        return;
     Stack<TreeNode> st=new Stack();
      st.push(root);
      while(!st.isEmpty())
      {
          TreeNode temp=st.pop();
          System.out.println(temp.data);
          if(temp.right!=null)
          st.push(temp.right);
          if(temp.left!=null)
          st.push(temp.left);
      }
    
    }
       public void Inordertraverse(TreeNode root)
    {
        if(root==null)
        return;
        
        Inordertraverse(root.left);
        System.out.println(root.data+" ");
        Inordertraverse(root.right);
        
    }
    public void InordertraverseByiteration(TreeNode root)
    {
        if(root==null)
        return;
        Stack<TreeNode> stack=new Stack();
        TreeNode temp=root;
        while(!stack.isEmpty()||temp!=null)
        {
            if(temp!=null)
            {
                stack.push(temp.left);
                temp=temp.left;
            }
            else
            {
               temp= stack.pop();
               System.out.println(temp.data+"");
               temp=temp.right;
            }
            
            
        
        }
        
        
    }
    
  public void Postordertraverse(TreeNode root)
    {
        if(root==null)
        return;
        
        Postordertraverse(root.left);
        Postordertraverse(root.right);
        System.out.println(root.data+" ");
        
    }
    public void levelordertraverse(TreeNode root)
    {
        
        if(root==null)
        return;
        Queue <TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode temp=queue.poll();
            System.out.println(temp.data+" ");
            if(temp.left!=null)
            queue.offer(temp.left);
            if(temp.right!=null)
            queue.offer(temp.right);
        }
        
    }

    
    public static void main(String args[]) {
        MyClass m1=new MyClass();
        m1.createtree();
        m1.levelordertraverse(m1.root);
        
    }
}








---------------------------------------------------------------------BST-----------------------------------------------------------------------------------------------






public class MyClass {
    
    public TreeNode root;
    public class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data)
        {
            this.data=data;
        }
    }
    public void insert(int value)
    {
        root=insert(root,value);
    }
    
    public TreeNode insert(TreeNode root,int value)
    {
        if(root==null)
           {
               root=new TreeNode(value);
               return root;
           }
           if(value<root.data)
           {
               root.left= insert(root.left,value);
           }
           if(value>root.data)
           {
               root.right= insert(root.right,value);
           }
           return root;
    }
    public void preordertraverse(TreeNode root)
    {
        if(root==null)
        return;
        preordertraverse(root.left);
       System.out.println(root.data+" ");
        preordertraverse(root.right);
    }
    public TreeNode search(TreeNode root,int value)
    {
        if(root==null||root.data==value)
        {
            return root;
        }
      if(value<root.data)
      return search(root.left,value);
      else
      return search(root.right,value);
    }
    
    
    public static void main(String args[]) {
    MyClass m1=new MyClass();
    m1.insert(10);
    m1.insert(4);
    m1.insert(6);
    m1.insert(14);
    m1.insert(2);
   
   if(null!= m1.search(m1.root,4))
   System.out.println("key found ");
   else
    System.out.println("key not found ");
   
    }
}













