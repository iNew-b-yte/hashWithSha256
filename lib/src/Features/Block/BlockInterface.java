package Features.Block;

/**
 * An interface {@code BlockInterface} has various functions such as
 * {@code calculatedHash(String previousHash, String data )}, {@code getData()}
 * and {@code mineBlock(int difficulty)}
 */
public interface BlockInterface {

    /** The function {@code calculatedHash(String previousHash, String data )} calculates the hash of the block 
    */
    public String calculatedHash(String previousHash, String data );


    /**A getter which gets the data */
    public String getData();

    /**
     * The function {@code mineBlock(int difficulty)} mines the block according to {@code difficulty}
     * before the block is added to the blockChain
     */
    public void mineBlock(int difficulty);
    
    

}
