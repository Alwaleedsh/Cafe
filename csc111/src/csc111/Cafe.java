package csc111;
import java.util.Scanner;
public class Cafe {
		private double coffeePrice;
		private double teaPrice;
		private double donutPrice;
		private int coffeeTotQty;
		private int teaTotQty;
		private int donutTotQty;
		private double discount;
		private double subtotal;
		private double discountedPrice;
		private double total;

		public Cafe() {

		}

		public Cafe(double cofp, double teap, double donp, int cofq, int teaq, int donq, double dis) {
			setcoffeePrice(cofp);
			setteaPrice(teap);
			setdonutPrice(donp);
			setcoffeeTotQty(cofq);
			setteaTotQty(teaq);
			setdonutTotQty(donq);
			setdiscount(dis);
		}

		public double getcoffeePrice() {
			return coffeePrice;
		}

		public double getteaPrice() {
			return teaPrice;
		}

		public double getdonutPrice() {
			return donutPrice;
		}

		public int getcoffeeTotQty() {
			return coffeeTotQty;
		}

		public int getteaTotQty() {
			return teaTotQty;
		}

		public int getdonutTotQty() {
			return donutTotQty;
		}

		public double getdiscount() {
			return discount;
		}

		public void setcoffeePrice(double coffeePrice) {
			if (coffeePrice < 0)
				coffeePrice *= -1;
			this.coffeePrice = coffeePrice;
		}

		public void setteaPrice(double teaPrice) {
			if (teaPrice < 0)
				teaPrice *= -1;
			this.teaPrice = teaPrice;
		}

		public void setdonutPrice(double donutPrice) {
			if (donutPrice < 0)
				donutPrice *= -1;
			this.donutPrice = donutPrice;
		}

		public double getsubtotal() {
			return subtotal;
		}

		public double getdiscountedPrice() {
			return discountedPrice;
		}

		public double gettotal() {
			return total;
		}

		public void setcoffeeTotQty(int coffeeTotQty) {
			if (coffeeTotQty < 0)
				coffeeTotQty *= -1;
			this.coffeeTotQty = coffeeTotQty;
		}

		public void setteaTotQty(int teaTotQty) {
			if (teaTotQty < 0)
				teaTotQty *= -1;
			this.teaTotQty = teaTotQty;
		}

		public void setdonutTotQty(int donutTotQty) {
			if (donutTotQty < 0)
				donutTotQty *= -1;
			this.donutTotQty = donutTotQty;
		}

		public void setdiscount(double discount) {
			this.discount = discount / 100;
		}

		private void calcuateTotal(int cofq, int teaq, int donq) {
			subtotal = (getcoffeePrice() * cofq) + (getteaPrice() * teaq) + (getdonutPrice() * donq);
		}

		private void calculateTotal(int cofq, int teaq, int donq) {
			calcuateTotal(cofq, teaq, donq);
			total = subtotal - (subtotal * discount);
			discountedPrice = subtotal - total;
		}

		public double order(int cofq, int teaq, int donq) {
			if ((getcoffeeTotQty() < cofq) || (getteaTotQty() < teaq) || (getdonutTotQty() < donq)) {
				System.out.print("Erorr: no enough cups and/or donuts ");
				return 0;
			} else {
				calculateTotal(cofq, teaq, donq);
				display(cofq, teaq, donq);
				return total;
			}
		}

		private void display(int cofq, int teaq, int donq) {
			System.out.print("--------------------------------------------------------\n");
			System.out.print("Item                   Quantity                    Price\n");
			System.out.print("--------------------------------------------------------\n");
			System.out.print("coffee                    " + cofq + "                  " + cofq * getcoffeePrice() + "\n");
			System.out.print("tea                       " + teaq + "                  " + teaq * getteaPrice() + "\n");
			System.out.print("donut                     " + donq + "                  " + donq * getdonutPrice() + "\n");
			System.out.print("--------------------------------------------------------\n");
			System.out.print("sub total                                         " + getsubtotal() + "\n");
			System.out.print("Discount                (%" + getdiscount() * 100 + ")                   "
					+ getdiscountedPrice() + "\n");
			System.out.print("--------------------------------------------------------\n");
			System.out.print("total                                             " + gettotal() + "\n");
			System.out.print("--------------------------------------------------------\n");
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner x = new Scanner(System.in);
			int s;
			double t=0.0;
			Cafe c1 =new Cafe(5.50,3.50,2.25,100,100,50,10);
			do{
				System.out.println("************************");
				System.out.println("*                        Welcome to Cafe :)                          *");
				System.out.println("*                        ---------------------------                 *");
				System.out.println("*       Please enter one of the following options:                   *");
				System.out.println("*       1) order  ==> this allows you to order a game                *");
				System.out.println("*       2) quit ==> to end this program                              *");
				System.out.println("*                                                                    *");
				System.out.println("************************");
				System.out.print("Enter your option :> ");
				s = x.nextInt();
				if (s==1){System.out.print("Please, enter order (#cups of coffee, #cups of tea and #donuts: ");
				c1.order(x.nextInt(), x.nextInt(), x.nextInt());
				t+= c1.gettotal();}
			}while(!(s==2));
			System.out.println("Total sales = "+t);
			System.out.println("Thanks. Goodbye!");

		}

	}

