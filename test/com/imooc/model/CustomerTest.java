package com.imooc.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.util.HibernateSessionFactory;

public class CustomerTest {
	private Session session = null;

	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testFromClause() {
		String hql = "from Customer,Seller";

		Query query = session.createQuery(hql);
		List<Object[]> customers = (List<Object[]>)query.list();
		for (Object[] objs: customers) {
			System.out.println(objs[0]);
			System.out.println(objs[1]);
			System.out.println("//////////////////////////////////////////////");
		}

	}
	
	@Test
	public void testSelect(){
		String hql = "select new map(c.id,c.name) from Customer c";
		Query query = session.createQuery(hql);
		List<Map> list = query.list();
		for(Map list2 : list){
			System.out.println(list2.get("0")); 
			System.out.println(list2.get("1"));
		}
	}

}
