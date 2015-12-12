/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Rajesh Surana
 */
public class SaltingPasswordFilter implements FilterInterface {

    public SaltingPasswordFilter() {
    }
    
    @Override
    public String executePreProcessing(String request) {
        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        byte[] encodedSalt = Base64.encodeBase64(salt); 
        String saltString = new String(encodedSalt);
        request = request.concat(saltString);
        return request;
    }

    @Override
    public String executePostProcessing(String request) {
        if(request.length()>=44){
            request = request.substring(0,request.length()-44);
        }
        return request;
    }
    
}
