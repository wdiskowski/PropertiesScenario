package de.deltalloyd.referenz.daten;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import de.deltalloyd.referenz.daten.ScenarioReader;

public class ScenarioReaderTest {

	private Logger logger = Logger.getLogger(ScenarioReaderTest.class);

	@Test
	public void getScenarioTest() throws IOException, ParseException {
		JSONArray jsonArray = new ScenarioFileReader("my.json").getScenario();
		logger.debug(jsonArray);
		assertThat(jsonArray.isEmpty(), equalTo(false));
		assertThat(((JSONObject) jsonArray.get(0)).get("vertrag"), equalTo(1L));
	}
}
