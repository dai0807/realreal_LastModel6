package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateTranCodeAction extends Action{

@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {

	System.out.println("UpdateTranCodeByProdAction �� ");

	Purchase purchase =new Purchase() ;

 
	
		int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // Ʈ���ڵ� ���� ���� 
		String  tranCode = request.getParameter("tranCode") ; 
	
	 
 	
	
		
		//�����Ͻ� ���� ���� 
		PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
		purchase = purchaseSerivce.getPurchase(tranNo);		
		purchase.setTranCode(tranCode); // Ʈ�� �ڵ� ����
	
		System.out.println("purchase::: "+purchase);
		purchaseSerivce.updateTranCode(purchase);
		



	//	Purchase pucPurchase = new ()
	
 
 	
return "forward:/listPurchase.do?currentPage="+(request.getParameter("currentPage")) ;   

}

}

