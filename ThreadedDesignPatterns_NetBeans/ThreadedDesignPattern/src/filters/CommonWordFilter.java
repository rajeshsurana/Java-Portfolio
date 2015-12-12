/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dao.CommonWordsDAO;

/**
 *
 * @author Rajesh Surana
 */
public class CommonWordFilter implements FilterInterface {
    
    public CommonWordFilter() {
    }

    @Override
    public String executePreProcessing(String request) {
        String[] commonWordsList = CommonWordsDAO.getAllDisneyCharacters();
        for(String commonWord: commonWordsList){
            if(commonWord.equals(request)){
                request = "";
                break;
            }
        }
        return request;
    }

    @Override
    public String executePostProcessing(String request) {
        return request;
    }
    
}
