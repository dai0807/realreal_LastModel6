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
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
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
			product.setProdName("최신");
			product.setProdDetail("곰돌이케이스");
			product.setPrice(10000);
			product.setManuDate("2020-01-20");
			product.setFileName("air.png");

	    	productService.addProduct(product) 	;
 			
			Assert.assertEquals("에어팟",product.getProdName());
			Assert.assertEquals("곰돌이케이스", product.getProdDetail());
			Assert.assertEquals(10000, product.getPrice());

			Assert.assertEquals("2020-01-20" , product.getManuDate());
			Assert.assertEquals("air.png", product.getFileName());
		
	}
	
//	@Test
	public void testUpdateUser() throws Exception{
		
		Product product = new Product() ;
		product.setProdNo(10043);
		product.setProdName("에어팟 Pro");
		product.setProdDetail("노랑색");
		product.setPrice(30000);
		product.setManuDate("2020-01-20");
		product.setFileName("air.png");
		
		productService.updateProduct(product);
		
		Assert.assertEquals("에어팟 Pro",product.getProdName());
		Assert.assertEquals("노랑색", product.getProdDetail());
		Assert.assertEquals(30000, product.getPrice());
		Assert.assertEquals("2020-01-20" , product.getManuDate());
		Assert.assertEquals("air.png", product.getFileName());
	
	}
	
 	//@Test
	public void tesfindProduct() throws Exception {
		Product product = new Product() ;
		System.out.println("시작");

		product  =  productService.getProduct(10043) ;
		System.out.println(product);
		
		Assert.assertEquals("에어팟 Pro",product.getProdName());
		Assert.assertEquals("노랑색", product.getProdDetail());
		Assert.assertEquals(30000, product.getPrice());
 		Assert.assertEquals("air.png", product.getFileName());
		
		
	}
	
// 	@Test
 	public void testfindListProduct() throws Exception{
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("에어팟");
	 	
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
