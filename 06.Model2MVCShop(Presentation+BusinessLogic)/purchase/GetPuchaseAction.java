package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class GetPuchaseAction extends Action   {
 		//GetProductAction
	@Override
	public String execute(	HttpServletRequest request,
										HttpServletResponse response) throws Exception {
		
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 
 		System.out.println("  buyer_id " + buyer_id);
		int  tranNo = Integer.parseInt(request.getParameter("tranNo")); // 트랜코드 가져 오기 
	//	Purchase pucPurchase = new ()
		// 시바ㅏㅏ
		Purchase purchase =new Purchase() ;
	
				
				
		//비지니스 로직 수행 
				PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
				purchase = purchaseSerivce.getPurchase(tranNo);
				System.out.println(purchase);
				
				request.setAttribute("purchase", purchase);
				request.setAttribute("buyer_id", buyer_id);

				
	return "forward:/purchase/getPurchaseView.jsp" ;  // 

	}

}
