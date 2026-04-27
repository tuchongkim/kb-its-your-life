import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class First extends Thread {
    //Object의 하위 클래스 -> Thread클래스 -> 여기서 상속받는 First
    //Runnable이라는 상위 인터페이스를 구현한 것이 Thread 클래스
    //Runnable에는 void run() 이라는 추상 메서드가 있다
    //Thread가 해야할 일을 run()에서 override한다
    //First도 해야할 일을 run()에서 override
    //start()는 Thread가 가지고 있는 메서드 (새로운 스레드 생성)

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);
            long millis = (long)(Math.random() * 1000); //0 <= r <= 1000
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Second extends Canvas implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            Date d = new Date();
            String f = sdf.format(d);
            System.out.println(f);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //java -cp ~~ ThreadTest
        //해당 경로에서 ThreadTEst.class 를 찾는다
        //바이트코드 검증
        //바이트코드를 JVM의 메서드 영역에 올린다
        //자주 호출되는 메서드가 있거나, 반복되는 코드가 있다면 JIT 컴파일러가 hotspot으로 체크를 해서 캐시에 바이너리로 기억해놓는다
        //Main-Thread 가 기본적으로 제공된다
        //JVM 메모리 공간을 보면 메서드 영역, heap, stack 영역이 있다
        //stack 영역이 thread별로 존재한다
        //Main-Thread용 Call Stack영역이 있고, 여기서 main 메서드가 호출되고, 실행된다
        //main 메서드에서 현재 사용되고 있는 thread 이름은 Main-Thread일 것이라고 예상할 수 있다

        First one = new First();
        First two = new First();

        //Second s = new Second();
        //s.start(); //컴파일에러. Second는 Runnable을 구현한 구현체이지, Thread를 상속받은 게 아니다
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (int i = 0; i < 10; i++) {
                    Date d = new Date();
                    String f = sdf.format(d);
                    System.out.println(f);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        one.start(); //새로운 스레드 시작, 자동으로 run() 메서드가 실행됨
        //one.run(); //실제로 사용되는 스레드는 main 하나만 남게 된다
        two.start();
        three.start(); //정상작동. 생성자 인자로 Runnable 구현체를 넘겨주면, 스레드인스턴스.start()가 가능하다

        System.out.println("main 메서드입니다");
        System.out.println("현재스레드이름: " + Thread.currentThread().getName()); //main
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("main의 끝입니다");
    }
}
