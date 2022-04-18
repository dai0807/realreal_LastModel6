package com.model2.mvc.view.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
 

public class ListProductAction extends Action {
// listProduct.do �� �ϸ� ����� ��  , ���ư��� �� ���� 
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Search search=new Search();
		
		
		int currentPage=1;
		System.out.println("List producAction ���⿡ �Գ��� ");
		System.out.println("request.getParameter(\"currentPage\") :: "+ request.getParameter("currentPage"));



			
		if(request.getParameter("currentPage") != null   ) {
		
	 
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("request.getParameter(\"currentPage\") :: " +currentPage );

		}
	
		search.setCurrentPage(currentPage);
		search.setSearchCondition(request.getParameter("searchCondition"));
		search.setSearchKeyword(request.getParameter("searchKeyword"));

		// web.xml meta-data�κ��� ��� ����

		int pageSize =Integer.parseInt(getServletContext().getInitParameter("pageSize"));
		int pageUnit = Integer.parseInt(getServletContext().getInitParameter("pageUnit")) ;
		search.setPageSize(pageSize);
		
	//	�����Ͻ� ���� 
		ProductService service = new ProductServiceImpl() ; 

		Map<String,Object> map=service.getProductList(search);  
		Page resultPage =
				new Page(currentPage,((Integer)map.get("totalCount")).intValue(),pageUnit,pageSize) ; 
		
		
		 // view �� ������
	//	request.setAttribute("map", map);
		request.setAttribute("list", map.get("list"));

		request.setAttribute("search", search);
		request.setAttribute("resultPage", resultPage);
		request.setAttribute("menu", request.getParameter("menu"));

	//	search.setSearchCondition("condition");
	//	search.setSearchKeyword("keyword");
		
		return "forward:/product/listProduct.jsp";
	//	return "forward:/product/listProduct_test.jsp";
	//	return  null ;
	

}
}
