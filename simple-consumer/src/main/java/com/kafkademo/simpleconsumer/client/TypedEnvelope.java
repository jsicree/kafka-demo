package com.kafkademo.simpleconsumer.client;

import java.io.Serializable;
import javax.annotation.Generated;

/*
 * @deprecated There were issues trying to use a typed envelope. May return to this at a later date 
 */
public class TypedEnvelope<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1496070996949590441L;
	private String guid;
	private String batchId;
	private Long timestamp;
	private OperationType opType;
	private Long payloadId;
	private T payload;

	@Generated("SparkTools")
	private TypedEnvelope(Builder<T> builder) {
		this.guid = builder.guid;
		this.batchId = builder.batchId;
		this.timestamp = builder.timestamp;
		this.opType = builder.opType;
		this.payloadId = builder.payloadId;
		this.payload = (T) builder.payload;
	}

	public TypedEnvelope() {
		super();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public OperationType getOpType() {
		return opType;
	}

	public void setOpType(OperationType opType) {
		this.opType = opType;
	}

	public Long getPayloadId() {
		return payloadId;
	}

	public void setPayloadId(Long payloadId) {
		this.payloadId = payloadId;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guid == null) ? 0 : guid.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((opType == null) ? 0 : opType.hashCode());
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime * result + ((payloadId == null) ? 0 : payloadId.hashCode());
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
		TypedEnvelope<?> other = (TypedEnvelope<?>) obj;
		if (guid == null) {
			if (other.guid != null)
				return false;
		} else if (!guid.equals(other.guid))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (opType != other.opType)
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (payloadId == null) {
			if (other.payloadId != null)
				return false;
		} else if (!payloadId.equals(other.payloadId))
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
		builder.append("Envelope [guid=");
		builder.append(guid);
		builder.append(", batchId=");
		builder.append(batchId);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", opType=");
		builder.append(opType);
		builder.append(", payloadId=");
		builder.append(payloadId);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Creates builder to build {@link TypedEnvelope}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder<TypedEnvelope<?>> builder() {
		return new Builder<TypedEnvelope<?>>();
	}

	/**
	 * Builder to build {@link TypedEnvelope}.
	 */
	@Generated("SparkTools")
	public static final class Builder<T> {
		private String guid;
		private String batchId;
		private Long timestamp;
		private OperationType opType = OperationType.DEFAULT;
		private Long payloadId;
		private Object payload;

		private Builder() {
		}

		public Builder<T> withGuid(String guid) {
			this.guid = guid;
			return this;
		}

		public Builder<T> withBatchId(String batchId) {
			this.batchId = batchId;
			return this;
		}
		
		public Builder<T> withTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder<T> withOpType(OperationType opType) {
			this.opType = opType;
			return this;
		}

		public Builder<T> withPayloadId(Long payloadId) {
			this.payloadId = payloadId;
			return this;
		}

		public Builder<T> withPayload(Object payload) {
			this.payload = payload;
			return this;
		}

		public TypedEnvelope<T> build() {
			return new TypedEnvelope<T>(this);
		}
	}
	
	
	
}
