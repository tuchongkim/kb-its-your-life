public class WrapperTest {
    public static void main(String[] args) {
        Object[] arr = new Object[10];
        arr[0] = new String("HELLO");
        int i = 10;
        arr[1] = i; //AutoBoxing : 컴파일 시에 arr[1] = new Integer(i); 로 바뀜
        arr[2] = 10.1F; //arr[2] = new Float(10.1F);
        arr[3] = 'A'; //arr[3] = new Character('A');

        int j = (Integer) arr[1]; /* AutoUnboxing :
        컴파일시에
        Integer inte = (Integer)arr[1];
        int j = inte.intValue(); // 언박싱
        로 바뀜
         */

        //int k = (Integer) arr[9]; //null을 Integer 타입으로 변환, NullPointerException 발생
        /*
        Integer inte = (Integer)arr[9];
        int k = inte.intValue(); // 언박싱
         */
        //System.out.println(k);


        try {
            int k = (Integer)arr[9];
        } catch (NullPointerException e) {
            //사후 처리
        }

        //  사전처리 Best)
        Integer inte = (Integer)arr[9]; //dwoncasting
        if(inte != null) {
            int k = inte.intValue();
        }
    }
}
