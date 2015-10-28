package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Models.LoginModel;

public class LoginController implements ActionListener{
	JTextField tfLogin;
	JPasswordField tfSenha;
	LoginModel model = new LoginModel();

	public LoginController(JTextField tfLogin, JPasswordField tfSenha){
		this.tfLogin = tfLogin;
		this.tfSenha = tfSenha;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {			
		if (tfLogin.getText().equalsIgnoreCase("") || tfSenha.getText().equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "Informe os dois campos para concluir a autentica��o!!!");
			return;
		}
		else {
			String loginAux = tfLogin.getText();
			String senhaAux = tfSenha.getText();

			if (model.buscarUsuario(loginAux, senhaAux).equalsIgnoreCase("Login efetuado")){
				JOptionPane.showMessageDialog(null, "O Usu�rio entrou no sistema!!!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Erro na autentica��o!!!");
				return;
			}
		}
	}	
}

