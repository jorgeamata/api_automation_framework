package com.projectName.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "rover_id", "full_name" })

public class CamerasPOJO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("rover_id")
	private Integer roverId;
	@JsonProperty("full_name")
	private String fullName;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public CamerasPOJO() {
	}

	/**
	 *
	 * @param name
	 * @param fullName
	 * @param id
	 * @param roverId
	 */
	public CamerasPOJO(Integer id, String name, Integer roverId, String fullName) {
		super();
		this.id = id;
		this.name = name;
		this.roverId = roverId;
		this.fullName = fullName;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("rover_id")
	public Integer getRoverId() {
		return roverId;
	}

	@JsonProperty("rover_id")
	public void setRoverId(Integer roverId) {
		this.roverId = roverId;
	}

	@JsonProperty("full_name")
	public String getFullName() {
		return fullName;
	}

	@JsonProperty("full_name")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(CamerasPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("roverId");
		sb.append('=');
		sb.append(((this.roverId == null) ? "<null>" : this.roverId));
		sb.append(',');
		sb.append("fullName");
		sb.append('=');
		sb.append(((this.fullName == null) ? "<null>" : this.fullName));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}