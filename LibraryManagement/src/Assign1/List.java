package Assign1;

public class List {
	
	private Node[] head;
	private int max=10;
	private int count;
	
	
	public List(int max) {
		this.max=max;
   	 count=0;
   	 head=new Node[max];
   	 }
	

	public boolean insert(String studentid, String booki, String bookname) {
		if (count<max){
	        Node temp =new Node(studentid, booki, bookname);
            head[count]=temp;
            count++;
            return true;}
       else  return false;
	}
	
	public void printlist()
    {
		Node temp;
		System.out.println("\nList:");
		for(int i=0;i<count;i++) {
			temp = head[i];
			temp.print();}   
   
    }
	
	
	 public Node searchWithId(String booki){
  	   Node res=null;
         for(int i=0;i<count;i++){
       	  Node temp=head[i];
       	  if (temp.bi().equals(booki)){
       		  res=temp;
       	  }
         }
  	   return res;
     }


	public Node getElement(int i) {
		// TODO Auto-generated method stub
		if (i<head.length)return head[i];
 	   else return head[head.length-1];
	} 
	
}
