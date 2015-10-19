public class DecimalConverter{
    public static int toDecimal(int number, int base){
        return Integer.parseInt(""+number, base);
        
        // Traditional way to do this
        /*
            int result = 0;
            int multiplier = 1;
            while(number>0){
                result += number%10 * multiplier;
                multiplier *= base;
                number /= 10;
            }
            return result;
        */
    }
    
    public static void main(String[] args){
        System.out.println(DecimalConverter.toDecimal(1111, 2));
    }
}