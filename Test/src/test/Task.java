
public class Task {

    String taskName;
    String taskDetail;
    String status;

    int ID;
    int epicID;

    public Task(String taskName, String taskDetail, String status, int ID) {
        this.taskName = taskName;
        this.taskDetail = taskDetail;
        this.status = status;
        this.ID = ID;
    }

    public Task(String taskName, String status,int ID) {
        this.taskName = taskName;
        this.ID=ID;
        this.status=status;

    }
    public Task(String taskName, String taskDetail, String status, int ID, int epicID) {
        this.taskName = taskName;
        this.taskDetail = taskDetail;
        this.status = status;
        this.ID = ID;
        this.epicID = epicID;

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEpicID() {
        return epicID;
    }

    public void setEpicID(int epicID) {
        this.epicID = epicID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskDetail='" + taskDetail + '\'' +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                '}';
    }
}