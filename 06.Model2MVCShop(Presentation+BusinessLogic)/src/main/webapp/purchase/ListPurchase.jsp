<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--�����ϴ� �� �� --%>
    <%-- 
      <%@ page import="com.model2.mvc.service.domain.Purchase" %>
       
    <%@ page import="com.model2.mvc.service.domain.*" %>
   <%@ page import="java.util.*"  %>  
    <%@ page import="com.model2.mvc.common.*" %>

    <%
	Map<String,Object> map=(Map<String,Object>)request.getAttribute("map");
    List<Purchase> list=(List<Purchase>) map.get("list");

	Search search=(Search)request.getAttribute("search");
	Page resultPage=(Page)request.getAttribute("resultPage");
	int currentPage=search.getCurrentPage();
	String buyer_id = (String)request.getAttribute("buyer_id") ; 
	
%>
--%>

<script type="text/javascript">
 <%-- �ڹ� ��ũ��Ʈ �ʹ� �Ƚ��ϴ�. ����� ������ �� �̷� �÷��� �ֽô� ���� ����
Ŀ��Ʈ ������ ������ , Ŀ��Ʈ ������ id�� ���� �±׿� ���� id�� "currentPage"�� value���� ���� 


  --%>


 function fncGetList(currentPage){
	document.getElementById("currentPage").value = currentPage;
	document.detailForm.submit();
}
 </script>
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


<!--
function fncGetProductList(currentPage){
	document.getElementById("currentPage").value = currentPage;
	document.detailForm.submit();
}
-->
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listPurchase.do" method="post">
 
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
		<td width="15" height="37"><img src="/images/ct_ttl_img03.gif"	width="15" height="37"></td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
	<td align="right">
		<tr>
			<td colspan="12" >
			��ü  ${resultPage.totalCount } �Ǽ�, ���� ${resultPage.currentPage}  ������
	</tr>	
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="100">ȸ��ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��ǰ�̸�</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��ȭ��ȣ</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����Ȳ</td>	
		<td class="ct_line02"></td>
	<!-- 	<td class="ct_list_b">��������</td>	
		<td class="ct_line02"></td>		 -->
	</tr>
		<tr>
		<td colspan="12" bgcolor="808285" height="1"></td>
	</tr>
		
	<tr>
		<td colspan="12" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	<%--
 
 
		int no=list.size();
		for(int i=0; i<list.size(); i++) {
          Purchase purchase = (Purchase)list.get(i) ;
		 --%>
		 
	 	 <c:set var="i" value="0" /> <!-- �� ���� --> 
		 <c:forEach var="Puchase" items="${list}">
				<c:set var="i" value="${ i+1 }" />
			 	<tr class="ct_list_pop">
			<td align="center" >
					<a href="/getPurchase.do?tranNo=${Puchase.tranNo}">  ${i }</a></td>
 
			<td></td>
			 <td align="left"> <a href="/getUser.do?userId=${buyer_id}">${buyer_id} </a> </td>
	 			
			
			<td></td>
			<td align="left">${Puchase.receiverName }      </td>
 			<td></td>
			<td align="left">${Puchase.purchaseProd.prodName }      </td>
			<td></td>
			<td align="left"> ${Puchase.receiverPhone}   </td>
			<td></td>
			 <td align="left"> 
			 
			 <c:if test="${Puchase.tranCode eq '002'}">
			 	 ���ſϷ� �����Դϴ�. 
			 
			 </c:if>
			   <c:if test="${Puchase.tranCode eq '003'}">
			 	 ����߻����Դϴ�. 
			 	  <a href="/updateTranCode.do?currentPage=${resultPage.currentPage }&tranNo=${Puchase.tranNo }&tranCode=004">��ǰ����</a> 
			 
			 </c:if>
	 			   <c:if test="${Puchase.tranCode eq '004'}">
					��ۿϷ� 
	 			 </c:if>
	 
	 
		 
		 
			 </td>
			 	
			 <td align="left"></td>
			<td></td>		
			 <td align="left"> </td>
			<td></td>	
		</tr>
		<tr>
			<td colspan="12" bgcolor="D6D7D6" height="1"></td>
		</tr>
  </c:forEach>		
  
	
		
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
					
 
			<%	for(int i=resultPage.getBeginUnitPage();i<= resultPage.getEndUnitPage() ;i++){	%>
				
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