package de.deltalloyd.referenz.daten;

import org.json.simple.JSONObject;

public abstract class AbstractReferenz {

	protected final transient JSONObject daten;

	protected AbstractReferenz(JSONObject daten) {
		this.daten = daten;
	}

	protected Integer getInteger(String key) {
		Number value = (Number)getValue(key);
		return value != null ? value.intValue() : null;
	}

	protected Long getLong(String key) {
		Number value = (Number)getValue(key);
		return value != null ? value.longValue() : null;
	}

	protected String getString(String key) {
		return (String)getValue(key);
	}

	private Object getValue(String key) {
		Object value = null;
		if (daten != null && daten.containsKey(key)) {
			value = daten.get(key);
		}
		return value;
	}

}
