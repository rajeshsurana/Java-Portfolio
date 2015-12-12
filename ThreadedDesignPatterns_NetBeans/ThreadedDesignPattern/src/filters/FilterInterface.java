package filters;


public interface FilterInterface {
    String executePreProcessing(String request);

    /**
     *
     * @param request
     * @return
     */
    String executePostProcessing(String request);
}
