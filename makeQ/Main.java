import java.util.*;
public class Main{
	public static void main(String[]args){
		Scanner scan =new Scanner(System.in);
		System.out.print("あなたの名前を入力してください>");
		String name=scan.next();
		System.out.print("あなたの年齢を入力してくだい>");
		int age=scan.nextInt();
		Player p=new Player(name,age);
		p.greet();
		if(p.age <= 18){
			System.out.println("18歳以下の方は遊戯できません");
			return;
		}
			
		System.out.println("残り枚数:" + p.coin);

		while(true){
			System.out.print("BET枚数を入力。0で終了　1-10>");
			int bet = new Scanner(System.in).nextInt();
			if(bet > p.coin){
				System.out.println("コインが不足しています");
			}else if(bet == 0){
				System.out.println("Game Over");
				return;
			}else{
				p.bet(bet);
			}
		}
	}
}

