package Core.utils;

import java.security.MessageDigest;

/**
 * The Class {@code Sha256} generates a fixed 256 bit hash of any given arbitrary value 
 * and returns it in the string format
 */
public class Sha256 {

    /** The function {@code sha256(String value)} has a parameter value which is passed when this function is
     * called
     */
    public static String sha256(String value){
        try {

            //MessageDigest class which is a security provider. Here its object "sha_Instance" is created
            //which gets the instance of SHA-256 algorithm from the message digest class
            MessageDigest sha_Instance = MessageDigest.getInstance("SHA-256");


                //Applies sha 256 algorithm to the value
                
                byte[] hashValue = sha_Instance.digest(value.getBytes("UTF-8"));

                StringBuffer hexdec_value = new StringBuffer(); //This will contain hash as hexidecimal

                for (byte d : hashValue){

                    hexdec_value.append(String.format("%02x", d));
                }

                 return hexdec_value.toString();

  


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
