ss<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
      <%@ page import="com.model2.mvc.service.domain.Purchase" %>
    <%@ page import="com.model2.mvc.service.domain.*" %>
   <%@ page import="java.util.*"  %>  
    <%@ page import="com.model2.mvc.common.*" %>
    
    
    
    
	Map<String,Object> map=(Map<String,Object>)request.getAttribute("map");
    List<Purchase> list=(List<Purchase>) map.get("list");

	Search search=(Search)request.getAttribute("search");
	Page resultPage=(Page)request.getAttribute("resultPage");
	int currentPage=search.getCurrentPage();
 	
--%>
    
  
 
 
<!DOCTYPE html>
<html>
<head>
 
<title>���� �����ȸ </title>
 


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

<form name="detailForm" action="/listSale.do" method="post">
 
<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">���� �����ȸ</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
	<td align="right">
		<tr>
			<td colspan="11" >��ü  
			��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
	</tr>	
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ��ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ ��ȣ </td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ �̸� </td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��ȭ��ȣ</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����Ȳ</td>	
		<td class="ct_line02"></td>
 	
	</tr>
		<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
		
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	
	 <c:set var="i" value="0" /> <!-- �� ���� --> 
 	 
	 <c:forEach var="purchase" items="${list}">
			<c:set var="i" value="${ i+1 }" />
							<%--
					 int no=list.size();
							for(int i=0; i<list.size(); i++) {
					          Purchase purchase = (Purchase)list.get(i) ;
							 --%>
			 <tr class="ct_list_pop">
			<td align="center" > ${i+1}</td>
 		 
 	 			
			<td></td>
					<td align="left">
						<a href="/getPurchase.do?tranNo=${purchase.tranNo}">  ${purchase.buyer.userId} </a></td>
			<td></td>
				 	<td align="left"> ${purchase.purchaseProd.prodNo }    </td>
			 <td></td>
 			 
						<td align="left"> ${purchase.purchaseProd.prodName }  </td>
			 <td></td>
			
						<td align="left"> ${purchase.receiverPhone}  </td>
			<td></td>
		
				 	<c:if test = "${ purchase.tranCode eq'000'}">
							<td align="left">  ���Ű��� &nbsp; &nbsp; </td>
		 				
					</c:if>		 			
					 <c:if test = "${ purchase.tranCode eq'002'}">
							<td align="left"> ���ſϷ� &nbsp; &nbsp; </td>
		 				
					</c:if>
					<c:if test ="${ purchase.tranCode eq'003'}">
					 	<td align="left"> 	����� &nbsp; &nbsp; </td>
		 				
					</c:if>
					<c:if test ="${ purchase.tranCode eq'004'}">
					 	<td align="left"> 	��ۿϷ� &nbsp; &nbsp; </td>
		 				
					</c:if>  
	 
			<td></td>	
		</tr>
		<tr>
			<td colspan="11" bgcolor="D6D7D6" height="1"></td>
		</tr>
</c:forEach>		
 

 			<%-- 
						<td align="left"> <a href="/getPurchase.do?tranNo=<%=purchase.getTranNo()%>"> <%=purchase.getReceiverName()%>    </td>
						<td></td>
						
						<td align="left">  <%=purchase.getBuyer().getUserId()%>   </td>
						<td></td>
						
						<td align="left"> <%=purchase.getPurchaseProd().getProdName() %>  </td>
						<td></td>
						<td align="left"> <%=purchase.getReceiverPhone()%>  </td>
						<td></td>
						 <td align="left"> 
						 <% if(purchase.getTranCode().equals("002")){%>
									���ſϷ� �����Դϴ�. 
							<%}else if(purchase.getTranCode().equals("003")){%>
										����߻����Դϴ�.
			 							
										
							<% }else if(purchase.getTranCode().equals("004")){%>
										��ۿϷ�
									<%} %>
			
					 
						 </td>
			 	--%>

	
		
		<td align="right" width="70">
		
		</td>
	 
</table>

 
 

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
		   		<jsp:include page="../common/pageNavigator.jsp"/>	
		   
		   <%--
			<% if( resultPage.getCurrentPage() <= resultPage.getPageUnit() ){ %>
					�� ����
			<% }else{ %>
					<a href="javascript:fncGetProductList('<%=resultPage.getCurrentPage()-1%>')">�� ����</a>
			<% } %>
					
 
			<%	for(int i=resultPage.getBseginUnitPage();i<= resultPage.getEndUnitPage() ;i++){	%>
				
			 	<a href="javascript:fncGetProductList('<%=i %>');"><%=i %></a> 



			<% 	}  %> 
			
	 
	
			<% if( resultPage.getEndUnitPage() >= resultPage.getMaxPage() ){ %>
					���� ��
			<% }else{ %>
					<a href="javascript:fncGetProductList('<%=resultPage.getEndUnitPage()+1%>')">���� ��</a>
			<% } %>
 --%>		
    	</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>