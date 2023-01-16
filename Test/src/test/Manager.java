import enums.AvailableStatus;
import test.Epic;
import test.Subtask;
import test.Task;

import java.util.*;

public class Manager {
    int ID = 0;

    Map<Integer, Task> taskMap = new HashMap<Integer, Task>();
    Map<Integer,Subtask> subtaskMap = new HashMap<Integer, Subtask>();
    Map<Integer,Epic> newEpicMap = new HashMap<Integer,Epic>();

    Map<Integer,String> epicStatus = new HashMap<Integer,String>();

    public void addNewTask(String taskName, String taskDetail, String status){

        createNewID();
        taskMap.put(ID, new Task(taskName,taskDetail,status,ID));
    }
    public void addNewEpic(String taskName){

        createNewID();
        String status=String.valueOf(AvailableStatus.Status.NEW);
        newEpicMap.put(ID, new Epic(taskName,status,ID));
        epicStatus.put(ID,"");

    }
    public void addNewSubtask(String taskName, String taskDetail, String status, int epicID){

        createNewID();
        subtaskMap.put(ID, new Subtask(taskName,taskDetail,status,ID,epicID));
        checkEpicStatus(epicID);

    }





    private void checkEpicStatus(int ID){
        epicStatus.put(ID,"");
        for (int count : subtaskMap.keySet()) {
            if(subtaskMap.get(count).epicID == ID){
                epicStatus.put(ID,epicStatus.get(ID)+" "+subtaskMap.get(count).status);
                //System.out.println("epicStatus "+epicStatus);
            }
        }
        if(epicStatus.containsKey(ID)){
            if(epicStatus.get(ID).contains("DONE") &
                    !epicStatus.get(ID).contains("IN_PROGRESS") &
                    !epicStatus.get(ID).contains("NEW")){
                newEpicMap.get(ID).status="DONE";

            }
            if(!epicStatus.get(ID).contains("DONE") &
                    !epicStatus.get(ID).contains("IN_PROGRESS") &
                    epicStatus.get(ID).contains("NEW")){
                newEpicMap.get(ID).status="NEW";
            }
            if(epicStatus.get(ID).contains("IN_PROGRESS")){
                newEpicMap.get(ID).status="IN_PROGRESS";
            }
        }
    }

    public void updateTaskMapByID(String taskName, String taskDetail,String status,int ID){
        if (taskMap.containsKey(ID)){
            taskMap.put(ID, new Task(taskName,taskDetail,status,ID));
        }else {
            System.out.println("Мы не test.Task по ID="+ID);
        }
    }
    public void updateEpicMapByID(String taskName, int ID){
        if(newEpicMap.containsKey(ID)){
            newEpicMap.put(ID, new Epic(taskName,newEpicMap.get(ID).status,ID));
        }else {
            System.out.println("Мы не test.Epic по ID="+ID);
        }
    }
    public void updateSubtaskByID(String taskName, String taskDetail,String status,int epicID,int ID){
        if(subtaskMap.containsKey(ID)){
            subtaskMap.put(ID, new Subtask(taskName, taskDetail, status, ID, epicID));
        }else{
            System.out.println("Мы не test.Subtask по ID="+ID);
        }
        checkEpicStatus(epicID);
    }
    public void deliteByID(int ID){
        if(taskMap.containsKey(ID)){
            taskMap.remove(ID);
        }else if(newEpicMap.containsKey(ID)){
            newEpicMap.remove(ID);
        } else if (subtaskMap.containsKey(ID)) {
            int oldEpicID=subtaskMap.get(ID).epicID;
            subtaskMap.remove(ID);
            checkEpicStatus(oldEpicID);

        }else{
            System.out.println("Мы не нашли задачу по ID="+ID);
        }

    }


    public List getAllEpic(){
        List epicList= new ArrayList();
        for (int count: newEpicMap.keySet()) {
            epicList.add(newEpicMap.get(count));
        }
        return epicList;
    }
    public List getAllTask(){
        List taskList= new ArrayList();
        for (int count: taskMap.keySet()) {
            taskList.add(taskMap.get(count));
        }
        //System.out.println("taskList "+taskList);
        return taskList;
    }
    public List getAllSubtask(){
        List subtaskList= new ArrayList();
        for (int count: subtaskMap.keySet()) {
            subtaskList.add(subtaskMap.get(count));
        }
        return subtaskList;
    }
    public void deliteAll(){
        newEpicMap.clear();
        taskMap.clear();
    }
    private void createNewID() {
        this.ID++;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "taskMap=" + taskMap+"\n" +
                ", newEpicMap=" + newEpicMap+"\n" +
                ", subtaskMap=" + subtaskMap+"\n" +
                '}';
    }
}

