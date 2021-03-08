import java.util.Scanner;
import java.util.ArrayList;

public class combinacoes {
	//String com tudo o que se quer imprimir no painel
	String textoFinal = "\n\n ----------------------------------------------- \n RELATÓRIO \n ----------------------------------------------- \n";
	 
	public String getRelatorio() {
		 return textoFinal;
	 }
	
	public combinacoes(ArrayList<acoes> lista) {
		
		//lista geral
		ArrayList<acoes> listaA = lista;
		acoes novaAcao = null;
		
		
		//listas de normais
		
		//lista de normais-permanentes
		ArrayList<acoes> listaNp = new ArrayList<acoes>(); 
		acoes acoesNp = null;
		
		//lista de normais-variaveis
		ArrayList<acoes> listaNv = new ArrayList<acoes>(); 
		acoes acoesNv = null;
		
//listas de momentos
		
		//lista de momentos-permanentes
		ArrayList<acoes> listaMp = new ArrayList<acoes>(); 
		acoes acoesMp = null;
				
		//lista de momentos-variaveis
		ArrayList<acoes> listaMv = new ArrayList<acoes>(); 
		acoes acoesMv = null;
		
//listas de cortantes
		
		//lista de cortante-permanentes
		ArrayList<acoes> listaVp = new ArrayList<acoes>(); 
		acoes acoesVp = null;
				
		//lista de cortantes-variaveis
		ArrayList<acoes> listaVv = new ArrayList<acoes>(); 
		acoes acoesVv = null;

//listas para separar acoes de sobrecarga, temperatura e vento:
		
		ArrayList<acoes> listaQ = new ArrayList<acoes>();
		acoes Sobrecarga = null;
		
		ArrayList<acoes> listaT = new ArrayList<acoes>();
		acoes temperatura = null;
		
		ArrayList<acoes> listaW = new ArrayList<acoes>();
		acoes vento = null;
				
		
		
		int nomeA;
		double valorA;
		int mnvA;
		int adicionarMais = 1;

		/*O for a seguir varre a lista de todas as ações (listaA) e separa listas de normais permanentes (listaNp), normais variaveis (listaNv),
		momentos permanentes (listaMp), momentos variáveis (listaMv), cortantes permanentes (listaVp) e cortantes variáveis (listaVv)*/

		for (int j=0; j < listaA.size(); j++) {
				
			//pegar o objeto da listaA na posição de j através do método get inerente ao arraylist
			acoes verAcoes = listaA.get(j);
			
			/*através de métodos get que retornam os valores das respectivas variáveis se obtém os parâmetros mnv, tipo, nome e 
			grandeza do objeto na posição j da listaA*/
			
			
			int mnv_aux = verAcoes.getMnv(); // 1-momento // 2-normal // 3-cortante
			int tipo_aux = verAcoes.getTipo(); // 1-permanente // 2-variavel 
			int nome_aux = verAcoes.getNome();
			double valor_aux = verAcoes.getValor();
			
			/* A sequência de if's a seguir utiliza o parâmetro mnv e tipo para classificar as ações permanentes em listas específicas de normais, momentos e 
			 cortantes.
			 */
			
				// verificar se a ação em análise é normal e permanente
				if(mnv_aux == 2 && tipo_aux == 1) {
					
					acoesNp = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesNp.preencher();
					listaNp.add(acoesNp);	
				
				}
				
				// verificar se a ação em análise é momento e permanente
				if(mnv_aux == 1 && tipo_aux == 1) {
					
					acoesMp = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesMp.preencher();
					listaMp.add(acoesMp);
					
				}
				
				// verificar se a ação em análise é cortante e permanente
				if(mnv_aux == 3 && tipo_aux == 1) {
					
					acoesVp = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesVp.preencher();
					listaVp.add(acoesVp);
					
				}
				
				// verificar se a ação em análise é normal e variável
				if(mnv_aux == 2 && tipo_aux == 2) {
					
					acoesNv = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesNv.preencher();
					listaNv.add(acoesNv);	
				
				}
				
				// verificar se a ação em análise é momento e variável
				if(mnv_aux == 1 && tipo_aux == 2) {
					
					acoesMv = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesMv.preencher();
					listaMv.add(acoesMv);
					
				}
				
				// verificar se a ação em análise é cortante e variável
				if(mnv_aux == 3 && tipo_aux == 2) {
					
					acoesVv = new acoes(mnv_aux,nome_aux,valor_aux);
					acoesVv.preencher();
					listaVv.add(acoesVv);
					
				}
				
		}

		
		//CALCULO DA PARTE PERMANENTE

		/*Varre-se então os três arraylists de ações permanentes: listaNp, listaMp e listaVp e realiza-se a operação multiplicar, para cada passagem do for, 
		o gama*valor de cada ação acessada pelo for. Os resultados de todas as repetições do laço são somados em uma variável*/
		
		//NORMAL
		double NdPermTot=0.0;
		for (int j=0; j < listaNp.size(); j++) {
			
			
			//acessando o objeto da lista de normais permanentes
			acoesNp = listaNp.get(j);
			
			//pegando dados do objeto acessado
			
			double valor_aux1 = acoesNp.getValor();	
			double gama_aux1 = acoesNp.getGama();
			
			//calculando o gama*valor do objeto acessado
			double NdPermParcial = acoesNp.CalculoPermanente(gama_aux1, valor_aux1);
			
			//compondo a soma de todos os resultados
			NdPermTot = NdPermTot + NdPermParcial;
			
			
	  }	
		
		//MOMENTO
		double MdPermTot=0.0;
		for (int j=0; j < listaMp.size(); j++) {
			
			
			//acessando o objeto da lista de normais permanentes
			acoesMp = listaMp.get(j);
			
			//pegando dados do objeto acessado
			
			double valor_aux1 = acoesMp.getValor();	
			double gama_aux1 = acoesMp.getGama();
			
			//calculando o gama*valor do objeto acessado
			double MdPermParcial = acoesMp.CalculoPermanente(gama_aux1, valor_aux1);
			
			//compondo a soma de todos os resultados
			MdPermTot = MdPermTot + MdPermParcial;
			
			
	  }	
		
		//CORTANTE
		double VdPermTot=0.0;
		for (int j=0; j < listaVp.size(); j++) {
			
			
			//acessando o objeto da lista de normais permanentes
			acoesVp = listaVp.get(j);
			
			//pegando dados do objeto acessado
			
			double valor_aux1 = acoesVp.getValor();	
			double gama_aux1 = acoesVp.getGama();
			
			//calculando o gama*valor do objeto acessado
			double VdPermParcial = acoesVp.CalculoPermanente(gama_aux1, valor_aux1);
			
			//compondo a soma de todos os resultados
			VdPermTot = VdPermTot + VdPermParcial;			
			
			
			
	  }	
		
		
	   //CALCULO PARTE VARIÁVEL
		
		/*Varre-se então os três arraylists de ações variáveis: listaNv, listaMv e listaVv e realiza-se a operação multiplicar, para cada passagem do for, 
		o gama*valor, pois a ação variável em análise é considerada como permanente. Dentro do for lê-se as ações variáveis antes e depois da considerada como principal
		e essas sim realizamos a multiplicação considerando o phi: gama*valor*phi. Soma-se tudo em uma variável e depois acrescenta-se o resultado das somas das permanentes */
		
		//NORMAIS VARIÁVEIS
		
		for (int j=0; j < listaNv.size(); j++) {
			
			//acessando o objeto da lista de normais variaveis que se comportará como principal nesta passagem do for
			acoesNv = listaNv.get(j);
			
			
			//pegando variaveis para realizar os calculos
			double valor_aux = acoesNv.getValor();
			double gama_aux = acoesNv.getGama();
			int nome_aux = acoesNv.getNome(); // É ESSE O NOME QUE VAI SER IMPRESSO NA TELA DIZENDO "CALCULO DE X PARA NOME COMO PRINCIPAL, SÓ USADO NO FINAL"
			
			double NdVariavParcial = 0.0;
			
			NdVariavParcial = acoesNv.CalculoPermanente(gama_aux, valor_aux);
			double NdVariavTot= 0.0;
			NdVariavTot = NdVariavTot + NdVariavParcial;
			
			
				//se houverem acoes variáveis ANTES da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
				if(j>0) {
				
			
						for(int k=0; k<j; k++) {
				
							//pegando um objeto da lista de normais variáveis (listaNv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
							acoesNv = listaNv.get(k);
					
							//do objeto selecionado pelo for pegam-se as seguintes variáveis
							double valor2_aux = acoesNv.getValor();
							double gama2_aux = acoesNv.getGama(); 
							double phi2_aux = acoesNv.getPhi();
				
							//zera-se a NdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
							NdVariavParcial = 0.0;
							
							//calcula-se a NdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
							NdVariavParcial = acoesNv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
				
							//acrescenta-se o novo resultado no total
							NdVariavTot = NdVariavTot + NdVariavParcial;
				
						}
						
				}
				
				
				//se houverem acoes variáveis DEPOIS da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
				if(j<(listaNv.size()-1)) {
					
						for(int l=(j+1); l<listaNv.size(); l++) {
							
							//pegando um objeto da lista de normais variáveis (listaNv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
							acoesNv = listaNv.get(l);
							
							//do objeto selecionado pelo for pegam-se as seguintes variáveis
							double valor2_aux = acoesNv.getValor();
							double gama2_aux = acoesNv.getGama(); 
							double phi2_aux = acoesNv.getPhi();
							
							//zera-se a NdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
							NdVariavParcial = 0.0;
							
							//calcula-se a NdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
							NdVariavParcial = acoesNv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
							
							//acrescenta-se o novo resultado no total
							NdVariavTot = NdVariavTot + NdVariavParcial;
							
						}
						
				}
				
				//para o nome da acao nao ficar em formato numerico o bloco de codigo a seguir é realizado atribuindo a String nome o nome da acao correspondente ao número que a identifica
				String nome=null;
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

				//Cria-se uma variável que receberá a soma da parte permanente e variável e será impressa juntamente com o nome da ação que é tida como principal	
				double Ndtotal = 0.0; 
				Ndtotal = NdVariavTot + NdPermTot;


				//Resultado final
				System.out.println("A Nd para " + nome + " como principal, eh igual a: \n Nd= " + Ndtotal );
				textoFinal = textoFinal + "\n\n A Nd para " + nome + " como principal, eh igual a: \n Nd= " + Ndtotal;
		}//fim da parte de normais
		
		//MOMENTOS VARIÁVEIS
						
				for (int j=0; j < listaMv.size(); j++) {
							
							//acessando o objeto da lista de momentos variaveis que se comportará como principal nesta passagem do for
							acoesMv = listaMv.get(j);
							
							
							//pegando variaveis para realizar os calculos
							double valor_aux = acoesMv.getValor();
							double gama_aux = acoesMv.getGama();
							int nome_aux = acoesMv.getNome(); // É ESSE O NOME QUE VAI SER IMPRESSO NA TELA DIZENDO "CALCULO DE X PARA NOME COMO PRINCIPAL, SÓ USADO NO FINAL"
							
							double MdVariavParcial = 0.0;
							
							MdVariavParcial = acoesMv.CalculoPermanente(gama_aux, valor_aux);
							double MdVariavTot= 0.0;
							MdVariavTot = MdVariavTot + MdVariavParcial;
							
							
								//se houverem acoes variáveis ANTES da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
								if(j>0) {
								
							
										for(int k=0; k<j; k++) {
								
											//pegando um objeto da lista de momentos variáveis (listaMv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
											acoesMv = listaMv.get(k);
									
											//do objeto selecionado pelo for pegam-se as seguintes variáveis
											double valor2_aux = acoesMv.getValor();
											double gama2_aux = acoesMv.getGama(); 
											double phi2_aux = acoesMv.getPhi();
								
											//zera-se a MdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
											MdVariavParcial = 0.0;
											
											//calcula-se a MdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
											MdVariavParcial = acoesMv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
								
											//acrescenta-se o novo resultado no total
											MdVariavTot = MdVariavTot + MdVariavParcial;
								
										}
										
								}
								
								
								//se houverem acoes variáveis DEPOIS da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
								if(j<(listaMv.size()-1)) {
									
										for(int l=(j+1); l<listaMv.size(); l++) {
											
											//pegando um objeto da lista de momentos variáveis (listaMv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
											acoesMv = listaMv.get(l);
											
											//do objeto selecionado pelo for pegam-se as seguintes variáveis
											double valor2_aux = acoesMv.getValor();
											double gama2_aux = acoesMv.getGama(); 
											double phi2_aux = acoesMv.getPhi();
											
											//zera-se a MdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
											MdVariavParcial = 0.0;
											
											//calcula-se a MdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
											MdVariavParcial = acoesMv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
											
											//acrescenta-se o novo resultado no total
											MdVariavTot = MdVariavTot + MdVariavParcial;
											
										}
										
								}
								
								//para o nome da acao nao ficar em formato numerico o bloco de codigo a seguir é realizado atribuindo a String nome o nome da acao correspondente ao número que a identifica
								String nome=null;
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
		
								//Cria-se uma variável que receberá a soma da parte permanente e variável e será impressa juntamente com o nome da ação que é tida como principal	
								double Mdtotal = 0.0; 
								Mdtotal = MdVariavTot + MdPermTot;
		
		
								//Resultado final
								System.out.println("A Md para " + nome + " como principal, eh igual a: \n Md= " + Mdtotal );
								textoFinal = textoFinal + "\n\nA Md para " + nome + " como principal, eh igual a: \n Md= " + Mdtotal;	
						} //fim da parte de momento
		
			//CORTANTES VARIÁVEIS
							
					    for (int j=0; j < listaVv.size(); j++) {
								
								//acessando o objeto da lista de cortantes variaveis que se comportará como principal nesta passagem do for
								acoesVv = listaVv.get(j);
								
								
								//pegando variaveis para realizar os calculos
								double valor_aux = acoesVv.getValor();
								double gama_aux = acoesVv.getGama();
								int nome_aux = acoesVv.getNome(); // É ESSE O NOME QUE VAI SER IMPRESSO NA TELA DIZENDO "CALCULO DE X PARA NOME COMO PRINCIPAL, SÓ USADO NO FINAL"
								
								double VdVariavParcial = 0.0;
								
								VdVariavParcial = acoesVv.CalculoPermanente(gama_aux, valor_aux);
								double VdVariavTot= 0.0;
								VdVariavTot = VdVariavTot + VdVariavParcial;
								
								
									//se houverem acoes variáveis ANTES da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
									if(j>0) {
									
								
											for(int k=0; k<j; k++) {
									
												//pegando um objeto da lista de cortantes variáveis (listaVv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
												acoesVv = listaVv.get(k);
										
												//do objeto selecionado pelo for pegam-se as seguintes variáveis
												double valor2_aux = acoesVv.getValor();
												double gama2_aux = acoesVv.getGama(); 
												double phi2_aux = acoesVv.getPhi();
									
												//zera-se a VdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
												VdVariavParcial = 0.0;
												
												//calcula-se a VdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
												VdVariavParcial = acoesVv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
									
												//acrescenta-se o novo resultado no total
												VdVariavTot = VdVariavTot + VdVariavParcial;
									
											}
											
									}
									
									
									//se houverem acoes variáveis DEPOIS da acao em análise no for maior (que é considerada a ação variável como principal) acessamos elas através do if+for a seguir
									if(j<(listaVv.size()-1)) {
										
											for(int l=(j+1); l<listaVv.size(); l++) {
												
												//pegando um objeto da lista de cortantes variáveis (listaVv) que esteja antes do objeto da mesma lista (for maior) considerado como permanente
												acoesVv = listaVv.get(l);
												
												//do objeto selecionado pelo for pegam-se as seguintes variáveis
												double valor2_aux = acoesVv.getValor();
												double gama2_aux = acoesVv.getGama(); 
												double phi2_aux = acoesVv.getPhi();
												
												//zera-se a VdVariavParcial, pois já foi utilizada anteriormente para armazenar o valor da acao variavel que se comporta como permanente
												VdVariavParcial = 0.0;
												
												//calcula-se a VdVariavelParcial para o objeto selecionado através do método a seguir, que multiplica gama*valor*phi
												VdVariavParcial = acoesVv.CalculoVariavel(gama2_aux, valor2_aux, phi2_aux);
												
												//acrescenta-se o novo resultado no total
												VdVariavTot = VdVariavTot + VdVariavParcial;
												
											}
											
									}
									
									//para o nome da acao nao ficar em formato numerico o bloco de codigo a seguir é realizado atribuindo a String nome o nome da acao correspondente ao número que a identifica
									String nome=null;
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
			
									//Cria-se uma variável que receberá a soma da parte permanente e variável e será impressa juntamente com o nome da ação que é tida como principal	
									double Vdtotal = 0.0; 
									Vdtotal = VdVariavTot + VdPermTot;
			
			
									//Resultado final
									System.out.println("A Vd para " + nome + " como principal, eh igual a: \n Vd= " + Vdtotal );
									textoFinal = textoFinal + "\n\nA Vd para " + nome + " como principal, eh igual a: \n Vd= " + Vdtotal;
							}
		
					    /*E se você acha que acabou o cálculo da Md você está muito enganado(a). Mesmo quando não temos momentoss para uma ação considerada como principal, podemos
						calcular a Md para aquela acao variável considerada como principal, o único porém é que todas as variáveis considerarão o phi em suas multiplicações*/
						
						//Varrendo toda a listaA para ver se tenho alguma ação variável que não possui normal, momento ou cortante
						
						for (int p=0; p < listaA.size(); p++) {
							
								//acessando, pelo método get, os objetos da lista A percorridos pelo for
								novaAcao = listaA.get(p);
								
								//Coletando nome, tipo e mnv do objeto em foco
								int nome3_aux = novaAcao.getNome();
								int mnv3_aux = novaAcao.getMnv();
								double valor3_aux = novaAcao.getNome();
								
								
								
						
								//criando sublista das ações da sobrecarga
								if(nome3_aux==3) {
									
									Sobrecarga = new acoes(mnv3_aux,nome3_aux ,valor3_aux);
									Sobrecarga.preencher();
									listaQ.add(Sobrecarga);
									
								}
								
								//criando sublista das ações da temperatura
								if(nome3_aux==4) {
									
									temperatura = new acoes(mnv3_aux,nome3_aux ,valor3_aux);
									temperatura.preencher();
									listaT.add(temperatura);
									
								}
								
								//criando sublista das ações do vento
								if(nome3_aux==5) {
									
									vento = new acoes(mnv3_aux,nome3_aux ,valor3_aux);
									vento.preencher();
									listaW.add(vento);
									
								}
								
						}//fecha o for que varre toda a listaA
								
								
								//variaveis auxiliares
								int m = 0;
								int n = 0;
								int v = 0;
								
								//varrendo a lista de acoes de sobrecarga e entendendo se falta alguma(mnv)
								for (int z=0; z < listaQ.size(); z++) {
									
										//acessando, pelo método get, os objetos da lista A percorridos pelo for
										Sobrecarga = listaQ.get(z);
										int mnv_aux4 = Sobrecarga.getMnv();

										
										if(mnv_aux4 == 1) 								
										{
											 m = 1;
										}
									
										if(mnv_aux4 == 2) 								
										{
											 n = 1;
										}
										
										if(mnv_aux4 == 3) 								
										{
											 v = 1;
										}
									
								}	
									
									if(m==0) {
										 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
									    double Mdtotal2 = 0.0;
									    
										for (int t=0; t<listaMv.size();t++) {
											
												//pegando o objeto na posição t da listaMv	
												listaMv.get(t);
											
												//pegando valor, gama e phi do objeto da listaMv em questão
												double valor_auxiliar = acoesMv.getValor();
												double gama_auxiliar = acoesMv.getGama();
											    double phi_auxiliar = acoesMv.getPhi();
											    
						
											    //atribuindo resultado parcial à soma total
											    Mdtotal2 = MdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
											    
									    
										} //fecha o for que varre todas as acoes variaveis
										
										
										System.out.println("A Md para Sobrecarga como principal, eh igual a: \n Md=" + Mdtotal2 );
										textoFinal = textoFinal + "\n\nA Md para Sobrecarga como principal, eh igual a: \n Md=" + Mdtotal2;
									}
									
									if(n==0) {
										 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
									    double Ndtotal2 = 0.0;
									    
										for (int t=0; t<listaNv.size();t++) {
											
												//pegando o objeto na posição t da listaMv	
												listaNv.get(t);
											
												//pegando valor, gama e phi do objeto da listaMv em questão
												double valor_auxiliar = acoesNv.getValor();
												double gama_auxiliar = acoesNv.getGama();
											    double phi_auxiliar = acoesNv.getPhi();
											    
						
											    //atribuindo resultado parcial à soma total
											    Ndtotal2 = NdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
											    
									    
										} //fecha o for que varre todas as acoes variaveis
										
										
										System.out.println("A Nd para Sobrecarga como principal, eh igual a: \n Nd=" + Ndtotal2 );
										textoFinal = textoFinal + "\n\nA Nd para Sobrecarga como principal, eh igual a: \n Nd=" + Ndtotal2;
									}
							
								
									if(v==0) {
										 //varrendo todas as acoes cortantes-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
									    double Vdtotal2 = 0.0;
									    
										for (int t=0; t<listaVv.size();t++) {
											
												//pegando o objeto na posição t da listaVv	
												listaVv.get(t);
											
												//pegando valor, gama e phi do objeto da listaMv em questão
												double valor_auxiliar = acoesVv.getValor();
												double gama_auxiliar = acoesVv.getGama();
											    double phi_auxiliar = acoesVv.getPhi();
											    
						
											    //atribuindo resultado parcial à soma total
											    Vdtotal2 = VdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
											    
									    
										} //fecha o for que varre todas as acoes variaveis
										
										
										System.out.println("A Vd para Sobrecarga como principal, eh igual a: \n Vd=" + Vdtotal2 );
										textoFinal = textoFinal + "\n\nA Vd para Sobrecarga como principal, eh igual a: \n Vd=" + Vdtotal2;
									}
						
									
							//Temperatura
									
									//variaveis auxiliares
									int m1 = 0;
									int n1 = 0;
									int v1 = 0;
									
									//varrendo a lista de acoes de sobrecarga e entendendo se falta alguma(mnv)
									for (int z=0; z < listaT.size(); z++) {
										
											//acessando, pelo método get, os objetos da lista A percorridos pelo for
											temperatura = listaT.get(z);
											int mnv_aux4 = temperatura.getMnv();

											
											if(mnv_aux4 == 1) 								
											{
												 m1 = 1;
											}
										
											if(mnv_aux4 == 2) 								
											{
												 n1 = 1;
											}
											
											if(mnv_aux4 == 3) 								
											{
												 v1 = 1;
											}
										
									}	
										
										if(m1==0) {
											 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
										    double Mdtotal2 = 0.0;
										    
											for (int t=0; t<listaMv.size();t++) {
												
													//pegando o objeto na posição t da listaMv	
													listaMv.get(t);
												
													//pegando valor, gama e phi do objeto da listaMv em questão
													double valor_auxiliar = acoesMv.getValor();
													double gama_auxiliar = acoesMv.getGama();
												    double phi_auxiliar = acoesMv.getPhi();
												    
							
												    //atribuindo resultado parcial à soma total
												    Mdtotal2 = MdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
												    
										    
											} //fecha o for que varre todas as acoes variaveis
											
											
											System.out.println("A Md para Temperatura como principal, eh igual a: \n Md=" + Mdtotal2 );
											textoFinal = textoFinal + "\n\nA Md para Temperatura como principal, eh igual a: \n Md=" + Mdtotal2;
										}
										
										if(n1==0) {
											 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
										    double Ndtotal2 = 0.0;
										    
											for (int t=0; t<listaNv.size();t++) {
												
													//pegando o objeto na posição t da listaMv	
													listaNv.get(t);
												
													//pegando valor, gama e phi do objeto da listaMv em questão
													double valor_auxiliar = acoesNv.getValor();
													double gama_auxiliar = acoesNv.getGama();
												    double phi_auxiliar = acoesNv.getPhi();
												    
							
												    //atribuindo resultado parcial à soma total
												    Ndtotal2 = NdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
												    
										    
											} //fecha o for que varre todas as acoes variaveis
											
											
											System.out.println("A Nd para temperatura como principal, eh igual a: \n Nd=" + Ndtotal2 );
											textoFinal = textoFinal + "\n\nA Nd para temperatura como principal, eh igual a: \n Nd=" + Ndtotal2;
										}
								
									
										if(v1==0) {
											 //varrendo todas as acoes cortantes-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
										    double Vdtotal2 = 0.0;
										    
											for (int t=0; t<listaVv.size();t++) {
												
													//pegando o objeto na posição t da listaVv	
													listaVv.get(t);
												
													//pegando valor, gama e phi do objeto da listaMv em questão
													double valor_auxiliar = acoesVv.getValor();
													double gama_auxiliar = acoesVv.getGama();
												    double phi_auxiliar = acoesVv.getPhi();
												    
							
												    //atribuindo resultado parcial à soma total
												    Vdtotal2 = VdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
												    
										    
											} //fecha o for que varre todas as acoes variaveis
											
											
											System.out.println("A Vd para temperatura como principal, eh igual a: \n Vd=" + Vdtotal2 );
											textoFinal = textoFinal + "\n\nA Vd para temperatura como principal, eh igual a: \n Vd=" + Vdtotal2;
										}
						
						
										//Vento
										
										//variaveis auxiliares
										int m2 = 0;
										int n2 = 0;
										int v2 = 0;
										
										//varrendo a lista de acoes de sobrecarga e entendendo se falta alguma(mnv)
										for (int z=0; z < listaW.size(); z++) {
											
												//acessando, pelo método get, os objetos da lista A percorridos pelo for
												vento = listaW.get(z);
												int mnv_aux4 = vento.getMnv();

												
												if(mnv_aux4 == 1) 								
												{
													 m2 = 1;
												}
											
												if(mnv_aux4 == 2) 								
												{
													 n2 = 1;
												}
												
												if(mnv_aux4 == 3) 								
												{
													 v2 = 1;
												}
											
										}	
											
											if(m2==0) {
												 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
											    double Mdtotal2 = 0.0;
											    
												for (int t=0; t<listaMv.size();t++) {
													
														//pegando o objeto na posição t da listaMv	
														listaMv.get(t);
													
														//pegando valor, gama e phi do objeto da listaMv em questão
														double valor_auxiliar = acoesMv.getValor();
														double gama_auxiliar = acoesMv.getGama();
													    double phi_auxiliar = acoesMv.getPhi();
													    
								
													    //atribuindo resultado parcial à soma total
													    Mdtotal2 = MdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
													    
											    
												} //fecha o for que varre todas as acoes variaveis
												
												
												System.out.println("A Md para Vento como principal, eh igual a: \n Md=" + Mdtotal2 );
												textoFinal = textoFinal + "\n\nA Md para Vento como principal, eh igual a: \n Md=" + Mdtotal2;
											}
											
											if(n2==0) {
												 //varrendo todas as acoes momentos-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
											    double Ndtotal2 = 0.0;
											    
												for (int t=0; t<listaNv.size();t++) {
													
														//pegando o objeto na posição t da listaMv	
														listaNv.get(t);
													
														//pegando valor, gama e phi do objeto da listaMv em questão
														double valor_auxiliar = acoesNv.getValor();
														double gama_auxiliar = acoesNv.getGama();
													    double phi_auxiliar = acoesNv.getPhi();
													    
								
													    //atribuindo resultado parcial à soma total
													    Ndtotal2 = NdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
													    
											    
												} //fecha o for que varre todas as acoes variaveis
												
												
												System.out.println("A Nd para vento como principal, eh igual a: \n Nd=" + Ndtotal2 );
												textoFinal = textoFinal + "\n\nA Nd para vento como principal, eh igual a: \n Nd=" + Ndtotal2;
											}
									
										
											if(v2==0) {
												 //varrendo todas as acoes cortantes-variaveis e submetendo elas ao CalculoVariaveis pois nenhuma será considerada como permanente 
											    double Vdtotal2 = 0.0;
											    
												for (int t=0; t<listaVv.size();t++) {
													
														//pegando o objeto na posição t da listaVv	
														listaVv.get(t);
													
														//pegando valor, gama e phi do objeto da listaMv em questão
														double valor_auxiliar = acoesVv.getValor();
														double gama_auxiliar = acoesVv.getGama();
													    double phi_auxiliar = acoesVv.getPhi();
													    
								
													    //atribuindo resultado parcial à soma total
													    Vdtotal2 = VdPermTot + (gama_auxiliar * valor_auxiliar * phi_auxiliar);	
													    
											    
												} //fecha o for que varre todas as acoes variaveis
												
												
												System.out.println("A Vd para vento como principal, eh igual a: \n Vd=" + Vdtotal2 );
												textoFinal = textoFinal + "\n\nA Vd para vento como principal, eh igual a: \n Vd=" + Vdtotal2;
											}


	}
	
}
	






	


