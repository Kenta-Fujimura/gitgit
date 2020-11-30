import java.util.*;
public class Player{

	/****フィールド変数****/
	public String name;
	public int age;
	public int coin;
	public int bet;

	/****コンストラクタ****/
	public Player(String name,int age){
		this.name=name;
		this.age=age;
		this.coin = 100;
	}

	public void greet(){
		System.out.printf("こんにちは%s(%d歳)さん。%n",this.name,this.age);
	}
	
	public static void clearScreen() {  
    	System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}  
	public void bet(int bet){
		clearScreen();
		coin = coin - bet;	
		int nums[] = new int [9];
		for(int i=0;i<9;i++){
			nums[i] = new Random().nextInt(10);
			System.out.print(nums[i]+ " ");
			try{
 		    //1000ミリ秒Sleepする
 		    Thread.sleep(1000);
			}catch(InterruptedException e){}
				if((i+1) % 3 == 0 ){
					System.out.println("");
				}
		}
		//当たり判定
		int winCount = 0;
		int win;
		if(nums[0] == nums[1] && nums[1] == nums[2]){winCount += 1;}
        if(nums[3] == nums[4] && nums[4] == nums[5]){winCount += 1;}
		if(nums[6] == nums[7] && nums[7] == nums[8]){winCount += 1;}
		if(nums[0] == nums[3] && nums[3] == nums[6]){winCount += 1;}
		if(nums[1] == nums[4] && nums[4] == nums[7]){winCount += 1;}
		if(nums[2] == nums[5] && nums[5] == nums[8]){winCount += 1;}
		if(nums[0] == nums[4] && nums[4] == nums[8]){winCount += 1;}
		if(nums[2] == nums[4] && nums[4] == nums[6]){winCount += 1;}
	    if(winCount > 0){
			win = bet * 12 * winCount;
			coin = coin + win;
			System.out.println(winCount + " LINE BINGO!!  win:"+ win);
		}else{
			System.out.println("boo");
		}
		System.out.println(this.name + "さんの所持コイン:" + coin);
	}

}
