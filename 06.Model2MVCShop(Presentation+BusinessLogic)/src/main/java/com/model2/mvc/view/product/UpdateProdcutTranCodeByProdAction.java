package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class UpdateProdcutTranCodeByProdAction extends Action   {
		//GetProductAction
@Override
public String execute(	HttpServletRequest request,
									HttpServletResponse response) throws Exception {
 
	System.out.println("UpdateProdcutTranCodeByProdAction 옴 ");
	Purchase purchase =new Purchase() ;
	
 
	int  prodNo = Integer.parseInt(request.getParameter("prodNo")); // 프로덕트 NO 
	System.out.println("prodNo:::  +  " + prodNo );
 
	String  tranCode = request.getParameter("tranCode") ; 

	System.out.println("tranCode:::  +  " + tranCode );

	//비지니스 로직 수행 
	ProductService productService = new ProductServiceImpl() ;
	PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
	int tran_no =  productService.findTrandtranNo(prodNo) ; 
	System.out.println("tran_no"); 
	purchase = purchaseSerivce.getPurchase(tran_no); // tran_no 찾아서 get에 넘김		
	purchase.setTranCode(tranCode); // 트랜 코드 삽입
	System.out.println("purchase::: "+purchase);
  
	purchaseSerivce.updateTranCode(purchase);
	
	
	
return "forward:/listProduct.do?currentPage="+(request.getParameter("currentPage")) ;   
}

}
