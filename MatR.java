package lib ;

  
import java.util.Random ;
import java.util.Vector ;
import java.util.StringTokenizer ;
import java.io.*;




/**
* MatR.java
* Gestion des matrices à coefficients réels.
*
*
*
*
* Classe permettant de gérer des matrices réelles avec des noms de lignes et colonnes. <br>
* Les numéros de lignes et de colonnes commencent à 1.<br> 
* Les principales fonctions sont :<br>
* - calcul matriciel (inversion, diagonalisation ...)<br>
* - lecture sur fichier<br>
* - affichage formaté dans un fichier ou une chaîne <p>
*
* Created: Sept  9 09:12:38 2001<p>
*
* @author daniel tounissoux
* @version 
*
**/


/*
* 12-02-01 (1) + fonctions getd et setd à utiliser sur des matrices non
*                transposées
* 21-02-01 + fonctions setForm pour définir le format des nombres 
*           à l'affichage + modification de AfficheSimple
* 05-03-01 + modif lire()
* 09-03-01 +supprimeColonne +supprimeLigne +MatRToDouble
* 28-04-01 + fonction retaille
* 30-11_01 + fonction lire : pour lire une matrice dans un fichier. 
* La première ligne comprend le nombre de lignes de colonnes, 0 ou 1 (id d'id de lignes) 0 ou 1 
* (id de lignes) 0 ou 1 (id de colonnes)
* 21-12-01 + fonction enregistrerSous
* 26-12-01 correction dans lire(String)
* 26-12-01 modif lire(String) et lire(String,int,int) pour prise en compte NaN 
* 06-01-02 modif lire(String) pour cause de pb de lecture des notations exponentielles
*         lire(String,int,int) a été remplacée par lire(String,boolean,boolean) 
* 17-01-02 modif afficheSimple(String nom,StringBuffer res) : \n a été remplacé par
*          lf pour compatibilité Windows
*          + gestion des formats exponentiels 
* 27-4-02 + insereColonnes ajouteColonnes ajouteColonne 
* 30-4-02 + numColonne(string s) : donne le n° de colonne à partir du nom
* 12-5-02 correction dans lire(string,int,int)
* 11-4-03 + quelques fonctions de cacul de moyenne varaince avec poids
* 15-4-03 + fonction setForm(Form) ;
* 17-4-03 + constructeur MatR(int,int[])
* 19-5-03 modif initmemAlea (la classe random donne toujours la même séquence)
* 8-7-03 + fonction setAfficheNomsLignesColonnes : permet d'afficher ou non les noms
* 18-11-03 modif dans afficheSimple(String nom,StringBuffer res)
* 16-3-04 + constructeur MatR(double[][])
* 16-4-04 + opérateurs de projection (à tester)
* 8-5-04 + Les fonctions qui se modifient se retournent elles mêmes (return this) ce 
*          qui facilitent l'utilisations dans les formules. Ces fonctions sont 
         précédées de * dans la liste.
         + constructeur prenant comme argument le nom du fichier. La détection
	 des noms de lignes ou colonnes est automatiques (mais les noms ne doivent pas être des valeurs numériques.
* 2-6-04 + fonction getTrans
         + erreurs corrigées dans constructeurs MatR(double[]) et MatR(int[])
	 +la fonctions carre retourne this
* 24-6-04 + fonction toString() et toString(titre)
* 5-7-04 + fonction setNoml(char) et setNomc(char) 
* 12-7-04 + fonctions vectToDiag() et getMatId(int)
* 16-2-05 correction la fonction setAfficheNomLignesColonnes était dans 
  un commentaire !
*/



// MatR()
// MatR(String nomFichier) 
// MatR(int nl,int nc, double v) éviter l'utilisation
// MatR(int nl,int nc)
// MatR(int nl,int nc, double x[][])  éviter l'utilisation
// MatR(double[][)]
// MatR(int nl,double x[]) éviter l'utilisation
// MatR(double[])
// MatR(int[])

// int n()
// int p()

// * MatR transpose()
// void initmem(int nl,int nc)
// void initmem(int nl,int nc, double v)

// double get(int i,int j)
// void set(int i, int j,double v)
// double getd(int i,int j)        //acces direct si matrice non transposée 
// void setd(int i, int j,double v)// a utiliser avec précaution
// double getv(int i)       
// void setv(int i,double v)

// int numColonne(String s) 

// double[][] MatRToDouble();

// void inc(i,j,v)
// void dec(i,j,v)
// void inc(i,j)
// void dec(i,j)
// void incv(i,v)
// void decv(i,v)
// void incv(i)
// void decv(i)

// String noml(int i)
// String nomc(int i)
// Vector noml()
// Vector nomc()
// void setNomc(int i,String s)
// void setNoml(int i,String s)
// Vector getNomc()
// Vector getNoml()
// void setNomc(Vector V)
// void setNoml(Vector V)

//  public MatR vectToDiag()
//  public MatR getMatId(int n)
// void initmemAlea(int nl,int nc)

// void setName(String s)
// String getName()

//    void setLg(int v){ _l=v; }
//    void setDec(int v){ _d=v;}
//    void setExp(boolean v){ _e=v; }
//    void setSp(int v){ _sp=v; }
//    int lg(){return _l;   }
//    int dec(){return _d;}
//    boolean exp(){ return _e;}
//    int sp(){return _sp;}

//    void setForm(int l, int d){ _l=l;_d=d ;}
//    void setForm(int l, int d,int sp ){ _l=l;_d=d ;_sp=sp; }
//    void setForm(int l, int d,boolean e){  _l=l;_d=d ; _e=e; }
//    void setFom(int l, int d, boolean e, int sp){ _l=l;_d=d ;sp=sp; _e=e; }
//     public void setForm(Form form)

// void afficheSimple(String S) 
// void afficheSimple()
// void afficheSimple(String nom,StringBuffer res)


// void copyTo(MatR M)
// MatR copy()

// void echangeColonnes(int i,int k)

// void insereColonnes(int i0,int k,double v) k : nb colonnes, i0 position, v0 valeur 
// void ajouteColonnes(int k,double v)
// void ajouteColonne(double v)
// void supprimeLignes(int i0,int i1)
// void supprimeColonnes(int j0,int j1)
// void supprimeLigne(int i0)
// void supprimeColonne(int j0)
// MatR extraireBloc(int i0,int i1,int j0,int j1)
// MatR extraireLignes(int i0,int i1)
// MatR extraireColonnes(int j0,int j1)
// MatR extraireLigne(int i0)
// MatR extraireColonne(int j0)

// void concatADroite(MatR M)
// void concatDessous(MatR M)

// void carre()
// MatR sqr()
// void racineCarree()
// MatR sqrt()

// * MatR multCste(double c) 
// * MatR addCste(double c)
// * MatR subCste(double c)
// * MatR changeSigne()

// * MatR addMat(MatR M)
// * MatR subMat(MatR M)
// * MatR multTab(MatR M)
// * MatR divTab(MatR M)

// * MatR addVectLigne(MatR V)
// * MatR subVectLigne(MatR V)
// * MatR multVectLigne(MatR V)
// * MatR divVectLigne(MatR V)
// * MatR multVectColonne(MatR V)
// * MatR divVectColonne(MatR V)

// MatR maxColonnes()
// MatR minColonnes()
// double max()
// double min()
// double somme()
// MatR sommeColonnes()
// MatR sommeLignes()
// MatR sommeColonnesP(MatR pd)
// MatR sommeCarresColonnes()
// MatR normeCarreeColonnes()
// MatR normeColonnes()
// MatR moyenneColonnes()
// MatR moyenneColonnesP(MatR pd)
// MatR moyenneCarresColonnes()
// MatR varianceColonnes()
// MatR ecartTypeColonnes()
// MatR sommeColonnesParGroupes(MatR g,MatR pdg )
// MatR moyenneColonnesParGroupes(MatR g,MatR pdg )

// MatR sommeColonnesParGroupesP(MatR g, MatR pd, MatR pdg )
// MatR moyenneColonnesParGroupesP(MatR g, MatR pd, MatR pdg )

// * MatR centrer()
// * MatR  reduire()
// * MatR normer()
// * MatR centrerReduire()
// * MatR centrerNormer()

// MatR profilsLignes(int c)
// MatR profilsColonnes(int c)
// MatR profilsLignes()
// MatR profilsColonnes()

// MatR multMat(MatR B)
// MatR XtX()

// MatR histoVect() // histogramme d'un vecteur contenant des valeurs entières
// MatR histoVect(int nc,MatR bornes) // histogramme en nc classes d'un vecteur
// MatR histoVect(int nc,MatR bornes,double min, double max)   
// MatR histoVect(int nc,MatR bornes, boolean cond[])  
// MatR histoVect(int nc,MatR bornes,double min, double max, boolean cond[])   


// void diag(MatR q, MatR lbd)

// void  heapsort()
// void triVect()
// void triVect(int index[])

// MatR solveGauss(MatR B,MatR X)
// MatR inverse()

// MatR retaille(int n1, int p1)

// void lire(String nf)
// void (String nf, boolean  vnl, boolean vnc)
// void lire(String nf, int  vnl, int vnc) pour compatibilité

//  MatR getProjecteur()
//  MatR getProjecteurOrth()
//  MatR getProjection(MatR m)
//  MatR getProjectionOrth(MatR m)


public class MatR {
  
  private String _name="";
  private int _n,_p ; // dimensions internes de la matrice. 
  //Accessible par n() et p() qui prennent en compte la transposition
  
  private boolean _trans ;
  
  private double _t[][]; 
  //_t est accessible par get() en lecture et set() en ecriture
  
  private Vector _noml=new Vector(),_nomc=new Vector(); 
  private boolean _afficheNomsLignes=true,_afficheNomsColonnes=true ;
  
  private int _l=10 ; // longueur des réels(comprend un espace avant)
  private int _d=3 ;  // décimales
  private int _sp=1 ; // nombre d'espaces en plus avant le nombre
  private boolean _e=false ; // notation exponentielle
  
  public static final String lf=System.getProperty("line.separator");
  
  public MatR(){}
  
  /**
  * construit une matrice à partir d'un fichier texte.
  * Dans le fichier il peut y avoir ou pas des noms de lignes 
  * ou de colonnes
  * @param nomFichier - nom du fichier contenant la matrice
  * @throws exception en cas de problème de lecture
  */
  public MatR(String nomFichier) throws Exception{
    lire(nomFichier, detectNomsLignes(nomFichier), detectNomsColonnes(nomFichier));
  }
  
