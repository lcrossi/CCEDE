public class acoes {
	
	/*variables*/
	
	int nome; // 1-peso proprio // 2-retracao // 3-sobrecarga // 4-temperatura // 5-vento //
    int mnv; // 1-momento // 2-normal // 3-cortante //
    double valor;
    int tipo; // 1-permanente // 2-variavel //
    double phi; 
    double gama;
    double Permanente;
    double Variavel;
    
    /*double NdPermParcial;
    double NdVarParcial;
    double MdPermParcial;
    double MdVarParcial;
    double VdPermParcial;
    double VdVarParcial;*/
    
    
    /* Constructor */
    
    public acoes(){
	  	
		this(0,0, 0);
	    }
    
    public acoes(int mnv, int nome, double valor){
    	   
        this.mnv = mnv;
        this.nome = nome;
        this.valor = valor;

    }
    
    /* methods */
    
   //gets 
   public int getNome(){
	  int nome = this.nome;
	  return nome;
	  
   }
   
   public int getMnv(){
		  int mnv = this.mnv;
		  return mnv;
		  
	   }
   
   public int getTipo(){
		 int tipo = this.tipo;
		  return tipo;
		  
	   }
   
   public double getValor(){
		 double valor = this.valor;
		  return valor;
		  
	   }
   
   public double getPhi(){
		 double phi = this.phi;
		  return phi;
		  
	   }
   
   public double getGama(){
		 double gama = this.gama;
		  return gama;
		  
	   }
   
   
   
   
   //fim dos gets
    
   public void preencher(){
    	
	   if (nome == 1)
		{ 
		   
		   tipo = 1;
		   gama=1.4;
           phi = 1.0;
           
		} else
		
		if (nome == 2)
			
		{
			
	        tipo = 1;
	        gama = 1.2;
	        this.phi = 1.0;
	        
		} else
			
       if (nome == 3){

        	this.tipo = 2;
       	    this.gama = 1.4;
       	    this.phi = 0.7;
       	    
       	} else
       
       if (nome == 4)
       {

    	    this.tipo = 2;
    	    this.gama = 1.2;
       	    this.phi = 0.6;
       	    
	    } else
		   
	    if (nome == 5)
	    {

	    	 this.tipo = 2;
	    	 this.gama = 1.4;
	    	 this.phi = 0.6;
		 }
	   
    }
   
   
   public void relatorio() {
	   
	   	 System.out.println("---------------------------------------------------- \n");
		 System.out.println("categoria:" + this.nome +  "\n");
		 System.out.println("valor:" + this.valor +  "\n");
		 System.out.println("tipo:" + this.tipo +  "\n");
		 System.out.println("phi:" + this.phi +  "\n");
		 System.out.println("gama:" + this.gama +  "\n");
		}
   
 //metodos de calculo 
   
   public double CalculoPermanente(double gama, double valor){
		 
		
		 this.Permanente = gama*valor;
		 	
		 
		 return Permanente;
	 }
   
   public double CalculoVariavel(double gama, double valor, double phi){
		 
		
		 this.Variavel = gama*valor*phi;
		 	
		 
		 return Variavel;
	 }
   
  /* 
 //NORMAIS
	 
	 public double CalculoNdpermanente(double gama, double valor){
		 
		 if(this.mnv == 2 && this.tipo == 1) {
			 this.NdPermParcial = gama*valor;
		 }	
		 
		 return NdPermParcial;
	 }
	 
 public double CalculoNdvariavelPermanente(double gama, double valor){
		 
		 if(this.mnv == 2 && this.tipo == 2) {
			 this.NdPermParcial = gama*valor;
		 }	
		 
		 return NdPermParcial;
	 }
	 
public double CalculoNdvariavel(double gama, double valor, double phi){
		 
	 if(this.mnv == 2 && this.tipo == 2  ) {
		 this.NdVarParcial = (this.gama)*(this.valor)*(this.phi);
	 }		
		 
		 return NdVarParcial;
	 }
	 

	 
	 	
	 	
//MOMENTOS

	 	
	 	 public double CalculoMdpermanente(double gama, double valor){
			 
			 if(this.mnv == 1 && this.tipo == 1) {
				 this.MdPermParcial = gama*valor;
			 }	
			 
			 return MdPermParcial;
		 }
		 
	 public double CalculoMdvariavelPermanente(double gama, double valor){
			 
			 if(this.mnv == 1 && this.tipo == 2) {
				 this.MdPermParcial = gama*valor;
			 }	
			 
			 return MdPermParcial;
		 }
		 
	public double CalculoMdvariavel(double gama, double valor, double phi){
			 
		 if(this.mnv == 1 && this.tipo == 2  ) {
			 this.MdVarParcial = (this.gama)*(this.valor)*(this.phi);
		 }		
			 
			 return MdVarParcial;
		 }
	 	
	 	
 //Memorial de Calculo
	
	public void imprimeNdvariavel(double valor, double gama, double phi){ 
		System.out.println( valor + "*" + gama + "*" + phi );
	}
	
	public void imprimeNdpermanente( double valor, double gama){ 
		System.out.println(  valor + "*" + gama );
	}
	

	public void imprimeMdvariavel(double valor, double gama, double phi){ 
		System.out.println( valor + "*" + gama + "*" + phi );
	}
	
	public void imprimeMdpermanente( double valor, double gama){ 
		System.out.println(  valor + "*" + gama );
	}

	public void imprimeVdvariavel(double valor, double gama, double phi){ 
		System.out.println( valor + "*" + gama + "*" + phi );
	}
	
	public void imprimeVdpermanente( double valor, double gama){ 
		System.out.println(  valor + "*" + gama );
	}


//CORTANTES

	
 public double CalculoVdpermanente(double gama, double valor){
	 
	 if(this.mnv == 3 && this.tipo == 1) {
		 this.VdPermParcial = gama*valor;
	 }	
	 
	 return MdPermParcial;
}

public double CalculoVdvariavelPermanente(double gama, double valor){
	 
	 if(this.mnv == 3 && this.tipo == 2) {
		 this.MdPermParcial = gama*valor;
	 }	
	 
	 return MdPermParcial;
}

public double CalculoVdvariavel(double gama, double valor, double phi){
	 
if(this.mnv == 3 && this.tipo == 2  ) {
	 this.VdVarParcial = (this.gama)*(this.valor)*(this.phi);
}		
	 
	 return VdVarParcial;
}*/

}







