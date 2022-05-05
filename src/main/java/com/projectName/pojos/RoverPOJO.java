package com.projectName.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "landing_date", "launch_date", "status" })

public class RoverPOJO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("landing_date")
	private String landingDate;
	@JsonProperty("launch_date")
	private String launchDate;
	@JsonProperty("status")
	private String status;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RoverPOJO() {
	}

	/**
	 *
	 * @param name
	 * @param id
	 * @param launchDate
	 * @param landingDate
	 * @param status
	 */
	public RoverPOJO(Integer id, String name, String landingDate, String launchDate, String status) {
		super();
		this.id = id;
		this.name = name;
		this.landingDate = landingDate;
		this.launchDate = launchDate;
		this.status = status;
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

	@JsonProperty("landing_date")
	public String getLandingDate() {
		return landingDate;
	}

	@JsonProperty("landing_date")
	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	@JsonProperty("launch_date")
	public String getLaunchDate() {
		return launchDate;
	}

	@JsonProperty("launch_date")
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RoverPOJO [id=" + id + ", name=" + name + ", landingDate=" + landingDate + ", launchDate=" + launchDate
				+ ", status=" + status + "]";
	}
	
	

}