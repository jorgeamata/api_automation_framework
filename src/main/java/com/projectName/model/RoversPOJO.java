package com.projectName.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rovers" })
public class RoversPOJO {

	@JsonProperty("rovers")
	private List<RoverPOJO> rovers = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RoversPOJO() {
	}

	/**
	 *
	 * @param rovers
	 */
	public RoversPOJO(List<RoverPOJO> rovers) {
		super();
		this.rovers = rovers;
	}

	@JsonProperty("rovers")
	public List<RoverPOJO> getRovers() {
		return rovers;
	}

	@JsonProperty("rovers")
	public void setRovers(List<RoverPOJO> rovers) {
		this.rovers = rovers;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RoversPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("rovers");
		sb.append('=');
		sb.append(((this.rovers == null) ? "<null>" : this.rovers));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
