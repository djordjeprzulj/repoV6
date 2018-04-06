package com.example.v5data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the t_product database table.
 * 
 */
@Entity
@Table(name="t_product")
@NamedQuery(name="TProduct.findAll", query="SELECT t FROM TProduct t")
public class TProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private BigDecimal price;

	//bi-directional many-to-one association to TOrderItem
	@OneToMany(mappedBy="TProduct")
	private List<TOrderItem> TOrderItems;

	public TProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<TOrderItem> getTOrderItems() {
		return this.TOrderItems;
	}

	public void setTOrderItems(List<TOrderItem> TOrderItems) {
		this.TOrderItems = TOrderItems;
	}

	public TOrderItem addTOrderItem(TOrderItem TOrderItem) {
		getTOrderItems().add(TOrderItem);
		TOrderItem.setTProduct(this);

		return TOrderItem;
	}

	public TOrderItem removeTOrderItem(TOrderItem TOrderItem) {
		getTOrderItems().remove(TOrderItem);
		TOrderItem.setTProduct(null);

		return TOrderItem;
	}

}