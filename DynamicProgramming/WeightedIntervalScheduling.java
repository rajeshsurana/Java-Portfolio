import java.util.*;
class Activity{
    private Float startTime;
    private Float endTime;
    private Float weight; 
    
    public Activity(){}
    public Activity(Float startTime, Float endTime, Float weight){
        this.startTime = startTime;
        this.endTime = endTime;
        this.weight = weight;
    }
    
    public Float getStartTime(){
        return startTime;
    }
    public Float getEndTime(){
        return endTime;
    }
    
    public Float getWeight(){
        return weight;
    }
   
    public void setStartTime(Float startTime){
        this.startTime = startTime;
    }
   
    public void setEndTime(Float endTime){
        this.endTime = endTime;
    }
    
    public void setWeight(Float weight){
        this.weight = weight;
    }
    
    public Float getDuration(){
        return endTime - startTime;
    }
    @Override
    public String toString(){
        return "Activity [Start Time: " + startTime + ", End Time: " + endTime + ", Weight: " + weight +"]";
    }
}

public class WeightedIntervalScheduling{
    // sorted list with end time 
    private List<Activity> sortedList;
    // to hold p(i)
    private int[] p;
    // to hold w(i)
    private Float[] w;
    
    public WeightedIntervalScheduling(){
        sortedList = new ArrayList<Activity>();
    }
    public void addActivities(List<Activity> activities){
        // Key will be Activity's endTime
        // Value will be all activities with same endTime
        Map<Float, List<Activity>> items;
        // TreeMap insterts keys in sorted order,
        // so we don't have to sort according to endTime
        items = new TreeMap<Float, List<Activity>>();
        for(Activity a: activities){
            if(items.containsKey(a.getEndTime())){
                List<Activity> listActivity = items.get(a.getEndTime());
                listActivity.add(a);
                items.put(a.getEndTime(), listActivity);
            }else{
                List<Activity> listActivity = new ArrayList<Activity>();
                listActivity.add(a);
                items.put(a.getEndTime(), listActivity);
            }
        }
        
        // Populate sorted list 
        for(Float endTime: items.keySet()){  
             sortedList.addAll(items.get(endTime));
        }
        //Initialize w and p array
        w = new Float[sortedList.size()];
        Arrays.fill(w, -1f);
        w[0] = 0f;
        p = new int[sortedList.size()];
        Arrays.fill(p, 0);
        
        // calculate p(i)
        for(int i=0; i< sortedList.size(); i++){
            for(int j=i; j>=0; j--){
                if(sortedList.get(i).getStartTime()>sortedList.get(j).getEndTime()){
                    p[i] = j;
                    break;
                }
            }
       }
       System.out.println("Sorted activity list according to finish time");
        for(int k=0; k<sortedList.size(); k++){
            System.out.println("P["+k+"]" + p[k] + " - " + sortedList.get(k));
        }
    }
    // Dynamic programming approach
    // Memoization technique for performance
    public Float MComputeOpt(int j){
        if(j >= sortedList.size()) return -1f;
        if(w[j] == -1f){
            w[j] = Math.max(sortedList.get(j).getWeight() + MComputeOpt(p[j]), MComputeOpt(j-1));
        }            
        return w[j]; 
    }
    
    // Use memoized array to determine solution
    public void printSolution(int j){
        if(j==0){
            return;
        }
        if(sortedList.get(j).getWeight() + w[p[j]] >= w[j-1]){
            printSolution(p[j]);
            System.out.println(sortedList.get(j));
        }else{
            printSolution(j-1);
        }
    }
    public static void main(String[] args){
        WeightedIntervalScheduling allIntSch = new WeightedIntervalScheduling();
        Activity a1 = new Activity(1f,7f, 7f);
        Activity a2 = new Activity(3f, 4f, 3f);
        Activity a3 = new Activity(6f, 10f, 5f);
        Activity a4 = new Activity(11f, 15f, 1f);
        Activity a5 = new Activity(11f, 13f, 2f);
        Activity a6 = new Activity(14f, 15f, 4f);
        Activity a7 = new Activity(1f, 4f, 3f);
        List<Activity> actList = new ArrayList<Activity>();
        actList.add(a1);
        actList.add(a2);
        actList.add(a3);
        actList.add(a4);
        actList.add(a5);
        actList.add(a6);
        actList.add(a7);
        allIntSch.addActivities(actList);
        System.out.println("\nMax weight possible: " + allIntSch.MComputeOpt(6));
        System.out.println("\nActivities selected:");
        allIntSch.printSolution(6);
        /* output:
        Sorted activity list according to finish time
        P[0]0 - Activity [Start Time: 3.0, End Time: 4.0, Weight: 3.0]
        P[1]0 - Activity [Start Time: 1.0, End Time: 4.0, Weight: 3.0]
        P[2]0 - Activity [Start Time: 1.0, End Time: 7.0, Weight: 7.0]
        P[3]1 - Activity [Start Time: 6.0, End Time: 10.0, Weight: 5.0]
        P[4]3 - Activity [Start Time: 11.0, End Time: 13.0, Weight: 2.0]
        P[5]3 - Activity [Start Time: 11.0, End Time: 15.0, Weight: 1.0]
        P[6]4 - Activity [Start Time: 14.0, End Time: 15.0, Weight: 4.0]

        Max weight possible: 14.0

        Activities selected:
        Activity [Start Time: 1.0, End Time: 4.0, Weight: 3.0]
        Activity [Start Time: 6.0, End Time: 10.0, Weight: 5.0]
        Activity [Start Time: 11.0, End Time: 13.0, Weight: 2.0]
        Activity [Start Time: 14.0, End Time: 15.0, Weight: 4.0]
        */
    }
}
