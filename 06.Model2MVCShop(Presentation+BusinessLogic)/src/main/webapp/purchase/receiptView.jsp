<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
    
        <%@ page import="com.model2.mvc.service.domain.Purchase" %>
    <%@ page import="com.model2.mvc.service.domain.User" %>
    
    <%@ page import="com.model2.mvc.common.*" %>

<%
Purchase purchase = (Purchase)request.getAttribute("Purchase") ; 
 	System.out.println("receipte�� �Գ��� ");
	System.out.println("purchase  " + purchase );

  %>
  --%>
 <script type="text/javascript">
 
function fncGoListPurchase() {
	document.viewPurchase.submit();
}
 
</script>
<html>
<head>
<link rel="stylesheet" href="/css/admin.css" type="text/css">

<title>���� ���� </title>
 
</head>


<body>
���� ���� �Դϴ�. 

 <form name="viewPurchase" action="/listPurchase.do" method="post">
 
 

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	 

	<tr>
		<td width="104" class="ct_write">��ǰ��ȣ</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> ${purchase.purchaseProd.prodNo }
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">�����ھ��̵�</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> ${purchase.buyer.userId} </td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">���Ź��</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			 		<c:if test = "${purchase.paymentOption eq '1'}">
	 		
			 				���ݱ���
			 
					</c:if>
					<c:if test = "${ purchase.paymentOption eq '2'}">
							�ſ뱸��
			
					</c:if>

		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>	
	<tr>
		<td width="104" class="ct_write">������ �̸�</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> ${purchase.receiverName } </td>
	</tr>

	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">������ ����ó</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${purchase.receiverPhone} </td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
			
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">�������ּ�</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> ${purchase.dlvyAddr} </td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">���ſ�û����</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">  ${purchase.dlvyRequest}   </td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">��������</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> ${purchase.dlvyDate} </td>
	</tr>

	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>

	<tr>
		<td width="104" class="ct_write">�ֹ���</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"> 2022-04-13 </td>
	</tr>

	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	
</table>



<!--  
<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td>${purchase.purchaseProd.prodNo }  </td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td> ${purchase.buyer.userId}  </td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
				<td>
			<%-- -- <%=purchase.getPaymentOption().equals("1") ?"���ݱ���" :"�ſ뱸��" %> --%>	
 				
	 		<c:if test = "${purchase.paymentOption eq '1'}">
	 		
	 				���ݱ���
	 
			</c:if>
			<c:if test = "${ purchase.paymentOption eq '2'}">
					�ſ뱸��
	
			</c:if>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td>${purchase.receiverName }</td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td>${purchase.receiverPhone} </td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td> ${purchase.dlvyAddr}</td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td>${purchase.dlvyRequest} </td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td>${purchase.dlvyDate}</td>
		<td></td>
	</tr>
	 
 </table>
 -->
 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td width="53%"></td>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
						<a href="javascript:fncGoListPurchase();">���</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
					<td width="30"></td>
				 
			</table>
		</td>
	</tr>
</table>
</form>

</body>
</html>