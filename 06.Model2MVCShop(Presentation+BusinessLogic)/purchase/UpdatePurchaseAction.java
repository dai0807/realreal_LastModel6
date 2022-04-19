package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdatePurchaseAction  extends Action{

@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
	System.out.println("UpdatePurchaseAction : 왔나용 " );

	
	int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // 프로덕트 no
	System.out.println("tranNo::" + tranNo  );

 	String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 


	Purchase purchase =new Purchase() ;
	purchase.setTranNo(tranNo);  //  

	purchase.setPaymentOption(request.getParameter("paymentOption"));  // 구매방식
	purchase.setReceiverName( request.getParameter("receiverName"));  // 구매자 이름 
 	purchase.setReceiverPhone(request.getParameter("receiverPhone") ); //휴대폰 번호 
	purchase.setDivyAddr(request.getParameter("divyAddr"));  // 배송지 주소 
	purchase.setDivyRequest( request.getParameter("receiverRequest"));// 구매 요청 사항 
	purchase.setDivyDate(request.getParameter("receiverDate"));  // 배송요청 날짜 
	System.out.println("pucrase page에서  " + purchase); 

	
	PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
	purchaseSerivce.updatePurchase(purchase);
	
//	purchase = purchaseSerivce.getPurchase(tranNo);
	System.out.println(purchase);
	
 	purchase = purchaseSerivce.getPurchase(tranNo);
 System.out.println("겟 purchase " + purchase); 
//	
//
//	
	System.out.println("update :: Action  끝 ");
	
	request.setAttribute("purchase", purchase);
	request.setAttribute("buyer_id", buyer_id);

	
	
return "forward:/purchase/getPurchaseView.jsp" ;  

}

}
