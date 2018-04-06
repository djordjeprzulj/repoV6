package com.example.v5data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_order_item database table.
 * 
 */
@Entity
@Table(name="t_order_item")
@NamedQuery(name="TOrderItem.findAll", query="SELECT t FROM TOrderItem t")
public class TOrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int quantity;

	@Column(name="seq_num")
	private int seqNum;

	//bi-directional many-to-one association to TOrder
	@ManyToOne
	@JoinColumn(name="order_id")
	private TOrder TOrder;

	//bi-directional many-to-one association to TProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private TProduct TProduct;

	public TOrderItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

}