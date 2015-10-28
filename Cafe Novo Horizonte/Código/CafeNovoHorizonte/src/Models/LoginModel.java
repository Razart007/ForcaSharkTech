package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Controllers.ConectarComBanco;

public class LoginModel {
	public String buscarUsuario(String login, String senha){
		ConectarComBanco banco = new ConectarComBanco();
		boolean encontrou = false;
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			String query = "SELECT * FROM cafenovohorizonte.TB_Usuario WHERE login LIKE '"+login+"' AND senha LIKE '"+senha+"'";
			ResultSet rs = stmt.executeQuery(query);
			rs.first();
			int cod = rs.getInt("id");
			String loginBanco = rs.getString("login");
			String senhaBanco = rs.getString("senha");

			if(login.equalsIgnoreCase(loginBanco) && senha.equalsIgnoreCase(senhaBanco)){
				encontrou = true;
				stmt.close();
				banco.fecharBDConn();
			}
			if (encontrou){
				return "Login efetuado";
			}
			else {
				return "Erro de autenticacao";
			}
		} catch (Exception e){
			return "Erro de Leitura";
		} 
	}	
}
