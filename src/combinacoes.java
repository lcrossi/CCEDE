import java.util.Scanner;
import java.util.ArrayList;

public class combinacoes {
	//String com tudo o que se quer imprimir no painel
	String textoFinal = "\n\n ----------------------------------------------- \n RELATÓRIO \n ----------------------------------------------- \n\n";
	 
	public String getRelatorio() {
		 return textoFinal;
	 }
	
	public combinacoes(ArrayList<acoes> lista) {
		
		//lista geral
		ArrayList<acoes> listaA = lista;
		acoes novaAcao = null;
		acoes buscaVariaveis = null;
		
		//NORMAIS
		
		//lista de normais-permanentes
		ArrayList<acoes> listaNp = new ArrayList<acoes>(); //Np = normal-permanente
		acoes acoesN = null;
		
		//lista de normais-variaveis
		ArrayList<acoes> listaNv = new ArrayList<acoes>(); //Np = normal-permanente
		acoes acoesV = null;
				
		/*//CORTANTES
		//lista de normais-permanentes
		ArrayList<acoes> listaVp = new ArrayList<acoes>(); //Np = normal-permanente
		acoes acoes = null;
				
		//lista de normais-variaveis
		ArrayList<acoes> listaNv = new ArrayList<acoes>(); //Np = normal-permanente
		acoes acoesV = null;*/
		
		
		int nomeA;
		double valorA;
		int mnvA;
		int adicionarMais = 1;
	/*	
		Scanner s = new Scanner (System.in);
do {
		System.out.println("Digite o numero correspondente ao tipo da acao: \n 1 - momento \n 2 - normal \n 3 - cortante \n 4 - calcular");
		int opcao = s.nextInt();//Tpo ação
		
		switch (opcao) {
		case 1: mnvA = opcao;
				System.out.println("Selecione a categoria da acao:\n 1- peso próprio \n 2- retracao \n 3- sobrecarga \n 4- temperatura \n 5- vento \n");
				nomeA = s.nextInt();//categ ação
System.out.println("Insira a grandeza da acao \n");
				valorA = s.nextDouble();//grandeza
				novaAcao = new acoes(mnvA, nomeA, valorA);
				novaAcao.preencher();
				listaA.add(novaAcao);
			    	
				//novaAcao.relatorio();
			    break;
				
		case 2: mnvA = opcao;
				System.out.println("Selecione a categoria da acao:\n 1- peso próprio \n 2- retracao \n 3- sobrecarga \n 4- temperatura \n 5- vento \n");
				nomeA = s.nextInt();
				System.out.println("Insira a grandeza da acao \n");
				valorA = s.nextDouble();
				novaAcao = new acoes(mnvA, nomeA, valorA);
				novaAcao.preencher();	
				listaA.add(novaAcao);
					
				//novaAcao.relatorio();
				break;
				
				
		case 3:	mnvA = opcao;
				System.out.println("Selecione a categoria da acao:\n 1- peso próprio \n 2- retracao \n 3- sobrecarga \n 4- temperatura \n 5- vento \n");
				nomeA = s.nextInt();
				System.out.println("Insira a grandeza da acao \n");
				valorA = s.nextDouble();
				novaAcao = new acoes(mnvA, nomeA, valorA);
				novaAcao.preencher();	
				listaA.add(novaAcao);		
				//novaAcao.relatorio();
				break;
				
		case 4: adicionarMais = 2;
				break;
		}
}
while (adicionarMais == 1);
*/
//imprimindo todas as acoes do arraylist

/*for(int i=0; i < listaA.size(); i++) {
	acoes verAcoes = listaA.get(i);
	verAcoes.relatorio();
}*/

//NORMAIS PARTE PERMANENTE

//varrendo a lista A e separando tudo o que tem normal permanente

for (int j=0; j < listaA.size(); j++) {
		
	acoes verAcoes = listaA.get(j);
	int mnv_aux;
	mnv_aux = verAcoes.getMnv();
	int tipo_aux; // 1-permanente // 2-variavel //
	tipo_aux = verAcoes.getTipo();
	
	if(mnv_aux == 2 && tipo_aux == 1) {
		
		int nome_aux = verAcoes.getNome();
		double valor_aux = verAcoes.getValor();
		
		acoesN = new acoes(mnv_aux,nome_aux,valor_aux);
		acoesN.preencher();
		listaNp.add(acoesN);
		
		}
		
	}


//varrendo a lista Np e calculando o valor final da soma das parcelas de normais permanentes multiplicadas pelos seus gamas
double NdPermTot=0.0;
double valor_aux1=0.0;
double gama_aux1=0.0; // 1-permanente // 2-variavel //
String nome=null;



for (int j=0; j < listaNp.size(); j++) {
	
	//acessando o objeto da lista de normais permanentes
	acoes acoesNp = listaNp.get(j);
	
	//pegando variaveis
	valor_aux1 = acoesNp.getValor();	
	gama_aux1 = acoesNp.getGama();
	
	
	double NdPermParcial = acoesNp.CalculoNdpermanente(gama_aux1, valor_aux1);
	NdPermTot = NdPermTot + NdPermParcial;
	System.out.println("---------------------------------------------------------");
	acoesN.imprimeNdpermanente(valor_aux1, gama_aux1);
	System.out.println("---------------------------------------------------------");
	textoFinal = textoFinal + acoesN.imprimeNdpermanente(valor_aux1, gama_aux1) + 
			"\n---------------------------------------------------------\n";
		}
		
//CHECKPOINT//
System.out.println("---------------------------------------------------------");
System.out.println("Nd permanente total:"+ NdPermTot); 	
System.out.println("---------------------------------------------------------");
textoFinal = textoFinal + "---------------------------------------------------------\n" 
		+ "Nd permanente total:"+ NdPermTot + 
		"\n---------------------------------------------------------\n";


//NORMAIS - PARTE VARIAVEL

//varrendo a lista A e separando tudo o que tem normal variável

for (int j=0; j < listaA.size(); j++) {
		
	acoes verAcoes = listaA.get(j);
	int mnv_aux;
	mnv_aux = verAcoes.getMnv();
	int tipo_aux; // 1-permanente // 2-variavel //
	tipo_aux = verAcoes.getTipo();
	
	if(mnv_aux == 2 && tipo_aux == 2) {
		
		int nome_aux = verAcoes.getNome();
		double valor_aux = verAcoes.getValor();
		
		acoesV = new acoes(mnv_aux,nome_aux,valor_aux);
		acoesV.preencher();
		listaNv.add(acoesV);
		
		}
		
	}

//imprimindo a lista Nv somente para verificação da separação anterior

/*for(int i=0; i < listaNv.size(); i++) {
	acoesV = listaNv.get(i);
	acoesV.relatorio();
	
}*/


//varrendo a lista Nv e calculando o valor final da soma das parcelas de normais variaveis multiplicadas pelos seus gamas e phi's
double NdVariavTot=0;

for (int j=0; j < listaNv.size(); j++) {
	
	//acessando o objeto da lista de normais variaveis
	acoesV = listaNv.get(j);
	
	
	//pegando variaveis para realizar os caclulos
	double valor_aux;
	valor_aux = acoesV.getValor();
	double gama_aux; // 1-permanente // 2-variavel //
	gama_aux = acoesV.getGama();
	int nome_aux = acoesV.getNome();
	
	double NdVariavParcial = 0.0;
	
	NdVariavParcial = acoesV.CalculoNdvariavelPermanente(gama_aux, valor_aux);
	NdVariavTot = 0.0;
	NdVariavTot = NdVariavTot + NdVariavParcial;
	
	System.out.println("---------------------------------------------------------");
	acoesV.imprimeNdpermanente(valor_aux, gama_aux);
	System.out.println("---------------------------------------------------------");
	textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
		+ acoesV.imprimeNdpermanente(valor_aux, gama_aux) + 
		"\n---------------------------------------------------------\n";
			
	//CHECKPOINT//
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("A parcela variavel que se comporta como principal eh " + NdVariavParcial );
	System.out.println("-------------------------------------------------------------------------------");
	textoFinal = textoFinal + "\n-------------------------------------------------------------------------------\n" 
			+ "A parcela variavel que se comporta como principal eh " + NdVariavParcial 
			+ "\n-------------------------------------------------------------------------------\n";
	
	if(j>0) {
	for(int k=0; k<j; k++) {
		
		acoesV = listaNv.get(k);
		double valor2_aux;
		valor2_aux = acoesV.getValor();
		double gama2_aux; // 1-permanente // 2-variavel //
		gama2_aux = acoesV.getGama();
		double phi2_aux; // 1-permanente // 2-variavel //
		phi2_aux = acoesV.getPhi();
		
		NdVariavParcial = 0.0;
		
		NdVariavParcial = acoesV.CalculoNdvariavel(gama2_aux, valor2_aux, phi2_aux);
		
		
		System.out.println("---------------------------------------------------------");
		acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux);
		System.out.println("---------------------------------------------------------");
		textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
			+ acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux) 
			+ "\n---------------------------------------------------------\n";
		
		//CHECKPOINT//
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas antes da considerada como principal. loop: " + k  + "- " + NdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ "As parcelas antes da considerada como principal. loop: " + k  + "- " 
				+ NdVariavParcial + "\n---------------------------------------------------------\n";
		
		NdVariavTot = NdVariavTot + NdVariavParcial;
		
	}
	}
	
