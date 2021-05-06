package br.com.projetogestao.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.repository.Repositorio;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario)session.getAttribute("session_usuario");
		
		if (usuario != null) {
			//session.invalidate(); //tira todos os elementos da seção
			session.removeAttribute("session_usuario");
		}
		
		response.sendRedirect(request.getContextPath() +  "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String senha = request.getParameter("txtSenha");
			
			Usuario usuario = Repositorio.getUsuariosDao().validar(nome, senha);
			
			if (usuario == null) {
				request.setAttribute("resultado", "Usuário ou Senha inválidos!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				//variável de sessão: usada para armazenar dados a serem consumidos em requisições futuras
				// passa a ser statfull
				HttpSession session = request.getSession();
				
				session.setAttribute("session_usuario", usuario);
				
				String contexto = request.getContextPath();
				response.sendRedirect(contexto + "/admin/cadastro");
			}
			
		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);			
		}
	}

}
