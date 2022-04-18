package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class ListmanageProductAction  extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
 
	//	return  null ;
		
		
		
		// 여기 매니지 페이지 따로 만들거임 , 그래서 어느 정도 수정 한 뒤에 옮기기 
		return  "" ;  
		
	}

}
