package controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet(name = "Cadastro", urlPatterns = {"/CadastroController"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO cli = new ClienteDAO();
		Cliente cliente = cli.getClienteByCpf(manterApenasNumeros(request.getParameter("cpf")));
		if(cliente == null)
		{
			cliente = new Cliente();
		    cliente.setNome(request.getParameter("Nome"));
		    cliente.setRg(manterApenasNumeros(request.getParameter("rg")));
		    cliente.setCpf(manterApenasNumeros(request.getParameter("cpf")));
		    cliente.setCelular(manterApenasNumeros(request.getParameter("celular")));
		    cliente.setEmail(request.getParameter("email"));
		    cliente.setNomeMae(request.getParameter("NomeMae"));
		    cliente.setNomePai(request.getParameter("NomePai"));
		    
		    try {
		        String param = request.getParameter("dtnasc");
		        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(param);
		        cliente.setDataNsc(d);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		   
		    // Todo pegar data atual 
		    Date dataAtual = new Date(); 
		    cliente.setDataCad(new Date(dataAtual.getTime()));
		    
		    
		   
		    cli.addCliente(cliente);
		    
		    RequestDispatcher view = request.getRequestDispatcher("/sucesso.jsp");
	        view.forward(request, response);
		}
		else { 
			String datahora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cliente.getDataCad());
			request.setAttribute("datacad", datahora);
			RequestDispatcher view = request.getRequestDispatcher("/existe.jsp");
	        view.forward(request, response);
		}
			
			
			
		
	}
	
	String manterApenasNumeros(String text) {
		return text.replaceAll("[\\.\\(\\) \\-]", "");
	}
	
}