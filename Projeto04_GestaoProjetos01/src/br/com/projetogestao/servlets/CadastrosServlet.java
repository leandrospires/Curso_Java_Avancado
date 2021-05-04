package br.com.projetogestao.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetogestao.enumerations.Niveis;
import br.com.projetogestao.interfaces.iDocumento;
import br.com.projetogestao.jdbc.UsuariosDao;
import br.com.projetogestao.models.Cliente;
import br.com.projetogestao.models.DocumentoCnpj;
import br.com.projetogestao.models.DocumentoCpf;
import br.com.projetogestao.models.Prestador;
import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.repository.Repositorio;
import br.com.projetogestao.utilities.Utils;

@WebServlet(
		urlPatterns = {
				"/admin/cadastro", 
				"/admin/listaClientes",
				"/admin/listaPrestadores",
				"/admin/excluir"
			})
public class CadastrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//System.out.println("getServletPath: " + request.getServletPath());

		if ( request.getServletPath().equals("/admin/cadastro") ) 
		{
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

						if (listaUsuarios.size() == 0) {
							throw new Exception("Não existem usuários com o nível esperado!");
						}

						request.setAttribute("usuarios", listaUsuarios);

						break;

					case "p":
						pagina += "cadPrestadores.jsp";

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

		} else if (request.getServletPath().equals("/admin/listaClientes") ) {
			
			try {
				
				request.setAttribute("listaClientes", Repositorio.getClientesDao().listar());
				request.getRequestDispatcher("/WEB-INF/admin/listaClientes.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				request.setAttribute("mensagemErro", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
				
			}
		} else if (request.getServletPath().equals("/admin/listaPrestadores") ){
			try {
				
				request.setAttribute("listaPrestadores", Repositorio.getPrestadoressDao().listar());
				request.getRequestDispatcher("/WEB-INF/admin/listaPrestadores.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				request.setAttribute("mensagemErro", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
				
			}
		} else if (request.getServletPath().equals("/admin/excluir") ){
			String opcao = request.getParameter("opcao");
			String id = request.getParameter("id");
			
			try {
				if (opcao != null) {
					switch (opcao) {
					case "c":
						excluirCliente(id, request, response);
						break;
					}
				}
			} catch (Exception e) {
				request.setAttribute("mensagemErro", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
			}
			
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
				
			case "p":
				incluirPrestador(request, response);
				break;

			}

		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}

	private void incluirUsuario(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

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
	
	private void excluirCliente(String id, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String idCliente = id;
		
		Repositorio.getClientesDao().excluir(idCliente);
		
		request.setAttribute("listaClientes", Repositorio.getClientesDao().listar());
		
		request.getRequestDispatcher("/WEB-INF/admin/listaClientes.jsp").forward(request, response);		
		
	}
	
	private void incluirCliente(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String telefone = request.getParameter("txtTelefone");
		String usuario = request.getParameter("cmbUsuario");
		
		Cliente cli = new Cliente();
		cli.setNome(nome);
		cli.setEmail(email);
		cli.setTelefone(telefone);
		cli.setUsuario(Repositorio.getUsuariosDao().buscar(usuario));
		
		Repositorio.getClientesDao().incluir(cli);
		
		request.setAttribute("listaClientes", Repositorio.getClientesDao().listar());
		
		request.getRequestDispatcher("/WEB-INF/admin/listaClientes.jsp").forward(request, response);
	}
	
	private void incluirPrestador(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		try {
			String tipoDoc = request.getParameter("optDoc");
			
			String documento = request.getParameter("txtDocumento");
			String usuario = request.getParameter("txtUsuario");
			String senha = request.getParameter("txtSenha");
			String nome = request.getParameter("txtnome");
			String email = request.getParameter("txtEmail");
			String telefone = request.getParameter("txtTelefone");
			
			Prestador pre = new Prestador();
			Usuario usu = new Usuario();
			
			iDocumento docCpf = new DocumentoCpf();
			iDocumento docCnpj = new DocumentoCnpj();

			if (tipoDoc == null) {
				request.setAttribute("mensagemErro", "Seleção do tipo de documento obrigatório!");
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
				return;
			} else if (tipoDoc.equals("optCpf")) {
				docCpf.setNumero(documento);
				pre.setDocumento(docCpf);
			} else if (tipoDoc.equals("optCnpj")) {
				docCnpj.setNumero(documento);
				pre.setDocumento(docCnpj);
			}
			
			usu.setNome(usuario);
			usu.setSenha(senha);
			usu.setNivel(Niveis.PREST);
			

			pre.setUsuario(usu);
			pre.setEmail(email);
			pre.setNome(nome);
			pre.setTelefone(telefone);
			
			
			Repositorio.getPrestadoressDao().setSenha(usu.getSenha());
			Repositorio.getPrestadoressDao().incluir(pre);
			
			request.setAttribute("listaPrestadores", Repositorio.getPrestadoressDao().listar());
			request.getRequestDispatcher("/WEB-INF/admin/listaPrestadores.jsp").forward(request, response);
			

		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}	
		
	}

}