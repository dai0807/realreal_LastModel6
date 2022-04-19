package com.model2.mvc.view.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class ListPurchaseAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
										HttpServletResponse response) throws Exception {

		Search search=new Search();
 
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 
 		System.out.println("  buyer_id " + buyer_id);
		
		int currentPage=1;
		if(request.getParameter("currentPage") != null   ) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("request.getParameter(\"currentPage\") :: " +currentPage );
		}
		search.setCurrentPage(currentPage);
		// web.xml meta-data로부터 상수 추출

		int pageSize =Integer.parseInt(getServletContext().getInitParameter("pageSize"));
		int pageUnit = Integer.parseInt(getServletContext().getInitParameter("pageUnit")) ;
		search.setPageSize(pageSize);
		
		//비지니스 로직 수행 
		PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;
		Map<String,Object> map=purchaseSerivce.GetPurchaseList(search,buyer_id);  
		
		Page resultPage =
				new Page(currentPage,((Integer)map.get("totalCount")).intValue(),pageUnit,pageSize) ;
		
		request.setAttribute("buyer_id", buyer_id);
		request.setAttribute("list", map.get("list"));

		//	request.setAttribute("map", map);
		request.setAttribute("search", search);
		request.setAttribute("resultPage", resultPage);
		
System.out.println(" List PurchaseAction 끝 ");
	return "forward:/purchase/ListPurchase.jsp" ;   

	}

	}
