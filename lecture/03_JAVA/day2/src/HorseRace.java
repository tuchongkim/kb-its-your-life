import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 이벤트 프로그램 절차
 * 1. 이벤트종류와 이벤트소스를 결정 ( ActionEvent, btReady )
 * 2. 이벤트처리기 작성
 * 3. 이벤트소스와 이벤트처리기 연결
 */

class Horse extends Canvas implements Runnable{
    String name;
    int x = 50;
    int y = 20;

    Horse(String name) {
        this.name = name;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.drawString(name, x, y);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.x += 10;
            repaint();
            long mills = (long) (Math.random() * 1000); // 0.0 <= r < 1000.0
            try {
                Thread.sleep(mills);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class HorseRace {
    private JFrame f;
    private Horse[] horses;
    private JButton btStart, btReady;
    private int readyClickCnt;

    class ReadyHandler implements ActionListener {
//        int cnt;
//
//        public ReadyHandler(int cnt) {
//            this.cnt = cnt;
//        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            this.cnt++;
//            System.out.println(this.cnt + "클릭됨");
            readyClickCnt++;
            System.out.println(readyClickCnt + "클릭됨");
        }
    }

    public HorseRace(){
        //1. 초기화
        f = new JFrame("달리기"); //액자
        horses = new Horse[3];
        for(int i=0; i<horses.length; i++){
            horses[i] = new Horse(i + 1 + "번 말");
        }
        btStart = new JButton("달려");
        btReady = new JButton("준비");

        //1-1. 이벤트소스와 이벤트처리기 연결
//        ReadyHandler readyHandler = new ReadyHandler(readyClickCnt); //1. outer class 객체생성
//        ReadyHandler readyHandler = new ReadyHandler(); //2. inner class 객체생성
//        btReady.addActionListener(readyHandler);

//        btReady.addActionListener(new ActionListener() { //3. 이름없는 클래스 객체생성
//            // 인터페이스를 구현한 하위 클래스 객체 (구현체)를 만드는 것이다
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                readyClickCnt++;
//                System.out.println(readyClickCnt + "클릭됨");
//            }
//        });

        //람다식
        btReady.addActionListener( (e) -> {
            readyClickCnt++;
            System.out.println(readyClickCnt + "클릭됨");
            //TODO 1.
            for (int i = 0; i < horses.length; i++) {
                horses[i].x = 0;
                horses[i].repaint(); //repaint() -> update() -> CLEAR -> paint() 자동호출됨
            }
        });

        btStart.addActionListener((e) -> {
            //TODO 2.
            for (Horse h: horses) {
//                for (int i = 0; i < 20; i++) {
//                    h.x += 10;
//                    h.repaint();
//                }
                new Thread(h).start();
            }
        });

        //2. UI배치
        java.awt.Container container  = f.getContentPane(); //액자뒷판
        container.setLayout(new GridLayout(4, 1));
        for(int i=0; i<horses.length; i++){
            container.add( horses[i] ); //배치될 떄 Horse의 paint()가 자동호출된다.
        }
        JPanel panel = new JPanel();
        panel.add(btReady);
        panel.add(btStart);
        container.add( panel );

        //3. 보여주기
        f.setSize(500, 400);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new HorseRace();
    }
}
