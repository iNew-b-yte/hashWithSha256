package Features.Chain;

import java.util.ArrayList;
import java.util.Iterator;

import Features.Block.Block;

/**
 * The class {@code ChainImplementation} that implements interface {@code ChainInterface} functions
 * and add blocks to the blockChain
 */
public class ChainImplementation implements ChainInterface {
    
  
    public static int difficulty = 3;

    //Defining an ArrayList "BlockChain" of Block type
    public static ArrayList<Block> blockChain = new ArrayList<>();
    
    @Override

    
    public void addBlock(String data) {
        
        //if the size of the blockChain is zero, only then the genesisBlock or the first Block is added
       if (blockChain.size() == 0){
           Block genesisBlock = new Block("0", data);
           blockChain.add(genesisBlock);
            System.out.println("Trying to Mine First Block or Genesis Block ... ");

            // calling the mineBlock() function
            genesisBlock.mineBlock(difficulty);

           
       }

       else { 
           //if the blockChain is not zero, then the below code will be executed
           String prevHash = blockChain.get(blockChain.size()-1).hash;
                    Block newBlock = new Block(prevHash, data);
                    blockChain.add(newBlock);  
                System.out.println("Trying to Mine  next block ....");

                //calling the mineBlock() function 
                newBlock.mineBlock(difficulty);

              
                
                }
    }

    @Override
    public Boolean CheckValidity() {
        Block currentBlock;  
        Block previousBlock;  

        String newTarget = new String( new char[difficulty]).replace('\0', '0');

        for (int  i = 1; i < blockChain.size(); i++){

            
            currentBlock = blockChain.get(i);   
            previousBlock= blockChain.get(i-1);

            //compare registered hash and calculated hash of current block

            if (!currentBlock.hash.equals(currentBlock.calculatedHash(previousBlock.hash, currentBlock.getData()))){
                System.out.println("Current hashes are not equal");
                return false;
            }
                // compare hash of the previous block and previous hash of the current block
            if (!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous hashes are not equal");
                return false;
            }
                //compare the substring of the hash with the "newTarget"
            if (!currentBlock.hash.substring(0, difficulty).equals(newTarget) ){
                System.out.println("This block has not been mined");
                return false;
            }

        }
        return true;
    }

    @Override    
    public void iterator() {
       Iterator<Block> it = blockChain.iterator();
       while (it.hasNext()){
           for( int x = 0; x < blockChain.size(); x++){
               System.out.println(it.next()+" : "+blockChain.get(x).hash);
           }
       }
        
    }

  
    }





