package world.asia;

public class Korea {
    private String capital = "서울";
    String language = "한국어"; //default 상태
    // public int population;
    private  int population;

    public void setPopulation(int population) {
        if (population <= 0) {
            System.out.println("인구는 0보다 큰 값이어야 합니다.");
            return;
        }
        this.population = population;
    }
}
