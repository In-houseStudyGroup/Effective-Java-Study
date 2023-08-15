package item3Singleton;

import java.io.Serializable;

public class SecondSingletonClass implements Serializable {
    
    // 접근 제한자를 public -> private
    private static final SecondSingletonClass INSTANCE = new SecondSingletonClass();
    
    // 추가
    public static SecondSingletonClass getInstance() {
        return INSTANCE;
    }
    
    // 직렬화 후 역직렬화 경우 새로운 인스턴스가 생성되는 것을 막기 위해 선언
    private Object readResolve() {
        return INSTANCE;
    }
    
    private int number;
    private String string;
    
    private SecondSingletonClass() {
        System.out.println("이거 실행되면 안되는데 SecondSingletonClass");
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
