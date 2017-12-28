
package com.batria;
import com.batria.Order_line_items;
import java.util.*;

public class Order
{
    private String delivery_notes;

    private String order_taken_by;

    private String order_source;

    private String order_dc;

    private String order_market;

    private String order_date;

    private String order_id;

    private List<Order_line_items> order_line_items;

    public String getDelivery_notes ()
    {
        return delivery_notes;
    }

    public void setDelivery_notes (String delivery_notes)
    {
        this.delivery_notes = delivery_notes;
    }

    public String getOrder_taken_by ()
    {
        return order_taken_by;
    }

    public void setOrder_taken_by (String order_taken_by)
    {
        this.order_taken_by = order_taken_by;
    }

    public String getOrder_source ()
    {
        return order_source;
    }

    public void setOrder_source (String order_source)
    {
        this.order_source = order_source;
    }

    public String getOrder_dc ()
    {
        return order_dc;
    }

    public void setOrder_dc (String order_dc)
    {
        this.order_dc = order_dc;
    }

    public String getOrder_market ()
    {
        return order_market;
    }

    public void setOrder_market (String order_market)
    {
        this.order_market = order_market;
    }

    public String getOrder_date ()
    {
        return order_date;
    }

    public void setOrder_date (String order_date)
    {
        this.order_date = order_date;
    }

    public String getOrder_id ()
    {
        return order_id;
    }

    public void setOrder_id (String order_id)
    {
        this.order_id = order_id;
    }

    public List<Order_line_items> getOrder_line_items ()
    {
        return order_line_items;
    }

    public void setOrder_line_items (List<Order_line_items> order_line_items)
    {
        this.order_line_items = order_line_items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [delivery_notes = "+delivery_notes+", order_taken_by = "+order_taken_by+", order_source = "+order_source+", order_dc = "+order_dc+", order_market = "+order_market+", order_date = "+order_date+", order_id = "+order_id+", order_line_items = "+order_line_items+"]";
    }
}
