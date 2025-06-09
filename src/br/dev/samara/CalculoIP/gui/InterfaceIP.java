package br.dev.samara.CalculoIP.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	
	

	btnLimpar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 try {
		            String oct1 = txtPrimeiroOcteto.getText().trim();
		            String oct2 = txtSegundoOcteto.getText().trim();
		            String oct3 = txtTerceiroOcteto.getText().trim();
		            String oct4 = txtQuartoOcteto.getText().trim();
		            String cidr = txtcidr.getText().trim();

		            // Verificação simples
		            if (oct1.isEmpty() || oct2.isEmpty() || oct3.isEmpty() || oct4.isEmpty() || cidr.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
		                return;
		            }

		            String ipCompleto = oct1 + "." + oct2 + "." + oct3 + "." + oct4 + "/" + cidr;

		            // Chama a lógica da classe
		            CalculoIP calculo = new CalculoIP();
		            calculo.setIp(ipCompleto);
		            calculo.separacaoIP();
		            calculo.ClasseIP();
		            calculo.converterMascaraBinario();
		            calculo.converterMascaraDecimal();
		            calculo.calcularHosts();
		            calculo.calcularSubRedes();
		            String[] resultado = calculo.visualizarResultado();
		            
		            

		            // Mostra os resultados
		            StringBuilder msg = new StringBuilder();
		            for (String linha : resultado) {
		                msg.append(linha).append("\n");
		            }

		            JOptionPane.showMessageDialog(null, msg.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Erro ao calcular: " + ex.getMessage());
		        }
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
	

	
	tela.setVisible(true);
	}
}
