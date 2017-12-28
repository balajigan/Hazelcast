package com.batria;

public class Order_line_items
{
    private String order_unit;

    private String product_id;

    private String order_qty;

    public String getOrder_unit ()
    {
        return order_unit;
    }

    public void setOrder_unit (String order_unit)
    {
        this.order_unit = order_unit;
    }

    public String getProduct_id ()
    {
        return product_id;
    }

    public void setProduct_id (String product_id)
    {
        this.product_id = product_id;
    }

    public String getOrder_qty ()
    {
        return order_qty;
    }

    public void setOrder_qty (String order_qty)
    {
        this.order_qty = order_qty;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [order_unit = "+order_unit+", product_id = "+product_id+", order_qty = "+order_qty+"]";
    }
}
