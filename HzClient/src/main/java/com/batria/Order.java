
package com.batria;

import java.io.Serializable;

public class Order implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String orderId;
	private String orderDesc;
	private String prdId;
	private int orderQty;

        public String getOrderId()
	{
             return this.orderId;
	}
        public void setOrderId(String orderId)
	{
             this.orderId = orderId;
	}
	public String getOrderDesc()
	{
		return this.orderDesc;
	}
	public void setOrderDesc(String orderDesc)
	{
		this.orderDesc = orderDesc;
	}

	public String getPrdId()
	{
		return this.prdId;
	}
	public void setPrdId(String prdId)
	{
		this.prdId = prdId;
	}

	public int getOrderQty()
	{
		return this.orderQty;
	}
	public void setOrderQty(int orderQty)
	{
		this.orderQty = orderQty;
	}
}
