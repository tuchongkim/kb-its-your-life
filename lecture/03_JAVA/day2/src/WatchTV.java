class TV {
    boolean power;
    int channel;

    void powerOn() { //Java에서는 메서드의 return type이 반드시 필요
        power = true;
        System.out.println("전원을 켭니다");
    }
    void channelUp() {
        this.channel++;
    }
    void setChannel(int channel) {
        // 매개변수가 인스턴수 변수보다 우선순위가 높기 떄문에 channel = channel 처럼 작성하면 안된다
        // 이런 경우가 this를 써야하는 대표적인 경우
        // 굳이 매개변수를 channel로 사용하는 이유 -> 사용설명서의 직관성을 높이기 위해
        this.channel = channel;
    }
    void printInfo() {
        System.out.println("전원:" + power +", 채널:" + channel);
    }
    boolean isPower() {
        // 반환형 선언 후 return을 안하면 컴파일 에러 발생
        return power;
    }
}

public class WatchTV {
    public static void main(String[] args) {
        TV tv1; //참조형 지역변수
        tv1 = null; //참조하지 않는다
        System.out.println(tv1); //null

        tv1 = new TV();
        System.out.println(tv1); //null이 아님 ~~~@xxxxxxxx

        tv1.powerOn(); //전원을 켠다

        if (tv1.isPower()) { //전원이 켜져있다면
            tv1.channelUp(); //채널을 1증가한다
            tv1.setChannel(21); //채널을 설정한다
            tv1.printInfo(); //"전원:true, 채널:21" 출력된다
        }
    }
}
