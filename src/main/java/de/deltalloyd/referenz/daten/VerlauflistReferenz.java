package de.deltalloyd.referenz.daten;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.simple.JSONObject;

public class VerlauflistReferenz extends AbstractReferenz {

	private static final String VERLAUF_ITEM_INDEX = "verlauf_item_index";
	private static final String VERLAUF_ITEM_COLOR = "verlauf_item_color";
	private static final String VERLAUF_ITEM_LABEL = "verlauf_item_label";

	protected VerlauflistReferenz(JSONObject daten) {
		super(daten);
	}

	public Integer getVerlaufItemIndex() {
		return getInteger(VERLAUF_ITEM_INDEX);
	}
	public String getVerlaufItemLabel() {
		return getString(VERLAUF_ITEM_LABEL);
	}

	public String getVerlaufItemColor() {
		return getString(VERLAUF_ITEM_COLOR);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(VERLAUF_ITEM_INDEX, getVerlaufItemIndex())
				.append(VERLAUF_ITEM_LABEL, getVerlaufItemLabel())
				.append(VERLAUF_ITEM_COLOR, getVerlaufItemColor()).build();
	}

}
