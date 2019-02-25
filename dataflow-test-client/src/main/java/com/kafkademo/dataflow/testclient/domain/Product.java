package com.kafkademo.dataflow.testclient.domain;

import java.io.Serializable;

import javax.annotation.Generated;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 3390553642230703236L;

	private Long id;
	private String sku;
	private String name;
	@Generated("SparkTools")
	private Product(Builder builder) {
		this.id = builder.id;
		this.sku = builder.sku;
		this.name = builder.name;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", sku=");
		builder.append(sku);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Creates builder to build {@link Product}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link Product}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Long id;
		private String sku;
		private String name;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withSku(String sku) {
			this.sku = sku;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}
	
	

}
