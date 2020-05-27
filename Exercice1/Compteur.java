package Exercice1;

public class Compteur extends Thread{

    public Compteur(String nom){
        super(nom);
    }

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(currentThread().getName()+" : "+i);
            try{
                Thread.sleep(1000);
               }
            catch(InterruptedException e){ }
        }
            System.out.printf(" le %s a fini ",currentThread().getName());
    }
    public static void main(String[] args) {
        Compteur[] cpts = {
            new Compteur("Cpt1"),new Compteur("Cpt2"),new Compteur("Cpt3"),new Compteur("Cpt4"),new Compteur("Cpt5")
         };
        for(Compteur c:cpts){
            c.start();
        }
        
    }
}