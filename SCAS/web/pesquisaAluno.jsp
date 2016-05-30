<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Alunos</title>
    </head>
    <body>
        <h1>Pesquisa de Alunos</h1>
        <table border="1">
            <tr>
                <th>Código Aluno</th>
                <th>Nome Aluno</th>
                <th>Curso Aluno</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${alunos}" var="aluno">
                <tr>
                    <td><c:out value="${aluno.matricula}"/></td>
                    <td><c:out value="${aluno.usuario.nome}"/></td>
                    <td><c:out value="${aluno.curso.nome}"/></td>
                    <td>
                        <a href="ManterAlunoController?acao=prepararEditar&codAluno=<c:out value="${aluno.matricula}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="ManterAlunoController?acao=prepararExcluir&codAluno=<c:out value="${aluno.matricula}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAlunoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>
