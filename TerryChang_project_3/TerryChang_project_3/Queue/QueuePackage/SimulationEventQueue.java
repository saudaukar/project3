package QueuePackage;
import java.util.Vector;
import java.util.List;


public class SimulationEventQueue implements SimulationEventQueueInterface{

    private double currentTime;
    private List<SimulationEvent> queue = new Vector<SimulationEvent>();
    
    public void add(SimulationEvent newEntry){
        int index = 0;
        while (index < queue.size() && queue.get(index).getTime() <= newEntry.getTime()){
            index++;
        }
        queue.add(index, newEntry);
    }

    public SimulationEvent remove(double timeChange){
        currentTime = timeChange;
        return queue.remove(0);
    }

    public SimulationEvent remove(){
        return queue.remove(0);
    }

    public SimulationEvent peek(){
        return queue.get(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int getSize(){
        return queue.size();
    }

    public void clear(){
        queue.clear();
    }

    public double getCurrentTime(){
        return currentTime;
    }
}