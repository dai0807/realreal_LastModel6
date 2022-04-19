package com.model2.mvc.web.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
 
//±¸¸Å°ü¸® ÄÁÆ²¤©·¯ 
@Controller
public class PurchaseController {

	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService ;

	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
//	
//	
	public   PurchaseController (){
		System.out.println(this.getClass());
	}
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	
	@RequestMapping("/addPurchaseView.do")
	public ModelAndView  addPurchaseView(@RequestParam("prodNo") int prodNo  , HttpSession session, HttpServletRequest request) throws Exception {
	
		System.out.println("addPurchaseView ::: "  +prodNo );
		
	//	ProductService service = new ProductServiceImpl() ; 
		 Product product =  productService.getProduct(prodNo);
 
			String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //À¯Àú ¾ÆÀÌµð »Ì±â 
		
 			
	 	User pubchaseUser=userService.getUser(buyer_id);
			
			System.out.println("user::::"+ buyer_id);
			System.out.println("product :::" + product);
		 
		

		ModelAndView modelAndView = new ModelAndView() ;
		modelAndView.addObject("buyer_id" ,buyer_id);
		modelAndView.addObject("product" ,product);
		modelAndView.addObject("User" ,pubchaseUser);

		modelAndView.setViewName("/purchase/addPurchaseView.jsp") ;
		
		return modelAndView;
	}
	
	@RequestMapping("/addPurchase.do") // ¾ÆÁÖ ÆãÆã ÅÍÁü ÁøÀÚ ÆãÆã ºÒ²É ³îÀÌ ÇÏ³Ä°í¿ä ,,,, 
	public ModelAndView addPurchase(@ModelAttribute("purchase") Purchase purchase , @RequestParam("buyerId") String buyerId ,  @RequestParam("prodNo") int prodNo ) throws Exception {
		System.out.println("adddPrucase Action " + purchase );
		System.out.println("adddPrucase buyerId " + buyerId );
		System.out.println("adddPrucase prodNo " + prodNo );
		
		User user  = new User() ;
		user.setUserId(buyerId); 
 		purchase.setBuyer(user) ;
 		
 		Product product =new Product() ;
 		product.setProdNo(prodNo) ;
 		purchase.setPurchaseProd(product) ;

		purchaseService.addPurchase(purchase);

		
		
		ModelAndView modelAndView = new ModelAndView() ;
		modelAndView.addObject("purchase" , purchase) ;
		modelAndView.setViewName("/purchase/receiptView.jsp") ;
		return modelAndView;
	}

	@RequestMapping("/listPurchase.do") // ¾ÆÁÖ ÆãÆã ÅÍÁü ÁøÀÚ ÆãÆã ºÒ²É ³îÀÌ ÇÏ³Ä°í¿ä ,,,, 
	public ModelAndView listPurchase(@ModelAttribute("purchase") Purchase purchase , @RequestParam("buyerId") String buyerId ,  @RequestParam("prodNo") int prodNo ) throws Exception {
 //  ¸®½ºÆ® ÇÏ±â 
		
		ModelAndView modelAndView = new ModelAndView() ;

 		modelAndView.setViewName("/purchase/ListPurchase.jsp") ;
 		
 		
		return modelAndView;
	}	
	
}
