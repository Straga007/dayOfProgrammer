public class Epic extends Task {
    public Epic(String taskName,String status, int ID) {
        super(taskName,status,ID);
        this.taskName = taskName;
        //this.ID=ID;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                '}'+"";
    }
}
