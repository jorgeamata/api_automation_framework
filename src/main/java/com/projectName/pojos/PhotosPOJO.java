package com.projectName.pojos;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "photos" })


public class PhotosPOJO {

	@JsonProperty("photos")
	private List<PhotoPOJO> photos = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PhotosPOJO() {
	}

	/**
	 *
	 * @param photos
	 */
	public PhotosPOJO(List<PhotoPOJO> photos) {
		super();
		this.photos = photos;
	}

	@JsonProperty("photos")
	public List<PhotoPOJO> getPhotos() {
		return photos;
	}

	@JsonProperty("photos")
	public void setPhotos(List<PhotoPOJO> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "PhotosPOJO [photos=" + photos + "]";
	}

}