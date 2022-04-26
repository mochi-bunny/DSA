package Code; // this file is in a subfolder of the git repo

import java.util.*;
import java.lang.*;
import java.io.*;

class Record{   //STORE RECORDS
        int id;
        String name;
        int age;
        String role;
        String position;
        
        public Record(){
            String x= "empty";
        }
        
        public Record(String rec){
            StringTokenizer st= new StringTokenizer(rec, ",");
            this.id= Integer.parseInt(st.nextToken());
            this.name= st.nextToken();
            this.age= Integer.parseInt(st.nextToken());
            this.role= st.nextToken();
            this.position=st.nextToken();
             //print();
            
        }
        
        void print(){
            System.out.println("\nid: "+id+"\nname: "+name+"\nage: "+age+"\nrole: "+role+"\nposition: "+position);
            
        }
        
}

class Queue{
    
    int size=0;
    int last=0;
    class Stack
    {
        int t=-1;
        Record[] stack;
        //int size=0;
        
        public Stack(){
            
            stack= new Record[size];
            last=size;
        }
        
        boolean isEmpty(){
            if(t==-1) return true;
            return false;
        }
        
        boolean isFull(){
            if (t==size-1){
                
                return true;
                
                
            }
            return false;
        }
        void push(Record a){
            
            if (t==size-1) System.out.println("stack full");
            else{
                
                t=t+1;
                stack[t]=a;
                System.out.println("VALUE INSERTED");
            }
        
        }
        
        Record pop(){
            Record s= new Record();
           if(!isEmpty()){
                 s=stack[t];
                stack[t]=null;
                t=t-1;
                
                //System.out.println(s+" removed from STACK");
            }    
            
            return s;
        }
        
        void display(){
            if(!isEmpty()){
            for(int i=0; i<size;i++){
                if (stack[i]!=null) stack[i].print();
    
            }
                
          }
        }
        
        
    }
    
    Stack s1; Stack s2;
    
    void copy(Stack stack1, Stack stack2){
       
        for (int i=0;i<size ;i++ ){
            stack2.push(stack1.stack[i]);
        } 
        //stack2.display();
    }
    
    public Queue(int n){
        size= n;
        s1= new Stack();
        s2= new Stack();
    }
    
    void enqueue(Record rec){
        s1.push(rec); //CREATING ENQUEUE STACK
        
        if (s1.isFull()){
          Stack s3= new Stack();  //DUMMY STACK FOR POPPING VALUES FROM ENQUEUE AND INSERTING INTO DEQUEUE
          
           copy(s1,s3);
           System.out.println("FULL");
           
           
            while(!s3.isEmpty()){  //CREATING DEQUEUE STACK
               Record r1= s3.pop();
               s2.push(r1);
           }
           
           
        }
    
        
    }
}


public class Main
{
	public static void main(String[] args) {
		   try{ 
	        File f= new File("sports.txt");
	        Scanner sc= new Scanner(f,"utf-8");
	        
	        Queue stck1= new Queue(3);  //1st stack
	       
	        
	        while(sc.hasNextLine()){
	            
	        String line= sc.nextLine();
	        Record recn= new Record(line);
	         stck1.enqueue(recn);
	         }
	         
	        System.out.println("enqueue stack");
	          stck1.s1.display();
             System.out.println("\n\ndequeue stack");
             stck1.s2.display();
	          
	       
	   }catch(IOException e){ e.printStackTrace(); }
	    
	}
}
