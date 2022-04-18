package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;

/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
//@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService ;
	
	@Test
	public void testAddUser() throws Exception{
			
			Product product = new Product () ; 
			product.setProdName("�ֽ�");
			product.setProdDetail("���������̽�");
			product.setPrice(10000);
			product.setManuDate("2020-01-20");
			product.setFileName("air.png");

	    	productService.addProduct(product) 	;
 			
			Assert.assertEquals("������",product.getProdName());
			Assert.assertEquals("���������̽�", product.getProdDetail());
			Assert.assertEquals(10000, product.getPrice());

			Assert.assertEquals("2020-01-20" , product.getManuDate());
			Assert.assertEquals("air.png", product.getFileName());
		
	}
	
//	@Test
	public void testUpdateUser() throws Exception{
		
		Product product = new Product() ;
		product.setProdNo(10043);
		product.setProdName("������ Pro");
		product.setProdDetail("�����");
		product.setPrice(30000);
		product.setManuDate("2020-01-20");
		product.setFileName("air.png");
		
		productService.updateProduct(product);
		
		Assert.assertEquals("������ Pro",product.getProdName());
		Assert.assertEquals("�����", product.getProdDetail());
		Assert.assertEquals(30000, product.getPrice());
		Assert.assertEquals("2020-01-20" , product.getManuDate());
		Assert.assertEquals("air.png", product.getFileName());
	
	}
	
 	//@Test
	public void tesfindProduct() throws Exception {
		Product product = new Product() ;
		System.out.println("����");

		product  =  productService.getProduct(10043) ;
		System.out.println(product);
		
		Assert.assertEquals("������ Pro",product.getProdName());
		Assert.assertEquals("�����", product.getProdDetail());
		Assert.assertEquals(30000, product.getPrice());
 		Assert.assertEquals("air.png", product.getFileName());
		
		
	}
	
// 	@Test
 	public void testfindListProduct() throws Exception{
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("������");
	 	
	 	Map<String,Object> map = productService.getProductList(search);
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	System.out.println("=======================================");
		System.out.println(list);
			 	
			 	totalCount = (Integer)map.get("totalCount");
			 	System.out.println(totalCount);
			 	
 	}

 	
 	
}
