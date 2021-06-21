package Features.Chain;


/**
 * The interface {@code ChainInterface} has functions such as
 * {@code addBlock(String data)} and {@code CheckValidity()}
 */
public interface ChainInterface {


    /**
     * The function {@code addBlock(String data)} takes some {@code data} and add blocks into the
     *  {@code blockChain} 
     */
    public void addBlock(String data);
    

    /** 
     * The function {@code CheckValidity()} checks whether the blockChain is valid or not                
    */
    public Boolean CheckValidity();
    

    /** 
     * The function {@code iterator()} iterates through all the blocks and print their hashes on the output 
     * screen
     */
    public void iterator();


}
