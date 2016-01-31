package de.deltalloyd.referenz.daten;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReferenzIterator<T extends AbstractReferenz> {
	private final Object daten;
	private final Class<T> referenzClass;
	private int currentIndex;
	private JSONObject currentDataObject;

	public ReferenzIterator(ScenarioReader reader, Class<T> referenzClass) {
		this.daten = reader.getScenario();
		this.referenzClass = referenzClass;
	}

	private ReferenzIterator(Object daten, Class<T> referenzClass) {
		this.daten = daten;
		this.referenzClass = referenzClass;
	}

	public T next() {
		JSONObject nextData = getNextDataObject();
		return getReferenzInstance(referenzClass, nextData);
	}

	public <K extends AbstractReferenz> ReferenzIterator<K> getChilds(
			Class<K> childReferenzClass) {
		return getChilds(childReferenzClass, StringUtils
				.substringBefore(childReferenzClass.getSimpleName(), "Referenz")
				.toLowerCase());
	}

	public <K extends AbstractReferenz> ReferenzIterator<K> getChilds(
			Class<K> childReferenzClass, String childsName) {
		Object childData = getChildsData(childsName);
		return getReferenzIteratorInstance(childReferenzClass, childData);
	}

	private Object getChildsData(String childsName) {
		Object childData = null;
		JSONObject currentData = getCurrentDataObject();
		if (currentData != null && currentData.containsKey(childsName)) {
			childData = currentData.get(childsName);
		}
		return childData;
	}

	private static <K extends AbstractReferenz> K getReferenzInstance(
			Class<K> referenzClazz, JSONObject nextData) {
		K instance = null;
		try {
			if (nextData != null) {
				instance = referenzClazz.getDeclaredConstructor(JSONObject.class)
						.newInstance(nextData);
			}
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException(e);
		}
		return instance;
	}

	private static <K extends AbstractReferenz> ReferenzIterator<K> getReferenzIteratorInstance(
			Class<K> referenzClazz, Object dataObject) {
		return new ReferenzIterator<>(dataObject, referenzClazz);
	}

	private synchronized JSONObject getCurrentDataObject() {
		return currentDataObject;
	}

	private synchronized JSONObject getNextDataObject() {
		JSONObject dataObject = null;
		if (daten instanceof JSONObject && currentIndex == 0) {
			dataObject = (JSONObject) daten;
		} else if (daten instanceof JSONArray
				&& ((JSONArray) daten).size() > currentIndex) {
			dataObject = (JSONObject) ((JSONArray) daten).get(currentIndex);
		}
		currentIndex ++;
		currentDataObject = dataObject;
		return currentDataObject;
	}
}
