package solution;

/**
 * @author sanguan.tangsicheng on 2017/5/25 上午11:35
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("abcd".contains("ad"));
    }

    public static class User{

        String name;

        Integer age;

        public User(String name,int age){
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString(){
            return "["+this.name+","+this.age+"]";
        }

    }
}
