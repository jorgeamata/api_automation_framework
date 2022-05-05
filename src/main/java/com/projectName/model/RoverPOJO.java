package com.projectName.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "landing_date", "launch_date", "status", "max_sol", "max_date", "total_photos",
		"cameras" })
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
	@JsonProperty("max_sol")
	private Integer maxSol;
	@JsonProperty("max_date")
	private String maxDate;
	@JsonProperty("total_photos")
	private Integer totalPhotos;
	@JsonProperty("cameras")
	private List<CamerasPOJO> cameras = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RoverPOJO() {
	}

	/**
	 *
	 * @param cameras
	 * @param maxSol
	 * @param name
	 * @param maxDate
	 * @param totalPhotos
	 * @param id
	 * @param launchDate
	 * @param landingDate
	 * @param status
	 */
	public RoverPOJO(Integer id, String name, String landingDate, String launchDate, String status, Integer maxSol,
			String maxDate, Integer totalPhotos, List<CamerasPOJO> cameras) {
		super();
		this.id = id;
		this.name = name;
		this.landingDate = landingDate;
		this.launchDate = launchDate;
		this.status = status;
		this.maxSol = maxSol;
		this.maxDate = maxDate;
		this.totalPhotos = totalPhotos;
		this.cameras = cameras;
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

	@JsonProperty("max_sol")
	public Integer getMaxSol() {
		return maxSol;
	}

	@JsonProperty("max_sol")
	public void setMaxSol(Integer maxSol) {
		this.maxSol = maxSol;
	}

	@JsonProperty("max_date")
	public String getMaxDate() {
		return maxDate;
	}

	@JsonProperty("max_date")
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	@JsonProperty("total_photos")
	public Integer getTotalPhotos() {
		return totalPhotos;
	}

	@JsonProperty("total_photos")
	public void setTotalPhotos(Integer totalPhotos) {
		this.totalPhotos = totalPhotos;
	}

	@JsonProperty("cameras")
	public List<CamerasPOJO> getCameras() {
		return cameras;
	}

	@JsonProperty("cameras")
	public void setCameras(List<CamerasPOJO> cameras) {
		this.cameras = cameras;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RoverPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("landingDate");
		sb.append('=');
		sb.append(((this.landingDate == null) ? "<null>" : this.landingDate));
		sb.append(',');
		sb.append("launchDate");
		sb.append('=');
		sb.append(((this.launchDate == null) ? "<null>" : this.launchDate));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null) ? "<null>" : this.status));
		sb.append(',');
		sb.append("maxSol");
		sb.append('=');
		sb.append(((this.maxSol == null) ? "<null>" : this.maxSol));
		sb.append(',');
		sb.append("maxDate");
		sb.append('=');
		sb.append(((this.maxDate == null) ? "<null>" : this.maxDate));
		sb.append(',');
		sb.append("totalPhotos");
		sb.append('=');
		sb.append(((this.totalPhotos == null) ? "<null>" : this.totalPhotos));
		sb.append(',');
		sb.append("cameras");
		sb.append('=');
		sb.append(((this.cameras == null) ? "<null>" : this.cameras));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
