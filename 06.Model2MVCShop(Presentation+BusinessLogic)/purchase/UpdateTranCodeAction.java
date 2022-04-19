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

	System.out.println("UpdateTranCodeByProdAction 옴 ");

	Purchase purchase =new Purchase() ;

 
	
		int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // 트랜코드 가져 오기 
		String  tranCode = request.getParameter("tranCode") ; 
	
	 
 	
	
		
		//비지니스 로직 수행 
		PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
		purchase = purchaseSerivce.getPurchase(tranNo);		
		purchase.setTranCode(tranCode); // 트랜 코드 삽입
	
		System.out.println("purchase::: "+purchase);
		purchaseSerivce.updateTranCode(purchase);
		



	//	Purchase pucPurchase = new ()
	
 
 	
return "forward:/listPurchase.do?currentPage="+(request.getParameter("currentPage")) ;   

}

}

