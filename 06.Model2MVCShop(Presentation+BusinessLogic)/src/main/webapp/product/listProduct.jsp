<%@page import="java.awt.PageAttributes.OrientationRequestedType"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%-- 
	List<Product> list= (List<Product>)request.getAttribute("list");

	Map<String,Object> map=(Map<String,Object>)request.getAttribute("map");
	Search search=(Search)request.getAttribute("search");
	Page resultPage=(Page)request.getAttribute("resultPage");
	int currentPage=search.getCurrentPage();

	System.out.println("list Product.jsp�� currentPage   :"+ currentPage) ;

	String menu = request.getParameter("menu");
	if(menu == null){
		menu =(String)request.getAttribute("menu");
	}
	 String searchKeyword =CommonUtil.null2str(search.getSearchKeyword());
	 String searchCondition =CommonUtil.null2str(search.getSearchCondition()) ;

--%>  
    
    
<!DOCTYPE html>
<html>
<head>
 	
 
<c:if test="${menu=='search'}">
	<title>��ǰ �˻�</title>
</c:if>
<c:if test="${menu=='manage'}">
	<title>��ǰ ����</title>
</c:if>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
// �˻� / page �ΰ��� ��� ��� Form ������ ���� JavaScrpt �̿�  
<%-- �ڹ� ��ũ��Ʈ �ʹ� �Ƚ��ϴ�. ����� ������ �� �̷� �÷��� �ֽô� ���� ����
Ŀ��Ʈ ������ ������ , Ŀ��Ʈ ������ id�� ���� �±׿� ���� id�� "currentPage"�� value���� ���� 
  --%>
function fncGetList(currentPage){
	document.getElementById("currentPage").value = currentPage;
	document.detailForm.submit();
}
</script>
</head>
<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=${menu}" method="post">
<!-- menu�� manage�� ����  -->

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					
					
					  <c:if test="${menu=='search'}">
						  	 ��ǰ �˻�
						  </c:if>
						<c:if test="${menu=='manage'}">
						  ��ǰ ���� 
						  </c:if>
						 
		 
					
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
	<td align="right">
				<select name="searchCondition"    class="ct_input_g" style="width:80px">
			 
				<option value="0" ${ ! empty search.searchCondition && search.searchCondition =="0" ? "selected" : ""} > ��ǰ��ȣ</option>
				<option value="1" ${ ! empty search.searchCondition && search.searchCondition =="1" ? "selected" : ""} > ��ǰ��</option>
				<option value="2" ${ ! empty search.searchCondition && search.searchCondition =="2" ? "selected" : ""} > ��ǰ����</option>
		 
			
			
			
				</select>
		<input type="text" name="searchKeyword" value="${search.searchKeyword}"  class="ct_input_g" style="width:200px; height:19px" />
				
				
				
	</td>	
		
		
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetList('1');">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
			<td colspan="11" >
	
	<%--	<td colspan="11" >��ü  <%= total%> �Ǽ�, ���� <%=currentPage %> ������</td> --%>
			��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
		
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����</td>	
		<td class="ct_line02"></td>
		 <c:if test="${menu eq 'manage'}"> <!--�Ť����϶� ���� ���̰� �ϱ�   -->
		
				<td class="ct_list_b">�������</td>	
		</c:if>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
		
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	

	
	 <c:set var="i" value="0" /> <!-- �� ���� --> 
	 <c:forEach var="product" items="${list}">
			<c:set var="i" value="${ i+1 }" />
	
	<!--  System.out.println("list :::: "+list);
		int no=list.size();
		for(int i=0; i<list.size(); i++) {
			Product pv = (Product)list.get(i);
		
		-->
	<tr class="ct_list_pop">
		<td align="center">${i}</td>
		<td></td>
				<td align="left">
				
						
				<a href="${ menu == 'search' ? '/getProduct.do' : '/updateProductView.do'}?prodNo=${product.prodNo }&menu=${ menu }&tranCode=${product.proTranCode}">
							${ product.prodName }</a>
				</td>
		
		<td></td>
		<td align="left">${product.price}</td>
		<td></td>
		<td align="left">${product.regDate}	</td>
		<td></td>	
			
		  <c:if test="${menu eq 'manage'}"> <!--�Ť����϶� ���� ���̰� �ϱ�   -->
			 	<td align="left">
 				 		
				<c:if test = "${product.proTranCode eq'002'}">
				���ſϷ� &nbsp; &nbsp; 
						<a href="/updateProdcutTranCodeByProd.do?currentPage=${resultPage.currentPage}&prodNo=${product.prodNo}&tranCode=003&menu=manage">����ϱ� </a>
				
				</c:if>
				<c:if test = "${ product.proTranCode eq '003'}">
				 	����� &nbsp; &nbsp; 
	 				
				</c:if>
				<c:if test ="${ product.proTranCode eq '004'}">
				 	��ۿϷ� &nbsp; &nbsp; 
	 				
					</c:if>   


			</c:if>

		<td></td>		
	</tr>
	<tr>
	
</c:forEach>		
		
		
		
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>

	
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
	<%-- /////////////////////// EL / JSTL �������� �ּ� ó�� //////////////////////// 		   
	<% if( resultPage.getCurrentPage() <= resultPage.getPageUnit() ){ %>
			�� ����
	<% }else{ %>
			<a href="javascript:fncGetUserList('<%=resultPage.getCurrentPage()-1%>')">�� ����</a>
	<% } %>

	<%	for(int i=resultPage.getBeginUnitPage();i<= resultPage.getEndUnitPage() ;i++){	%>
			<a href="javascript:fncGetUserList('<%=i %>');"><%=i %></a>
	<% 	}  %>
	
	<% if( resultPage.getEndUnitPage() >= resultPage.getMaxPage() ){ %>
			���� ��
	<% }else{ %>
			<a href="javascript:fncGetUserList('<%=resultPage.getEndUnitPage()+1%>')">���� ��</a>
	<% } %>
	 /////////////////////// EL / JSTL �������� �ּ� ó�� //////////////////////// --%>
	
		<jsp:include page="../common/pageNavigator.jsp"/>	
			
    	</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>