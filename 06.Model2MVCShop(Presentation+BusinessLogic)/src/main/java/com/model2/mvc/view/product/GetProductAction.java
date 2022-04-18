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

		//  ��Ű ����     response.addCookie(new Cookie("name", "dololak")); 


 		
		Cookie cookies = new Cookie("history", (request.getParameter("prodNo"))  ) ; // ��Ű�� ������ �߰��Ѵ� c.setComment("ȸ����ȣ") ;
 		 response.addCookie(cookies);
		
 		 	// ��Ű �߰�
 			System.out.println("��Ű:: "+cookies);
 			
		//return  "" ;
		return "forward:/product/getProduct.jsp" ;  // ������ ������ �����
		
	}

}
