// 메모리 그림처럼되도록 main 메서드를 작성
// singleton은 아니고, heap 메모릭 공간에 Share 타입의 객체 생성
// 인스턴스 변수 i 를 0값이 되도록 int 타입 변수
//

class Share {
    int i;

    public void push() {
        for (int i = 0; i < 100; i++) {
            //notifyAll()은 wait()된 여러 스레드를 한꺼번에 꺠우는 것
            //큐 방식으로 가장 먼저 wait()된 스레드부터 깨어난다
            notify();
            synchronized (this) { // 공유객체(Share 인스턴스)에 대한 lock
                System.out.print("before push : i=" + this.i);
                this.i++;
                System.out.println(", after push : i=" + this.i);
            }
        }
    }

    public void pop() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) { // 공유객체(Share 인스턴스)에 대한 lock
                if (this.i == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("before pop : i=" + this.i);
                this.i--;
                System.out.println(", after pop : i=" + this.i);
            }
        }
    }
}

class Pop extends Thread {
    Share s;

    Pop(Share s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            s.pop();
        }
    }
}

class Push extends Thread {
    Share s;

    Push(Share s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            s.push();
        }
    }
}

public class ThreadSharedTest {
    public static void main(String[] args) {
        Share s1, s2;

        s1 = new Share();
        s2 = s1;
        Pop pop = new Pop(s1);
        Push push = new Push(s1);

        pop.start();
        push.start();
    }
}
