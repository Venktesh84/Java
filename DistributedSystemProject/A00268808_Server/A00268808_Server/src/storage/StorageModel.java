package storage;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Item")
@XmlType(propOrder = { "id", "name", "number", "cabinet" })

public class StorageModel{
	
	int id, cabinet = 0;
	String name, number;
	
	public StorageModel() {
		// TODO Auto-generated constructor stub
	}
	
	public StorageModel(int id, String name, String number, int cabinet) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.cabinet = cabinet;
		this.name = name;
		this.number = number;
	}
	
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	@XmlElement
	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getCabinet() {
		return cabinet;
	}
	
	@XmlElement
	public void setCabinet(int cabinet) {
		this.cabinet = cabinet;
	}
		
}
