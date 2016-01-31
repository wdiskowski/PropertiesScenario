package de.deltalloyd.referenz.daten;

import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ScenarioFileReader implements ScenarioReader {

	private final String fileName;

	public ScenarioFileReader(String fileName) {
		this.fileName = fileName;
	}

	public JSONArray getScenario() {
		JSONArray array;
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream(fileName)));
			array = (JSONArray) obj;
		} catch (IOException | ParseException e) {
			throw new IllegalArgumentException(e);
		}
		return array;
	}
}
