package com.example.v5data.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_order database table.
 * 
 */
@Entity
@Table(name="t_order")
@NamedQuery(name="TOrder.findAll", query="SELECT t FROM TOrder t")
public class TOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	//bi-directional many-to-one association to TCustomer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private TCustomer TCustomer;

	//bi-directional many-to-one association to TOrderItem
	@OneToMany(mappedBy="TOrder")
	private List<TOrderItem> TOrderItems;

	public TOrder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public TCustomer getTCustomer() {
		return this.TCustomer;
	}

	public void setTCustomer(TCustomer TCustomer) {
		this.TCustomer = TCustomer;
	}

	@JsonIgnore
	public List<TOrderItem> getTOrderItems() {
		return this.TOrderItems;
	}

	public void setTOrderItems(List<TOrderItem> TOrderItems) {
		this.TOrderItems = TOrderItems;
	}

	public TOrderItem addTOrderItem(TOrderItem TOrderItem) {
		getTOrderItems().add(TOrderItem);
		TOrderItem.setTOrder(this);

		return TOrderItem;
	}

	public TOrderItem removeTOrderItem(TOrderItem TOrderItem) {
		getTOrderItems().remove(TOrderItem);
		TOrderItem.setTOrder(null);

		return TOrderItem;
	}

}