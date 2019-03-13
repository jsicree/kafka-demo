package com.kafkademo.simpleproducer.adapter.rest;

import java.io.Serializable;

import javax.annotation.Generated;

public class DispatchRequest implements Serializable {

	private static final long serialVersionUID = -1144137811934989571L;

	private String source;
	private String body;

	@Generated("SparkTools")
	private DispatchRequest(Builder builder) {
		this.source = builder.source;
		this.body = builder.body;
	}

	public DispatchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		DispatchRequest other = (DispatchRequest) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DispatchRequest [source=");
		builder.append(source);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link DispatchRequest}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DispatchRequest}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String source;
		private String body;

		private Builder() {
		}

		public Builder withBody(String body) {
			this.body = body;
			return this;
		}

		public DispatchRequest build() {
			return new DispatchRequest(this);
		}
	}

}
