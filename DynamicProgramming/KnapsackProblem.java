import java.util.*;
class Item{
    int id;
    int value;
    int weight;
    public void setId(int id){
        this.id = id;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getId(){
        return id;
    }
    public int getValue(){
        return value;
    }
    public int getWeight(){
        return weight;
    }
    public String toString(){
        return "Item [ID: "+ id + ", Value: " + value + ", Weight: " + weight + "]";
    }
    public Item(int id, int value, int weight){
        this.id = id;
        this.value = value;
        this.weight = weight;
    }
}

public class KnapsackProblem{
        
    public static int[][] getSolution(List<Item> itemList, int weight){
        int numberOfItems = itemList.size();
        int[][] maxSubset = new int[numberOfItems+1][weight+1];
        for(int i=0; i<weight; i++){
            maxSubset[0][i] = 0;
        }
        for(int i=1; i<= numberOfItems; i++){
            for(int w=1; w <= weight; w++){
                if(itemList.get(i-1).getWeight() > w){
                    maxSubset[i][w] = maxSubset[i-1][w];
                }else{
                    maxSubset[i][w] = Math.max(maxSubset[i-1][w], itemList.get(i-1).getValue() + maxSubset[i-1][w-itemList.get(i-1).getWeight()]);
                }
            }
        }
        return maxSubset;
    }
    
    public static void main(String[] args){
        int weightLimit = 11;
        Item i1 = new Item(1, 1, 1);
        Item i2 = new Item(2, 6, 2);
        Item i3 = new Item(3, 18, 5);
        Item i4 = new Item(4, 22, 6);
        Item i5 = new Item(5, 28, 7);
        List<Item> iList = new ArrayList<Item>();
        iList.add(i1);
        iList.add(i2);
        iList.add(i3);
        iList.add(i4);
        iList.add(i5);
        int[][] sol = KnapsackProblem.getSolution(iList, weightLimit);
        for(int i=0; i<= iList.size(); i++){
            for(int j=0; j<= weightLimit; j++){
                System.out.printf("%02d ",sol[i][j]);
            }
            System.out.println();
        }
        /*output:
        column   w-> 0...w weightLimit
        rows n-> 0...n  items 
        00 00 00 00 00 00 00 00 00 00 00 00
        00 01 01 01 01 01 01 01 01 01 01 01
        00 01 06 07 07 07 07 07 07 07 07 07
        00 01 06 07 07 18 19 24 25 25 25 25
        00 01 06 07 07 18 22 24 28 29 29 40
        00 01 06 07 07 18 22 28 29 34 35 40
        */
    }
}