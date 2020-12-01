package snackbar;

public class Main
{
	public static void printCashOnHand(Customer obj)
	{
        System.out.println(obj.getName() + " cash on hand: $" + obj.getCash());
    }
    public static void printQuantityofSnack(Snack obj){
        System.out.println("Quantity of " + obj.getName() + " is " + obj.getQuantity() + "\n");
    }    

    public static void printMVP(Customer customerObj, Snack snackObj, int amount){
        customerObj.buySnack(snackObj.getTotalCost(amount));
        snackObj.buySnack(amount);
        printCashOnHand(customerObj);
        printQuantityofSnack(snackObj);
    }

    public static void printStretch(Snack snackObj, VendingMachine vendingObj){
        System.out.println("Snack: " + snackObj.getName());
        System.out.println("Vending Machine: " + vendingObj.getName());
        System.out.println("Quantity: " + snackObj.getQuantity());
        System.out.println("Total Cost: " + "$" + snackObj.getTotalCost(snackObj.getQuantity()) + "\n");
    }

    public static void main(String[] args) {
        Customer jane = new Customer("Jane", 45.25);
        Customer bob = new Customer("Bob", 33.14);

        VendingMachine food = new VendingMachine("Food");
        VendingMachine drink = new VendingMachine("Drink");
        VendingMachine office = new VendingMachine("Office");

        //public Snack(String name, int quantity, double cost, int vendingMachineId)
        Snack chips = new Snack("Chips", 36, 1.75, 1);
        Snack chocolateBar = new Snack("Chocolate Bar", 36, 1.00, 1);
        Snack pretzel = new Snack("Pretzel", 30, 2.00, 1);
        Snack soda = new Snack("Soda", 24, 2.50, 2);
        Snack water = new Snack("Water", 20, 2.75, 2);
    
        printMVP(jane, soda, 3);
        printMVP(jane, pretzel, 1);
        printMVP(bob, soda, 2);

        jane.addCash(10);
        printCashOnHand(jane);

        pretzel.addQuantity(12);
        printQuantityofSnack(pretzel);

        printMVP(bob, pretzel, 3);

        System.out.println("Stretch Goals" + "\n");
        printStretch(chips, food);
        printStretch(chocolateBar, food);
        printStretch(pretzel, food);
        printStretch(soda, drink);
        printStretch(water, drink);
    }   	
}