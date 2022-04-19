package com.model2.mvc.view.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseSerivce;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class ListSaleAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	Search search=new Search();
		
		
		int currentPage=1;
		System.out.println("SaleList 여기에 왔나요 ");
		System.out.println("request.getParameter(\"currentPage\") :: "+ request.getParameter("currentPage"));


		
		if(request.getParameter("currentPage") != null   ) {
		
	 
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("request.getParameter(\"currentPage\") :: " +currentPage );

		}
	
		search.setCurrentPage(currentPage);
		search.setSearchCondition(request.getParameter("searchCondition"));
		search.setSearchKeyword(request.getParameter("searchKeyword"));

		// web.xml meta-data로부터 상수 추출

		int pageSize =Integer.parseInt(getServletContext().getInitParameter("pageSize"));
		int pageUnit = Integer.parseInt(getServletContext().getInitParameter("pageUnit")) ;
		search.setPageSize(pageSize);
		
	//	비지니스 로직 
		PurchaseSerivce purchaseSerivce = new PurchaseServiceImpl() ;

		Map<String,Object> map=purchaseSerivce.getSaleList(search);  
		Page resultPage =
				new Page(currentPage,((Integer)map.get("totalCount")).intValue(),pageUnit,pageSize) ; 
		
		
		 // view 로 보내기
		request.setAttribute("list", map.get("list"));
		request.setAttribute("search", search);
		request.setAttribute("resultPage", resultPage);
	//	request.setAttribute("menu", request.getParameter("menu"));
		System.out.println("SaleList 끄 ");
		
		
		
		return "forward:/purchase/listSaleView.jsp" ;  
	}
	

}