  /**
  *  crée et initialise une matrice de dimension (nl,nc) 
  * avec la valeur v
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  * @param v  valeur pour l'initialisation
  **/ 
  public MatR(int nl,int nc, double v){
    initmem(nl,nc,v);
  }
  
  /**
  * initialise une matrice de dimension (nl,nc) avec la valeur 0
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  **/ 
  public MatR(int nl,int nc){
    initmem(nl,nc);
  }
  
  /**
  * initialise une matrice de dimension (nl,nc) avec un tableau à 2 dimensions
  * Attention : seules les parties du tableau à partir de l'indice 1 sont prises en compte. A EVITER
  * @deprecated 
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(int nl,int nc, double x[][]) {
    initmem(nl,nc);
    for (int i=1;i<=n();i++)
      for (int j=1;j<=p();j++)
        set(i,j,x[i][j]) ;
  }
  
  /**
  * initialise une matrice de dimension (nl,nc) avec un tableau à 2 dimensions
  * version meilleure, le tableau fourni a exactement la même dimension que la matrice
  * @param x le tableau pour l'initialisation
  */
  public MatR(double x[][]){
    initmem(x.length,x[0].length);
    for (int i=1;i<=n();i++)
      for (int j=1;j<=p();j++)
        set(i,j,x[i-1][j-1]) ;      
  }
  
  
  /**
  * initialise une matrice de dimension (nl,nc) avec un tableau à 2 dimensions
  * Attention : seules les parties du tableau à partir de l'indice 1 sont prises en compte. A EVITER
  * @deprecated 
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  * @param x le tableau pour l'initialisation
  **/   
  public MatR(int nl,int nc, float x[][]){
    initmem(nl,nc);
    for (int i=1;i<=n();i++)
      for (int j=1;j<=p();j++)
	set(i,j,x[i][j]) ;
  }
  
  
  
  /**
  * initialise une matrice de dimension (nl,1) avec un tableau à 1 dimension
  * Attention : seules les parties du tableau à partir de l'indice 1 sont prises en
  * compte. A EVITER
  * @param nl  nbe de lignes
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(int nl,double x[]){
    initmem(nl,1);
    for (int i=1;i<=n();i++)
      set(i,1,x[i]) ;
  }

  /**
  * initialise une matrice de dimension (nl,1) avec un tableau à 1 dimension
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(double x[]){
    initmem(x.length,1);
    for (int i=1;i<=n();i++)
      set(i,1,x[i-1]) ;
  }

  /**
  * initialise une matrice de dimension (nl,1) avec un tableau à 1 dimension
  * Attention : seules les parties du tableau à partir de l'indice 1 sont prises en
  * compte. A EVITER
  * @deprecated 
  * @param nl  nbe de lignes
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(int nl,float x[]){
    initmem(nl,1);
    for (int i=1;i<=n();i++)
      set(i,1,x[i]) ;
  }
  
  
  /**
  * initialise une matrice de dimension (nl,1) avec un tableau à 1 dimension
  * Attention : seules les parties du tableau à partir de l'indice 1 sont prises en
  * compte. A EVITER
  * @deprecated 
  * @param nl  nbe de lignes
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(int nl,int x[]){
    initmem(nl,1);
    for (int i=1;i<=n();i++)
      set(i,1,x[i]);
  }

  /**
  * initialise une matrice de dimension (nl,1) avec un tableau à 1 dimension
  * @param x le tableau pour l'initialisation
  **/ 
  public MatR(int[] x){
    initmem(x.length,1);
    for (int i=1;i<=n();i++)
      set(i,1,x[i-1]) ;
  }

  
  /**
  * Initialise la matrice avec les éléments du vecteur colonne x, vérifiant une  condition
  * @param nl  nbe de lignes de x
  * @param x le tableau pour l'initialisation
  * @param cond le tableau de booléens definissant la condition
  **/
  public MatR(int nl,float x[],boolean cond[]){
    int j=0 ;int i;
    for (i=1;i<=nl;i++) if (cond[i]) j++ ;
    initmem(j,1);
    for (i=1,j=0;i<=n();i++)
      if (cond[i]) {j++;set(j,1,x[i]) ;}
  }
  
  /**
  * @return  nombre de lignes de la matrice, en prenant en compte la fait
  * que la matrice est tansposée
  **/
  public int n(){
    if (_trans)  return _p ; else return _n ;
  } 
  
  /**
  * @return nombre de colonnes de la matrice, en prenant en compte la fait
  * que la matrice est tansposée
  **/
  public int p(){
    if (_trans) return _n ; else return _p ;
  }
  
  /**
  * transpose la matrice
  * @return la matrice transposée (this)
  **/
  public MatR transpose(){
    _trans = !_trans ; return this ;
  }
  
  /**
  * retourne une copie transposée de la matrice
  * @return la matrice transposée 
  **/
  public MatR tr(){
    MatR X=copy();
    X.transpose();
    return X;
  }
  
  /**
  * permet de savoir si la matrice est transposée
  * @return vrai si la matrice est transposée
  */  
  public boolean getTrans(){
    return _trans ; 
  }
  
  /**
  * initialisation du tableau définissant la matrice à 0. Définit et initialise le tabeau.
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  **/
  public void initmem(int nl,int nc){
    initmem(nl,nc,0);
  }
  
  /**
  * initialisation du tableau définissant la matrice à une valeur v 
  * @param nl  nbe de lignes
  * @param nc  nbe de colonnes
  * @param v la valeur d'initialisation
  **/
  public void initmem(int nl,int nc, double v){
    int i,j;
    _t=new double[nl][nc];
    _n=nl;_p=nc ;_trans=false ;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
        set(i,j,v) ;
    for (i=1;i<=nl;i++) _noml.addElement("a"+i);
    for (j=1;j<=nc;j++) _nomc.addElement("c"+j);
  }
  
  
  /**
  * retourne l'élément (i,j) de la matrice. Attention numérotation à partir de 1
  * @param i indice de ligne
  * @param j indice de colonne
  * @return l'élément i,j de la matrice. Tout accès à un élément devrait utiliser cette fonction
  **/
  public double get(int i,int j){
    if (_trans) return _t[j-1][i-1]; else return _t[i-1][j-1];
  }  
  
  /**
  * définition de l'élément (i,j) de la matrice. Attention numérotation à partir de 1
  * @param i indice de ligne
  * @param j indice de colonne
  * @param 
  **/
  public void set(int i,int j,double v){
    if (_trans) _t[j-1][i-1]=v ; else _t[i-1][j-1]=v ;
  }
  
  /**
  * accès direct à l'élément (i,j). Attention si la matrice est transposée le résultat
  * sera faux. A utiliser avec précautions si la matrice n'est pas transposée pour optimiser la vitesse.
  * @param i indice de ligne
  * @param j indice de colonne
  **/
  public double getd(int i,int j){
    return  _t[i-1][j-1];
  }  
  
  /**
  * définition directe de l'élément (i,j). 
  * Attention si la matrice est transposée le résultat sera faux
  A utiliser avec précautions si la matrice n'est pas transposée pour optimiser la vitesse.
  * @param i indice de ligne
  * @param j indice de colonne
  * @param v valeur d'initialisation
  **/
  public void setd(int i,int j,double v){
    _t[i-1][j-1]=v ;
  }
  
  /**
  * @return si la matrice n'a qu'une ligne ou qu'une colonne, retourne le ième terme
  * @param i indice de ligne ou de colonne selon le cas
  **/
  public double getv(int i){
    if (n()==1) return get(1,i); else return get(i,1) ;
  }
  
  /**
  * si la matrice n'a qu'une ligne ou qu'une colonne, définit le ième terme à v
  @param i l'indice du vecteur
  @param v la valeur
  **/
  public void setv(int i,double v){
    if (n()==1)  set(1,i,v); else set(i,1,v) ;
  }
  
  /**
  * @param s nom d'une colonne
  * @return  le numéro de la colonne dont le nom est s
  **/
  public int numColonne(String s){ 
    int i;for (i=1;i<=p() && ! nomc(i).equals(s);i++ ) ;
    if (nomc(i).equals(s)) return i ;else return -1 ;
  }
  
  /**
  *
  * transforme un vecteur en une matrice diagonale
  * @return la matrice transformée (this)
  */
  public MatR vectToDiag(){
    int dim = n()==1 ? p() : n() ;
    MatR m=new MatR(dim,dim) ;
    for (int i=1;i<=dim;i++) m._t[i-1][i-1]=getv(i);
    return m;
  }
  
  /**
  * @return la matrice identité de dimension n 
  @param n dimension
  */
  public static MatR getMatId(int n){
    MatR m=new MatR(n,n);
    for (int i=1;i<=n;i++) m._t[i-1][i-1]=1;
    return m ;
  }
  
  /**
  * transforme la matrice en un tableau à 2 dimensions ordinaire
  * @return un tableau à deux dimensions
  **/
  public double[][] MatRToDouble(){ 
    double m[][]=new double[n()+1][p()+1];int i,j ;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
        m[i][j]=get(i,j);
    return m ;
  }
  
  
  /**
  * incrémente l'élément (i,j) de v
  @param i ligne
  @param j colonne
  @param valeur à ajouter
  **/
  public void inc(int i,int j,double v){
    set(i,j,get(i,j)+v);
  }
  
  /**
  * décrémente l'élément (i,j) de v
  @param i ligne
  @param j colonne
  @param valeur à soustraire
  **/
  public  void dec(int i,int j,double v){
    set(i,j,get(i,j)-v);
  }
  
  /**
  * incrémente l'élément (i,j) de 1
  @param i ligne
  @param j colonne
  **/
  public void inc(int i,int j){
    set(i,j,get(i,j)+1);
  }
  
  /**
  * décrémente l'élément (i,j) de 1
  @param i ligne
  @param j colonne
  **/
  public void dec(int i,int j){
    set(i,j,get(i,j)-1);
  }
  
  
  /**
  * si la matrice a une dimension égale à 1, incrémente de v le ième élément.
  @param i ligne
  **/
  public void incv(int i,double v){
    setv(i,getv(i)+v);
  }
  
  /**
  * si la matrice a une dimension égale à 1, décrémente de v le ième élément.
  @param i ligne
  **/
  public void decv(int i,double v){
    setv(i,getv(i)-v);
  }
  
