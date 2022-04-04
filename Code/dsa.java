package Code; // this file is in a subfolder of the git repo

// packages
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


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
