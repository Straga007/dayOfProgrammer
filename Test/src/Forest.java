import java.util.List;

public class Forest {
    private List<MountainHare> hares;

    public Forest(List<MountainHare> hares) {
        this.hares = hares;
    }

    // добавьте метод setSeason(String newSeason)
    static void setSeason(String newSeason){
        MountainHare.season = newSeason;

        if(newSeason.equals("зима")){
            //color = "белый";
            MountainHare.color="белый";
        }else {
            MountainHare.color="серо-рыжий";
        }
    }
    // в этом методе реализуйте логику смены цвета шубок зайцев-беляков

    // добавьте метод printHares()
    public void printHares(){
        for (MountainHare hare : hares) {
            System.out.println(hare);
        }


    }
}