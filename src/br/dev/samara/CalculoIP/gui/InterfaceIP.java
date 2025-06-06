package br.dev.samara.CalculoIP.gui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceIP {

	private JLabel lblDigiteIp;
	private JLabel lblIp;
	private JLabel lblSeparador1;
	private JLabel lblSeparador2;
	private JLabel lblSeparador3;
	private JLabel lblSeparador4;
	
	private JTextField txtcidr;
	private JTextField txtPrimeiroOcteto;
	private JTextField txtSegundoOcteto;
	private JTextField txtTerceiroOcteto;
	private JTextField txtQuartoOcteto;
	
	private JButton btnCalcular;
	private JButton btnLimpar;
	
	
	
public void criarTela(){
	
	      
	
	JFrame tela = new JFrame();
	tela.setSize(500, 500);
	tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tela.setTitle("Calculadora IP");
	tela.setLocationRelativeTo(null);
	tela.setLayout(null);
	tela.setResizable(false);
	
	
	JLabel lblDigiteIp = new JLabel();
	lblDigiteIp.setText("Digite o IP: ");
	lblDigiteIp.setBounds(15, 10, 100, 20);
	
	JLabel lblIp = new JLabel();
	lblIp.setText("IP: ");
	lblIp.setBounds(15, 45, 90, 40);
	
	JTextField txtPrimeiroOcteto = new JTextField();
	txtPrimeiroOcteto.setBounds(35, 50, 60, 30);
	
	JLabel lblSeparador1 = new JLabel();
	lblSeparador1.setText(".");
	lblSeparador1.setBounds(100, 60, 10, 10);


	
	JTextField txtSegundoOcteto = new JTextField();
	txtSegundoOcteto.setBounds(110, 50, 60, 30);
	
	JLabel lblSeparador2 = new JLabel();
	lblSeparador2.setText(".");
	lblSeparador2.setBounds(180, 60, 10, 10);
	
	JTextField txtTerceiroOcteto = new JTextField();
	txtTerceiroOcteto.setBounds(190, 50, 60, 30);
	
	JLabel lblSeparador3 = new JLabel();
	lblSeparador3.setText(".");
	lblSeparador3.setBounds(260, 60, 10, 10);
	
	JTextField txtQuartoOcteto = new JTextField();
	txtQuartoOcteto.setBounds(280, 50, 60, 30);
	
	JLabel lblSeparador4 = new JLabel();
	lblSeparador4.setText("/");
	lblSeparador4.setBounds(355, 60, 10, 10);
	
	JTextField txtcidr = new JTextField();
	txtcidr.setBounds(380, 50, 50, 30);
	
	JButton btnCalcular = new JButton();
	btnCalcular.setText("Calcular");
	btnCalcular.setBounds(120, 110, 100, 40);
	
	JButton btnLimpar = new JButton();
	btnLimpar.setText("Limpar");
	btnLimpar.setBounds(250, 110, 100, 40);
	
	Container painel = tela.getContentPane();
	
	painel.add(lblDigiteIp);
	painel.add(lblIp);
	painel.add(txtPrimeiroOcteto);
	painel.add(txtSegundoOcteto);
	painel.add(lblSeparador1);
	painel.add(txtTerceiroOcteto);
	painel.add(lblSeparador2);
	painel.add(lblSeparador3);
	painel.add(txtQuartoOcteto);
	painel.add(lblSeparador4);
	painel.add(txtcidr);
	painel.add(btnCalcular);
	painel.add(btnLimpar);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	tela.setVisible(true);
	}
}
