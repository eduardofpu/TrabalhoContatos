package ExcluirContatosServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

@WebServlet(urlPatterns = "/Deletar")
public class DeleteServlets extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		
		
		
		String contato = req.getParameter("Contato");
		String telefone = req.getParameter("Telefone");
		String x = leitura(contato,telefone);
		PrintWriter writer = resp.getWriter();
		
		
		if (contato  != null && telefone != null ) {
			
			writer.write(x);
		} else {
			writer.write("Erro, falta de parametros");
		}
	}
	
	
	private  String leitura(String contato,String telefone) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Novo Contato</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		         
		
		
		                
		                ////////////////////
		                Path t = Paths.get("C:/Users/Delfino/Documents/Texto/contatos.txt");//Abre o caminho especificado
		        		List<String> linhas = Files.readAllLines(t,Charset.defaultCharset());
		        		  
		        		for(String linha:linhas){
		        			
		        			String[] split = linha.split(";");
		        			
		        			if(split[0].equals(contato)&&split[1].equals(telefone)){
		        					
		        				Files.write(t,linhas,Charset.defaultCharset(), StandardOpenOption.DELETE_ON_CLOSE);
		        				sb.append("Excluido com sucesso!!");	
		        				
		        			}else {
		        				sb.append("");	
		        			
		        			System.out.println(linha);
		        			}
	     
	}	
		
		
		
		
		sb.append("<h1>Lista de Contatos</h1>");sb.append("<br>");	
		
		
		
		Path pa= Paths.get("C:/Users/Delfino/Documents/Texto/contatos.txt");//cria a pasta se não existir
		String conteudo = "";
		
		OpenOption modoAbertura = Files.exists(pa)? APPEND : CREATE;//import static java.nio.file.StandardOpenOption.*;
		Files.write(pa,conteudo.getBytes(),modoAbertura);
		
		Path pat = Paths.get("C:/Users/Delfino/Documents/Texto/contatos.txt");//Abre o caminho especificado
		List<String> readAllLine = Files.readAllLines(pat,Charset.defaultCharset());
		
		
		for(String linha:readAllLine){
			
			System.out.println(linha);
			
			sb.append(linha);
			sb.append("<br>");
		}
		
		
		sb.append("<br>");		
		sb.append("");
		sb.append("</div>");
		sb.append("<div class='panel-footer'>");
		sb.append("<a class='btn btn-default' href='index3.html' role='button'>Excluir contatos</a>");
		sb.append("<a class='btn btn-default' href='index2.html' role='button'>Adicionar mais contatos</a>");
		sb.append("<a class='btn btn-default' href='index.html' role='button'>Inicio</a>");

		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
		
	
	}

	
}
