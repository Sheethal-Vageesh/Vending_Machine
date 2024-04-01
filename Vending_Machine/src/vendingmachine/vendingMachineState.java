package vendingmachine;

import coin.Coin;
import java.util.*;
import item.Item;

public class vendingMachineState 
{
   public vendingMachineState()
   {
      System.out.println("Vending machine is in idle state");
   }

   public void clickOnStartProductSelectionButton()
   {
      System.out.println("Vending machine is in HasMoneyState");
   }

   public void insertCoin(VendingMachine vendingMachine,Coin coin)
   {
      System.out.println("Vending machine is in HasMoneyState");
      System.out.println("Accepted the coin");
      vendingMachine.getCoinList().add(coin);
   }

   public void chooseProduct(VendingMachine vendingMachine,int itemCodeNumber)
   {
      //1. get the item for given itemcodenumber
      //2.total amount paid by user
      //3. compare the amount paid by user with item price
      //4. dispense the product

      Item item=vendingMachine.getInventory().getItem(itemCodeNumber);
      int paidByUser=0;
      for(Coin coin:vendingMachine.getCoinList())
      {
          paidByUser+=coin.getValue();
      }
      if(item.getPrice()>paidByUser)
      {
         refundFullMoney(vendingMachine);
         return;
      }
      else
      {
         getChange(item.getPrice(),paidByUser);
         dispenseProduct(vendingMachine,itemCodeNumber);
         return;
      }
   }
 
   public List<Coin> refundFullMoney(VendingMachine vendingMachine)
   {
      System.out.println("Returned full amount back in the coin dispese tray");
      vendingMachine.setVendingMachineState(new vendingMachineState());
       return vendingMachine.getCoinList();
   }

   public void updateInventory(VendingMachine vendingMachine,Item item,int itemCodeNumber)
   {
      vendingMachine.getInventory().addItem(item,itemCodeNumber);
   }

   public void dispenseProduct(VendingMachine vendingMachine,int itemCodeNumber)
   {
     System.out.println("Currently vending machine is in dispense state");
     System.out.println("product has been dispense");
     vendingMachine.getInventory().updateSoldOutItem(itemCodeNumber);
     vendingMachine.setVendingMachineState(new vendingMachineState());
   }

   public void getChange(int itemPrice,int paidByUser)
   {
      int change=paidByUser-itemPrice;
      System.out.println("Returning the change in coin dispense tray : " + change);
   }

}
