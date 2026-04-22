class Employee {
    String empno;
    String name;
    String department;
    int salary;

    /**
     * 생성자 : 객체 생성시 호출되는 특수 메서드
     * 생성자의 형태 :
     *     생성자 이름은 클래스 이름과 같다
     *     반환형이 없어야 한다
     * 생성자의 호출시점 : 객체 생성시 자동호출된다
     * 기본생성자 : 개발자가 생성자를 명시하지 않았을 경우 컴파일시에 자동 포함되는 생성자를 말한다
     * 기본생성자의 형태 : 클래스이름(){}
     *
     * this() : 현재객체의 또다른 생성자를 호출하라
     */
    Employee(){}
    Employee(String empno, String name) {
        // System.out.println("생성자입니다");
        this(empno, name, "부서없음", 0); //this생성자 호출
    }
    Employee(String empno, String name, String department, int salary) {
        // 생성자는 클래스 이름과 같은 이름을 사용해야하고, return 타입이 없어야 한다
        // 객체 생성시 호출되는 특수메서드
        // 개발자가 생성자를 명시하면 디폴트 생성자는 안 만들어진다
        this.empno= empno;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
        Employee e1;
//        e1 = new Employee();
//        e1.empno = "202601"; //사원의 사번
//        e1.name = "김두종";
//        e1.department = "총무부";
//        e1.salary = 100;
        e1 = new Employee("202601", "김두종", "총무부", 100);

        Employee e2;
        e2 = new Employee();
        e2.empno = "202602"; //사원의 사번
        e2.name = "홍길동";
        e2.department = "SW개발";
        e2.salary = 150;

        Employee e3 = new Employee("202603", "나자바");
    }
}
