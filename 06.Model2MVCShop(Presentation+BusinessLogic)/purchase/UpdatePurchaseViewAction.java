package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
 
public class UpdatePurchaseViewAction extends Action{

@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {


	
	System.out.println("UpdatePurchaseViewAction View옴 ");
	String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 
		System.out.println("  buyer_id " + buyer_id);
	int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // 트랜코드 가져 오기 
//	Purchase pucPurchase = new ()
	// 시바ㅏㅏ
	System.out.println(tranNo);
	Purchase purchase =new Purchase() ;
	
	
	
	//비지니스 로직 수행 
			PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
			purchase = purchaseSerivce.getPurchase(tranNo);
			System.out.println(purchase);

			
			request.setAttribute("purchase", purchase);
			request.setAttribute("buyer_id", buyer_id);
			request.setAttribute("tranNo", tranNo);

	
	
return "forward:/purchase/updatePurchaseView.jsp" ;   

}

}
