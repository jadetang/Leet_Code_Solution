package solution;

public class _860_Lemonade_Change {

  public boolean lemonadeChange(int[] bills) {
    int five = 0;
    int ten = 0;
    int twenty = 0;
    for(int bill : bills ){
      if( bill == 5){
        five++;
      }else if( bill == 10 ){
        if(five < 1){
          return false;
        }else{
          five--;
          ten++;
        }
      }else if(bill == 20){
        if(five >= 1 && ten >= 1 ){
          five--;
          ten--;
          continue;
        }
        if(five < 3 ){
          return false;
        }else{
          five -= 3;
          twenty++;
        }

      }
    }
    return true;
  }

  public static void main(String[] args) {
    _860_Lemonade_Change q = new _860_Lemonade_Change();
    int[] bills = new int[]{5,5,5,10,5,5,10,20,20,20};
    q.lemonadeChange(bills);
  }

}
