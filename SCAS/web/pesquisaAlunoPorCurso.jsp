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
                <td>Curso do Aluno:
                    <form action="RelatorioAlunosPorCursoController" method="post">
                    <select name="optCurso">
                        <option value="0" <c:if test="${aluno.codCurso == null}"> selected</c:if>> </option>  
                        <c:forEach items="${cursos}" var="curso">
                            <option value="${curso.codCurso}" <c:if test="${aluno.codCurso == curso.codCurso}"> selected</c:if>>${curso.nome}</option>  
                        </c:forEach>
                    </select>
                    <input type="submit" name="" value="Gerar Relatório Aluno por Curso"/>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
