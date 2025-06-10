package br.dev.samara.CalculoIP.model;

public class CalculoIP {

	private String ip;
	private int hosts;
	private int cidr;
	private int subRedes;
	private String classe;
	private String mascaraBinario = "";
	private String mascaraDecimal = "";
	private String[] octetos;
	private String ipBroadcast;
	private String primeiroIpValido;
	private String ultimoIpValido;

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClas() {
		return classe;
	}

	public void separacaoIP() {

		String[] splitCidr = ip.split("/");
		cidr = Integer.valueOf(splitCidr[1]);
		String[] splitIp = ip.split("\\.");

//		if (octetos.length != 4) {
//			octetos[0] = "Ip Invalido.";
//		}

		classeIP(splitIp[0]);

	}

	public void classeIP(String splitIp) {

		int primeiroOcteto = Integer.valueOf(splitIp);

		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			classe = "Classe A";

		} else if (primeiroOcteto > 127 && primeiroOcteto <= 191) {
			classe = "Classe B";

		} else if (primeiroOcteto > 191 && primeiroOcteto <= 223) {
			classe = "Classe C";

		} else if (primeiroOcteto > 223 && primeiroOcteto <= 239) {
			classe = "Classe D (Multicast)";

		} else if (primeiroOcteto > 239 && primeiroOcteto <= 255) {
			classe = "Classe E (Reservada)";
		}

	}

	public void converterMascaraBinario() {
		int contador = 0;
		int octeto = 0;
		while (contador < cidr) {

			mascaraBinario += "1";
			octeto++;
			contador++;

			if (octeto == 8) {
				mascaraBinario += ",";
				octeto = 0;
			}

			if (contador == cidr) {
				while (mascaraBinario.length() < 35) {
					mascaraBinario += "0";
					octeto++;

					if (octeto == 8 && mascaraBinario.length() < 32) {
						mascaraBinario += ",";
						octeto = 0;
					}
				}
			}
		}

	}

	public String converterMascaraDecimal() {

		System.out.println(mascaraBinario);
		
		String[] splitBinario = mascaraBinario.split(",");
		
		int firstOctect = Integer.parseInt(splitBinario[0], 2);
		int secondOctect = Integer.parseInt(splitBinario[1], 2);
		int thirdOctect = Integer.parseInt(splitBinario[2], 2);
		int quarterOctect = Integer.parseInt(splitBinario[3], 2);
		
		mascaraDecimal = String.format("%s.%s.%s.%s", firstOctect, secondOctect, thirdOctect, quarterOctect);

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

			} else {
				bits = 8 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		} else if (classe.equals("Classe B")) {
			if (cidr == 16) {
				subRedes = 0;

			} else {
				bits = 16 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		} else if (classe.equals("Classe C")) {
			if (cidr == 24) {
				subRedes = 0;
			} else {
				bits = 24 - cidr;
				subRedes = (int) Math.pow(2, bits);
			}
		}
		return subRedes;
	}

	public void calcularIpsValidos() {
		
		
	}
        
	
	public String[] visualizarResultado() {
		
	
		String[] resultado = new String[9];
		
		resultado[0] = "IP: " + ip;
		resultado[1] = "Classe do IP " + classe;
		if(classe.equals("Classe D (Multicast)") || classe.equals("Classe E (Reservada)")) {
			
			resultado[2] = "Mascara em binario: IP´s de classe D ou E não possuem máscara.";
			resultado[3] = "Mascara em decimal: IP´s de classe D ou E não possuem máscara.";
			resultado[4] = "IP's disponiveis por rede: Não aplicável";
			resultado[5] = "Numero de sub-redes: Não possui";
//			resultado[6] = "Primeiro IP válido: " + primeiroIpValido;
//	        resultado[7] = "Último IP válido: " + ultimoIpValido;
//	        resultado[8] = "IP Broadcast: " + ipBroadcast;
			
		} else {
			
			resultado[2] = "Mascara em binario: " + mascaraBinario;
			resultado[3] = "Mascara em decimal: " + converterMascaraDecimal();
			resultado[4] = "IP's disponiveis por rede: " + calcularHosts();
			resultado[5] = "Numero de sub-redes: " + calcularSubRedes();
//			resultado[6] = "Primeiro IP válido: " + primeiroIpValido;
//	        resultado[7] = "Último IP válido: " + ultimoIpValido;
//	        resultado[8] = "IP Broadcast: " + ipBroadcast;
		
		}
		
		return resultado;
	}

}