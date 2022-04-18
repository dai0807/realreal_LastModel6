package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		Product prod = new Product(); 
		prod.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		prod.setProdName(request.getParameter("prodName")); // 상품명 
		String proD = request.getParameter("prodName") ;
		System.out.println("상품명의 값 : " + proD);

		prod.setProdDetail(request.getParameter("prodDetail"));  // 상품상세 
		prod.setManuDate(request.getParameter("manuDate").replaceAll("-", ""));  // 제조일자
		System.out.println("price 1: "+request.getParameter("price"));
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("price : " + price);
		prod.setPrice(price); // 가격

		
		
		//	prod.setPrice(Integer.parseInt(request.getParameter("price").trim())); // 가격
		prod.setFileName(request.getParameter("fileName"));  // 상품이미지

		
		
		ProductService service = new ProductServiceImpl() ; 
		service.updateProduct(prod) ;
		request.setAttribute("Product", prod); 
		
		
		//어덯게 
		
		
		//return  "redirect:/getProduct.do?prodNo="+request.getParameter("prodNo") ;  
		return  "forward:/getProduct.do?prodNo="+request.getParameter("prodNo") ;  

	}

}
