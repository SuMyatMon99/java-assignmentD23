package BankAccountTransfer;
import java.util.Scanner;
public class Account {
	String id;
	String name;
	int balance = 0;
	
	Account(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	Account(String id, String name, int balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public void credit(int amt) {
		this.balance += amt;
		System.out.println(toString());
	}
	public void debit(int amt) {
		if ( amt <= this.balance) {
			this.balance -= amt;
			System.out.println(toString());
		}
		else {
			System.out.println("Your amount not sufficient!");
		}
	}
	public void transferTo(Account another, int amt) {
		if ( amt <= this.balance) {
			this.balance -= amt;
			another.credit(amt);
			System.out.println(toString());
		}
		else {
			System.out.println("Amount exceed!");
		}
	}
	public String toString() {
		
		String str = "Id:" + this.id + "\t" + "Name:" + this.name + "\t" +  "Balance:" + this.balance;
		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id1;
		String name1;
		int bal1;
		String id2;
		String name2;
		//int bal2;
		int transferAmt;
		System.out.print("Enter first acc's id : " );
		id1 = sc.next();
		System.out.print("Enter first acc's name : " );
		name1 = sc.next();
		System.out.print("Enter first acc's balance : " );
		bal1 = sc.nextInt();
		
		System.out.print("Enter second acc's id : " );
		id2 = sc.next();
		System.out.print("Enter second acc's name : " );
		name2 = sc.next();
		//System.out.print("Enter second acc's balance : " );
		//bal2 = sc.nextInt();
		
		System.out.print("Enter transfer amount : ");
		
		transferAmt = sc.nextInt();
		Account acc1 = new Account(id1, name1, bal1);
		Account acc2 = new Account(id2, name2);
		
		System.out.println(acc1.toString());
		
		acc1.transferTo(acc2, transferAmt);
		
		sc.close();
	}

}
