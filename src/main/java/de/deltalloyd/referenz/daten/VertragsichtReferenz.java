package de.deltalloyd.referenz.daten;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.simple.JSONObject;

public class VertragsichtReferenz extends AbstractReferenz {

	private static final String DIALOG_ANZAHL = "dialog_anzahl";
	private static final String VERTRAG = "vertrag";
	private static final String MANDANT = "mandant";

	protected VertragsichtReferenz(JSONObject daten) {
		super(daten);
	}

	public Integer getMandant() {
		return getInteger(MANDANT);
	}

	public Long getVertrag() {
		return getLong(VERTRAG);
	}

	public Integer getDialogAnzahl() {
		return getInteger(DIALOG_ANZAHL);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(MANDANT, getMandant()).append(VERTRAG, getVertrag())
				.append(DIALOG_ANZAHL, getDialogAnzahl()).build();
	}
}
