package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Models.LoginModel;
import Views.FramePrincipal;

public class LoginController implements ActionListener{
	
	private JFrame frame;
	private LoginModel model;
	private JTextField tfLogin; 
	private JPasswordField tfSenha;


	public LoginController(JFrame frame, JTextField tfLogin, JPasswordField tfSenha) {

		this.frame = frame;
		this.tfLogin = tfLogin;
		this.tfSenha = tfSenha;
		this.model = new LoginModel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String login = tfLogin.getText();
		String senha = new String(tfSenha.getPassword());
				
		if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")){
			
			JOptionPane.showMessageDialog(null, "Informe os dois campos para concluir a autentica��o!!!");
			return;
			
		} else {

			int resultado = model.buscarUsuario(login, senha);
			
			if (resultado == LoginModel.LOGIN_SUCESSO){
				
				frame.dispose();
				FramePrincipal framePrincipal = new FramePrincipal();
				
			} else {
				JOptionPane.showMessageDialog(null, "Erro na autentica��o!!!");
				return;
			}
		}
	}
}

