package test;

public class Subtask extends Task {

    public Subtask(String taskName, String taskDetail, String status, int ID, int epicID) {
        super(taskName, taskDetail, status, ID, epicID);
    }

    @Override
    public String toString() {
        return "test.Subtask{" +
                "taskName='" + taskName + '\'' +
                ", taskDetail='" + taskDetail + '\'' +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                ", epicID=" + epicID +
                '}';
    }
}
