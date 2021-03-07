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
		
		
		//MOMENTOS
		
		//lista de momentos-permanentes
		ArrayList<acoes> listaMp = new ArrayList<acoes>(); //Mp = momento-permanente
		acoes acoesMp = null;
				
		//lista de momentos-variaveis
		ArrayList<acoes> listaMv = new ArrayList<acoes>(); //Mp = momento-permanente
		acoes acoesMv = null;
				
		
		//CORTANTES
		
		//lista de normais-permanentes
		ArrayList<acoes> listaVp = new ArrayList<acoes>();
		acoes acoesVp = null;
				
		//lista de normais-variaveis
		ArrayList<acoes> listaVv = new ArrayList<acoes>();
		acoes acoesVv = null;
		
				
		
		
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
	/*textoFinal = textoFinal + acoesN.imprimeNdpermanente(valor_aux1, gama_aux1) + 
			"\n---------------------------------------------------------\n";*/
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
	/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
		+ acoesV.imprimeNdpermanente(valor_aux, gama_aux) + 
		"\n---------------------------------------------------------\n";*/
			
	//CHECKPOINT//
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("A parcela variavel que se comporta como principal eh " + NdVariavParcial );
	System.out.println("-------------------------------------------------------------------------------");
	textoFinal = textoFinal + "\n-------------------------------------------------------------------------------\n" 
			+ "A parcela variavel que se comporta como principal é " + NdVariavParcial 
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
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
			+ acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux) 
			+ "\n---------------------------------------------------------\n";
		*/
		//CHECKPOINT//
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas antes da considerada como principal. loop: " + k  + "- " + NdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ "As parcelas antes da considerada como principal. loop: " + k  + "- " 
				+ NdVariavParcial + "\n---------------------------------------------------------\n";
		*/
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
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ acoesV.imprimeNdvariavel(valor2_aux, gama2_aux, phi2_aux) 
				+ "\n---------------------------------------------------------\n";
		*/
		//CHECKPOINT
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas depois da considerada como principal. loop: " + l + "- "  + NdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ "As parcelas depois da considerada como principal. loop: " 
				+ l + "- "  + NdVariavParcial 
				+ "\n---------------------------------------------------------\n";
		*/
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
System.out.println("A Nd para " + nome + " como principal, eh igual a: \n Nd=" + Ndtotal );
textoFinal = textoFinal + "\nA Nd para " + nome + " como principal, eh igual a: \n Nd=" + Ndtotal;
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
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ buscaVariaveis.imprimeNdvariavel(valor_auxiliar, gama_auxiliar, phi_auxiliar) 
				+ "\n---------------------------------------------------------\n";
	    */
	    double Ndtotal2 = NdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
	    System.out.println("A Nd para " + nome3_aux + " como principal, eh igual a: \n Nd=" + Ndtotal2 );
	    //textoFinal = textoFinal + "\nA Nd para " + nome3_aux + " como principal, eh igual a: \n Nd=" + Ndtotal2;
		}
		
		
		
		
	    }
		
		}
	
		}

//-------------------------------------------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------------------------//

//A seguir, de maneira semelhante ao momento e normal, o código para a combinação 
//de cortantes está descrito. Porém, não é do escopo das situações em análise, utilizar as combinações de cortantes.

//-------------------------------------------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------------------------------------------------------------------------------------------------------------//
//CORTANTES - PARTE PERMANENTE

//varrendo a lista A e separando tudo o que tem momento permanente
for (int j=0; j < listaA.size(); j++) {
	
	acoes verAcoes = listaA.get(j);
	int mnv_aux;
	mnv_aux = verAcoes.getMnv();
	int tipo_aux; // 1-permanente // 2-variavel //
	tipo_aux = verAcoes.getTipo();
	
	if(mnv_aux == 3 && tipo_aux == 1) {
		
		int nome_aux = verAcoes.getNome();
		double valor_aux = verAcoes.getValor();
		
		acoesVp = new acoes(mnv_aux,nome_aux,valor_aux);
		acoesVp.preencher();
		listaVp.add(acoesVp);
		
		}
		
	}

//varrendo a lista Mp e calculaVdo o valor final da soma das parcelas de CORTANTES permanentes multiplicadas pelos seus gamas
double VdPermTot=0.0;
double valor_aux3=0.0;
double gama_aux3=0.0; // 1-permanente // 2-variavel //
String nome3=null;

for (int j=0; j < listaVp.size(); j++) {
	
	//acessaVdo o objeto da lista de CORTANTES permanentes
	acoesVp = listaVp.get(j);
	
	//pegaVdo variaveis
	valor_aux3 = acoesVp.getValor();	
	gama_aux3 = acoesVp.getGama();
	
	
	double VdPermParcial = acoesVp.CalculoVdpermanente(gama_aux3, valor_aux3);
	VdPermTot = VdPermTot + VdPermParcial;
	System.out.println("---------------------------------------------------------");
	acoesVp.imprimeVdpermanente(valor_aux3, gama_aux3);
	System.out.println("---------------------------------------------------------");
	/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
			+ acoesVp.imprimeVdpermanente(valor_aux3, gama_aux3) 
			+ "\n---------------------------------------------------------\n";*/
		}

