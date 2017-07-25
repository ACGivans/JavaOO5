/**
   Name: Andrew Givans
   Date: 4/26/2016

  
            Description: billing Implementation class
     
   The purpose of this program is to provide the user with a list 
where they can add a bill, calculate the payee total, provide 
a bill summary, or quit the application. Each bill also as a 
payee and a check object inside it so the values for each of 
these objects will be collected as well. 
   
**/

import javax.swing.JOptionPane;
public class Billing{
   public static void main(String[] args){

      final int MAX_NUM_BILLS = 2060;
      
      Bill[] bills = new Bill[MAX_NUM_BILLS];
      
      Bill aBill;

      int menuChoice = getMenuOption();
      
      while (menuChoice != 4) {
         switch(menuChoice) {
            case 1:
               aBill = addBill();
               populateBill(aBill);
               bills[Bill.getNumBills()-1] = aBill;
               break;
               
            case 2:
               calculatePayeeTotal(bills);
               break;
               
            case 3:
               printBillSummary(bills);
               break;
               
            case 4:
               exit();
               break;         
         }
      }
   }
   
   //Purpose: To create a Bill object 
   //Parameters: none
   //Return type: Bill      
   private static Bill addBill(){
   Bill aBill;
   
   String reimbursable = JOptionPane.showInputDialog(null, "Is the bill reimbursable?");
   
   double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Bill Amount: "));
   String tax = JOptionPane.showInputDialog(null, "Is there a state tax?");
   String name = JOptionPane.showInputDialog(null, "Enter the name of the payee: ");
   String add = JOptionPane.showInputDialog(null, "Enter the payee address: ");
   int zip = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the payee zipcode: "));
   int acctNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the payee account number: "));
   
   if (reimbursable.equalsIgnoreCase("yes")){
      aBill = new ReimbursableBill(amount, tax, name, add, zip, acctNum);
   }
   else{
      aBill = new Bill(amount, tax, name, add, zip, acctNum);
   }
 
   return aBill;
   
   }
   
   //Purpose: To populate a Bill or ReimbursableBill object 
   //Parameters: none
   //Return type: void 
   private static void populateBill(Bill aBill){
      
      if (aBill instanceof ReimbursableBill){
         ((ReimbursableBill)aBill).setOrg(JOptionPane.showInputDialog(null, "Enter organization reimbursing bill"));
         ((ReimbursableBill)aBill).setPerRe(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the percentage of the bill to be reimbursed")));
      }
   
   }
   
   //Purpose: To allow the user to select a payee and calculate the total owed 
   //Parameters: Bill[] bills
   //Return type: void 
   private static void calculatePayeeTotal(Bill[] bills){
      String payee = JOptionPane.showInputDialog(null, "Enter payee");
      double totalOwed = 0;
      
      //for (int x=0; x < Bill.getNumBills(); x++){
      //   if (bills[x].Payee.getName() == payee){
      //      bills[x].Payee.getAmount() += totalOwed;
      //   }
      //}
      
      JOptionPane.showMessageDialog(null, payee + "Owes " + totalOwed);
   }
   
   //Purpose: Provides a list containing the amount of housing options, 
   //         the average lot size, and the housing option with the 
   //         lowest monthly cost. 
   //Parameters: Bill[] bills
   //Return type: void 
   private static void printBillSummary(Bill[] bills){
      
      //double checksTotal;
      //double amount;
      
      //for(int x=0; x<Bill.getNumBills(); x++){
        // bills[x].amountToPayBill() = amount;
         //amount+= checksTotal;
      //}
      
      //double reimburseableTotal;
      //double amount2;
      
      //for(int x=0; x<Bill.getNumBills(); x++){
         //if (bills[x] instanceof ReimbursableBill){
            //((ReimbursableBill)bills[x]).reimburseAmount() = amount2;
         //amount+= reimburseableTotal;
         //}
      //}

      
      String Output =	"Bill Summary\n\n" +
                        "\n Number of bills with state tax: " + Bill.getNumTax()  +
                        "\n Total amount reimbursable: " + ReimbursableBill.getreimburseAmountTotal() +
                        "\n Total Check amount: " + Bill.getTotalCheckAmount();
   
      JOptionPane.showInputDialog(null, Output);
   }
   
   //Purpose: Ends the program and displays a message
   //Parameters: None
   //Return type: void 
   private static void exit(){
      String output = "Thank you for using this application!\n\n" +
                      "\n Number of bills: " + Bill.getNumBills() +
                      "\n Number of Reimbursable bills: " + ReimbursableBill.getNumReBills();
      
      JOptionPane.showMessageDialog(null, output);
   }
   
   
   //Purpose: To allow the user to select a menu option 
   //Parameters: none
   //Return type: int 
   private static int getMenuOption() {
      int menuChoice;
      
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "What would you like to accomplish:"
               + "\n(1) Add Bill"
               + "\n(2) Calculate Individual Payee Total Owed"
               + "\n(3) Print Bill Summary"
               + "\n(4) Exit Application"
            ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         if (menuChoice < 1 || menuChoice > 4) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 4);
      
      return menuChoice;
   }
}