  /**
  * si la matrice a une dimension égale à 1, incrémente de 1 le ième élément.
  @param i numéro élément
  **/
  public void incv(int i){
    setv(i,getv(i)+1);
  }
  
  /**
  * si la matrice a une dimension égale à 1, décrémente de 1 le ième élément.
  @param i numéro élément
  **/
  public void decv(int i){
    setv(i,getv(i)-1);
  }
  
  
  /**
  * retourne le nom de la ième ligne
  @param i  numéro ligne
  @return nom de la ligne
  **/
  public String noml(int i){
    if (!_trans) 
      return (String)(_noml.elementAt(i-1));
    else	
      return (String)(_nomc.elementAt(i-1));
  }
  
  /**
  * retourne le nom de la ième colonnee
  @param i  numéro colonne
  @return nom de la colonne
  **/
  public String nomc(int i){
    if (!_trans) 
      return (String)(_nomc.elementAt(i-1)); 
    else  
      return (String)(_noml.elementAt(i-1));
  }
  
  
  /**
  * définit le nom de la ième colonne
  @param i  numéro colonne
  @param s nom de la colonne
  **/
  public void setNomc(int i,String s){
    if (!_trans)
      _nomc.setElementAt(s,i-1);
    else
      _noml.setElementAt(s,i-1);
  }
  
  
  /**
  * définit le nom de la ième ligne
  @param i  numéro ligne
  @param s nom de la ligne
  **/
  public void setNoml(int i,String s){
    if (!_trans)
      _noml.setElementAt(s,i-1);
    else
      _nomc.setElementAt(s,i-1);
  }
  
  /**
  * définit les noms des lignes par une lettre et le n° de la la ligne
  @param c caractère (lettre)
  */
  public void setNoml(char c){
    if (!_trans)
      for (int i=1;i<=_n;i++)
        _noml.setElementAt(""+c+i,i-1);
    else
      for (int i=1;i<=_p;i++)
        _nomc.setElementAt(""+c+i,i-1);    
  }

  public void setNomc(char c){
    transpose(); setNoml(c); transpose();
  }

  
  /**
  * @return le vecteur des noms de colonne. Le nom de la colonne 1 est en position 0.
  **/
  public  Vector getNomc(){
    if (!_trans) 
      return _nomc ; 
    else  
      return _noml ;
  }
  
  /**
  * @return le vecteur des noms de colonne
  **/
  public Vector getNoml(){
    if (!_trans) 
      return _noml ; 
    else  
      return _nomc ;
  }
  
  
  /**
  * Définit les noms de colonne comme ceux de la matrice M
  @param  M la matrice
  **/
  public void setNomc(MatR M){  // à simplifier avec setNomc(vector)
    if (!_trans) 
      _nomc=(Vector)(M.getNomc()).clone();
    else 
      _noml=(Vector)(M.getNomc()).clone();
  }
  
  /**
  * Définit les noms de ligne comme ceux de la matrice M
  @param  M la matrice
  **/
  public void setNoml(MatR M){ 
    if (!_trans) 
      
    _noml=(Vector)(M.getNoml()).clone();
    else
      _nomc=(Vector)(M.getNoml()).clone();
  }
  
  
  
  /**
  *  Définit les noms de colonnes avec le vecteur V
  @param vecteur des noms
  **/
  public void setNomc(Vector V){
    if (!_trans) 
      _nomc=(Vector)V.clone();
    else 
      _noml=(Vector)V.clone();
  }
  
  /**
  *  Définit les noms de lignes avec le vecteur V
  @param vecteur des noms
  **/
  public void setNoml(Vector V){
    if (!_trans) 
      _noml=(Vector)V.clone();
    else 
      _nomc=(Vector)V.clone();
  }
  
  /**
  * initialise la matrice aux dimension (nl,nc) de façon aléatoire
  @param nl nombre de lignes
  @param nc nombre de colonnes
  **/
  public void initmemAlea(int nl,int nc){
    int i,j ; 
    initmem(nl,nc);
    //Random r1=new Random();
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
        set(i,j,Math.random());
    //set(i,j,r1.nextDouble()) ;
  }
  
  /**
  * définit le nom de la matrice
  @param s nom de la matrice
  **/
  public void setName(String s){
    _name=s;
  }
  
  /**
  * @return le nom de la matrice
  **/
  public String getName(){return _name;  }
  
  /**
  * pour l'affichage, définit la longueur des valeurs
  @param v longueur des nombres
  **/
  public void setLg(int v){ _l=v; }
  
  /**
  * pour l'affichage, définit le nombre de décimales
  @param v nombre de décimales
  **/
  public void setDec(int v){ _d=v;}

  /**
  * pour l'affichage, définit la notation exponetielle ou non
  @param v vrai pour avoir la notation exponentielle
  **/
  public void setExp(boolean v){ _e=v; }

  /**
  * pour l'affichage, définit le nombre d'espaces entre 2 valeurs
  @param v nombre d'espaces minimal entre 2 valeurs
  **/
  public void setSp(int v){ _sp=v; }
  
  /**
  * @return la longueur des nombres
  **/
  public int lg(){return _l;   }

  /**
  * @return  le nombre de décimales
  **/
  public int dec(){return _d;}
  /**
  * @return vrai si la notation est exponentielle
  **/
  public boolean exp(){ return _e;}
  /**
  * @return  le nombre d'espaces entre 2 valeurs
  **/
  public int sp(){return _sp;}
  
  /**
  * définition du format (longueur, décimales)
  @param l longueur
  @param d nb de décimales
  **/
  public void setForm(int l, int d){ _l=l;_d=d ;}

  /**
  * définition du format (longueur, décimales, espaces)
  @param l longueur
  @param d nb de décimales
  @param so nb d'espaces
  **/
  public void setForm(int l, int d,int sp ){ _l=l;_d=d ;_sp=sp; }

  /**
  * définition du format (longueur, décimales, notation)
  **/
  public void setForm(int l, int d,boolean e){  _l=l;_d=d ; _e=e; }
  /**
  * définition du format (longueur, décimales, notation, espaces)
  **/
  public void setFom(int l, int d, boolean e, int sp){ _l=l;_d=d ;_sp=sp; _e=e; }
  
  /**
  * définition du format à partir d'un objet Form
  * @param form le format (Form) 
  **/
  public void setForm(Form form){ _l=form.l; _d=form.d; _sp=form.sp ; _e=form.e ; }
  
  /**
  * @param l vrai pour afficher les noms de ligne
  * @param c vrai pour afficher les noms de colonne
  **/
  public void setAfficheNomsLignesColonnes(boolean l,boolean c){
    _afficheNomsLignes=l ;
    _afficheNomsColonnes=c ;
  }
  
  /**
  * affiche la matrice sur la sortie standard avec un titre
  @param nom le titre à afficher
  **/
  public void afficheSimple(String nom){
    StringBuffer s=new StringBuffer();
    afficheSimple(nom,s);
    System.out.print(s);
  }
  
  /**
  * affiche la matrice sur la sortie standard sans titre
  **/
  public void afficheSimple(){
    afficheSimple("");
  }
  
  
  /**
  * envoie la matrice dans une chaîne StringBuffer.
  @param nom le titre à afficher
  @param la variable StringBuffer  
  **/
  public void afficheSimple(String nom,StringBuffer res){
    int i,j;
    Form f=new Form(lg(),dec(),exp(),sp());
    if (! nom.equals("")) res.append(nom+lf);
    res.append(f.toStringf(""));
    if (_afficheNomsColonnes){
      for (j=1;j<=p();j++) res.append(f.toStringf(nomc(j))); 
      res.append(lf); 
    }
    for (i=1;i<=n();i++){
      String nl;
      if (_afficheNomsLignes) nl=noml(i); else nl="";
      res.append(f.toStringf(nl));
      for (j=1;j<=p();j++){
        res.append(f.toStringf(get(i,j)));
      }
      res.append(lf); 
    }
    res.append(lf);
  }
  
  /**
  * transforme la matrice en chaîne de caractères
  @param nom le titre
  */
  public String toString(String nom){
     StringBuffer s=new StringBuffer() ;
     afficheSimple(nom,s) ;
     return s.toString();   
  }
  
  /**
  * transforme la matrice en chaîne de caractères
  @param nom le titre
  */
  public String toString(){
    return toString(""); 
  }
  
  
  /**
  * enregistre la matrice dans un fichier, en incluant un en_tête
  * comprenant, sur une ligne (séparés par des espaces)
  * - nb de lignes
  * - nb de colonnes
  * - 1 si noms de lignes (0 sinon)
  * - 1 si noms de colonnes (0 sinon)
  * - 1 si nom pour les noms de lignes (0 sinon)
  @param nf nom du fichier
  **/
  public void enregistrerSous(String nf){
    try{
      StringBuffer res= new StringBuffer() ;
      afficheSimple("",res);
      FileWriter fo=new FileWriter(nf);
      PrintWriter f=new PrintWriter(fo);
      f.print(n()+" "+p()+" 1 1 0"+lf); // en tête
      f.print(res);
      f.close();
    }
    catch(Exception e){}
  }
  
  /**
  * initialise une copie de la matrice. M doit être initialisée avec un new, avant l'appel.
  @param M la matrice cible
  **/
  public void copyTo(MatR M){
    int i,j;
    M.initmem(n(),p());
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	M.set(i,j,get(i,j));
    M.setNoml(this);M.setNomc(this);
  }
  
  /**
  * retourne une copie de la matrice. 
  **/
  public MatR copy(){
    MatR C=new MatR();
    this.copyTo(C);
    return C;
  }
  
