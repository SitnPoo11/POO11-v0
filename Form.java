package lib ;


/*
 * 26-12-01 modif toStringf(double) test isNaN (renvoie NaN)
 * 10-5-02 modif toStringf1(double) pour cause de dépassement de capacité sur int
 *         + modif de la fonction ordre 
 * 2-4-03 + fonctions setPar : permet de modifier les paramètres
 * 15-4-03 correction de la fonction ordre (problème pour x=0)
 * 16-4-03 corr fonction ordre, log(abs()) !!
 */
 
 /**
 * Form.java
 *
 * formatage des nombres 
 *
 * Created: Tue Feb  6 16:07:26 2001
 *
 * @author daniel tounissoux
 * @version
 */



public class Form  {
    
    public int l,d ; //longueur, decimales 
    public boolean e ; // notation exponentielle
    public int sp=1 ;  // nombre d'espaces avant la valeur 

    final double ln10=Math.log(10); 
    
    /**
    @param l longueur
    @param d nombre de décimales
    @param e notation exponentielle
    @param nombre d'espace entre deux valeurs
    */
    public Form(int l,int d,boolean e,int sp) {
	this.l=l;this.d=d;this.e=e;this.sp=sp;	
    }

    /**
    @param l longueur
    @param d nombre de décimales
    @param e notation exponentielle
    */
    public Form(int l,int d,boolean e) {
	this.l=l;this.d=d;this.e=e;			
    }

    /**
    définit les paramètres
    @param l longueur
    @param d nombre de décimales
    @param e notation exponentielle
    */
    public void setPar(int l,int d,boolean e){
	this.l=l;this.d=d;this.e=e;
    }
    
    
    /**
    définit les paramètres
    @param l longueur
    @param d nombre de décimales
    */  
    public void setPar(int l,int d){
	this.l=l;this.d=d;
    }
    
    /**
    définit les paramètres
    @param l longueur
    @param d nombre de décimales
    */     
    public void setPar(int l,int d,boolean e,int sp){
	this.l=l;this.d=d;this.e=e;this.sp=sp;
    }

    
    
    private String spaces(int v){
	StringBuffer s0=new StringBuffer("                         ");
	s0.setLength(v<0 ? 0 : v ); return s0.toString();
    }

   
    /**
    formate la chaîne s en ajoutant des blancs
    @param s une chaîne
    @return la chaîne formatée
    */
    public String toStringf(String s){
	if (s.length()>l) return s.substring(0,l);
	else {int v=l-s.length();return spaces(v).toString()+s;}
    }

    /**
    formate un entier 
    @param n un entier
    @return la chaîne formatée représentant n
    */
    public String toStringf(int n){
	int l0=l; l=l0-sp ;
	String s=Integer.toString(n);
	int v=l-s.length(); l=l0;
	return spaces(v+sp)+s ;
    }
    

    private String toStringf1(double x){
	int l0=l; l=l0-sp;
	double coef=Math.pow(10,d);
	x=Math.round(x*coef);
	String s=Long.toString(Math.abs((long)x));// pb capacité avec int
	while (s.length()<=d) {s='0'+s;}  
	if (d>0) {int sl=s.length();s=s.substring(0,sl-d)+'.'+s.substring(sl-d,sl);}
	int v=l-1-s.length();l=l0;
	return spaces(sp)+(x<0 ? spaces(v)+'-'+s : spaces(v)+' '+s);
    }



    private String toStringf2(double x){
	int l0=l,d0=d;
	//exposant
	int p=ordre(x);String e=Integer.toString(Math.abs(p));
	char signe= p<0 ? '-' : '+';
	String exp="e"+signe+(Math.abs(p)<10 ? "0"+e : e) ;
	//mantisse
	double m=x/Math.pow(10,ordre(x)); 
	if (l-sp<7) l=7+sp ; l=l-exp.length();d=l-4;
        String s=toStringf1(m);l=l0;d=d0;
	
	return s+exp ;
    }


    /**
    formate un double
    @param x un double
    @return la chaîne formatée représentant x en notation décimale
    */
    public String toStringf(double x){
	if (Double.isNaN(x)) return toStringf(new String("NaN")) ;
	boolean e0=e; if (Math.abs(ordre(x))>6) e=true ; 
	String rep= e ? toStringf2(x) : toStringf1(x); 
        e=e0 ;return rep ;
    }



    private int ordre(double x){
	if (x==0) 
	  return 0 ;
	else 
	  return (int)(Math.log(Math.abs(x))/ln10); 	
	/* ancienne version moins rapide ?? */
	/*int k=0 ;
	if (x==0) k=0; else{
	    while (Math.abs(x)<1) {x=x*10;k--;}
	    while (Math.abs(x)>=10) {x=x/10;k++;}
	}
	return k; 
       */
    }


   /* Exemple d'essai
    public static void main(String a[]){
	Form f=new Form(12,4,true,2);double x=-150.356 ;
	System.out.println(x+"*\n"+f.toStringf(x));
    }
    */
    
    

} // Form
