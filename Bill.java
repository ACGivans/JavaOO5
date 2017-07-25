/**
   Name: Andrew Givans
   Date: 4/12/2016

  
                     Description: Bill DDC
                     
   The purpose of these classes are to contain the instance variables 
with their mutators and accessors as well as default constructors 
to create each Bill object. Validators for the instance 
variables are also present.
      
**/

public class Bill implements Payable{

   private double amount;
   private String tax;
   private int checkNum;
   private Payee payee;
   private static int numBills;
   private static int numTax;
   private static int totalCheckAmount;
   
   public Bill(){
      this.payee = new Payee();
      numBills++;
   }
   
   //Purpose: The purpose of this specific constructor is to create
   //         a bill object
   //Parameters: amount, tax, checkNum
   //Return type: None
   public Bill(double amount, String tax, String name, String add, int zip, int acctNum){
      this();
      this.amount = amount;
      this.tax = tax;
      this.checkNum = checkNum;
      this.payee = new Payee(name, add, zip, acctNum);
      this.checkNum = 3000 + numBills;
      amount+= totalCheckAmount;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: amount
   //Return type: boolean
   public boolean setAmount(double amount){
      if(amount < 0){
         return false;
      }
      else{
         this.amount = amount;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: tax
   //Return type: boolean
   public boolean setTax(String tax){
      if(tax.equalsIgnoreCase("YES") || tax.equalsIgnoreCase("No")){
         this.tax = tax;
         numTax++;
         return true;
      }
      else{
         return false;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: payee
   //Return type: void
   public void setPayee(Payee payee){
      this.payee = payee;
   }
   
   //Purpose: The purpose of these get methods are to get the values requested
   //Parameters: None
   //Return type: int, double, String, Payee
   public static int getNumBills(){
      return numBills;
   }
   
   public static int getNumTax(){
      return numTax;
   }
   
   public static int getTotalCheckAmount(){
      return totalCheckAmount;
   }
   
   public double getAmount(){
      return this.amount;
   }

   public String getTax(){
      return this.tax;
   }

   public int getCheckNum(){
      return this.checkNum;
   }

   public Payee getPayee(){
      return this.payee;
   }
   

   public double amountToPayBill(){
   
      double totalBillAmount = 0;
      double salesTax = .07;
      
      if(this.tax.equalsIgnoreCase("Yes")){
      totalBillAmount = (this.amount * salesTax) + this.amount;
      }
      else{
         totalBillAmount = this.amount;
      }
   
      return totalBillAmount;
   }
  
}