  /**
  * échange les colonnes j et k
  @param j 
  @param k les numéros des colonnes
  **/
  public void echangeColonnes(int j,int k){
    double v;int i;
    for (i=1;i<=n();i++){
      v=get(i,j);set(i,j,get(i,k));set(i,k,v);
    }
    String s=nomc(j);setNomc(j,nomc(k));setNomc(k,s);
  }
  
  
  /**
  * Insere k colonnes en colonne j0. Ces colonnes sont initialisées à la valeur v
  @param j0 numéro de la colonne où insérer
  @param k vombre de colonnes à insérer
  @param v valeur pour initialiser les colonnes
  **/
  public void insereColonnes(int j0,int k,double v){
    int i,j ;
    int nn=n(); int pp=p()+k ;
    double tt[][]=new double[nn][pp];
    for (i=0;i<=nn-1;i++){
      for (j=0;j<=j0-2;j++) tt[i][j]=get(i+1,j+1) ;
      for (j=j0-1;j<=j0+k-2;j++) tt[i][j]=v ;
      for (j=j0+k-1;j<=pp-1;j++) tt[i][j]=get(i+1,j-k+1) ;
    }
    if (_trans) {Vector vv=getNoml();setNoml(getNomc());setNomc(vv);}
    _t=tt; _trans=false ; _n=nn;_p=pp ;
    
    for (i=1;i<=k;i++) getNomc().insertElementAt("***",j0-1);
  }
  
  
  /**
  * Ajoute k colonnes à la fin, remplies par la valeur v
  @param k nombre de colonnes à ajouter
  @param v valeur pour initialiser les colonnes
  **/
  public void ajouteColonnes(int k,double v){
    insereColonnes(p()+1,k,v);
  }
  
  
  /**
  * Ajoute 1 colonne, remplie par la valeur v
   @param v valeur pour initialiser les colonnes
  **/
  public void ajouteColonne(double v){
    insereColonnes(p()+1,1,v);
  }
  
  /**
  * Supprime les lignes de i0 à i1 (incluses);
  @param i0 ligne début
  @param i1 ligne fin
  **/
  public void supprimeLignes(int i0,int i1){
    int i,j,k;
    int nn=n()-(i1-i0+1) ;int pp=p();
    double tt[][] =new double[n()-(i1-i0+1)][p()];
    for (j=1;j<=p();j++) {
      for (i=1;i<i0;i++) tt[i-1][j-1]=get(i,j);
      for (i=i0;i<=n()-(i1-i0+1);i++) tt[i-1][j-1]=get(i+(i1-i0+1),j);
    } 
    if (_trans) {Vector v=getNoml();setNoml(getNomc());setNomc(v);}
    _t=tt; _trans=false ; _n=nn;_p=pp ;
    
    for (i=1;i<=i1-i0+1;i++) getNoml().removeElementAt(i0-1);
  }
  
  
  /**
  * Supprime les colonnes de j0 à j1 (incluses);
  @param i0 colonne début
  @param i1 colonne fin
  **/
  public void supprimeColonnes(int j0,int j1){
    transpose();supprimeLignes(j0,j1);transpose();
  }
  
  
  /**
  * Supprime la ligne de i0
  @param i0 numéro de la ligne 
  **/
  public void supprimeLigne(int i0){
    supprimeLignes(i0,i0);
  }
  
  
  /**
  * Supprime la colonne j0;
  @param j0 numéro de la colonne 
  **/
  public void supprimeColonne(int j0){
    supprimeColonnes(j0,j0);
  }
  
  
  /**
  * extrait les lignes pour lesquelles la condition est vérifée.
  @param cond tableau de booléens possétdant autant d'élément que la matrice possède de lignes 
  @return matrice extraite où seules les lignes telles que cond[i] est vraie sont conservées
  **/
  public MatR extraire(boolean cond[]){ // à vérifier
    int j=0 ;int i;
    for (i=1;i<=n();i++) if (cond[i]) j++ ;
    MatR x=new MatR(j,1);
    for (i=1,j=0;i<=n();i++)
      if (cond[i]) {j++;x.set(j,1,getv(i)) ;}
    return x;
  }
  
  /**
  * extrait le bloc des lignes i0 à i1 et des colonnes j0 à j1
  **/ 
  public MatR extraireBloc(int i0,int i1,int j0,int j1){
    int i,j;
    MatR X=new MatR(i1-i0+1,j1-j0+1);
    for (i=1;i<=X.n();i++)
      for (j=1;j<=X.p();j++)
	X._t[i-1][j-1]=get(i+i0-1,j+j0-1);
    for (i=1;i<=X.n();i++){X.setNoml(i,noml(i+i0-1));}
    for (j=1;j<=X.p();j++){X.setNomc(j,nomc(j+j0-1));}
    
    return X;
  }
  
  /**
  * extrait les lignes i0 à i1 
  **/ 
  public MatR extraireLignes(int i0,int i1){
    return extraireBloc(i0,i1,1,p());
  }
  
  
  /**
  * extrait les colonnes j0 à j1 
  **/ 
  public MatR extraireColonnes(int j0,int j1){
    return extraireBloc(1,n(),j0,j1);
  }
  
  
  
  /**
  * extrait la lignes i0  
  **/ 
  public MatR extraireLigne(int i0){
    return extraireLignes(i0,i0);
  }
  
  
  /**
  * extrait la colonne j0  
  **/ 
  public MatR extraireColonne(int j0){
    return extraireColonnes(j0,j0);
  }
  
  
  /**
  * concatène la matrice et M (M est placée à droite). Les nombres de lignes doivent correspondre.
  @param M matrice à ajouter
  **/
  public void concatADroite(MatR M){
    int i,j,nnew=n(),pnew=p()+M.p();
    double tt[][]=new double [nnew][pnew];
    for (i=1;i<=n();i++) for (j=1;j<=p();j++) tt[i-1][j-1]=get(i,j);
    for (i=1;i<=n();i++) for (j=1;j<=M.p();j++) tt[i-1][j-1+p()]=M.get(i,j);
    Vector newnoml=(Vector)getNoml().clone();
    Vector newnomc=(Vector)getNomc().clone();
    for (j=1;j<=M.p();j++) newnomc.addElement(M.nomc(j));
    _noml=newnoml ; _nomc=newnomc ;
    _t=tt ;  _p=pnew;_n=nnew; _trans =false ;	  
  }
  
  
  /**
  * concatène la matrice et M (M est placée dessous). Les nombres de colonnes doivent correspondre
  @param M matrice à ajouter
  **/
  public void concatDessous(MatR M){
    transpose();M.transpose();
    concatADroite(M); 
    M.transpose();transpose();
  }
  
