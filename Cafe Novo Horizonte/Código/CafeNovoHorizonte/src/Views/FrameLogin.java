package Views;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controllers.LoginController;
import Models.LoginModel;

public class FrameLogin extends JFrame{ //Classe filha da classe JFrame para fazer telas
	ImageIcon imgFundo; //Imagem de fundo
	JLabel lbLogin, lbSenha, lbFundo, lbDesenvolvimento, lbSharkTech, lbSharkIcone; //Labels de login, senha, desenvolvimento e as imagens de fundo
	JTextField tfLogin; //Campo de texto de login
	JPasswordField tfSenha; //Campo de senha
	JButton btLogin; //Botão para efetuar o login
	LoginController controller;
	
	public FrameLogin(){ //Construtor da classe
		inicializaFrame(); //Chamada do método para instanciar o frame
		inicializaComponentes(); //Chamada do método para instanciar os componentes do frame
	}
		
	private void inicializaFrame(){ //Método para criar o frame
		try { //Exceção para utilizar ou não o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		
		this.setTitle("Café Novo Horizonte"); //Título do frame
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens/CafeIcone.png")); //Icone do frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Operação ao fechar o frame
		this.setResizable(false); //Não deixa modificar o tamanho da tela
		this.setLayout(null); //Seta o layout como null
		this.setSize(628,419); //Tamanho do frame
		this.setLocationRelativeTo(null); //Posição da tela onde o frame vai aparecer, quando o valor é nulo, aparece no meio da tela
		this.setVisible(true); //Deixa o frame visível
		
		this.addWindowListener(new WindowAdapter() {  //Verifica se o usuário deseja mesmo sair do sistema
			public void windowClosing(WindowEvent e){
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?");
				if (i == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		} );
	}
	
	private void inicializaComponentes(){ //Método para instanciar os objetos do frame
		lbLogin = new JLabel("Login");
		add(lbLogin); 
		lbLogin.setBounds(299, 140, 50, 20);

		lbSenha = new JLabel("Senha");
		add(lbSenha);
		lbSenha.setBounds(296, 200, 50, 20);

		tfLogin = new JTextField();
		add(tfLogin);
		tfLogin.setBounds(215, 160, 200, 25);

		tfSenha = new JPasswordField();
		add(tfSenha);
		tfSenha.setBounds(215, 220, 200, 25);

		btLogin = new JButton(new ImageIcon("Imagens/LoginButtonIcone.png"));
		add(btLogin);
		btLogin.setBounds(264, 260, 100, 30);
		btLogin.setContentAreaFilled(false);
		
		lbDesenvolvimento = new JLabel("Desenvolvido pela:");
		add(lbDesenvolvimento);
		lbDesenvolvimento.setBounds(263, 310, 130, 20);
		
		lbSharkTech = new JLabel("hark Tech®");
		add(lbSharkTech);
		lbSharkTech.setBounds(280, 345, 120, 20);
		lbSharkTech.setFont(new Font("Arial", Font.BOLD, 20));
		
		lbSharkIcone = new JLabel(new ImageIcon("Imagens/Shark.png"));
		add(lbSharkIcone);
		lbSharkIcone.setBounds(220, 325, 64, 64);
		
		imgFundo = new ImageIcon("Imagens/CafeFundoLogin.png");
		lbFundo = new JLabel(imgFundo);
		add(lbFundo);
		lbFundo.setBounds(0, 0, 626, 417);
		
		btLogin.addActionListener(new LoginController(tfLogin, tfSenha));
	}
	
	public static void main(String[] args) {
		FrameLogin frame = new FrameLogin();
	}
}