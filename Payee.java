/**
   Name: Andrew Givans
   Date: 4/29/2016

  
                     Description: Payee DDC
                     
   The purpose of these classes are to contain the instance variables 
with their mutators and accessors as well as default constructors 
to create each Payee object. Validators for the instance 
variables are also present.
      
**/

public class Payee{

   private String name;
   private String add;
   private int zip;
   private int acctNum;
   private static int numPayees;
   
   public Payee(){
      numPayees++;
   }

   //Purpose: The purpose of this specific constructor is to create
   //         a Payee object
   //Parameters: name, add, zip,acctNum
   //Return type: None
   public Payee(String name, String add, int zip, int acctNum){
      this();
      this.name = name;
      this.add = add;
      this.zip = zip;
      this.acctNum = acctNum;
   }

   //Purpose: The purpose of these get methods are to get the values requested
   //Parameters: None
   //Return type: int, double, String
   public static int getNumPayees(){
      return numPayees;
   }
   
   public String getName(){
      return this.name;
   }
   
   public String getAdd(){
      return this.add;
   }
   
   public int getZip(){
      return this.zip;
   }
   
   public int getAcctNum(){
      return this.acctNum;
   }
   
}