package com.kafkademo.simpleproducer.domain;

import java.io.Serializable;

import javax.annotation.Generated;

public class ProducerMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6768559111285193597L;
	private String guid;
	private String source;
	private String body;
	private String newField;

	@Generated("SparkTools")
	private ProducerMessage(Builder builder) {
		this.guid = builder.guid;
		this.source = builder.source;
		this.body = builder.body;
		this.newField = builder.newField;
	}

	public ProducerMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
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

	public String getNewField() {
		return newField;
	}

	public void setNewField(String newField) {
		this.newField = newField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((guid == null) ? 0 : guid.hashCode());
		result = prime * result + ((newField == null) ? 0 : newField.hashCode());
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
		ProducerMessage other = (ProducerMessage) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (guid == null) {
			if (other.guid != null)
				return false;
		} else if (!guid.equals(other.guid))
			return false;
		if (newField == null) {
			if (other.newField != null)
				return false;
		} else if (!newField.equals(other.newField))
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
		builder.append("ProducerMessage [guid=");
		builder.append(guid);
		builder.append(", source=");
		builder.append(source);
		builder.append(", body=");
		builder.append(body);
		builder.append(", newField=");
		builder.append(newField);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link ProducerMessage}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ProducerMessage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String guid;
		private String source;
		private String body;
		private String newField;

		private Builder() {
		}

		public Builder withGuid(String guid) {
			this.guid = guid;
			return this;
		}

		public Builder withSource(String source) {
			this.source = source;
			return this;
		}

		public Builder withBody(String body) {
			this.body = body;
			return this;
		}

		public Builder withNewField(String newField) {
			this.newField = newField;
			return this;
		}

		public ProducerMessage build() {
			return new ProducerMessage(this);
		}
	}

	
	
}
