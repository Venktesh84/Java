package itemStorage;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ParseItem {

	boolean inStorageModels = false;
	boolean inItems = false;
	boolean inId = false;
	boolean inName = false;
	boolean inNumber = false;
	boolean inCabinet = false;
	
	Item It;
	
	List<Item> currentItemList;

	/**
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public List<Item> doParsestorage(String s) throws Exception {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser pullParser = factory.newPullParser();
		pullParser.setInput(new StringReader(s));
		processDocument(pullParser);
		return currentItemList;
	}
	
	/**
	 * Paring the document to make it understandable
	 * @param pullParser XML of the request
	 * @throws XmlPullParserException
	 * @throws IOException 
	 */
	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				//System.out.println("Start Document");
			} 
			else if (eventType == XmlPullParser.END_DOCUMENT) {
			//	System.out.println("End Document");
			} 
			else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} 
			else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} 
			else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}
	
	/**
	 * Checking if each value is being manipulated
	 * @param event Type of event
	 */
	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if(name.equals("storageModels")) {
			inStorageModels = true;
			currentItemList = new ArrayList<Item>();
		} 
		else if (name.equals("Item")) {
			inItems = true;
			It = new Item();
		} 
		else if (name.equals("id")) {
			inId = true;
		} 
		else if (name.equals("name")) {
			inName = true;
		} 
		else if (name.equals("number")) {
			inNumber = true;
		} 
		else if (name.equals("cabinet")) {
			inCabinet = true;
		}
	}
	
	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		if(name.equals("storageModels")) {
			inStorageModels = false;
		} 
		else if (name.equals("Item")) {
			inItems = false;
			currentItemList.add(It);
		} 
		else if (name.equals("id")) {
			inId = false;
		} 
		else if (name.equals("name")) {
			inName = false;
		} 
		else if (name.equals("number")) {
			inNumber = false;
		} 
		else if (name.equals("cabinet")) {
			inCabinet = false;
		}
	}

	public void processText(XmlPullParser event) throws XmlPullParserException {
		if(inId) {
			String s = event.getText();
			It.setId(Integer.parseInt(s));
			//System.out.println(""+Integer.parseInt(s));
		}
		if(inName) {
			String s = event.getText();
			It.setName(s);

			//System.out.println(s);
		}
		if(inNumber) {
			String s = event.getText();
			It.setNumber(s);
			//System.out.println(s);
	
		}
		if(inCabinet) {
			String s = event.getText();
			It.setCabinet(Integer.parseInt(s));
		//	System.out.println(""+Integer.parseInt(s));
			
		}
	}
}
