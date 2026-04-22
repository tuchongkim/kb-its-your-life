import java.util.Calendar;

/**
 * 조건문
 * if ~ else if ~ else
 * switch
 */
public class ConditionTest {
    public static void main(String[] args) {
        //상하반기 구분
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        System.out.println(month);

        if (month < 6) {
            System.out.println("상반기");
        } else {
            System.out.println("하반기");
        }

        switch(month) { //올 수 있는 자료형이 정해져 있다: byte, short, int, String
            case 0:
            case 1:
            case 2:
                System.out.println("1분기");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("2분기");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("3분기");
                break;
            default:
                System.out.println("4분기");
                break;
        }


    }
}
