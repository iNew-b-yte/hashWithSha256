package Features.Block;

import java.util.Date;

import Core.utils.Sha256;

/**The class {@code Block} has {@code hash} of itself , hash of previous block
 * which is {@code previousHash},some {@code data}, {@code timeStamp} and
 * {@code nonce}  */

public class Block implements BlockInterface{
    public String hash;
    public String previousHash;
    private String data;
    private Long timeStamp;
    private int nonce;

    //The Constructor Block initializes the values
    public Block(String previousHash, String data){
        this.data=data;
        this.previousHash=previousHash;
        this.timeStamp=new Date().getTime();
        this.hash= calculatedHash(previousHash, data);

    }
    @Override
    public String calculatedHash(String previousHash, String data) {
        return Sha256.sha256(previousHash + data + Long.toString(timeStamp) + Integer.toString(nonce));
    }
    @Override
    public String getData() {
            return this.data;
    }

    @Override
    public void mineBlock(int difficulty) {

        //Declaring char array with parameter "difficulty" inside the string "hashTarget" and
        //replacing those characters with "0". 
        String hashTarget = new String ( new char[difficulty]).replace('\0', '0');

        /* comparing the substring of the hash with the "hashTarget" 
        If not equal, then nonce is increased by 1 and new hash is calulated using the new nonce until 
        the target is met*/
        while ( !hash.substring(0,difficulty).equals(hashTarget)){
            nonce++;
            hash = calculatedHash(previousHash, data);
           
        }
        System.out.println("Block Mined : "+ hash);
    }

  

}
