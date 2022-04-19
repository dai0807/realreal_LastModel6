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
	System.out.println("UpdatePurchaseAction : �Գ��� " );

	
	int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // ���δ�Ʈ no
	System.out.println("tranNo::" + tranNo  );

 	String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 


	Purchase purchase =new Purchase() ;
	purchase.setTranNo(tranNo);  //  

	purchase.setPaymentOption(request.getParameter("paymentOption"));  // ���Ź��
	purchase.setReceiverName( request.getParameter("receiverName"));  // ������ �̸� 
 	purchase.setReceiverPhone(request.getParameter("receiverPhone") ); //�޴��� ��ȣ 
	purchase.setDivyAddr(request.getParameter("divyAddr"));  // ����� �ּ� 
	purchase.setDivyRequest( request.getParameter("receiverRequest"));// ���� ��û ���� 
	purchase.setDivyDate(request.getParameter("receiverDate"));  // ��ۿ�û ��¥ 
	System.out.println("pucrase page����  " + purchase); 

	
	PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
	purchaseSerivce.updatePurchase(purchase);
	
//	purchase = purchaseSerivce.getPurchase(tranNo);
	System.out.println(purchase);
	
 	purchase = purchaseSerivce.getPurchase(tranNo);
 System.out.println("�� purchase " + purchase); 
//	
//
//	
	System.out.println("update :: Action  �� ");
	
	request.setAttribute("purchase", purchase);
	request.setAttribute("buyer_id", buyer_id);

	
	
return "forward:/purchase/getPurchaseView.jsp" ;  

}

}
