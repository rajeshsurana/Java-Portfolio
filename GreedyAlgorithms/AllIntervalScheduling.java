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

class ClassRoom{
    private List<Activity> classroom;
    private Float lastActivityEndTime;
    // Update lastActivityEndTime each time
    // new activity is assigned.
    public void assignActivity(Activity a){
        classroom.add(a);
        if(a.getEndTime() > lastActivityEndTime){
            lastActivityEndTime = a.getEndTime();
        }
    }
    public List<Activity> getAllActivities(){
        return classroom;
    }
    public String toString(){
        return "ClassRoom [ Activities : " + classroom + ", Last Activity End Time: "+ lastActivityEndTime + "]";
    }
    public Float getLastActivityEndTime(){
        return lastActivityEndTime;
    }
    public ClassRoom(){
        classroom = new ArrayList<Activity>();
        lastActivityEndTime = -1f;
    }
}

public class AllIntervalScheduling{
    private Map<Float, List<Activity>> optimalSchedule;
    public AllIntervalScheduling(){
        // We use TreeMap so that all the activities are sorted
        // with start time at the time of insertion itself
        optimalSchedule = new TreeMap<Float, List<Activity>>();
    }
    // Add activities according to start time
    public void addActivities(List<Activity> actList){
        for(Activity a: actList){
            if(optimalSchedule.containsKey(a.getStartTime())){
                List<Activity> tempActList = optimalSchedule.get(a.getStartTime());
                tempActList.add(a);
                optimalSchedule.put(a.getStartTime(), tempActList);
            }else{
                List<Activity> tempActList = new ArrayList<Activity>();
                tempActList.add(a);
                optimalSchedule.put(a.getStartTime(), tempActList);
            }
        }
    }
    
    public List<ClassRoom> getOptimalAllIntervalSchedule(){
        List<ClassRoom> classRooms = new ArrayList<ClassRoom>();

        for(Float startTime: optimalSchedule.keySet()){
            List<Activity> actList = optimalSchedule.get(startTime);
            // Check each activity against each class till
            // we assign activity to some class
            // If no class available then add it to new class.
            for(Activity a: actList){
                boolean added = false;
                for(ClassRoom c: classRooms){
                    if(c.getLastActivityEndTime() < a.getStartTime()){
                        c.assignActivity(a);
                        added = true;
                        break;
                    }
                }
                if(!added){
                    ClassRoom tempClassRoom = new ClassRoom();
                    tempClassRoom.assignActivity(a);
                    classRooms.add(tempClassRoom);                     
                }
            }
        }
        return classRooms;
    }
    
    public static void main(String[] args){
        AllIntervalScheduling allIntSch = new AllIntervalScheduling();
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
        allIntSch.addActivities(actList);
        List<ClassRoom> optClassSch = allIntSch.getOptimalAllIntervalSchedule();
        System.out.println("Optimal class Schedule: ");
        
        for(int i = 0; i< optClassSch.size(); i++){
            System.out.println(i+1+". "+ optClassSch.get(i));
        }
        System.out.println("Number of classes: " + optClassSch.size());
        /* Output:
        Optimal class Schedule:
        1. ClassRoom [ Activities : [Activity [Start Time: 1.0, End Time: 7.0], Activity [Start Time: 11.0, End Time: 15.0]], Last Activity End Time: 15.0]
        2. ClassRoom [ Activities : [Activity [Start Time: 1.0, End Time: 4.0], Activity [Start Time: 6.0, End Time: 10.0], Activity [Start Time: 11.0, End Time: 13.0], Activity [Start Time: 14.0, End Time: 15.0]], Last Activity End Time: 15.0]
        3. ClassRoom [ Activities : [Activity [Start Time: 3.0, End Time: 4.0]], Last Activity End Time: 4.0]
        Number of classes: 3 */
    }
}