import java.util.*;
class Activity{
    private Float startTime;
    private Float endTime;
    
    public Activity(){}
    public Activity(Float startTime, Float endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Float getStartTime(){
        return startTime;
    }
    public Float getEndTime(){
        return endTime;
    }
   
    public void setStartTime(Float startTime){
        this.startTime = startTime;
    }
   
    public void setEndTime(Float endTime){
        this.endTime = endTime;
    }
    
    public Float getDuration(){
        return endTime - startTime;
    }
    @Override
    public String toString(){
        return "Activity [Start Time: " + startTime + ", End Time: " + endTime + "]";
    }
}

public class IntervalScheduling{
    // Key will be Activity's endTime
    // Value will be all activities with same endTime
    private Map<Float, List<Activity>> items;
    public IntervalScheduling(){
        // TreeMap insterts keys in sorted order,
        // so we don't have to sort according to endTime
        items = new TreeMap<Float, List<Activity>>();
    }
    public void setActivities(List<Activity> activities){
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
    }
    
    // Tree map is sorted with endTime keys
    // If two activities ends at same time we choose whichever 
    // starts first, so our resources will be busy max time
    // performaing max number of possible activities
    public List<Activity> getOptimalSchedule(){
        List<Activity> optimalSchedule = new ArrayList<Activity>();
        Float lastEndTime = -1f;
        for(Float endTime: items.keySet() ){
            List<Activity> actList = items.get(endTime);
            // If there are many activities that ends with the same
            // end time we break tie by  selecting activity
            // that starts earlier
            Float duration = 0f;
            Activity maxDurationActivity = null;
            for(Activity a: actList){
                if(a.getStartTime()>lastEndTime){
                    if(duration < a.getDuration()){
                        duration = a.getDuration();
                        maxDurationActivity = a;
                    }
                }
            }
            if(maxDurationActivity != null){
                lastEndTime = maxDurationActivity.getEndTime();
                optimalSchedule.add(maxDurationActivity);
            }
        }
        return optimalSchedule;
    }
    
    public static void main(String[] args){
        IntervalScheduling intsch = new IntervalScheduling();
        Activity a1 = new Activity(1f,7f);
        Activity a2 = new Activity(3f, 4f);
        Activity a3 = new Activity(6f, 10f);
        Activity a4 = new Activity(11f, 15f);
        Activity a5 = new Activity(11f, 13f);
        Activity a6 = new Activity(14f, 15f);
        Activity a7 = new Activity(1f, 4f);
        List<Activity> actList = new ArrayList<Activity>();
        actList.add(a1);
        actList.add(a2);
        actList.add(a3);
        actList.add(a4);
        actList.add(a5);
        actList.add(a6);
        actList.add(a7);
        intsch.setActivities(actList);
        List<Activity> optList = intsch.getOptimalSchedule();
        System.out.println(optList);
        /* Output ->
        [Activity [Start Time: 1.0, End Time: 4.0], Activity [Start Time: 6.0, End Time: 10.0], Activity [Start Time: 11.0, End Time: 13.0], Activity [Start Time: 14.0, End Time: 15.0]]
        */
    }
}