	if(j<(listaNv.size()-1)) {
for(int l=(j+1); l<listaNv.size(); l++) {
		
		acoesV = listaNv.get(l);
		double valor2_aux;
		valor2_aux = acoesV.getValor();
		double gama2_aux; // 1-permanente // 2-variavel //
		gama2_aux = acoesV.getGama();
		double phi2_aux; // 1-permanente // 2-variavel //
		phi2_aux = acoesV.getPhi();
		
		NdVariavParcial = 0.0;
		NdVariavParcial = acoesV.CalculoNdvariavel(gama2_aux, valor2_aux, phi2_aux);
		
		System.out.println("---------------------------------------------------------");
		acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux);
		System.out.println("---------------------------------------------------------");
		textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux) 
				+ "\n---------------------------------------------------------\n";
		
		//CHECKPOINT
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas depois da considerada como principal. loop: " + l + "- "  + NdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ "As parcelas depois da considerada como principal. loop: " 
				+ l + "- "  + NdVariavParcial 
				+ "\n---------------------------------------------------------\n";
		
		NdVariavTot = NdVariavTot + NdVariavParcial;
		
	}
	}

	
	
if(nome_aux == 1) {
	nome = "Peso proprio";
}

if(nome_aux == 2) {
	nome = "Retracao";
}

