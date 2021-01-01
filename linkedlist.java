public class MyClass {
    
    public listnode head;
    
    public static class listnode{
        public int data;
        public listnode next;
        public listnode(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public void display()
    {
        int size=0;
       listnode current=head;
        while(current!=null)
        {
            System.out.print(current.data+"->");
            size++;
            current=current.next;
        }
         System.out.print("null");
          System.out.println("");
         System.out.println(size);
    }
    public void insertatbeg(int data)
    {
        listnode start=new listnode(data);
        start.next=head;
        head=start;
        
    }
    public void insertatend(int data)
    {
        listnode end=new listnode(data);
        listnode temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=end;
        
        
    }
    public void deleteatbeg()
    {
        listnode temp=head.next;
        head=temp;
        
    }
    public void deleteatend()
    {
        listnode current=head;
        listnode prev=null;
        while(current.next!=null)
        {
            prev=current;
            current=current.next;
        }
        prev.next=null;
        
        
        
    }
    public void insertAt(int index,int data)
    {
        listnode node= new listnode(data);
        listnode n=head;
        for(int i=0;i<index-1;i++)
        {
            n=n.next;
        }
        node.next=n.next;
        n.next=node;
    }
    public void deleteAt(int index)
    {
        
    }
    public void reverse()
    {
        listnode current=head;
        listnode prev=null;
        listnode next=null;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
    }
    
    public static void main(String args[]) {
        MyClass m =new MyClass();
        m.head=new listnode(10);
        listnode s1=new listnode(20);
         listnode s2=new listnode(30);
         listnode s3=new listnode(40);
          listnode s4=new listnode(50);
          m.head.next=s1;
          s1.next=s2;
          s2.next=s3;
          s3.next=s4;
         // m.insertatbeg(67);
          //m.insertatbeg(627);
          //m.insertatbeg(673);
          //m.insertatend(987);
          //m.insertatend(12);
          //m.deleteatbeg();
          //m.deleteatbeg();
          //m.deleteatend();
          //m.deleteatend();
       // m.reverse();
       m.insertAt(2,76);

          m.display();
       
    }
}