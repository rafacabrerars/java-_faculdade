<!DOCTYPE html>
<html>
    <head>
        <title>Template</title>
        <%@include file="_header.jsp" %>
    </head>
    <body class="w3-black">
        <%-- MENU --%>
        <%@include file="_menu.jsp" %>
        <%-- CONTEÚDO --%>
        <div class="w3-padding-large" id="main">
            <%@include file="_perfil.jsp" %>
            <%@include file="_sobre.jsp" %>
            <%if (session.getAttribute("login") != null) {%>
            <%@include file="_planos.jsp" %>
            <%}%>
            <%@include file="_portfolio.jsp" %>
            <%@include file="_contato.jsp" %>
            <%@include file="_rodape.jsp" %>
        </div>
    </body>
</html>
