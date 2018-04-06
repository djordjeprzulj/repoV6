package com.example.v5data.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the t_customer database table.
 * 
 */
@Entity
@Table(name="t_customer")
@NamedQuery(name="TCustomer.findAll", query="SELECT t FROM TCustomer t")
public class TCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to TOrder
	@OneToMany(mappedBy="TCustomer")
	private List<TOrder> TOrders;

	public TCustomer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonIgnore
	public List<TOrder> getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(List<TOrder> TOrders) {
		this.TOrders = TOrders;
	}

	public TOrder addTOrder(TOrder TOrder) {
		getTOrders().add(TOrder);
		TOrder.setTCustomer(this);

		return TOrder;
	}

	public TOrder removeTOrder(TOrder TOrder) {
		getTOrders().remove(TOrder);
		TOrder.setTCustomer(null);

		return TOrder;
	}

}