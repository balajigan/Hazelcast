
package com.batria;
import com.batria.Order;
import com.batria.Order_line_items;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import java.util.Random;

public class GenerateOrder
{
	private static Logger logger = Logger.getLogger(GenerateOrder.class);
	private String[] productPrefix = {"KRC", "ABD", "RHG", "KGB", "WRD", "TRS", "DSG", "LOP", "TOP", "DWE", "WQS","USF", "WHG","KXV","UGF","KDG" };
	public GenerateOrder()
	{
	}
	public String getOrderJsonString(int orderId)
	{
		Order order = new Order();
		List<Order_line_items> orderLineItems = new ArrayList<Order_line_items>();

		for(int lineItemCount =0; lineItemCount < 20; lineItemCount ++)
		{
			Order_line_items orderLineItem = new Order_line_items();
			orderLineItem.setOrder_unit("case");
			orderLineItem.setProduct_id("productId"+ createProductId(lineItemCount));
			orderLineItem.setOrder_qty(Integer.toString(10*lineItemCount));

			orderLineItems.add(orderLineItem);
		}
		order.setOrder_line_items(orderLineItems);
		order.setOrder_id(Integer.toString(orderId));
		order.setOrder_date(createOrderDate());
		order.setOrder_market("Market"+Integer.toString(orderId));
		order.setOrder_dc("OrderDc"+Integer.toString(orderId));
		order.setOrder_source("OrderSource"+Integer.toString(orderId));
		order.setOrder_taken_by("AgentId"+Integer.toString(orderId));
		order.setDelivery_notes("Delivery Note for order Id"+Integer.toString(orderId));

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try
		{
			jsonInString = mapper.writeValueAsString(order);
		}
		catch(Exception ex)
		{
			logger.error("Exception while converting JSON to string");
			ex.printStackTrace();
		}
		return jsonInString;
	}
	public String createProductId(int id)
	{
		Random rand = new Random();
		int num1 = rand.nextInt(15);
		int num2 = rand.nextInt(15);
		int num3 = rand.nextInt(15);
		String prdId = productPrefix[num1] + productPrefix[num2] + productPrefix[num3] + Integer.toString(id);
		return prdId;
	}
	public String createOrderDate()
	{
		Random rand = new Random();
		int num1 = rand.nextInt(12);
		int num2 = rand.nextInt(28);
		int num3 = 2000 + rand.nextInt(17);
		return Integer.toString(num1)+"-"+Integer.toString(num2) + "-" + Integer.toString(num3); 
	}

}
