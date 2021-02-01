package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet(name = "Cadastro", urlPatterns = {"/CadastroController"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Cliente cliente = new Cliente();
	    cliente.setNome(request.getParameter("Nome"));
	    cliente.setRg(request.getParameter("rg"));
	    cliente.setCpf(request.getParameter("cpf"));
	    cliente.setCelular(request.getParameter("celular"));
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
	    Date dataAtual = new Date(1); 
	    cliente.setDataCad(new Date(dataAtual.getTime()));
	    
	    
	    ClienteDAO cli = new ClienteDAO();
	    cli.addCliente(cliente);
	    
	    
	   
	}
}