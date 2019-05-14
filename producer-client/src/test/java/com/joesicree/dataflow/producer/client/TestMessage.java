package com.joesicree.dataflow.producer.client;

import javax.annotation.Generated;

public class TestMessage {

	private Long id;
	private String message;

	@Generated("SparkTools")
	private TestMessage(Builder builder) {
		this.id = builder.id;
		this.message = builder.message;
	}
	
	public TestMessage() {
		// TODO Auto-generated constructor stub
	}

	public TestMessage(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		TestMessage other = (TestMessage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TestMessage [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link TestMessage}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link TestMessage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Long id;
		private String message;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public TestMessage build() {
			return new TestMessage(this);
		}
	}
	
}
