package solution;

/**
 * @author sanguan.tangsicheng on 16/7/12 上午10:34
 */
public class _372_Super_Pow {

    public int superPow(int a,int[] b){

        int ans = 1;

        for ( int i = b.length - 1; i >=0 ;  i--) {
            ans = ans * (int) Math.pow(a,b[i] )% 1337 ;
            a = (int)Math.pow(a,10) % 1337;
        }
        return a;
    }

    public static void main(String[] args) {
        _372_Super_Pow q = new _372_Super_Pow();
        System.out.println(q.superPow(2,new int[]{1,0}));
    }

}
