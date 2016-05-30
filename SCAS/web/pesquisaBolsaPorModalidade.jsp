<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr> 
                <td>Bolsa por Modalidade:
                    <form action="RelatorioBolsasPorModalidadeController" method="post">
                    <select name="optModalidade">
                        <option value="0" <c:if test="${bolsa.formulario.selecao.codModalidade == null}"> selected</c:if>> </option>  
                        <c:forEach items="${modalidades}" var="modalidade">
                            <option value="${modalidade.codModalidade}" <c:if test="${bolsa.formulario.selecao.codModalidade == modalidade.codModalidade}"> selected</c:if>>${modalidade.nome}</option>  
                        </c:forEach>
                    </select>
                    <input type="submit" name="" value="Gerar Relatório Bolsa por Modalidade"/>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
