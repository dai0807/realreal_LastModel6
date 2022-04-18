package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		Product prod = new Product(); 
		prod.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		prod.setProdName(request.getParameter("prodName")); // ��ǰ�� 
		String proD = request.getParameter("prodName") ;
		System.out.println("��ǰ���� �� : " + proD);

		prod.setProdDetail(request.getParameter("prodDetail"));  // ��ǰ�� 
		prod.setManuDate(request.getParameter("manuDate").replaceAll("-", ""));  // ��������
		System.out.println("price 1: "+request.getParameter("price"));
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("price : " + price);
		prod.setPrice(price); // ����

		
		
		//	prod.setPrice(Integer.parseInt(request.getParameter("price").trim())); // ����
		prod.setFileName(request.getParameter("fileName"));  // ��ǰ�̹���

		
		
		ProductService service = new ProductServiceImpl() ; 
		service.updateProduct(prod) ;
		request.setAttribute("Product", prod); 
		
		
		//��F�� 
		
		
		//return  "redirect:/getProduct.do?prodNo="+request.getParameter("prodNo") ;  
		return  "forward:/getProduct.do?prodNo="+request.getParameter("prodNo") ;  

	}

}
