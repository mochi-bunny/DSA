package Code; // this file is in a subfolder of the git repo

// packages
import java.util.*;
import java.lang.*;
import java.io.*;

public class Link //BINARYSEARCH
{
    // instance variables - replace the example below with your own
    private Node head;
    private Node tail;
    private int size;
    
      Link(){
        this.head=new Node("");
        this.tail=new Node("");
        this.size=0;
    }
    
    void push(String e){
        Node n = new Node (e);
        Node x = this.tail.getPrev ();
        if (x != null){
    	x.setNext (n);
    	n.setPrev (x);
          }
        else{
    	    this.head.setNext (n);
          }
          
        this.tail.setPrev (n);
        this.size++;
      }
     
    void display(){
         
             System.out.println("list:");
            Node x= this.head.getNext();
            while(x!=null){
                System.out.println(x.getVal()+" ");
                x=x.getNext();
            }
        }
        
    String traverse(int mid){
        Node x=this.head.getNext();
        int i=0;
        while(x!=null && i<mid){
        x=x.getNext();
        i++;
        }
        return x.getVal();
    }
    void binsearch(String e){
        int l=0; int f=0;
        int r=this.size;
        Node x= this.head.getNext();
        
        StringTokenizer skz= new StringTokenizer(e, " ");
        int ele= Integer.parseInt(skz.nextToken());
        
        while(l<=r){
            int mid=(l+r)/2;
            String b= traverse(mid);
            StringTokenizer stz= new StringTokenizer(b, " ");
            int item= Integer.parseInt(stz.nextToken());
            
            if (ele==item){ f=1; break;}
            else if ( ele<item ) r=mid-1;
            else l=mid+1;
        }
        
        if (f==1) System.out.println("rec found");
	else  System.out.println("rec not found");
    }
        
    }

class Node{
    private Node prev;
    private Node next;
    private String val;
    
    public Node(String a){
        this.val=a;
        this.next=null;
        this.prev=null;
    }
    
    void setNext(Node n){
        this.next=n;
    }
    
    Node getNext(){
        return this.next;
    }
    
    void setPrev(Node n){
        this.prev=n;
    }
    
    Node getPrev(){
        return this.prev;
    }
    
    String getVal(){
        return this.val;
    }
    
}
 
class Stack
{
    int t=-1;
    String[] stack;
    int size=0;
    
    public Stack(int n){
        size=n;
        stack= new String[size];
    }
    
    
    void push(String a){
        if (t==size-1) System.out.println("stack full");
        else{
            t=t+1;
            stack[t]=a;
            System.out.println("VALUE INSERTED");
        }
    }
    
    void pop(){
        if (t==-1) System.out.println("STACK EMPTY");
        else{
            String s=stack[t];
            stack[t]=null;
            t=t-1;
            System.out.println(s+" removed from STACK");
            
        }
    }
    
     void display(){
        for(int i=0; i<size;i++){
            if (stack[i]!=null) System.out.println(stack[i]);
        }
    }   
}

class Queue
{
      int f=0;
      int r=0;
      int size;
      
      String[] q;
      
      public Queue(int n){
          size=n;
          q= new String[size];
      }
      
      
      
      void enqueue(String d){
            if (r==(size-1))    System.out.println("FULL Q");
            else{
                q[r]=d;
                r=r+1;
                System.out.println("inserted");
            }
     }
     
     void display(){
        for(int i=0; i<size;i++){
            if (q[i]!=null) System.out.println(q[i]);

        }
    }
    
    void dequeue(){
        if (f==r){ System.out.println("EMPTY QUEUE");  }
        
        else{
            String de=q[f];
            q[f]=null;
            f=f+1;
            System.out.println(de+" removed");
        }
        
    }   
        
}


class dsa
{
	static String inputFile = "input.txt";
	static String outputFile = "output.txt";
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Hello World");
	}
}
