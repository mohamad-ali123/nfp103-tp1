package Exercice2;

import java.util.concurrent.atomic.AtomicInteger;

public class Compteur extends Thread{
    AtomicInteger niveau;
    public Compteur(String name,AtomicInteger niveau){
        super(name);
        this.niveau=niveau;
    }

    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(currentThread().getName()+" : "+i);
            try{
                Thread.sleep(1000); }
            catch(InterruptedException e){ }
            if(i==4){
                synchronized(System.out){
                System.out.printf(" Le %s a fini de niveau %d ",currentThread().getName(),niveau.incrementAndGet());
                }
            }
        }
        
    }
    public static void main(String[] args) {
        AtomicInteger niveau=new AtomicInteger(0);
        Compteur[] cpts = {
            new Compteur("Cpt1",niveau),new Compteur("Cpt2",niveau),new Compteur("Cpt3",niveau), new Compteur("Cpt4",niveau),new Compteur("Cpt5",niveau)
        };
        for(Compteur c:cpts){
            c.start();
    }
        
    }
}