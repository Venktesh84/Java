package Assign1;

public class Node {
	
	private String student;
	private String booki; 
	private String bookn;
	
	public Node(String studentid, String bookid, String bookname) {
		student = new String(studentid);
		booki = new String(bookid);
		bookn = new String(bookname);
	}

	public String std() {
		return student;
	}
	
	public String bi() {
		return booki;
	}
	
	public String bn() {
		return bookn;
	}

	public void print() {
		System.out.print("\n[\nStudent Id :"+student+"\nBook Id :"+booki+"\nBook Name: "+bookn+"]");
	}

}
