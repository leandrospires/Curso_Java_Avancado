package br.com.projeto.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.classes.Funcionario;


@WebServlet(name = "Funcionario Servlet", urlPatterns = { "/employee" })
public class FuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/funcionario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String datanasc = request.getParameter("txtDataNasc");
			
			Date dataNasc = new SimpleDateFormat("yyy-MM-dd").parse(datanasc);
			
			String cargo = request.getParameter("txtCargo");
			
			double salario = Double.parseDouble(request.getParameter("txtSalario"));
			
			Funcionario funcionario = new Funcionario(nome, dataNasc, cargo, salario);
			
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getDataNascimento());
			System.out.println(funcionario.getCargo());
			System.out.println(funcionario.getSalario());
			
			request.setAttribute("func", funcionario);
			request.getRequestDispatcher("/WEB-INF/pages/resultado.jsp").forward(request, response);
			
		} catch (Exception e) {
			
		} 
	}

}