if(nome_aux == 3) {
	nome = "Sobrecarga";
}

if(nome_aux == 4) {
	nome = "Temperatura";
}

if(nome_aux == 5) {
	nome = "Vento";
}

	
double Ndtotal = 0.0; 
Ndtotal = NdVariavTot + NdPermTot;


//CHECKPOINT
System.out.println("A Nd para" + nome + " como principal, eh igual a: \n Nd=" + Ndtotal );
textoFinal = textoFinal + "\nA Nd para" + nome + " como principal, eh igual a: \n Nd=" + Ndtotal;
//calculando o Nd para os casos em que a variavel principal não tem normal na direcao


for (int n=0; n < listaA.size(); n++) {
	
	
	buscaVariaveis = listaA.get(n);
	
	int nome3_aux = buscaVariaveis.getNome();
	int tipo3_aux;
	tipo3_aux = buscaVariaveis.getTipo();
	int mnv3_aux;
	mnv3_aux = buscaVariaveis.getMnv();
	
	if(tipo3_aux == 2 && mnv3_aux != 2)
		
	{	
		double valor_auxiliar = 0;
		double gama_auxiliar = 0;
	    double phi_auxiliar = 0;
	    
		for (int t=0; t<listaNv.size();t++) {
		listaNv.get(t);
		
		valor_auxiliar = acoesV.getValor();
		gama_auxiliar = acoesV.getGama();
	    phi_auxiliar = acoesV.getPhi();
			
	    
	    if(nome3_aux == 1) {
	    	nome = "Peso proprio";
	    }

	    if(nome3_aux == 2) {
	    	nome = "Retracao";
	    }

	    if(nome3_aux == 3) {
	    	nome = "Sobrecarga";
	    }

	    if(nome3_aux == 4) {
	    	nome = "Temperatura";
	    }

	    if(nome3_aux == 5) {
	    	nome = "Vento";
	    }

	    
	    System.out.println("---------------------------------------------------------");
		buscaVariaveis.imprimeNdvariavel(valor_auxiliar, gama_auxiliar, phi_auxiliar);
		System.out.println("---------------------------------------------------------");
		textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ buscaVariaveis.imprimeNdvariavel(valor_auxiliar, gama_auxiliar, phi_auxiliar) 
				+ "\n---------------------------------------------------------\n";
	    
	    double Ndtotal2 = NdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
	    System.out.println("A Nd para" + nome3_aux + " como principal, eh igual a: \n Nd=" + Ndtotal2 );
	    textoFinal = textoFinal + "\nA Nd para" + nome3_aux + " como principal, eh igual a: \n Nd=" + Ndtotal2;
		}
		
		
		
		
	    }
		
		}
	
		}





		
	



	}
	
}
	






	


