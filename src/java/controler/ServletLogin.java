package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Por default chamarei a pagina index e passarei o parametro erro=1
        String pagina = "index.jsp?erro=1";

        // Nunca se coloca usuário e senha na classe java! (hardcode)
        // coloque em BD. Isso é só um exemplo.
        String oAcao = request.getParameter("acao");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (oAcao.equals("login")) {
            if ((login.equals("admin") && senha.equals("admin"))
                    || (login.equals("ela") && senha.equals("ela"))
                    || (login.equals("ele") && senha.equals("ele"))) {
                // Criar objeto para obter sessão do JSP:
                HttpSession sessao = request.getSession();
                // Setando um atributo da sessao:
                sessao.setAttribute("login", request.getParameter("login"));
                // Como obteve sucesso, chamar a página principal:
                pagina = "index.jsp";
            }
        } else if (oAcao.equals("logout")) {
            // No logout invalido a sessao:
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            // Chamar novamente a pagina principal:
            pagina = "index.jsp";
        }

        response.sendRedirect(pagina);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
