package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class AddProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Product prod = new Product(); 
		
		prod.setProdName(request.getParameter("prodName")); // ��ǰ�� 
		prod.setProdDetail(request.getParameter("prodDetail"));  // ��ǰ�� 
		prod.setManuDate(request.getParameter("manuDate").replaceAll("-", ""));  // ��������
		prod.setPrice(Integer.parseInt(request.getParameter("price"))); // ����
		prod.setFileName(request.getParameter("fileName"));  // ��ǰ�̹���

		
 
		
		ProductService service = new ProductServiceImpl() ; 
		service.addProduct(prod) ;
		request.setAttribute("Product", prod); 
		// ������Ʈ�� �� �÷� ������ �ٷ� �����ϴ�! ����� �ٺ� �Դϴ�! 
		System.out.println(prod);

		

	
		return "forward:/product/addgetProduct.jsp"; // ���ιٷ� ������
	}

}
