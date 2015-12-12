package filters;

import dao.CurseWordsDAO;

public class CurseWordFilter implements FilterInterface {

    public CurseWordFilter() {
    }
    
    @Override
    public String executePreProcessing(String request) {
        String[] curseWordsList = CurseWordsDAO.getAllCurseWords();
        
        for(String curseWord: curseWordsList){
            if(curseWord.equals(request)){
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
