package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class AddProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Product prod = new Product(); 
		
		prod.setProdName(request.getParameter("prodName")); // 상품명 
		prod.setProdDetail(request.getParameter("prodDetail"));  // 상품상세 
		prod.setManuDate(request.getParameter("manuDate").replaceAll("-", ""));  // 제조일자
		prod.setPrice(Integer.parseInt(request.getParameter("price"))); // 가격
		prod.setFileName(request.getParameter("fileName"));  // 상품이미지

		
 
		
		ProductService service = new ProductServiceImpl() ; 
		service.addProduct(prod) ;
		request.setAttribute("Product", prod); 
		// 오브젝트로 안 올려 보내면 바로 터집니다! 당신은 바보 입니다! 
		System.out.println(prod);

		

	
		return "forward:/product/addgetProduct.jsp"; // 열로바로 보내기
	}

}
