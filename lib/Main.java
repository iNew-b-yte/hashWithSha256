

import Features.Chain.ChainImplementation;
import Features.Chain.ChainInterface;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ChainInterface chainObject = new ChainImplementation();

        
        chainObject.addBlock("First");
        chainObject.addBlock("Second");
        chainObject.addBlock("Third");
        chainObject.addBlock("Fourth");
        chainObject.addBlock("Fifth");

        chainObject.iterator();   

        boolean res = chainObject.CheckValidity();

            System.out.println("Block Chain is :"+ res);

            

          



    }
}