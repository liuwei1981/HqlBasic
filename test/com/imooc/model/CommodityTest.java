package com.imooc.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.util.HibernateSessionFactory;

public class CommodityTest {
	private Session session = null;

	@Test
	public void testFromClause() {
		String hql = " from Commodity ";

		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		for (Commodity commodity : commodities) {
			System.out.println("name:" + commodity.getName());
			
			System.out.println("seller:"+commodity.getSeller().getName());
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
