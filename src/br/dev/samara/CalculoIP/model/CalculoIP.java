package br.dev.samara.CalculoIP.model;

public class CalculoIP {
	
	private String IP;
	private int hosts;
	private int cidr;
	private int subRedes;
	private String classe;
	private String mascaraBinario = "";
	private String mascaraDecimal = "";
	private String[] octetos;
	
	public void setIp(String ip) {
		this.IP = ip;
	}
	
	public void separacaoIP() {
		
		String[] splitIP = IP.split("/");
		cidr = Integer.valueOf(splitIP[1]);
		octetos = splitIP[0].split("\\");
		if (octetos.length != 4) {
			octetos[0] = "Ip Invalido.";
		}
	}
	
	public String ClasseIP() {
		
		int primeiroOcteto = Integer.valueOf(octetos[0]);
		
		if (primeiroOcteto > 0 && primeiroOcteto <= 127) {
			classe = "Classe A";
			
		}else if (primeiroOcteto > 127 && primeiroOcteto <= 191) {	
			classe = "Classe B";
			
		} else if (primeiroOcteto > 191 && primeiroOcteto <= 223) {
			classe = "Classe C";
		
		}else if (primeiroOcteto > 223 && primeiroOcteto <= 239) {
			classe = "Classe D (Multicast)";
			
		}else if (primeiroOcteto > 239 && primeiroOcteto <= 255) {
			classe = "Classe E (Reservada)";
		} 
		
		return classe;
		
	}

	public String converterBinario() {
		int contador = 0;
		int octeto = 0;
		while (contador < cidr) {
		
			mascaraBinario += "1";
			octeto++;
			contador++;
			
			if (octeto == 8) {
					mascaraBinario += ".";
					octeto = 0;
			}
		
		if (contador == cidr) {	
			while (mascaraBinario.length() < 35) {
				mascaraBinario += "0";
				octeto++;
				
				if (octeto == 8 && mascaraBinario.length() < 35) {
					mascaraBinario += ".";
					octeto = 0;
				}
			}
		}
	} 
		return mascaraBinario;
}

	public String converterDecimal(){
		
		String[] splitBinario = mascaraBinario.split("\\.");
		
		int binario = 128;
		int octetoDecimal = 0;
		
		int i = 0;
		int indexContador = 0;
		
		while (i < 4) {
			
			String[] octeto = splitBinario[i].split("");
		
		
		while (indexContador < octeto.length) {
			
			if (octeto[indexContador].equals("1")) {
				
				octetoDecimal += binario;
				binario = binario/2;
				indexContador++;
				
			}else {
				binario = binario/2;
				indexContador++;
			}
		}
	
   i++;
   binario = 128;
   indexContador = 0;
   
   if (i == 4) {
	   mascaraDecimal += String.valueOf(octetoDecimal);
	   octetoDecimal = 0;
	   
   }else {
	   
	   mascaraDecimal += String.valueOf(octetoDecimal) + "";
	   octetoDecimal = 0;
   
   }
   
}
	return mascaraDecimal;
   
   } 
	
	public int calcularHosts() {
		
		hosts = 32 - cidr;
		this.hosts = (int) Math.pow(2, hosts);
		return this.hosts;
	}
	
	public int calcularSubRedes() {

		int bits = 0;
		
		if (classe.equals("Classe A")) {
			if (cidr == 8) {
				subRedes = 0;
				
			}else {
				bits = 8 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		} else if (classe.equals("Classe B")) {
			if(cidr == 16) {
				subRedes = 0;
				
			} else {
				bits = 16 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		}else if (classe.equals("Classe C")) {
			if (cidr == 24) {
				subRedes = 0;
			} else {
				bits = 24 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		}
		return subRedes;
	}
	
	public String[] visualizarResultado() {
		
	
		String[] resultado = new String[6];
		
		resultado[0] = "IP: " + IP;
		resultado[1] = "Classe do IP" + ClasseIP();
		if(classe.equals("Classe D (Multicast)") || classe.equals("Classe E (Reservada)")) {
			
			resultado[2] = "Mascara em binario: IP´s de classe D ou E não possuem máscara.";
			resultado[3] = "Mascara em decimal: IP´s de classe D ou E não possuem máscara.";
			resultado[4] = "IP's disponiveis por rede: Não aplicável";
			resultado[5] = "Numero de sub-redes: Não possui";
			
			
		} else {
			
			resultado[2] = "Mascara em binario: " + converterBinario();
			resultado[3] = "Mascara em decimal: " + converterDecimal();
			resultado[4] = "IP's disponiveis por rede: " + calcularHosts();
			resultado[5] = "Numero de sub-redes: " + calcularSubRedes();
		}
		
		return visualizarResultado();
	}
	
}