package com.projectName.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "rover_id", "full_name" })

public class CameraPOJO {

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
	public CameraPOJO() {
	}

	/**
	 *
	 * @param name
	 * @param fullName
	 * @param id
	 * @param roverId
	 */
	public CameraPOJO(Integer id, String name, Integer roverId, String fullName) {
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
		return "CameraPOJO [id=" + id + ", name=" + name + ", roverId=" + roverId + ", fullName=" + fullName + "]";
	}
	
	

}