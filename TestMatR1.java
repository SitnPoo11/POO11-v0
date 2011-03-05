public class TestMatR1{

    public static void main (String [] args){
 
    double[][] tab = {{1,2,3},{4,5,6},{7,8,9}};
    MatR mat1 = new MatR(tab);
    mat1.afficheSimple("Matrice");
    MatR mat2 = mat1.tr();
    double[][] tab2 = mat2.MatRToDouble();
    MatR mat3 = new MatR(tab2);
    MatR mat4 = mat3.extraireBloc(2,mat3.n(),2,mat3.p());
    mat3.afficheSimple("tr");
    mat4.afficheSimple("tr");

    double[][] tab3 = {{1,2,3},{4,5,6}};
    MatR mat5 = new MatR(tab3);
    mat5.afficheSimple("Matrice");
    double[][] tab4 = mat5.tr().MatRToDouble();
    MatR mat6 = new MatR(tab4);
    mat6.supprimeLigne(1);
    mat6.supprimeColonne(1);
    mat6.afficheSimple("transpose");
    }

}