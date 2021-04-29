package br.com.projetogestao.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetogestao.enumerations.Niveis;
import br.com.projetogestao.jdbc.UsuariosDao;
import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.repository.Repositorio;
import br.com.projetogestao.utilities.Utils;

@WebServlet("/admin/cadastro")
public class CadastrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcao = request.getParameter("opcao");

		try {

			String pagina = "/WEB-INF/admin/";
			Collection<Usuario> listaUsuarios;

			if (opcao != null) {
				switch (opcao) {
				case "u":
					pagina += "cadUsuarios.jsp";
					break;

				case "c":
					pagina += "cadClientes.jsp";
					listaUsuarios = Utils.listarUsuariosPorNivel(Niveis.CLIENTE); 
					
					if ( listaUsuarios.size() == 0 ) {
						throw new Exception("Não existem usuários com o nível esperado!");
					}

					request.setAttribute("usuarios",
							listaUsuarios);
					
					break;

				case "p":
					pagina += "cadPrestadores.jsp";
					listaUsuarios = Utils.listarUsuariosPorNivel(Niveis.PREST);
					
					if ( listaUsuarios.size() == 0 ) {
						throw new Exception("Não existem usuários com o nível esperado!");
					}

					request.setAttribute("usuarios",
							listaUsuarios);					
					
					break;
				default:
					throw new Exception("Opção inválida: " + opcao);
				}

				request.getRequestDispatcher(pagina).forward(request, response);

			} else {
				pagina += "home.jsp";
				request.getRequestDispatcher(pagina).forward(request, response);
				// throw new Exception("Recurso usado incorretamente!");
			}

		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String opcao = request.getParameter("opcao");

			switch (opcao) {
			case "u":
				incluirUsuario(request, response);
				break;
				
			case "c":
				incluirCliente(request, response);
				break;				

			}

		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}

	private void incluirUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("txtNome");
		String senha = request.getParameter("txtSenha");
		String nivel = request.getParameter("cmbNivel");

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setNivel(Utils.buscarNivel(nivel));

		UsuariosDao dao = Repositorio.getUsuariosDao();
		dao.incluir(usuario);

		request.setAttribute("resultado", "Usuário incluído com sucesso!");
		request.getRequestDispatcher("/WEB-INF/admin/cadUsuarios.jsp").forward(request, response);

	}
	
	private void incluirCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("resultado", "Cliente incluído com sucesso!");
		request.getRequestDispatcher("/WEB-INF/admin/cadClientes.jsp").forward(request, response);
	}

}
