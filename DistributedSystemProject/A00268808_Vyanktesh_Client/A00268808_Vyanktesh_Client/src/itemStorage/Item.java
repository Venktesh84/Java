package itemStorage;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Item")
@XmlType(propOrder = { "id", "name", "number", "cabinet"})
public class Item {
	
	int id, cabinet;
	String name, number;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int id, String name, String number, int cabinet) {
		// TODO Auto-generated constructor stub
		super();
		this.id=id;
		this.name=name;
		this.number=number;
		this.cabinet=cabinet;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCabinet() {
		return cabinet;
	}
	
	public void setCabinet(int cabinet) {
		this.cabinet = cabinet;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}
