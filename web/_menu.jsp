<!-- Icon Bar (Sidebar - hidden on small screens) -->
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
    <!-- Avatar image in top left corner -->
    <% if (session.getAttribute("login") == null) {%>
    <a href="_login.jsp">
        <img src="w3images/avatar.jpg" style="width:100%" alt="Clique aqui para se autenticar">
        <%=  (request.getParameter("erro") != null) ? "<br>Login Inválido!" : ""%>
    </a>
    <% } else {
        String login = session.getAttribute("login").toString();
    %>
    <a href="ServletLogin?acao=logout">
        <img src="w3images/<%=login%>.jpg" style="width:100%" alt="<%=login%> - Clique para logout" >
    </a>    
    <% }%>
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-black">
        <i class="fa fa-home w3-xxlarge"></i>
        <p>HOME</p>
    </a>
    <a href="#about" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-user w3-xxlarge"></i>
        <p>SOBRE</p>
    </a>
    <%
        if (session.getAttribute("login") != null) {
    %>
    <a href="#planos" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-money w3-xxlarge"></i>
        <p>PLANOS</p>
    </a>
    <%}%>
    <a href="#photos" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-eye w3-xxlarge"></i>
        <p>FOTOS</p>
    </a>
    <a href="#contact" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-envelope w3-xxlarge"></i>
        <p>CONTATO</p>
    </a>
</nav>

<!-- Navbar on small screens (Hidden on medium and large screens) -->
<div class="w3-top w3-hide-large w3-hide-medium" id="myNavbar">
    <div class="w3-bar w3-black w3-opacity w3-hover-opacity-off w3-center w3-small">
        <a href="#" class="w3-bar-item w3-button" style="width:25% !important">HOME</a>
        <a href="#about" class="w3-bar-item w3-button" style="width:25% !important">SOBRE</a>
        <%
            if (session.getAttribute("login") != null) {
        %>
        <a href="#planos" class="w3-bar-item w3-button" style="width:25% !important">PLANOS</a>
        <%}%>
        <a href="#photos" class="w3-bar-item w3-button" style="width:25% !important">FOTOS</a>
        <a href="#contact" class="w3-bar-item w3-button" style="width:25% !important">CONTATO</a>
    </div>
</div>
