package User;

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



@WebServlet(urlPatterns = "/geranota")
public class UsuarioServlets extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>");
		
		//writer.write(String.format(" %s",req.getSession().getAttribute("Usuario") ));
		writer.write("</h1>");
		writer.write("</body>");
		writer.write("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String nomeUser = req.getParameter("userUsuario");
		req.getSession().setAttribute("Usuario",nomeUser);
		
		String senhaUser = req.getParameter("senhaUsuario");
		req.getSession().setAttribute("Senha",senhaUser);
		
		String x = leitura(nomeUser,senhaUser);
		PrintWriter w = resp.getWriter();
		
		
		if (nomeUser  != null && senhaUser != null ) {
			
			w.write(x);
		
		} else {
			
			w.write("Erro, falta de parametros");
		}
	}
	
	
	private  String leitura(String nomeUser,String senhaUser) throws IOException {
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
		sb.append("<h3 class='panel-title'>Usuario</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		
		
		Path path = Paths.get("C:/Users/Delfino/Documents/Texto/usuario.txt");//Abre o caminho especificado
		List<String> readAllLines = Files.readAllLines(path,Charset.defaultCharset());
		
		for(String linha:readAllLines){
			
			String[] split = linha.split(";");
			
			if(split[0].equals(nomeUser)&&split[1].equals(senhaUser)){
				//sb.append(String.format("Usuario conectado : %s ", nomeUser));//sb.append("<br>");
				sb.append("Usuario conectado :  "+nomeUser+"  ");//sb.append("<br>");sb.append("<br>");
				//sb.append("Senha:"+senhaUser);	
				sb.append("<a class='btn btn-default' href='index2.html' role='button'>Contatos</a>");
				
			}else
				//sb.append("?");	
			
			System.out.println(linha);
			
		}	
		
		sb.append("<br>");		
		sb.append("</div>");
		sb.append("<div class='panel-footer'>");		
		sb.append("<a class='btn btn-default' href='index.html' role='button'>voltar</a>");		
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
				
  }

}
