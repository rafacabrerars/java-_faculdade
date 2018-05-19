<script>

    function editar(id,descricao,categoria,especificacao,suporte,periodo,titulo,valor,status){
         $("#descricao").val(descricao);
         $("#categoria").val(categoria);
         $("#especificacao").val(descricao);
         $("#suporte").val(categoria);
         $("#periodo").val(periodo);
         $("#titulo").val(titulo);
         $("#valor").val(valor);
         $("#id").val(id);
         $("#status").val(status);
         
    }
    
</script>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="model.PlanoDAO"/>
<%
    if (session.getAttribute("login") != null) {
%>
<div class="w3-content w3-justify w3-text-grey w3-padding-64" id="planos">
    <!-- Grid for pricing tables -->
    <h3 class="w3-padding-16 w3-text-light-grey">Planos</h3>
    <div class="w3-row-padding" style="margin:0 -16px">

        <c:forEach var="plano" items="${dao.getAll()}">
            
                
            
            <c:if test = "${plano.status == 1}" >
                
            
            <div class="w3-half w3-margin-bottom">
                <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
                    <li class="w3-dark-grey w3-xlarge w3-padding-32">${plano.titulo}</li>
                    <li class="w3-padding-16">${plano.descricao}</li>
                    <li class="w3-padding-16">${plano.categoria}</li>
                    <li class="w3-padding-16">${plano.especificacao}</li>
                    <li class="w3-padding-16">${plano.suporte}</li>
                    <li class="w3-padding-16">
                        <h2>R$ ${plano.valor}</h2>
                        <span class="w3-opacity">${plano.periodo}</span>
                    </li>
                    <li class="w3-light-grey w3-padding-24">
                        <span class="w3-button w3-white w3-padding-large w3-hover-black">
                            <a href="comprar.jsp?${plano.id}">Comprar   </a>
                           <%
                             if (session.getAttribute("login").equals("admin")) {
                                
                            %> 
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"id='editar'  onclick="editar('${plano.id}','${plano.descricao}','${plano.categoria}','${plano.especificacao}','${plano.suporte}','${plano.periodo}','${plano.titulo}','${plano.valor}', '${plano.status}')">Editar</button>
                            <%}%>
                        </span>
                    </li>
                </ul>
            </div>
           </c:if>
        </c:forEach>
        <!-- End Grid/Pricing tables -->
    </div>
</div>
<%
    }
%>
<form action="ServletPlano" method="POST">
    
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
            <input type="hidden" name="valida" value="editar">
            <input type="hidden" name="id" id="id">
            <div class="row">
                <div class="col-md-6">
                    <label style="color:black">Descri��o</label>
                    <input type="text" name="descricao" id="descricao" class="form-control">
                </div>
                 <div class="col-md-6">
                    <label style="color:black">Categoria</label>
                    <input type="text" name="categoria" id="categoria" class="form-control">
                </div>
            </div>
             <div class="row">
                <div class="col-md-6">
                    <label style="color:black">Especificacao</label>
                    <input type="text" name="especificacao" id="especificacao" class="form-control">
                </div>
                 <div class="col-md-6">
                    <label style="color:black">Suporte</label>
                    <input type="text" name="suporte" id="suporte" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label style="color:black">Periodo</label>
                    <input type="text" name="periodo"  id="periodo" class="form-control">
                </div>
                 <div class="col-md-6">
                    <label style="color:black">Titulo</label>
                    <input type="text" name="titulo" id="titulo" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label style="color:black">valor</label>
                    <input type="text" name="valor"  id="valor" class="form-control">
                </div>
               <div class="col-md-6">
                    <label style="color:black">Status</label>
                    <select class="form-control" name="status" id="status">
                        <option></option>
                        <option value="1">Ativo</option>
                        <option value="0">Inativo</option>
                    </select>
                </div>
            </div>
              <div class="row">
                  <div class="col-md-5"></div>
                  <div class="col-md-5"></div>
                <div class="col-md-2">
                    <br>
                    <input type="submit" class="btn btn-default" value="Salvar">
                </div>
            </div>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</form>