package com.kafkademo.dataflow.producer;

import java.io.Serializable;

import javax.annotation.Generated;

public class Envelope implements Serializable {

	private static final long serialVersionUID = 5482726486670149029L;
	private Long timestamp;
	private String payload;

	@Generated("SparkTools")
	private Envelope(Builder builder) {
		this.timestamp = builder.timestamp;
		this.payload = builder.payload;
	}

	public Envelope() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Envelope other = (Envelope) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Envelope [timestamp=");
		builder.append(timestamp);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link Envelope}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Envelope}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Long timestamp;
		private String payload;

		private Builder() {
		}

		public Builder withTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withPayload(String payload) {
			this.payload = payload;
			return this;
		}

		public Envelope build() {
			return new Envelope(this);
		}
	}

}
