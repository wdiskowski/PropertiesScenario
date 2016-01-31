package de.deltalloyd.referenz.daten;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.simple.JSONObject;

public class SignallistReferenz extends AbstractReferenz {

	private static final String SIGNAL_INDEX = "signal_index";
	private static final String SIGNAL_LABEL = "signal_label";

	protected SignallistReferenz(JSONObject daten) {
		super(daten);
	}

	public Integer getSignalIndex() {
		return getInteger(SIGNAL_INDEX);
	}

	public String getSignalLabel() {
		return getString(SIGNAL_LABEL);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(SIGNAL_INDEX, getSignalIndex())
				.append(SIGNAL_LABEL, getSignalLabel()).build();
	}

}
