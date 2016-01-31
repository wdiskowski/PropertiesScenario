package de.deltalloyd.referenz.daten;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MainTest {

	private Logger logger = Logger.getLogger(MainTest.class);
	
	@Test
	public void buldReferenzTest() {
		iterateVertraege();
	}

	private void iterateVertraege() {
		ReferenzIterator<VertragsichtReferenz> vertraegeIterator = new ReferenzIterator<>(
				new ScenarioFileReader("my.json"), VertragsichtReferenz.class);
		VertragsichtReferenz vertragsicht = vertraegeIterator.next();
		while(vertragsicht != null) {
			logger.debug(vertragsicht);
			iterateDialogs(vertraegeIterator);
			vertragsicht = vertraegeIterator.next();
		}
	}

	private void iterateDialogs(
			ReferenzIterator<VertragsichtReferenz> vertraegeIterator) {
		ReferenzIterator<DialoglistReferenz> dialogIterator = vertraegeIterator.getChilds(DialoglistReferenz.class);
		DialoglistReferenz dialog = dialogIterator.next();
		while(dialog != null) {
			logger.debug("\t" + dialog);
			iterateVeralauf(dialogIterator);
			iterateSignals(dialogIterator);
			
			dialog = dialogIterator.next();
		}
	}

	private void iterateVeralauf(
			ReferenzIterator<DialoglistReferenz> dialogIterator) {
		ReferenzIterator<VerlauflistReferenz> verlaufIterator = dialogIterator.getChilds(VerlauflistReferenz.class);
		VerlauflistReferenz verlaufItem = verlaufIterator.next();
		while(verlaufItem != null) {
			logger.debug("\t\t" + verlaufItem);
			verlaufItem = verlaufIterator.next();
		}
	}

	private void iterateSignals(
			ReferenzIterator<DialoglistReferenz> dialogIterator) {
		ReferenzIterator<SignallistReferenz> signalIterator = dialogIterator.getChilds(SignallistReferenz.class);
		SignallistReferenz signalItem = signalIterator.next();
		while(signalItem != null) {
			logger.debug("\t\t" + signalItem);
			signalItem = signalIterator.next();
		}
	}
	
}
