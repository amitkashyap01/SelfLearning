package mySimpleSpringApp.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Fruit {

	String myName;
	private List<String> fruitNameList;
	private Map<String, String> fruitNameMap;

	public List<String> getFruitNameList() {
		return fruitNameList;
	}


	public void setFruitNameList(List<String> fruitNameList) {
		this.fruitNameList = fruitNameList;
	}


	public Map<String, String> getFruitNameMap() {
		return fruitNameMap;
	}


	public void setFruitNameMap(Map<String, String> fruitNameMap) {
		this.fruitNameMap = fruitNameMap;
	}


	public String getMyName() {
		return myName;
	}


	public void setMyName(String myName) {
		this.myName = myName;
	}


	public String introduceYourself() {
		String introduction= "Hi. I am from Fruit class.";

		if (myName!=null && myName!="")
			introduction += " My name is "+myName;

		if (fruitNameList!=null  && fruitNameList.size()>0)
		{
			introduction +="\n List:: ";
			for(String name: fruitNameList)
				introduction += name+" ";
		}


		if(fruitNameMap!=null && fruitNameMap.size() >0)
		{
			introduction +="\n Map:: ";
			for(Entry<String, String> fruitName: fruitNameMap.entrySet()) {
				introduction+= " Name: "+fruitName.getKey()+" Color: "+fruitName.getValue()+" ";
			}
		}
		
		
		return introduction;

	}



}
