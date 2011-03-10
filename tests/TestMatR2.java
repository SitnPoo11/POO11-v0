/** Avant de compiler ce fichier, taper dans le terminal :
    export CLASSPATH = ..:.;
**/

/** 
 *  Cette classe de tests n'utilise pas jUnit.
 *  Elle n'est là que pour voir comment récupérer 
 *  un fichier txt.
 **/

public class TestMatR2{

    public static void main (String [] args){
	try{
    MatR mat1 = new MatR("data1.txt");
    mat1.afficheSimple("Data");
    System.out.println(mat1.get(1,1));
    System.out.println(mat1.get(1,2));
    System.out.println(mat1.get(2,1));
	}
	catch(Exception e){};
    }

}