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
	String  buyerId =  request.getParameter("buyerId") ; //  ���� ���̵� 
	System.out.println("2");

	int  prodNo = Integer.parseInt(request.getParameter("prodNo")) ; //  ���δ�Ʈ no
	System.out.println("3");

	String tranCode = request.getParameter("tranCode");
	System.out.println("4");

	ProductService productservice = new ProductServiceImpl() ;
	Product pubchaseProd = productservice.getProduct(prodNo); // ���δ�Ʈ �ֱ� 
	
	UserService userService=new UserServiceImpl();
	
	User pubchaseUser=userService.getUser(buyerId);
	
	PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
	
	
  

	Purchase purchase =new Purchase() ;
	purchase.setBuyer(pubchaseUser);
	purchase.setPurchaseProd(pubchaseProd);

 	purchase.setReceiverPhone(request.getParameter("receiverPhone") ); //�޴��� ��ȣ 
	purchase.setDivyAddr(request.getParameter("receiverAddr"));  // ����� �ּ� 
	purchase.setDivyDate(request.getParameter("receiverDate"));  // ��ۿ�û ��¥ 
	purchase.setDivyRequest( request.getParameter("receiverRequest"));// ���� ��û ���� 
	purchase.setPaymentOption(request.getParameter("paymentOption"));  // ���Ź��
	purchase.setReceiverName( request.getParameter("receiverName"));  // ������ �̸� 
	purchase.setTranCode( request.getParameter("tranCode")); // Ʈ�� �ڵ尡 0 �̸� //���� �Ϸ� 
	//���� User,Prouct �� �޾ƿͼ� , insert DAO�ؼ� �� ���� �ֱ�! 
	//�׷��� �ͼ� ���� ���� PucrchaseView�� forward�� ���� �����ֱ� 
	
	
 	purchaseSerivce.addPurchase(purchase);
	request.setAttribute("Purchase", purchase);
	request.setAttribute("buyerId", buyerId);

	System.out.println("������ ���� " + purchase);
	System.out.println("AddPurchaseAction Page  ��!! ---  ");

return "forward:/purchase/receiptView.jsp" ;  

}

}