  /**
  * Elève tous les termes au carré
  @return this
  @see sqr
  **/
  public MatR carre(){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)*get(i,j));
    return this ;
  }
  
  
  /**
  * retourne une matrice dont tous les termes sont élévés au carré
  @return une autre matrice. 
  @see carre
  **/
  public MatR sqr(){MatR m=copy();m.carre();return m; }
  
  
  /**
  * prend la racine carré de tous les termes
  @return this
  @see sqrt
  **/
  public void racineCarree(){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,Math.sqrt(get(i,j)));
  }
  
  
  /**
  * @return une matrice dont tous les termes sont élévés à la puissance 1/2
  @see racineCarree
  **/
  public MatR sqrt(){ MatR m=copy();m.racineCarree();return m; }
  
  /**
  @param c constante 
  * @return this multipliée par la constante c
  **/
  public MatR multCste(double c){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
        set(i,j,c*get(i,j));
    return this ;
  }
  
  /**
  @param c constante 
  * @return this divisée par la constante c
  **/  
  public MatR divCste(double c){
    multCste(1.0/c) ; 
    return this ;
  }
  
  
  /**
  * ajoute c à tous les termes de la matrice
  @param c constante
  @return this
  **/
  public MatR addCste(double c){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,c+get(i,j));
    return this ;
  }
  
  
  
  /**
  * change les signes de tous les termes de la matrice
  @return this
  **/
  public MatR changeSigne(){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,-get(i,j));
    return this ;
  }
  
  /**
  * ajoute la matrice M à la matrice
  @param M matrice à ajouter
  @return this
  **/
  public MatR addMat(MatR M){
    int i,j;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)+M.get(i,j));
    return this ;
  }
  
  /**
  * soustrait la matrice M à la matrice
  @param M matrice à sustraire
  @return this
 **/
  public MatR subMat(MatR M){
    int i,j;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)-M.get(i,j));
    return this ;
  }
  
  /**
  * multiplie la matrice par M (terme à terme)
  @param M matrice de même dimensions que this
  @return this
  **/
  public MatR multTab(MatR M){
    int i,j;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)*M.get(i,j));
    return this ;
  }
  
  
  /**
  * divise chaque terme par la valeur correspondante de M
  @param M matrice de même dimensions que this
  @return this
  **/
  public MatR divTab(MatR M){
    int i,j;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)/M.get(i,j));
    return this ;
  }
  
  /**
  * ajoute le vecteur V à chaque ligne de la matrice
  @param V vecteur (matrice ligne)
  @return this
  **/
  public MatR addVectLigne(MatR V){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)+V.get(1,j));
    return this ;
  }
  
  /**
  * soustrait le vecteur V à chaque ligne de la matrice
  @param V vecteur (matrice ligne)
  @return this
  **/
  public MatR subVectLigne(MatR V){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)-V.get(1,j));
    return this ;
  }
  
  /**
  * multiplie par le vecteur V  chaque ligne de la matrice
  @param V vecteur (matrice ligne)
  @return this
  **/
  public MatR multVectLigne(MatR V){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)*V.get(1,j));
    return this ;
  }
  
  
  /**
  * divise par le vecteur V  chaque ligne de la matrice
  @param V vecteur (matrice ligne)
  @return this
  **/
  public MatR divVectLigne(MatR V){
    int i,j;	
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	set(i,j,get(i,j)/V.get(1,j));
    return this ;
  }
  
  /**
  * multiplie par le vecteur V  chaque colonne de la matrice
  @param V vecteur (matrice colonne)
  @return this
  **/
  public MatR multVectColonne(MatR V){
    transpose();V.transpose();
    multVectLigne(V);
    transpose();V.transpose();
    return this ;
  }
  
  
  /**
  * divise par le vecteur V  chaque colonne de la matrice
  @param V vecteur (matrice colonne)
  @return this
  **/
  public MatR divVectColonne(MatR V){
    transpose();V.transpose();
    divVectLigne(V);
    transpose();V.transpose();
    return this ;
  }
  
  /**
  * recherche le maximum de chaque colonne. Retourne une matrice contenant les max.
  @return vecteur des max
  **/
  public MatR maxColonnes(){
    int i,j; MatR S=new MatR(1,p());
    double sj;
    for (j=1;j<=p();j++) {
      sj=get(1,j) ;
      for (i=1;i<=n();i++) 
	if ( sj<get(i,j)) sj=get(i,j) ; 
      S.setv(j,sj) ;
    }
    S.setNomc(this);
    return S;
  }
  
  
  /**
  * recherche le minimum de chaque colonne. Retourne une matrice contenant les min.
  @return vecteur des min
  **/
  public MatR minColonnes(){
    changeSigne();
    MatR S=maxColonnes();
    S.changeSigne();changeSigne();
    return S;
  }
  
  /**
  * recherche le max dans la matrice.
  @return maximum de la matrice
  **/
  public double max(){
    int i,j;double m=get(1,1);
    for (i=1;i<=n();i++)
    for (j=1;j<=p();j++){
      double xij=get(i,j);
      if (xij>m) m=xij;
    }
    return m;
  }
  
  
  /**
  * recherche le min dans la matrice.
  @return minimum de la matrice
  **/
  public double min(){
    changeSigne();
    double m=-max();
    changeSigne();
    return m;
  }
  
  
  /**
  * calcule la somme de tous les termes
  @return somme de tous les termes de la matrice
  **/
  public double somme(){
    int i,j;double s=0 ;
    for (i=1;i<=n();i++)
    for (j=1;j<=p();j++){
      s+=get(i,j);
    }
    return s;
  }
  
  /**
  * calcule la somme de chaque colonne
  @return vecteur des sommes des colonnes
  **/
  public MatR sommeColonnes(){
    int i,j; MatR S=new MatR(1,p());
    double sj;
    for (j=1;j<=p();j++) {
      sj=0;
      for (i=1;i<=n();i++) 
	sj+=get(i,j); 
      S.setv(j,sj) ;
    }
    S.setNomc(this);
    return S;
  }
  
  /**
  * calcule la somme de chaque ligne
  @return vecteur des sommes des lignes
  **/
  public MatR sommeLignes(){
    transpose();
    MatR S=sommeColonnes();
    S.transpose();transpose();
    return S;
  }
  
  /**
  * calcule la somme des colonnes. 
  * Chaque élément de la colonne est affecté d'un poids.
  @param pd poids des lignes
  @return vecteur des sommes pondérées des colonnes
  **/
  public MatR sommeColonnesP(MatR pd){
    int i,j; MatR S=new MatR(1,p());
    double sj;
    for (j=1;j<=p();j++) {
      sj=0;
      for (i=1;i<=n();i++) 
	sj+=get(i,j)*pd.getv(i); 
      S.setv(j,sj) ;
    }
    S.setNomc(this);
    return S;
  }
  
  
  /**
  * calcule la somme des carrés des éléments de chaque colonne
  @return vecteur contenant les sommes des termes aux carrés de chaque colonne
  **/
  public MatR sommeCarresColonnes(){
    int i,j; MatR S=new MatR(1,p());
    double sj;
    for (j=1;j<=p();j++) {
      sj=0;
      for (i=1;i<=n();i++) 
	sj+=get(i,j)*get(i,j); 
      S.setv(j,sj) ;
    }
    S.setNomc(this);
    return S;
  }
  
  /**
  * calcule la somme pondérée des carrés des éléments de chaque colonne
  @param pd poids des lignes
  @return vecteur des sommes pondérées des éléments de chaque colonne
  **/
  public MatR sommeCarresColonnesP(MatR pd){
    int i,j; MatR S=new MatR(1,p());
    double sj;
    for (j=1;j<=p();j++) {
      sj=0;
      for (i=1;i<=n();i++) 
	sj+=get(i,j)*get(i,j)*pd.getv(i);  
      S.setv(j,sj) ;
    }
    S.setNomc(this);
    return S;
  }
  
  
  
  /**
  * calcule la norme au carré de chaque colonne
  @return vecteur des normes carrées des colonnes
  **/
  public MatR normeCarreeColonnes(){
    return sommeCarresColonnes();
  }
  
  /**
  * calcule la norme de chaque colonne
  @return vecteur des normes des colonnes
  **/
  public MatR normeColonnes(){
    MatR s=sommeCarresColonnes();
    s.racineCarree();
    return s;
  }
  
  /**
  * calcule la norme de chaque colonne
  @param vecteur des poids
  @return vecteur des normes pondérées des colonnes
  **/
  public MatR normeColonnesP(MatR Pd){
    MatR s=sommeCarresColonnesP(Pd);
    s.racineCarree();
    return s;
  }
  
  
  /**
  * calcule la moyenne de chaque colonne
  @return vecteur des moyennes des colonnes
  **/
  public MatR moyenneColonnes(){
    MatR M=sommeColonnes();M.multCste(1.0/(double)n());
    return M;
  }
  
  /**
  * calcule la moyenne de chaque colonne si chaque ligne est affectée d'un poids
  @param vecteur des poids
  @return vecteur des moyennes des colonnes
  **/
  public MatR moyenneColonnesP(MatR pd){
    MatR M=sommeColonnesP(pd);M.multCste(1.0/pd.somme());
    return M;
  }
  
  /**
  * calcule la moyenne des carrées pour chaque colonne si chaque ligne est affectée d'un poids
  @param vecteur des poids
  @return vecteur des moyennes des carrés des éléments des colonnes
  **/
  public MatR moyenneCarresColonnesP(MatR pd){
    MatR M=sommeCarresColonnesP(pd);M.multCste(1.0/pd.somme());
    return M;
  }
  
  
  
  /**
  * calcule la moyenne des carrés de chaque colonne
  @return vecteur des moyennes des carrés des éléments des colonnes
  **/
  public MatR moyenneCarresColonnes(){
    MatR M=sommeCarresColonnes();M.multCste(1.0/(double)n());
    return M;
  }
  
  
  /**
  * calcule la variance de chaque colonne
  @return vecteur des variances des colonnes
  **/
  public MatR varianceColonnes(){
    MatR v=moyenneCarresColonnes();
    MatR m=moyenneColonnes();m.carre();
    v.subVectLigne(m);
    return v;
  }
  
  /**
  * calcule la variance de chaque colonne avec poids
  @return vecteur des variances
  **/    
  public MatR varianceColonnesP(MatR pd){
    MatR v=moyenneCarresColonnesP(pd);
    MatR m=moyenneColonnesP(pd);m.carre();
    v.subVectLigne(m);
    return v;       
  }
  
  /**
  * calcule l'écart-type de chaque colonne
  @return vecteur de écarts-types
  **/
  public MatR ecartTypeColonnes(){
    MatR v=varianceColonnes();
    v.racineCarree();
    return v;
  }
  
  /**
  * calcule l'écart-type de chaque colonne, chaque ligne étant pondérée 
  @return vecteur de écarts-types
  **/
  public MatR ecartTypeColonnesP(MatR Pd){
    MatR v=varianceColonnesP(Pd);
    v.racineCarree();
    return v;
  }
  
  /**
  * Calcule la somme des colonnes, dans chacun des groupes définis par g (Le premier groupe doit porter le n° 1) Le poids (effectif) de chaque groupe est calculé.
  @param g vecteur des groupes (numérotés de 1 à ..) 
  @param pdg poids des groupes
  @return vecteur des sommes
  **/
  public MatR sommeColonnesParGroupes(MatR g, MatR pdg )
  { // les groupes doivent etre numérotés à partir de 1
    int i,j ; MatR s=new MatR((int)g.max(),p()) ;
    pdg.initmem((int)g.max(),1) ;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	s.inc((int)g.getv(i),j,get(i,j)) ;
    for (i=1;i<=n();i++)
      pdg.inc((int)g.getv(i),1) ;
    return s;
  }
  
  /**
  * Calcule la moyenne des colonnes, dans chacun des groupes définis par g (Le premier
  * groupe doit porter le n° 1) Le poids (effectif) de chaque groupe est calculé.
  @param g vecteur des groupes (numérotés de 1 à ..) 
  @param pdg poids des groupes
  @return vecteur des moyennes
  **/
  public MatR moyenneColonnesParGroupes(MatR g, MatR pdg )
  {
    MatR m=sommeColonnesParGroupes( g, pdg );
    m.transpose();pdg.transpose();m.divVectLigne(pdg);
    m.transpose();pdg.transpose();
    return m;
  }
  
  
  
  
  /**
  * Dans le cas où les lignes sont affectées d'un poids (défini par pd),
  * calcule la somme des colonnes, dans chacun des groupes définis par g (Le premier
  * groupe doit porter le n° 1) Le poids de chaque groupe est calculé.
  @param g vecteur des groupes (numérotés de 1 à ..) 
  @param pd poids des lignes
  @param pdg poids des groupes
  @return vecteur des sommes  
  **/
  public MatR sommeColonnesParGroupesP(MatR g, MatR pd, MatR pdg )
  { // les groupes doivent etre numérotés à partir de 1
    int i,j ; MatR s=new MatR((int)g.max(),p()) ;
    pdg.initmem((int)g.max(),1) ;
    for (i=1;i<=n();i++)
      for (j=1;j<=p();j++)
	s.inc((int)g.getv(i),j,get(i,j)*pd.getv(i)) ;
    for (i=1;i<=n();i++)
      pdg.inc((int)g.getv(i),1,pd.getv(i)) ;
    return s;
  }
  
  
  /**
  * Dans le cas où les lignes sont affectées d'un poids (défini par pd),
  * calcule la moyenne des colonnes, dans chacun des groupes définis par g (Le premier
  * groupe doit porter le n° 1) Le poids de chaque groupe est calculé.
  @param g vecteur des groupes (numérotés de 1 à ..) 
  @param pd poids des lignes
  @param pdg poids des groupes
  @return vecteur des moyennes
  **/
  public MatR moyenneColonnesParGroupesP(MatR g, MatR pd, MatR pdg )
  {
    MatR m=sommeColonnesParGroupesP( g, pd, pdg );
    m.transpose();pdg.transpose();m.divVectLigne(pdg);
    m.transpose();pdg.transpose();
    return m;
  }
  
  /**
  * centre la matrice en colonnes
  @return la matrice centrée (this)
  **/
  public MatR centrer(){
    subVectLigne(moyenneColonnes()); return this ;
  }
  
  /**
  * centre la matrice en colonnes quand chaque ligne est affectée d'un poids
  @return la matrice centrée (this)
  **/
  public MatR centrerP(MatR pd){
    subVectLigne(moyenneColonnesP(pd)); return this ;
  }
  
  
  /**
  * norme  les colonnes de la matrice 
  @return la matrice normée
  **/
  public MatR normer(){
    divVectLigne(normeColonnes()); return this ;
  }
  
  
  /**
  * norme la matrice en colonnes quand chaque ligne est affectée d'un poids
  @return la matrice normée (this)
  */
  public MatR normerP(MatR Pd){
    divVectLigne(normeColonnesP(Pd)); return this ;
  }
  
  
  /**
  * réduit les colonnes de la matrice 
  @return la matrice réduite
  **/
  public MatR reduire(){
    divVectLigne(ecartTypeColonnes());return this ;
  }
  
  /**
  * réduit la matrice en colonnes quand chaque ligne est affectée d'un poids
  @return la matrice réduite (this)
  */
  public MatR reduireP(MatR pd){
    divVectLigne(ecartTypeColonnesP(pd)); return this ;
  }
  
  /**
  * centre et réduit les colonnes
  @return la matrice centrée réduite (this)
  **/
  public MatR centrerReduire(){
    centrer();reduire(); return this ;
  }


  /**
  * centre et réduit la matrice en colonnes quand chaque ligne est affectée d'un poids
  @return la matrice réduite (this)
  */
  public MatR centrerReduire(MatR pd){
    centrerP(pd);reduireP(pd);return this ;
  }
  
  
  /**
  * centre et norme les colonnes
  @return la matrice centrée réduite (this)
  **/
  public MatR centrerNormer(){
    centrer();normer(); return this ;
  }
  
  
  /**
  * centre et norme la matrice en colonnes quand chaque ligne est affectée d'un poids
  @return la matrice centrée normée (this)
  */  
  public MatR centrerNormerP(MatR pd){
    centrerP(pd);normerP(pd); return this ;
  }
  
  /**
  * @return la matrice des profils lignes multipliée par une constante c
  **/
  public MatR profilsLignes(int c){
    MatR m=copy();
    m.divVectColonne(m.sommeLignes());m.multCste(c);
    return m;
  }
  
  
  /**
  * @return la matrice des profils lignes
  * (chaque ligne est divisée par sa somme)
  **/
  public MatR profilsLignes(){ return profilsLignes(1);}
  
  /**
  * @return  la matrice des profils colonnes multipliée par une constante c
  **/
  public MatR profilsColonnes(int c){
    transpose();
    MatR m=profilsLignes(c);m.transpose();transpose();
    return m;
  }
  
  
  /**
  * @return   la matrice des profils colonnes
  * (chaque colonne est divisée par sa somme)
  **/
  public MatR profilsColonnes(){ return profilsColonnes(1); }
  
  
  /**
  * @return la matrice multipliée par une matrice B. 
  **/
  public MatR multMat(MatR B){
    MatR P= new MatR(n(),B.p());
    int i,j,k ;double aij;
    for (i=1;i<=P.n();i++)
    for (j=1;j<=P.p();j++) {
      aij=0 ;
      for (k=1;k<=p();k++)
	aij+=this.get(i,k)*B.get(k,j);
      P.set(i,j,aij);
    }
    P.setNoml(this);P.setNomc(B);
    return P;
  }
  
  
  
  /**
  * @return   le produit de la matrice transposée par elle même
  **/
  public MatR XtX(){ 
    MatR P= new MatR(p(),p());
    int i,j,k ;double aij;
    for (i=1;i<=P.n();i++)
    for (j=1;j<=P.p();j++) {
      aij=0 ;
      for (k=1;k<=n();k++)
	aij+=this.get(k,i)*get(k,j);
      P.set(i,j,aij);
    }
    P.setNomc(this);P.setNoml(this.getNomc());
    return P;
  }
  
  
  /**
  * Calcule l'histogramme (effectifs des valeurs) d'un vecteur dont les composantes sont entières
  @return l'histogramme 
  **/
  public MatR histoVect(){      
    int nbClasses=(int)(max()-min()+1);
    MatR h=new MatR(nbClasses,1);
    for (int i=1;i<=n();i++){
      int num=(int)this.getv(i);
      h.incv(num);
    }    
    return h ;
  }
  
  
  /**
  * Calcule l'histogramme en nc classes d'un vecteur dont les composantes sont réelles
  * les bornes des intervalles sont calculées dans "bornes".
  @param nc nombre de classes
  @param bornes calculées par la méthode
  @return l'histogramme
  **/
  public MatR histoVect(int nc,MatR bornes){      
    double max=max(),min=min();
    return histoVect(nc,bornes,min,max);
  }
  
  /**
  * Calcule l'histogramme en nc classes d'un vecteur dont les composantes sont réelles
  * L'intervalle [Min,Max] est divisé en nc intervalles égaux (cet intervalle doit
  * contenir tous les termes du vecteur.
  * les bornes des intervalles sont calculées dans "bornes".
  @param nc nombre de classes
  @param bornes calculées par la méthode
  @param min borne inf de l'intervalle
  @param min borne sup de l'intervalle
  @return l'histogramme
  **/
  public MatR histoVect(int nc,MatR bornes,double min, double max){      
    bornes.initmem(nc+1,1); int i,j;
    MatR h=new MatR(nc,1);
    for (i=0;i<=nc;i++){
      bornes.setv(i+1,min+(max-min)/nc*i);
    }   
    for (i=1;i<=n();i++)
    for (j=1;j<=nc;j++){
      if (getv(i)<=bornes.getv(j+1)) {h.incv(j);break;}
    }
    return h;
  }
  
  /**
  * idem, mais seules sont prises en compte les valeurs vérifiant la condition cond[i]
  **/
  public MatR histoVect(int nc,MatR bornes, boolean cond[]){      
    // histo seulement pour les éléménts vérifiant la condition cond
    double max=-1.0e20,min=1.0e20; int i;double vi;
    for (i=1;i<=n();i++){
      if (!cond[i]) continue ;
      vi=getv(i);
      if (vi>max) max=vi;
      if (vi<min) min=vi;
    }
    return histoVect(nc,bornes,min,max,cond);
  }
  
  /**
  * idem, mais les bornes sont définies par division de l'intervalle [min,max] 
  **/
  public MatR histoVect(int nc,MatR bornes,double min, double max, boolean cond[]){
    // histo seulement pour les éléménts vérifiant la condition cond
    bornes.initmem(nc+1,1); int i,j; double vi ;
    MatR h=new MatR(nc,1);
    for (i=0;i<=nc;i++){
      bornes.setv(i+1,min+(max-min)/nc*i);
    }   
    for (i=1;i<=n();i++){
      if (!cond[i]) continue; else vi=getv(i);
      for (j=1;j<=nc;j++){
	if (vi<=bornes.getv(j+1)) {h.incv(j);break;}
      }
    }
    return h;
  }
  
  
  
  /* Les procedures qui suivent sont tirées de Numerical Recipes
  **/
  
  private double pythag(double a, double b)  {
    double absa,absb;
    absa=Math.abs(a);
    absb=Math.abs(b);
    if (absa > absb) return absa*Math.sqrt(1.0+(absb/absa)*(absb/absa));
    else return (absb == 0.0 ? 0.0 : absb*Math.sqrt(1.0+(absa/absb)*(absa/absb)));
  }
  
  
  
  private void tred2(double a[][], int n, double d[], double e[])
  {
    int l,k,j,i;
    double scale,hh,h,g,f;
    
    for (i=n;i>=2;i--) {
      l=i-1;
      h=scale=0.0;
      if (l > 1) {
	for (k=1;k<=l;k++)
	  scale += Math.abs(a[i][k]);
	if (scale == 0.0)
	  e[i]=a[i][l];
	  else {
	    for (k=1;k<=l;k++) {
	      a[i][k] /= scale;
	      h += a[i][k]*a[i][k];
	    }
	    f=a[i][l];
	    g=(f >= 0.0 ? -Math.sqrt(h) : Math.sqrt(h));
	    e[i]=scale*g;
	    h -= f*g;
	    a[i][l]=f-g;
	    f=0.0;
	    for (j=1;j<=l;j++) {
	      a[j][i]=a[i][j]/h;
	      g=0.0;
	      for (k=1;k<=j;k++)
		g += a[j][k]*a[i][k];
	      for (k=j+1;k<=l;k++)
		g += a[k][j]*a[i][k];
	      e[j]=g/h;
	      f += e[j]*a[i][j];
	    }
	    hh=f/(h+h);
	    for (j=1;j<=l;j++) {
	      f=a[i][j];
	      e[j]=g=e[j]-hh*f;
	      for (k=1;k<=j;k++)
		a[j][k] -= (f*e[k]+g*a[i][k]);
	    }
	  }
      } else
      e[i]=a[i][l];
      d[i]=h;
    }
    d[1]=0.0;
    e[1]=0.0;
    /* Contents of this loop can be omitted if eigenvectors not
    wanted except for statement d[i]=a[i][i]; **/
    for (i=1;i<=n;i++) {
      l=i-1;
      if (d[i]>0) {  // au lieu de if (d[i]) 
	for (j=1;j<=l;j++) {
	  g=0.0;
	  for (k=1;k<=l;k++)
	    g += a[i][k]*a[k][j];
	  for (k=1;k<=l;k++)
	    a[k][j] -= g*a[k][i];
	}
      }
      d[i]=a[i][i];
      a[i][i]=1.0;
      for (j=1;j<=l;j++) a[j][i]=a[i][j]=0.0;
    }
  }
  
  private double SIGN(double a,double b){
    return ((b) >= 0.0 ? Math.abs(a) : -Math.abs(a));
  }
  
  
  private void tqli(double d[], double e[], int n, double z[][])
  {
    //double pythag(double a, double b);
    int m,l,iter,i,k;
    double s,r,p,g,f,dd,c,b;
    
    for (i=2;i<=n;i++) e[i-1]=e[i];
    e[n]=0.0;
    for (l=1;l<=n;l++) {
      iter=0;
      do {
	for (m=l;m<=n-1;m++) {
	  dd=Math.abs(d[m])+Math.abs(d[m+1]);
	  if ((double)(Math.abs(e[m])+dd) == dd) break;
	}
	if (m != l) {
	  //if (iter++ == 30) nrerror("Too many iterations in tqli");
	  g=(d[l+1]-d[l])/(2.0*e[l]);
	  r=pythag(g,1.0);
	  g=d[m]-d[l]+e[l]/(g+SIGN(r,g));
	  s=c=1.0;
	  p=0.0;
	  for (i=m-1;i>=l;i--) {
	    f=s*e[i];
	    b=c*e[i];
	    e[i+1]=(r=pythag(f,g));
	    if (r == 0.0) {
	      d[i+1] -= p;
	      e[m]=0.0;
	      break;
	    }
	    s=f/r;
	    c=g/r;
	    g=d[i+1]-p;
	    r=(d[i]-g)*s+2.0*c*b;
	    d[i+1]=g+(p=s*r);
	    g=c*r-b;
	    for (k=1;k<=n;k++) {
	      f=z[k][i+1];
	      z[k][i+1]=s*z[k][i]+c*f;
	      z[k][i]=c*z[k][i]-s*f;
	    }
	  }
	  if (r == 0.0 && i >= l) continue;
	  d[l] -= p;
	  e[l]=g;
	  e[m]=0.0;
	}
      } while (m != l);
    }
  }
  
  
  private void diagQR(double a[][], int n, double  d[])
  {
    double  e[] ; 
    e=new double[n+1] ;
    
    tred2(a,n,d,e);
    tqli(d,e,n,a);
  }  
  
  
  /**
  * diagonalisation de la matrice (elle doit être symétrique définie positive)
  * Les vecteurs propres (en colonnes) sont stockés dans q, 
  * et les valeurs propres dans lbd)
  Il faut initialiser q et lbd avant l'appel
  @param q vecteurs propres
  @param lbd valeurs propres
  **/
  public void diag(MatR q, MatR lbd){
    int i,j,v; 
    double lbd0[]=new double[n()+1];
    double q0[][]=new double[n()+1][p()+1];
    
    for (i=1;i<=n();i++) for (j=1;j<=p();j++)  q0[i][j]=this.get(i,j); 
    diagQR(q0,n(),lbd0);
    lbd.initmem(n(),1);
    for (i=1;i<=n();i++)  lbd.set(i,1,lbd0[i]) ;
    q.initmem(n(),p());
    for (i=1;i<=n();i++) for (j=1;j<=p();j++) q.set(i,j,q0[i][j]); 
    // tri des valeurs/vecteurs propres
    int ind[]=new int[n()+1];int rg[]=new int[n()+1] ;
    lbd.changeSigne();
    lbd.triVect(ind,rg) ;
    lbd.changeSigne();
    for (i=1;i<=n();i++)
    { if (i != rg[i])
      { q.echangeColonnes(i,ind[i]);
	v=rg[i] ; rg[i]=rg[ind[i]] ;rg[ind[i]]=v ;
	int u=ind[i];ind[i]=ind[v]; ind[v]=u;   
      }
    }
    if (q.get(1,1)<0) q.changeSigne();
    for (i=1;i<=p();i++) q.setNomc(i,"c"+i);
    q.setNoml(this);
  }
  
  /*
  * tri d'un vecteur avec constitution d'un index 
  * index doit etre de dimension n+1, et déclaré dans le prog appelant par
  *  index= new int[n+1]  
  * Les valeurs triées sont dans a
  **/
  private void heapsort(double a[] , int n, int  index[])
  {
    int i,j,k, iv ; double v ;
    for (i=1;i<=n;i++) {index[i]=i;} 
    a[0]=1.0E+20 ;
    for (k=2;k<=n;k++)
    { i=k ; v=a[i] ; iv=index[i] ;
      while (a[i/2]<v)
	{ a[i]=a[i/2] ;index[i]=index[i/2] ; i=i/2 ; }
      a[i]=v ;index[i]=iv ;
    }
    for (k=n;k>=2;k--)
    { v=a[1]; a[1]=a[k] ; a[k]=v ;
      iv=index[1]; index[1]=index[k] ; index[k]=iv ;
      i=1 ; v=a[1] ; iv=index[1] ;
      while (2*i<k)
      { j=2*i ;
	if ( (j+1<k)&&(a[j] < a[j+1]) ) {j++;}  
	if ( v<a[j] ) { a[i]=a[j] ;index[i]=index[j]; i=j ;} 
	else {break;}
      }
      a[i]=v ;index[i]=iv ;
    }
  }
  
  
  /*
  *tri d'un vecteur sans constitution d'index
  **/
  private void  heapsort(double a[], int n)
  {
    int i,j,k; double v ;
    a[0]=1.0E+20 ; //sentinelle
    for (k=2;k<=n;k++)
    { i=k ; v=a[i] ; 
      while (a[i/2]<v)
	{ a[i]=a[i/2] ; i=i/2 ; }
      a[i]=v ;
    }
    for (k=n;k>=2;k--)
    { v=a[1]; a[1]=a[k] ; a[k]=v ;
      i=1 ; v=a[1] ;
      while (2*i<k)
      { j=2*i ;
	if ( (j+1<k)&&(a[j] < a[j+1]) ) {j++;}  
	if ( v<a[j] ) { a[i]=a[j] ; i=j ;} else {break;}
      }
      a[i]=v ;
    }
  }
  
  
  /**
  * tri des éléments de la matrice supposée avoir une dimension égale à 1.
  **/
  public void  heapsort(){
    // idem précédent mais pas besoin de passer par un vecteur auxiliaire
    // mais moins rapide
    int i,j,k; double v ;
    int n=( (n()==1) ? p() : n() ) ;
    // a[0]=1.0E+20 ; //sentinelle remplacée par
    int kMax;double aMax;
    kMax=1;aMax=getv(1);
    for (k=1;k<=n;k++) if (getv(k)>aMax) {aMax=getv(k);kMax=k;}
    setv(kMax,getv(1));setv(1,aMax) ;
    
    for (k=2;k<=n;k++)
    { i=k ; v=getv(i) ; 
      while (getv(i/2)<v)
	{ setv(i,getv(i/2)) ; i=i/2 ; }
      setv(i,v) ;
    }
    for (k=n;k>=2;k--)
    { v=getv(1);setv(1,getv(k));setv(k,v);//v=a[1]; a[1]=a[k] ; a[k]=v ;
      i=1 ; v=getv(1) ;
      while (2*i<k)
      { j=2*i ;
	if ( (j+1<k)&&(getv(j) < getv(j+1)) ) {j++;}  
	if ( v<getv(j) ) { setv(i,getv(j)) ; i=j ;} else {break;}
      }
      setv(i,v) ;
    }
  }
  
  
  /**
  * tri des éléments de la matrice supposée avoir une dimension égale à 1.
  **/ 
  public void triVect(){
    int n,i; n=( (n()==1) ? p() : n() ) ;
    double x[]=new double[n+1];
    for (i=1;i<=n;i++) x[i]=getv(i) ;
    heapsort(x,n);
    for (i=1;i<=n;i++) setv(i,x[i]) ;
  }
  
  
  
  
  /**
  * tri des éléments de la matrice supposée avoir une dimension égale à 1,
  * avec constitution d'un index.
  **/ 
  public void triVect(int index[]){
    int n,i; n=( (n()==1) ? p() : n() ) ;
    double x[]=new double[n+1];
    for (i=1;i<=n;i++) x[i]=getv(i) ;
    heapsort(x,n,index);
    for (i=1;i<=n;i++) setv(i,x[i]) ;
  }
  
  /**
  * tri des éléments de la matrice supposée avoir une dimension égale à 1,
  * avec constitution d'un index et du tableau des rangs.
  **/ 
  public void triVect(int index[],int rang[]){
    int n,i; n=( (n()==1) ? p() : n() ) ;
    triVect(index);
    for (i=1;i<=n;i++) rang[index[i]]=i;
  }
  
  
  private void SWAP(double a,double b){
    double p=a;a=b;b=p;
  }
  
  
  private void gaussj(double a[][], int n, double b[][], int m)
  // attention les messages d'erreur ont été supprimés
  // a matrice carrée, n : dimension de a, b vecteur des 2èmes membres, 
  // m : nb de col de b ; en sortie a est inversée ; b contient les sol des syst.
  {
    int indxc[],indxr[],ipiv[];
    int i,icol,irow,j,k,l,ll;
    double big,dum,pivinv,temp;
    
    icol=0 ; irow=0 ;
    indxc = new int[n+1]; 
    indxr = new int[n+1]; 
    ipiv  = new int[n+1]; 
    for (j=1;j<=n;j++) ipiv[j]=0;
    for (i=1;i<=n;i++) {
      big=0.0;
      for (j=1;j<=n;j++)
	if (ipiv[j] != 1)
	for (k=1;k<=n;k++) {
	  if (ipiv[k] == 0) {
	    if (Math.abs(a[j][k]) >= big) {
	      big=Math.abs(a[j][k]);
	      irow=j;
	      icol=k;
	    }
			} else if (ipiv[k] > 1){}; //nrerror("gaussj: Singular Matrix-1");
	}
	ipiv[icol]=ipiv[icol]+1;//++(ipiv[icol]);
	if (irow != icol) {
	  for (l=1;l<=n;l++) SWAP(a[irow][l],a[icol][l]);
	  for (l=1;l<=m;l++) SWAP(b[irow][l],b[icol][l]);
	}
	indxr[i]=irow;
	
	indxc[i]=icol;
	if (a[icol][icol] == 0.0) {};//nrerror("gaussj: Singular Matrix-2");
	pivinv=1.0/a[icol][icol];
	a[icol][icol]=1.0;
	for (l=1;l<=n;l++) a[icol][l] *= pivinv;
	for (l=1;l<=m;l++) b[icol][l] *= pivinv;
	for (ll=1;ll<=n;ll++)
	if (ll != icol) {
	  dum=a[ll][icol];
	  a[ll][icol]=0.0;
	  for (l=1;l<=n;l++) a[ll][l] -= a[icol][l]*dum;
	  for (l=1;l<=m;l++) b[ll][l] -= b[icol][l]*dum;
	}
    }
    for (l=n;l>=1;l--) {
      if (indxr[l] != indxc[l])
	for (k=1;k<=n;k++)
	  SWAP(a[k][indxr[l]],a[k][indxc[l]]);
    }
  }
  
  
  /**
  * résolution d'un système linéaire this * x=b (la matrice doit être carrée!)
  @param B vecteur des seconds membres
  @param X contient la solution.
  @return la matrice triangulaire
  **/ 
  public MatR solveGauss(MatR B,MatR X){
    // résolution du systeme linéaire this.X=B
    // retourne l'inverse. La solution est dans X
    int i,j ;
    MatR A=this.copy();X.initmem(B.n(),B.p()) ;
    double A0[][]=new double[n()+1][p()+1];
    double B0[][]=new double[B.n()+1][B.p()+1];
    for (i=1;i<=n();i++) for (j=1;j<=p();j++) A0[i][j]=this.get(i,j);
    for (i=1;i<=B.n();i++) for (j=1;j<=B.p();j++) B0[i][j]=B.get(i,j);
    gaussj(A0,this.n(),B0,B.p());
    for (i=1;i<=n();i++) for (j=1;j<=p();j++) A.set(i,j,A0[i][j]);
    for (i=1;i<=B.n();i++) for (j=1;j<=B.p();j++) X.set(i,j,B0[i][j]);
    return A; 
  }
  
  /**
  * @return la matrice inverse (la matrice doit être carrée!)
  **/
  public MatR inverse(){
    MatR B=new MatR(n(),1);MatR X=new MatR();
    return solveGauss(B,X);      
  }
  
  
  /**
  * retaille la matrice en lui donnant les dimension n1,p1
  **/
  public MatR retaille(int n1, int p1){
    MatR m=new MatR(n1,p1);int i,j,i1,j1,k;
    k=0;
    for (i=1;i<=n();i++)
    for (j=1;j<=p();j++){ k++;
      i1=(k-1)/p1 +1; j1=(k-1)%p1 +1;
      m.set(i1,j1,get(i,j));
    }
    return(m);
  }
  
  
  
  
  /**
  * lecture de  la matrice sur le fichier nf avec en-tête
  * pas de noms de lignes ni de colonnes. n et p sur la première ligne
  @param nf nom du fichier
  @throws  IOException
  **/
  public void lireSimple0(String nf) throws IOException {
    int i,j,n0=0,p0=0 ;
    FileReader fichier = new FileReader(nf);
    StreamTokenizer entree = new StreamTokenizer(fichier);
    if (entree.nextToken()== StreamTokenizer.TT_NUMBER) n0=(int)entree.nval ; 
    if (entree.nextToken()== StreamTokenizer.TT_NUMBER) p0=(int)entree.nval ;
    initmem(n0,p0);
    for (i=1;i<=n0;i++)
    for (j=1;j<=p0;j++){
      if (entree.nextToken()== StreamTokenizer.TT_NUMBER)
	_t[i-1][j-1]= (double)entree.nval;
    }
    
    fichier.close();
  }
  
  /**
  * @deprecated
  */
  public void lireSimple(String nf) throws IOException {
    //noms de lignes et de colonnes. n et p sur la première ligne 
    //suivi de 1 si il y a une chaine v00 avant le premier nom de colonne, 0 (ou rien) sinon
    // conservé pour compatibilité avec les précédentes versions
    lire(nf);
  }
  
  
  /**
  * lecture d'un fichier avec en tête contenant une matrice. 
  * le fichier peut comporter ou pas des noms de lignes et de colonnes. 
  * n et p sur la première ligne 
  * suivi de 1 (défaut) si noms de lignes , 0 sinon
  * suivi de 1 (défaut) si noms de colonnes, 0 sinon 
  * suivi de 1 si il y a une chaine v00 avant le premier nom de colonne, 0 (défaut) sinon
  @param nf nom du fichier
  *
  **/ 
  public void lire(String nf) throws IOException {
    int i,j ;
    int n0=0,p0=0,x ;int v00=0;int vnl=1; int vnc=1; // contenu de la ligne 1
    
    FileReader fichier = new FileReader(nf);
    BufferedReader d = new BufferedReader(fichier);
    
    StringTokenizer st=new StringTokenizer(d.readLine());
    n0=Integer.parseInt(st.nextToken()) ;
    p0=Integer.parseInt(st.nextToken()) ;
    if (st.hasMoreTokens()) vnl= Integer.parseInt(st.nextToken()) ;
    if (st.hasMoreTokens()) vnc= Integer.parseInt(st.nextToken()) ;
    if (st.hasMoreTokens()) v00= Integer.parseInt(st.nextToken()) ;
    
    boolean nomsLignes=(vnl==1);
    boolean nomsColonnes=(vnc==1);
    
    lireMatrice(d,n0,p0,nomsLignes,nomsColonnes,v00);
    fichier.close();
  }
  
  
  /**
  * lecture d'un fichier contenant une matrice. On doit indiquer s'il y a
  * des noms de lignes et de colonnes (false absence ou true présence)
  @param nf nom du fichier
  * @param nomsLignes = true s'il y a des noms de lignes
  * @param nomsColonnes = true s'il y a des noms de colonnes
  @throws  IOException 
  **/ 
  public void lire(String nf, boolean  nomsLignes, boolean nomsColonnes) throws IOException {
    int i,j,x ;
    int ll=compteLignes(nf);
    int cc[]=compteColonnes(nf,ll);int n0=0,p0=0,v00=0 ;
    if ( !nomsLignes & !nomsColonnes) {n0=ll; p0=cc[0];}
    if ( !nomsLignes & nomsColonnes) {n0=ll-1; p0=cc[0];}
    if ( nomsLignes & !nomsColonnes) {n0=ll; p0=cc[0]-1;}
    if ( nomsLignes & nomsColonnes) {
      n0=ll-1; p0=cc[1]-1;
      if (cc[0]!=cc[1])v00=0; else v00=1; 
    }
    
    FileReader fichier = new FileReader(nf);
    BufferedReader d = new BufferedReader(fichier);
    lireMatrice(d,n0,p0,nomsLignes,nomsColonnes,v00);
    fichier.close();
  }
  
  
  private void lireMatrice(BufferedReader d, int n0, int p0,boolean nomsLignes,boolean nomsColonnes, int v00)throws IOException {
    int i,j;StringTokenizer st ;
    
    initmem(n0,p0);
    // lecture des noms de colonnes
    if  (nomsColonnes){                  
      st=new StringTokenizer(d.readLine());
      if (v00>0) st.nextToken() ;
      for (i=1;i<=p0;i++) _nomc.setElementAt(st.nextToken(),i-1);
    }  
    //lecture de la matrice
    for (i=1;i<=n0;i++){
      st=new StringTokenizer(d.readLine());
      if (nomsLignes)  _noml.setElementAt(st.nextToken(),i-1);
      for (j=1;j<=p0;j++) {
	try{_t[i-1][j-1]=Double.parseDouble(st.nextToken()) ;}
	catch(NumberFormatException e){_t[i-1][j-1]=Double.NaN ;}
      }
    }
  }
  
  
  /**
  * pour compatibilité avec anciennes versions
  * @deprecated 
  **/
  public void lire(String nf, int  vnl, int vnc) throws IOException {
    lire(nf,vnl==1,vnc==1);
  }
  
  
  /** 
  @param nf nom du fichier
  * @return vrai si le deuxième élément de la première ligne n'est pas un nombre.
  * (il y alors des noms de colonnes)
  **/
  public static boolean detectNomsColonnes (String nf) throws IOException {
    FileReader fichier = new FileReader(nf);boolean res ;
    BufferedReader d = new BufferedReader(fichier);
    StringTokenizer st=new StringTokenizer(d.readLine());st.nextToken();
    try { Double.valueOf(st.nextToken());  res= false ;}
    catch (Exception e){ res=true ;}
    return res; 
  }
  
  
  /** 
  * retourne vrai si le premier élément de la deuxième ligne n'est pas un nombre
  * (il y a alors des noms de lignes)
  **/
  public static boolean detectNomsLignes (String nf) throws IOException {
    FileReader fichier = new FileReader(nf);boolean res;
    BufferedReader d = new BufferedReader(fichier);
    d.readLine();
    StringTokenizer st=new StringTokenizer(d.readLine());
    try { Double.valueOf(st.nextToken());  res= false ;}
    catch (Exception e){ res=true ;}
    return res ; 
  }
  
  
  /**
  * compte le nombre de lignes non vides dans un fichier
  @param nf nom du fichier
  @return nombre de lignes
  @throws  IOException
  **/
  public static int compteLignes(String nf) throws  IOException {
    String s ; 
    FileReader fichier = new FileReader(nf);
    BufferedReader d = new BufferedReader(fichier);
    boolean fin=false ;int count=0 ;s="";
    while (s!=null){
      s=d.readLine();
      if (s!=null && !s.trim().equals("")) count++; 
    }
    fichier.close();
    return count;
  }
  
  
  /**
  * compte le nombre d'éléments sur chaque ligne d'un fichier
  * @param nf nom du fichier
  @param nbLignes nombres de lignes
  @return vecteur contenant le nombre d'éléments sur chaque ligne 
  **/
  public static int[] compteColonnes(String nf, int nbLignes) throws  IOException {
    int n0=nbLignes ; String s;
    int nc[]=new int[n0] ;
    FileReader fichier = new FileReader(nf);
    BufferedReader d = new BufferedReader(fichier);
    for (int i=0;i<n0;i++) {
      StringTokenizer st=new StringTokenizer(d.readLine());
      nc[i]=st.countTokens();
    }
    fichier.close();
    return nc ;  
  }  
  
  
    
  /**
  * @return le projecteur sur le sous-esp engendré par les colonnes
  * = x(x'x)^-1x'
  */
  public MatR getProjecteur(){
    return (multMat(XtX().inverse())).multMat(tr());
  } 
  
  /**
  * @return le projecteur sur le sous-espace orth = I- x(x'x)^-1x'
  */
  public MatR getProjecteurOrth(){
    MatR p=getProjecteur();p.multCste(-1);
    for (int i=1;i<=p.n();i++) p.inc(i,i,1);
    return p ;
  }
  
  /**
  * @return la projection de m sur le sous-esp engendré par les colonnes
  * = x(x'x)^-1x'm
  @param m matrice contenant les colonnes à projeter
  */
  public MatR getProjection(MatR m){
    return getProjecteur().multMat(m); 
  }
  
  /**
  * @return les coord de la projection de m sur les colonnes = (x'x)^-1x'y
  @param m matrice contenant les colonnes à projeter
  */
  public MatR getCoordProjection(MatR m){
    return (XtX().inverse()).multMat(tr()).multMat(m); 
  }
  
  /**
  * @return la projection de m sur le sous-esp orth
  * = x(x'x)^-1x'm
  @param m matrice contenant les colonnes à projeter
  */
  public MatR getProjectionOrth(MatR m){
    return getProjecteurOrth().multMat(m);      
  }

  
  /* main pour effectuer des essais
  public static void main(String Arg[])throws IOException{
    int nc[]=MatR.compteColonnes("xx.dat",MatR.compteLignes("xx.dat"));
    for (int i=0;i<nc.length;i++){System.out.println(nc[i]); }
    MatR X=new MatR();
    X.lire("xx.dat",true,true);X.afficheSimple();
  }
  */
  
  
  
}
