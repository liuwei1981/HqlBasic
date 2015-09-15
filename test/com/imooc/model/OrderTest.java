package com.imooc.model;


import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.util.HibernateSessionFactory;

public class OrderTest {
	private Session session = null;
	
	@Test
	public void testFromClause(){
		String hql = " from com.imooc.model.Order ";
		
		Query query = session.createQuery(hql);
		List<Order> orders = query.list();
		
		for(Order order : orders){
			System.out.println("tradedate:"+order.getTradeDate());
			
			Set<OrderItem> items = order.getOrderItems();
			for(OrderItem item : items){
				System.out.println(item.getActPrice());
			}
		}
		 
	}

	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

}
