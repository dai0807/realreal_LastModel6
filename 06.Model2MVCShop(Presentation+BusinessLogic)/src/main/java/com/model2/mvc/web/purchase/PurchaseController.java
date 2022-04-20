package com.model2.mvc.web.purchase;

import java.util.Map;

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

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PuchaseDaoImpl;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
 
//���Ű��� ��Ʋ���� 
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
 
			String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 
		
 			
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
	
	@RequestMapping("/addPurchase.do") // ���� ���� ���� ���� ���� �Ҳ� ���� �ϳİ��� ,,,, 
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

	@RequestMapping("/listPurchase.do") // ���� ���� ���� ���� ���� �Ҳ� ���� �ϳİ��� ,,,, 
	public ModelAndView listPurchase(@ModelAttribute("search") Search search  ,HttpServletRequest request ,   HttpSession session ) throws Exception {
 //  ����Ʈ �ϱ� 

		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		System.out.println("search ������ "+search);
		// Business logic ����
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 
		System.out.println("buyer_id :: " + buyer_id );
		search.setSearchCondition(" ") ;
		search.setSearchKeyword(buyer_id) ;

	 Map<String , Object> map=purchaseService.getPurchaseList(search);
		
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
 
		
		ModelAndView modelAndView = new ModelAndView() ;
		modelAndView.addObject("buyer_id", buyer_id) ; 
		modelAndView.addObject("search", search) ; 
		modelAndView.addObject("list",  map.get("list")) ; 
		modelAndView.addObject("resultPage", resultPage) ; 
 		modelAndView.setViewName("/purchase/ListPurchase.jsp") ;
 		
 		
		return modelAndView;
	}	
	
	@RequestMapping("/getPurchase.do")
	public ModelAndView listPurchase(@RequestParam("tranNo" ) int tranNo , HttpServletRequest request ,  HttpSession session ) throws Exception 
	{
		
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 
		System.out.println("buyer_id :: " + buyer_id );
		System.out.println("getPurchase TranNO " + tranNo);
		 Purchase purchase = purchaseService.getPurchase(tranNo) ;
		System.out.println(purchase);
		
		ModelAndView modelAndView = new ModelAndView() ;

		modelAndView.addObject("buyer_id", buyer_id) ; 
		modelAndView.addObject("purchase", purchase) ; 
 		modelAndView.setViewName("/purchase/getPurchaseView.jsp") ;

		return modelAndView;
		
	}
	@RequestMapping("/updatePurchaseView.do")
	public ModelAndView updatePurchaseView(@RequestParam("tranNo" ) int tranNo  , HttpServletRequest request ,  HttpSession session    ) throws Exception 
	{
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 

		System.out.println("UpdatePurchaseViewAction View�� ");
		System.out.println("tranNo  �� " +  tranNo );

		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		System.out.println(purchase);

		
		
		ModelAndView modelAndView = new ModelAndView() ;
		modelAndView.addObject("buyer_id", buyer_id) ; 
		modelAndView.addObject("purchase", purchase) ; 
		
		
		
		//  ������Ʈ �� ���� �� ,  �ͼ� VIw���� ������ Ȯ�� �ϱ�!! 
		
		
		
 		modelAndView.setViewName("/purchase/updatePurchaseView.jsp") ;
 		return modelAndView;
		
	}
	
	
	@RequestMapping("/updatePurchase.do")  // ������ �ޱ� 
	public ModelAndView updatePurchase(@RequestParam("tranNo") int tranNo,@ModelAttribute("purchase") Purchase purchase, HttpServletRequest request ,  HttpSession session ) throws Exception 
	{
		System.out.println("updatePurchase ::  "  + purchase );
		String buyer_id =((User)request.getSession(true).getAttribute("user")).getUserId(); //���� ���̵� �̱� 

		System.out.println("updatePurchase�� ");
		ModelAndView modelAndView = new ModelAndView() ;
		purchaseService.updatePurchase(purchase) ; 
		
		
		System.out.println("update ��! ");
		
 		modelAndView.setViewName("/getPurchase.do?tranNo"+tranNo) ;
 		return modelAndView;
		
	}
	
	@RequestMapping("/updateTranCode.do")  // ������ �ޱ� 
	public ModelAndView updateTranCode(@ModelAttribute("search") Search search  , @RequestParam("tranNo") int tranNo  , @RequestParam("tranCode") String tranCode ,@RequestParam("currentPage") int  intcurrentPage ) throws Exception 
	{
		System.out.println("updatePurchase�� ");

		System.out.println("updateTranCode :: tranNo ::  "  + tranNo  + " tranc Code :: " + tranCode );
 
		
		Purchase purchase = purchaseService.getPurchase(tranNo);		
		System.out.println("tranNo���� ��  " + purchase  );
		purchase.setTranCode(tranCode)  ; 
		System.out.println(   "purchase ::: "+  purchase.getTranCode()     );    
		//purchase.setTranCode(tranCode); // Ʈ�� �ڵ� ����
		System.out.println("����");
		purchaseService.updateTranCode(purchase) ;
		
		System.out.println("����!"  );

		purchase = purchaseService.getPurchase(tranNo);		
		System.out.println("tranNo������   " + purchase  );
		
		ModelAndView modelAndView = new ModelAndView() ;
 		
		System.out.println(intcurrentPage);
		
		System.out.println("update ��! ");
		modelAndView.addObject("search", search) ; 

 		modelAndView.setViewName("/listPurchase.do?") ;
 		return modelAndView;
		
	}
	 
	
	
}
