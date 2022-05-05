package com.projectName.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "checkin", "checkout" })

public class BookingDatesPOJO {

	@JsonProperty("checkin")
	private String checkin;
	@JsonProperty("checkout")
	private String checkout;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public BookingDatesPOJO() {
	}

	/**
	 *
	 * @param checkin
	 * @param checkout
	 */
	public BookingDatesPOJO(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@JsonProperty("checkin")
	public String getCheckin() {
		return checkin;
	}

	@JsonProperty("checkin")
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	@JsonProperty("checkout")
	public String getCheckout() {
		return checkout;
	}

	@JsonProperty("checkout")
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BookingDatesPOJO.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("checkin");
		sb.append('=');
		sb.append(((this.checkin == null) ? "<null>" : this.checkin));
		sb.append(',');
		sb.append("checkout");
		sb.append('=');
		sb.append(((this.checkout == null) ? "<null>" : this.checkout));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}