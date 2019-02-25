package com.kafkademo.dataflow.testclient.domain;

import java.io.Serializable;
import javax.annotation.Generated;

public class Address implements Serializable {

	private static final long serialVersionUID = -3418509813621030602L;

	private String primaryLine;
	private String secondaryLine;
	private String city;
	private String state;
	private String zip;

	@Generated("SparkTools")
	private Address(Builder builder) {
		this.primaryLine = builder.primaryLine;
		this.secondaryLine = builder.secondaryLine;
		this.city = builder.city;
		this.state = builder.state;
		this.zip = builder.zip;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrimaryLine() {
		return primaryLine;
	}

	public void setPrimaryLine(String primaryLine) {
		this.primaryLine = primaryLine;
	}

	public String getSecondaryLine() {
		return secondaryLine;
	}

	public void setSecondaryLine(String secondaryLine) {
		this.secondaryLine = secondaryLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((primaryLine == null) ? 0 : primaryLine.hashCode());
		result = prime * result + ((secondaryLine == null) ? 0 : secondaryLine.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (primaryLine == null) {
			if (other.primaryLine != null)
				return false;
		} else if (!primaryLine.equals(other.primaryLine))
			return false;
		if (secondaryLine == null) {
			if (other.secondaryLine != null)
				return false;
		} else if (!secondaryLine.equals(other.secondaryLine))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [primaryLine=");
		builder.append(primaryLine);
		builder.append(", secondaryLine=");
		builder.append(secondaryLine);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zip=");
		builder.append(zip);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link Address}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Address}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String primaryLine;
		private String secondaryLine;
		private String city;
		private String state;
		private String zip;

		private Builder() {
		}

		public Builder withPrimaryLine(String primaryLine) {
			this.primaryLine = primaryLine;
			return this;
		}

		public Builder withSecondaryLine(String secondaryLine) {
			this.secondaryLine = secondaryLine;
			return this;
		}

		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		public Builder withState(String state) {
			this.state = state;
			return this;
		}

		public Builder withZip(String zip) {
			this.zip = zip;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}

}
