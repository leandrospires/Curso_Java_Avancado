package br.com.projetoconceito.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login Servlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("login.jsp");
		request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String usuario = request.getParameter("txtUsuario");
			String senha = request.getParameter("txtSenha");
			
			if ( usuario.equals("admin") && (senha.equals("admin")) ) {

				//response.sendRedirect("resultado.jsp");
				request.setAttribute("mensagem", "Usuário Autenticado!");
				
			} else {
				//throw new Exception();
				request.setAttribute("mensagem", "Erro de autenticação.");
			}
			
		}catch (Exception e) {
			//response.sendRedirect("erro.jsp");
			throw e;
		} finally {
			
			request.getRequestDispatcher("/WEB-INF/admin/resultado.jsp").forward(request, response);
			
		}


	}

}
