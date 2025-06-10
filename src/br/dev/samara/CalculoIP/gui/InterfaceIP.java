package br.dev.samara.CalculoIP.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import br.dev.samara.CalculoIP.model.CalculoIP;

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
	private JList<String> listaresultados;
	private JScrollPane scroll;
	
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
	
	
	lblDigiteIp = new JLabel();
	lblDigiteIp.setText("Digite o IP: ");
	lblDigiteIp.setBounds(15, 10, 100, 20);
	
	lblIp = new JLabel();
	lblIp.setText("IP: ");
	lblIp.setBounds(15, 45, 90, 40);
	
	txtPrimeiroOcteto = new JTextField();
	txtPrimeiroOcteto.setBounds(35, 50, 60, 30);
	
	lblSeparador1 = new JLabel();
	lblSeparador1.setText(".");
	lblSeparador1.setBounds(100, 60, 10, 10);

	listaresultados = new JList<String>();
	
	
	scroll = new JScrollPane(listaresultados);
	scroll.setBounds(25, 160, 450, 200);
	
	
	txtSegundoOcteto = new JTextField();
	txtSegundoOcteto.setBounds(110, 50, 60, 30);
	
	lblSeparador2 = new JLabel();
	lblSeparador2.setText(".");
	lblSeparador2.setBounds(180, 60, 10, 10);
	
	txtTerceiroOcteto = new JTextField();
	txtTerceiroOcteto.setBounds(190, 50, 60, 30);
	
	lblSeparador3 = new JLabel();
	lblSeparador3.setText(".");
	lblSeparador3.setBounds(260, 60, 10, 10);
	
	txtQuartoOcteto = new JTextField();
	txtQuartoOcteto.setBounds(280, 50, 60, 30);
	
	lblSeparador4 = new JLabel();
	lblSeparador4.setText("/");
	lblSeparador4.setBounds(355, 60, 10, 10);
	
	txtcidr = new JTextField();
	txtcidr.setBounds(380, 50, 50, 30);
	
	btnCalcular = new JButton();
	btnCalcular.setText("Calcular");
	btnCalcular.setBounds(120, 110, 100, 40);
	
	btnLimpar = new JButton();
	btnLimpar.setText("Limpar");
	btnLimpar.setBounds(250, 110, 100, 40);

    btnCalcular.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			CalculoIP ip = new CalculoIP();
			
			ip.setIp(String.format("%s.%s.%s.%s/%s", txtPrimeiroOcteto.getText(), txtSegundoOcteto.getText(),  txtTerceiroOcteto.getText(), txtQuartoOcteto.getText(), txtcidr.getText()));
			ip.separacaoIP();
			ip.converterMascaraBinario();
			ip.converterMascaraDecimal();
			ip.calcularHosts();
			
			
			String[] answer = ip.visualizarResultado();
			listaresultados.setListData(answer);

			
		}
	});
    
	btnLimpar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			txtPrimeiroOcteto.setText("");
			txtSegundoOcteto.setText("");
			txtTerceiroOcteto.setText("");
			txtQuartoOcteto.setText("");
			txtcidr.setText("");
			listaresultados.setListData(new String[1]);
			
		}
		
		});
	
	
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
	painel.add(scroll);
	

	
	tela.setVisible(true);
	}
}