//imprimindo a lista Vp somente para verificação da separação anterior

for(int i=0; i < listaVp.size(); i++) {
	acoesVp = listaVp.get(i);
	System.out.println("//////////////////////////////////////"); 
	System.out.println("Lista de CORTANTES permanentes"); 		
	acoesVp.relatorio();
	System.out.println("//////////////////////////////////////"); 
	/*textoFinal = textoFinal + "\n---------------------------------------------------------\n"
			+ "\n//////////////////////////////////////\n"
			+ "Lista de CORTANTES permanentes"
			+ "\n//////////////////////////////////////\n";	*/
}
		
//CHECKPOINT//
System.out.println("---------------------------------------------------------");
System.out.println("Vd permanente total:"+ VdPermTot); 
System.out.println("---------------------------------------------------------");
textoFinal = textoFinal + "\n---------------------------------------------------------\n"
	+ "Vd permanente total:"+ VdPermTot
	+ "\n---------------------------------------------------------\n";


//CORTANTES - PARTE VARIAVEL

//varreVdo a lista A e separaVdo tudo o que tem momento variável

for (int j=0; j < listaA.size(); j++) {
		
	acoes verAcoes = listaA.get(j);
	int mnv_aux;
	mnv_aux = verAcoes.getMnv();
	int tipo_aux; // 1-permanente // 2-variavel //
	tipo_aux = verAcoes.getTipo();
	
	if(mnv_aux == 3 && tipo_aux == 2) {
		
		int nome_aux = verAcoes.getNome();
		double valor_aux = verAcoes.getValor();
		
		acoesVv = new acoes(mnv_aux,nome_aux,valor_aux);
		acoesVv.preencher();
		listaVv.add(acoesVv);
		
		}
		
	}

//imprimiVdo a lista Mv somente para verificação da separação anterior

for(int i=0; i < listaVv.size(); i++) {
	acoesVv = listaVv.get(i);
	
	
	acoesVv.relatorio();
	
}


//varreVdo a lista Mv e calculaVdo o valor final da soma das parcelas de CORTANTES variaveis multiplicadas pelos seus gamas e phi's
double VdVariavTot=0.0;

