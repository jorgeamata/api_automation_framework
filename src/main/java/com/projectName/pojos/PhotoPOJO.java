package com.projectName.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "sol", "camera", "img_src", "earth_date", "rover" })

public class PhotoPOJO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("sol")
	private Integer sol;
	@JsonProperty("camera")
	private CameraPOJO camera;
	@JsonProperty("img_src")
	private String imgSrc;
	@JsonProperty("earth_date")
	private String earthDate;
	@JsonProperty("rover")
	private RoverPOJO rover;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PhotoPOJO() {
	}

	/**
	 *
	 * @param sol
	 * @param id
	 * @param camera
	 * @param earthDate
	 * @param rover
	 * @param imgSrc
	 */
	public PhotoPOJO(Integer id, Integer sol, CameraPOJO camera, String imgSrc, String earthDate, RoverPOJO rover) {
		super();
		this.id = id;
		this.sol = sol;
		this.camera = camera;
		this.imgSrc = imgSrc;
		this.earthDate = earthDate;
		this.rover = rover;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("sol")
	public Integer getSol() {
		return sol;
	}

	@JsonProperty("sol")
	public void setSol(Integer sol) {
		this.sol = sol;
	}

	@JsonProperty("camera")
	public CameraPOJO getCamera() {
		return camera;
	}

	@JsonProperty("camera")
	public void setCamera(CameraPOJO camera) {
		this.camera = camera;
	}

	@JsonProperty("img_src")
	public String getImgSrc() {
		return imgSrc;
	}

	@JsonProperty("img_src")
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@JsonProperty("earth_date")
	public String getEarthDate() {
		return earthDate;
	}

	@JsonProperty("earth_date")
	public void setEarthDate(String earthDate) {
		this.earthDate = earthDate;
	}

	@JsonProperty("rover")
	public RoverPOJO getRover() {
		return rover;
	}

	@JsonProperty("rover")
	public void setRover(RoverPOJO rover) {
		this.rover = rover;
	}

	@Override
	public String toString() {
		return "PhotoPOJO [id=" + id + ", sol=" + sol + ", camera=" + camera + ", imgSrc=" + imgSrc + ", earthDate="
				+ earthDate + ", rover=" + rover + "]";
	}
	
	

}