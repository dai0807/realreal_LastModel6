package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class GetProductAction extends Action {
				//GetProductAction
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int  prodNo = Integer.parseInt(request.getParameter("prodNo")) ; 
		
 		
		ProductService service = new ProductServiceImpl() ; 
		 Product prod = service.getProduct(prodNo);
		 service.getProduct(prodNo) ;
		
		request.setAttribute("Product", prod);
		request.setAttribute("tranCode",request.getParameter("tranCode"));

		//  쿠키 열개     response.addCookie(new Cookie("name", "dololak")); 


 		
		Cookie cookies = new Cookie("history", (request.getParameter("prodNo"))  ) ; // 쿠키에 설명을 추가한다 c.setComment("회원번호") ;
 		 response.addCookie(cookies);
		
 		 	// 쿠키 추가
 			System.out.println("쿠키:: "+cookies);
 			
		//return  "" ;
		return "forward:/product/getProduct.jsp" ;  // 보옂ㄹ 페이지 만들기
		
	}

}