for (int j=0; j < listaVv.size(); j++) {
	
	//acessaVdo o objeto da lista de CORTANTES variaveis
	acoesVv = listaVv.get(j);
	
	
	//pegaVdo variaveis para realizar os caclulos
	double valor_aux;
	valor_aux = acoesVv.getValor();
	double gama_aux; // 1-permanente // 2-variavel //
	gama_aux = acoesVv.getGama();
	int nome_aux = acoesVv.getNome();
	
	double VdVariavParcial = 0.0;
	
	VdVariavParcial = acoesVv.CalculoVdvariavelPermanente(gama_aux, valor_aux);
	VdVariavTot = 0.0;
	VdVariavTot = VdVariavTot + VdVariavParcial;
	
	System.out.println("---------------------------------------------------------");
	acoesVv.imprimeVdpermanente(valor_aux, gama_aux);
	System.out.println("---------------------------------------------------------");
	/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
			+ acoesVv.imprimeVdpermanente(valor_aux, gama_aux)
			+ "\n---------------------------------------------------------\n";
	*/
	//CHECKPOINT//
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("A parcela variavel que se comporta como principal eh " + VdVariavParcial );
	System.out.println("-------------------------------------------------------------------------------");
	textoFinal = textoFinal + "\n---------------------------------------------------------\n"
			+ "A parcela variavel que se comporta como principal eh " + VdVariavParcial 
			+ "\n---------------------------------------------------------\n";
	
	if(j>0) {
	for(int k=0; k<j; k++) {
		
		acoesVv = listaVv.get(k);
		double valor2_aux;
		valor2_aux = acoesVv.getValor();
		double gama2_aux; // 1-permanente // 2-variavel //
		gama2_aux = acoesVv.getGama();
		double phi2_aux; // 1-permanente // 2-variavel //
		phi2_aux = acoesVv.getPhi();
		
		VdVariavParcial = 0.0;
		
		VdVariavParcial = acoesVv.CalculoVdvariavel(gama2_aux, valor2_aux, phi2_aux);
		
		
		System.out.println("---------------------------------------------------------");
		acoesVv.imprimeVdvariavel(valor2_aux, gama2_aux, phi2_aux);
		System.out.println("---------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ acoesVv.imprimeVdvariavel(valor2_aux, gama2_aux, phi2_aux)
				+ "\n---------------------------------------------------------\n";
		*/
		//CHECKPOINT//
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas antes da considerada como principal. loop: " + k  + "- " + VdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n"
				+ "As parcelas antes da considerada como principal. loop: " + k  + "- " + VdVariavParcial 
				+ "\n---------------------------------------------------------\n";
		*/
		VdVariavTot = VdVariavTot + VdVariavParcial;
		
	}
	}
	
	if(j<(listaVv.size()-1)) {
for(int l=(j+1); l<listaVv.size(); l++) {
		
		acoesVv = listaVv.get(l);
		double valor2_aux;
		valor2_aux = acoesVv.getValor();
		double gama2_aux; // 1-permanente // 2-variavel //
		gama2_aux = acoesVv.getGama();
		double phi2_aux; // 1-permanente // 2-variavel //
		phi2_aux = acoesVv.getPhi();
		
		VdVariavParcial = 0.0;
		VdVariavParcial = acoesVv.CalculoVdvariavel(gama2_aux, valor2_aux, phi2_aux);
		
		System.out.println("---------------------------------------------------------");
		acoesVv.imprimeVdvariavel(valor2_aux, gama2_aux, phi2_aux);
		System.out.println("---------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ acoesVv.imprimeVdvariavel(valor2_aux, gama2_aux, phi2_aux)
				+ "\n---------------------------------------------------------\n";
		*/
		//CHECKPOINT
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("As parcelas depois da considerada como principal. loop: " + l + "- "  + VdVariavParcial );
		System.out.println("-------------------------------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n"
				+ "As parcelas depois da considerada como principal. loop: " + l + "- "  + VdVariavParcial
				+ "\n---------------------------------------------------------\n";*/
		VdVariavTot = VdVariavTot + VdVariavParcial;
		
	}
	}

	
	
if(nome_aux == 1) {
	nome3 = "Peso proprio";
}

if(nome_aux == 2) {
	nome3 = "Retracao";
}

if(nome_aux == 3) {
	nome3 = "Sobrecarga";
}

if(nome_aux == 4) {
	nome3 = "Temperatura";
}

if(nome_aux == 5) {
	nome3 = "Vento";
}

	
double Vdtotal = 0.0; 
Vdtotal = VdVariavTot + VdPermTot;


//CHECKPOINT
System.out.println("A Vd para " + nome3 + " como principal, eh igual a: \n Vd=" + Vdtotal );
textoFinal = textoFinal + "\n---------------------------------------------------------\n"
		+ "A Vd para " + nome3 + " como principal, eh igual a: \n Vd=" + Vdtotal
		+ "\n---------------------------------------------------------\n";

//calculaVdo o Vd para os casos em que a variavel principal não tem normal na direcao


for (int n=0; n < listaA.size(); n++) {
	
	
	buscaVariaveis = listaA.get(n);
	
	int nome3_aux = buscaVariaveis.getNome();
	int tipo3_aux;
	tipo3_aux = buscaVariaveis.getTipo();
	int mnv3_aux;
	mnv3_aux = buscaVariaveis.getMnv();
	
	if(tipo3_aux == 2 && mnv3_aux != 3)
		
	{	
		double valor_auxiliar = 0;
		double gama_auxiliar = 0;
	    double phi_auxiliar = 0;
	    
		for (int t=0; t<listaVv.size();t++) {
		listaVv.get(t);
		
		valor_auxiliar = acoesVv.getValor();
		gama_auxiliar = acoesVv.getGama();
	    phi_auxiliar = acoesVv.getPhi();
			
	    
	    if(nome3_aux == 1) {
	    	nome3 = "Peso proprio";
	    }

	    if(nome3_aux == 2) {
	    	nome3 = "Retracao";
	    }

	    if(nome3_aux == 3) {
	    	nome3 = "Sobrecarga";
	    }

	    if(nome3_aux == 4) {
	    	nome3 = "Temperatura";
	    }

	    if(nome3_aux == 5) {
	    	nome3 = "Vento";
	    }

	    
	    System.out.println("---------------------------------------------------------");
		buscaVariaveis.imprimeVdvariavel(valor_auxiliar, gama_auxiliar, phi_auxiliar);
		System.out.println("---------------------------------------------------------");
		/*textoFinal = textoFinal + "\n---------------------------------------------------------\n" 
				+ buscaVariaveis.imprimeVdvariavel(valor_auxiliar, gama_auxiliar, phi_auxiliar)
				+ "\n---------------------------------------------------------\n";
	    */
	    double Vdtotal2 = VdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
	    System.out.println("A Vd para " + nome3 + " como principal, eh igual a: \n Vd=" + Vdtotal2 );
	    textoFinal = textoFinal + "\n---------------------------------------------------------\n"
	    			+ "A Vd para " + nome3 + " como principal, eh igual a: \n Vd=" + Vdtotal2
	    			+ "\n---------------------------------------------------------\n";
		}
		
		
	    }
		
		}
	
		}

		
	



	}
	
}
	






	


