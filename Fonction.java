  
import java.util.Random ;
import java.util.Vector ;
import java.util.StringTokenizer ;
import java.io.*;

public class Fonction extends MatR{

    public Fonction(double[][] x){
	super(x);
    }

    public static double[] get(MatR mat){

	double m[] = new double [mat.n()*mat.p()];
	for (int i=0;i<mat.n();i++)
	    for (int j=0;j<mat.p();j++)
		m[i+j]=mat.get(i+1,j+1);
	return m ;

    }

    // public static void main(String[] args){
	//double[][] val1 = {{1,2,3},{2,1,3},{5,4,3}};
	//Fonction mat1 = new Fonction(val1);
	//mat1.afficheSimple("mat1");
	//double[] mat2=get(mat1);
	// Fonction mat3 = new Fonction(mat2);
	// mat3.afficheSimple();

	// double[][] val1 = {{15,1,2},{5,1,1},{1,1,20}};
    	// MatR f1 = new MatR(val1);
	// Fonction f1bis = (Fonction) f1.maxColonnes();
	// // MatR f1bis = f1.maxColonnes();

	// // double[][] val2 = {{15},{1},{20}};
    	// // Fonction f2 = new Fonction(val2);


 	// // double[] tab1 = get(f1bis);
 	// // double[] tab2 = get(f2);

	// // for (int j=0;j<3;j++){
	// // System.out.println(tab1[j]);
	// // System.out.println(tab2[j]);
	// // }

    // }


}