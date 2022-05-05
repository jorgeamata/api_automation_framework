package com.projectName.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "firstname", "lastname", "totalprice", "depositpaid", "bookingdates", "additionalneeds" })

public class BookingPOJO {

	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("totalprice")
	private Integer totalprice;
	@JsonProperty("depositpaid")
	private Boolean depositpaid;
	@JsonProperty("bookingdates")
	private BookingDatesPOJO bookingdates;
	@JsonProperty("additionalneeds")
	private String additionalneeds;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public BookingPOJO() {
	}

	/**
	 *
	 * @param firstname
	 * @param additionalneeds
	 * @param bookingdates
	 * @param totalprice
	 * @param depositpaid
	 * @param lastname
	 */
	public BookingPOJO(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
			BookingDatesPOJO bookingdates, String additionalneeds) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	@JsonProperty("firstname")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonProperty("totalprice")
	public Integer getTotalprice() {
		return totalprice;
	}

	@JsonProperty("totalprice")
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	@JsonProperty("depositpaid")
	public Boolean getDepositpaid() {
		return depositpaid;
	}

	@JsonProperty("depositpaid")
	public void setDepositpaid(Boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	@JsonProperty("bookingdates")
	public BookingDatesPOJO getBookingdates() {
		return bookingdates;
	}

	@JsonProperty("bookingdates")
	public void setBookingdates(BookingDatesPOJO bookingdates) {
		this.bookingdates = bookingdates;
	}

	@JsonProperty("additionalneeds")
	public String getAdditionalneeds() {
		return additionalneeds;
	}

	@JsonProperty("additionalneeds")
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BookingPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("firstname");
		sb.append('=');
		sb.append(((this.firstname == null) ? "<null>" : this.firstname));
		sb.append(',');
		sb.append("lastname");
		sb.append('=');
		sb.append(((this.lastname == null) ? "<null>" : this.lastname));
		sb.append(',');
		sb.append("totalprice");
		sb.append('=');
		sb.append(((this.totalprice == null) ? "<null>" : this.totalprice));
		sb.append(',');
		sb.append("depositpaid");
		sb.append('=');
		sb.append(((this.depositpaid == null) ? "<null>" : this.depositpaid));
		sb.append(',');
		sb.append("bookingdates");
		sb.append('=');
		sb.append(((this.bookingdates == null) ? "<null>" : this.bookingdates));
		sb.append(',');
		sb.append("additionalneeds");
		sb.append('=');
		sb.append(((this.additionalneeds == null) ? "<null>" : this.additionalneeds));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
