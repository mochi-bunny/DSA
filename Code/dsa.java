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
        
       public Record(){ }
        public Record(String rec){
            StringTokenizer st= new StringTokenizer(rec, ",");
            this.id= Integer.parseInt(st.nextToken());
            this.name= st.nextToken();
            this.age= Integer.parseInt(st.nextToken());
            this.role= st.nextToken();
            this.position=st.nextToken();
             //print();
            
        }
        
        void print(){  //PRINT RECORD DETAILS
            System.out.println("\nid: "+id+"\nname: "+name+"\nage: "+age+"\nrole: "+role+"\nposition: "+position);
            
        }
        
        int getID(){    return id; }
        String getName(){   return name;}
        int getAge(){   return   age; }
        String getRole(){   return role;}
        String getPos(){        return position; }
        
}

class Queue{
    
    //int size=0;
    int last=0;
    int capacity=20; //TOTAL CAPACITY OF STACK
    
    class Stack     //SUBCLASS STACK FOR CREATING STACK OBJECTS
    {
        int t=-1;
        
        Record[] stack;
        //int size=t+1;
        
        public Stack(){ //INITIALISES STACK WITH MENTIONED DEFAULT CAPACITY
            stack= new Record[capacity]; 
        }
        
        boolean isEmpty(){
            if(t==-1) return true;
            return false;
        }
        
        boolean isFull(){
            if ( getSize() == capacity ){           return true;            }
            return false;
        }
        
        void push(Record a){
            
            if (isFull()) System.out.println("stack full");
            else{
                
                t=t+1;
                //size++;
                stack[t]=a;
                System.out.println("VALUE INSERTED");
             }
        
        }
        
        Record pop(){       //POP FROM STACK
           Record s= new Record();
           
           if(!isEmpty()){
                 s=stack[t];
                stack[t]=null;
                t=t-1;
               // size--;
                
                //System.out.println(s+" removed from STACK");
            }    
            
            return s;
        }
        
        void display(){  //DISPLAYS RECORDS PRESENT IN STACK
            if(!isEmpty()){
            for(int i=0; i<getSize();i++){
                if (stack[i]!=null) stack[i].print();
    
            }
                
          }
        }
        
        Record[] getStack(){    return stack;}   //RETURNS THE STACK ARRAY
        
        int getSize(){  return t+1;    } //SIZE OF THE STACK(GETS UPDATED)
    }
    
    
    
    Stack s1;  //ENQ STACK
    Stack s2;   //DEQ STACK
    
    public Queue(){ //INITIALIZES 2 STACKS- ONE FOR ENQUEUE AND ONE FOR DEQUEUE
    
        s1= new Stack();
        s2= new Stack();
    }
    
    void enqueue(Record rec){
        s1.push(rec); //CREATING ENQUEUE STACK
       
      //  System.out.println(s1.getSize());
        
           
    }
    
    void dequeue(){
        while(!s1.isEmpty()){  //CREATING DEQUEUE STACK
               Record r1= s1.pop();
              // r1.print();
               s2.push(r1);
           }
           
         //  s2.display();
    }
    
    Stack getQ(){  //DEQUEUES THE ENQ STACK, S1, INTO S2 AND RETURNS S2
         dequeue();
      //   s2.display();
        return s2;
        
    }
    
    
    void binSearch(int id_no){ // SEARCHES BASED ON ID
        Stack stck= getQ();     // FETCHES DEQUEUE STACK OBJECT
       // stck.display();
        Record[] records= stck.getStack();  //FETCHES STACK ARRAY FOR SEARCHING
        
        int r= stck.getSize() - 1;
         int l=0;
        int p=0;
        
        Record rex= new Record();  //EMPTY RECORD FOR ASSIGNING FOUND RECORD
        
        while(l<=r){
            int mid= (l+r)/2;
             
            int id_mid= records[mid].getID();
            
            
            if (id_mid == id_no){
                rex= records[mid];
                 p=1;
                break;
            }
            
            else if (id_mid > id_no) { l= mid + 1; }
            
            else{ r= mid - 1; }
            
        }
        
        if (p==1){ 
            System.out.println("Record found");
            rex.print();  
        }
        else{   System.out.println("Record not found");        }
    }
    
     
    
     void radixSort(){
        Stack stck= getQ();    // FETCHES DEQUEUE STACK OBJECT
        
        Record[] records= stck.getStack();    //FETCHES STACK ARRAY FOR SEARCHING
        
        int len= stck.getSize();        // FETCHES THE SIZE OF THE STACK
	    int max= getMax(records, len);
	    
	    for (int e=1; max/e >0 ; e*= 10 ){
	        sort(records, 0, len-1 );
	    } 
	    
	    
	    for (int i=0; i<=len-1; i++){
	        records[i].print();
	    } 
	    
	}
	
	   void merge(Record arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Record L[] = new Record[n1];
        Record R[] = new Record[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getID() <= R[j].getID() ) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
     
     void sort(Record arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	 int getMax(Record[] r, int len){
	    int max= r[0].getID();
	    
 	    for (int i=1; i<len ; i++){
	        if (max < r[i].getID() ){
	            max= r[i].getID();
	        }
	    } 
	    return max;
	}
    
    
}


public class Main
{
    static Scanner s= new Scanner(System.in);
    
	public static void main(String[] args) {
		   try{ 
	        File f= new File("sports.txt");
	        Scanner sc= new Scanner(f,"utf-8");
	        
	        Queue q= new Queue();  //1st stack
	       
	        
	        while(sc.hasNextLine()){
	            
    	        String line= sc.nextLine();
    	        Record recn= new Record(line);
    	         q.enqueue(recn);   //INSERTS RECORDS INTO STACK S1
	        }
	       
	       
	        
	       
	      System.out.print("1-binarysearch\n2-radix sort :\nn=");   //MENU
	         int n= s.nextInt();
	         
	         switch(n){
	             case 1:{  
	                 System.out.println("BINARYSEARCH\n"); 
	                 System.out.print("ID to be searched: ");
	                 int id_no= s.nextInt();
	                 q.binSearch(id_no);
	                 break;
	             }
	             
	             case 2:{
	                 System.out.println("RADIX SORT\n"); 
	                 q.radixSort(); 
	                 break;
	             }
	               
	             
	            default:{ break;}
	                
	         };
	        
	       
	       
		   }catch(IOException e){     e.printStackTrace();  }
	}
}
