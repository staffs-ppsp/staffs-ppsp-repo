package kchcinemas;

import java.util.HashMap;
import java.util.Map;

public class PropertyList extends HashMap<String,String> {
	public PropertyList add(String strKey, String strValue) {
		super.put(strKey, strValue);
		return this;
	}

	public PropertyList copy() {
		return PropertyList.merge(this, null);
	}

	public static PropertyList merge(PropertyList objPriorityList, PropertyList objSecondaryList) {
		PropertyList objPropertyList = new PropertyList();
		if (objSecondaryList != null) {
			for (Map.Entry<String,String> objProperty : objSecondaryList.entrySet()) {
				objPropertyList.put(objProperty.getKey(),objProperty.getValue());
			}
		}
		for (Map.Entry<String,String> objProperty : objPriorityList.entrySet()) {
			objPropertyList.put(objProperty.getKey(),objProperty.getValue());
		}
		return objPropertyList;
	}
}
