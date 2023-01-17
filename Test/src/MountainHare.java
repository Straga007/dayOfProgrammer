public class MountainHare {
    int jumpLength;
    int age;
    double weight;
     static String season;
     static String color ;
    // добавьте переменные и конструктор
    public MountainHare(int age, double weight, int jumpLength ){
        this.age = age;
        this.weight = weight;
        this.jumpLength = jumpLength;
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
                "age=" + age +
                ", weight=" + weight +
                ", jumpLength=" + jumpLength +
                ", color=" + color +
                '.';
    }


}