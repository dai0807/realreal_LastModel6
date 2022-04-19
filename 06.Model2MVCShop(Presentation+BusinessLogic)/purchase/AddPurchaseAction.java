package com.model2.mvc.view.purchase;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class AddPurchaseAction extends Action {
	//GetProductAction
@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
 
	
	System.out.println("1");
	String  buyerId =  request.getParameter("buyerId") ; //  유저 아이디 
	System.out.println("2");

	int  prodNo = Integer.parseInt(request.getParameter("prodNo")) ; //  프로덕트 no
	System.out.println("3");

	String tranCode = request.getParameter("tranCode");
	System.out.println("4");

	ProductService productservice = new ProductServiceImpl() ;
	Product pubchaseProd = productservice.getProduct(prodNo); // 프로덕트 넣기 
	
	UserService userService=new UserServiceImpl();
	
	User pubchaseUser=userService.getUser(buyerId);
	
	PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
	
	
  

	Purchase purchase =new Purchase() ;
	purchase.setBuyer(pubchaseUser);
	purchase.setPurchaseProd(pubchaseProd);

 	purchase.setReceiverPhone(request.getParameter("receiverPhone") ); //휴대폰 번호 
	purchase.setDivyAddr(request.getParameter("receiverAddr"));  // 배송지 주소 
	purchase.setDivyDate(request.getParameter("receiverDate"));  // 배송요청 날짜 
	purchase.setDivyRequest( request.getParameter("receiverRequest"));// 구매 요청 사항 
	purchase.setPaymentOption(request.getParameter("paymentOption"));  // 구매방식
	purchase.setReceiverName( request.getParameter("receiverName"));  // 구매자 이름 
	purchase.setTranCode( request.getParameter("tranCode")); // 트랜 코드가 0 이면 //구매 완료 
	//이제 User,Prouct 값 받아와서 , insert DAO해서 값 집어 넣기! 
	//그래서 와서 받은 값을 PucrchaseView로 forward로 쏴서 보여주기 
	
	
 	purchaseSerivce.addPurchase(purchase);
	request.setAttribute("Purchase", purchase);
	request.setAttribute("buyerId", buyerId);

	System.out.println("정보들 들어옴 " + purchase);
	System.out.println("AddPurchaseAction Page  끝!! ---  ");

return "forward:/purchase/receiptView.jsp" ;  

}

}
