// Lecture des données
dat = read("/home/Bart/Documents/M2SITN/POO/github/Tests/data1.txt" , -1 , 7) ;
// Centrage des données 
dat_barre = sum(dat,1)/size(dat,1) ;
dat = dat - dat_barre(ones(size(dat,1),:),:) ;

cor = dat'*dat/size(dat,1) ;

valP = spec(cor) ; //valeur propre
disp(valP) ;
[Ab,vectP]=bdiag(cor) ;
disp(vectP) ;