/**
   Name: Andrew Givans
   Date: 4/26/2016

  
                     Description: Reimbursable Bill DDC
                     
   The purpose of these classes are to contain the instance variables 
with their mutators and accessors as well as default constructors 
to create each Reimbursable Bill object. Validators for the instance 
variables are also present.
      
**/

public class ReimbursableBill extends Bill implements Payable{

   private static int numReBills;
   private static int reimburseAmountTotal;
   private String org;
   private double perRe;
   
   //Purpose: The purpose of this specific constructor is to create
   //         a Reimbursablebill object
   //Parameters: amount, tax, name, add, zip, acctNum
   //Return type: None
   public ReimbursableBill(double amount, String tax, String name, String add, int zip, int acctNum){
      super(amount, tax, name, add, zip, acctNum);
      numReBills++;
      reimburseAmountTotal+= amount*perRe;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: org
   //Return type: boolean
   public boolean setOrg(String org){
      if(org.equals("")){
         return false;
      }
      else{
         this.org = org;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: preRe
   //Return type: boolean
   public boolean setPerRe(double preRe){
      if(perRe < 0){
         return false;
      }
      else{
         this.perRe = perRe;
         return true;
      }
   }
   
   //Purpose: The purpose of these get methods are to get the values requested
   //Parameters: None
   //Return type: int, double, String, Payee
   public static int getNumReBills(){
      return numReBills;
   }
   
   public static int getreimburseAmountTotal(){
      return reimburseAmountTotal;
   }
   
   public String getOrg(){
      return this.org;
   }
   
   public double getPerRe(){
      return this.perRe;
   }
   
   public double reimburseAmount(){
      double reimburseAmount = this.getAmount()*this.perRe;
      
      return reimburseAmount;
   }
   
   
   
   public double amountToPayBill(){
   
      double totalBillAmount = 0;
      double salesTax = .07;
      
      if(this.getTax().equalsIgnoreCase("Yes")){
      totalBillAmount = (this.getAmount() * salesTax) + this.getAmount() - (this.getAmount()*this.perRe);
      }
      else{
         totalBillAmount = this.getAmount()-(this.getAmount()*this.perRe);
      }
   
      return totalBillAmount;
   }
  
   
}