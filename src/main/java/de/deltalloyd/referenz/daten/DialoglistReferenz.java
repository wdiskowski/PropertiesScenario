package de.deltalloyd.referenz.daten;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.simple.JSONObject;

public class DialoglistReferenz extends AbstractReferenz {

	private static final String DIALOG_INDEX = "dialog_index";
	private static final String VERLAUF_ITEM_ANZAHL = "verlauf_item_anzahl";

	protected DialoglistReferenz(JSONObject daten) {
		super(daten);
	}
	
	public Integer getVerlaufItemAnzahl() {
		return getInteger(VERLAUF_ITEM_ANZAHL) ;
	}

	public Integer getDialogIndex() {
		return getInteger(DIALOG_INDEX);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(VERLAUF_ITEM_ANZAHL, getVerlaufItemAnzahl())
				.append(DIALOG_INDEX, getDialogIndex()).build();
	}
}
