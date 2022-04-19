package com.model2.mvc.view.purchase;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;


public class AddPurchaseViewAction extends Action {
	//GetProductAction
@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
	System.out.println("addPurchase View 페이지 ");
	int  prodNo = Integer.parseInt(request.getParameter("prodNo")) ; // 나와라 번호 

	// User user = (User)request.getSession(true).getAttribute("user")   ;// 세션 가져오기 
	String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 

	
	//ProductService Pservice = new ProductServiceImpl() ; 
	 //Product product = Pservice.getProduct(prodNo) ;

	
	Product product =  com.model2.mvc.service.product.dao.ProductDAO.findProduct(prodNo) ;
	 
System.out.println("user::::"+ buyer_id);
System.out.println("product :::" + product);
		//request.setAttribute("User", user); 
		request.setAttribute("Product", product); 
		request.setAttribute("buyer_id", buyer_id); 

System.out.println("나는 addPurchaseView의 역활을 다 하였다. ");

return "forward:/purchase/addPurchaseView.jsp" ;  // 보옂ㄹ 페이지 만들기

}

}
