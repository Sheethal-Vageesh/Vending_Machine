
import item.Item;
import item.ItemShelf;
import coin.Coin;
import vendingmachine.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
        VendingMachine vendingMachine=new VendingMachine();

        System.out.println("| Fill the Inventory |");
        fillTheInventory(vendingMachine);

        System.out.println("| Display the Inventory |");
        displayInventory(vendingMachine);

        vendingMachineState vendingMachineState=vendingMachine.getVendingMachineState();
       
        vendingMachineState.insertCoin(vendingMachine,Coin.FIFTY);
        vendingMachineState.insertCoin(vendingMachine,Coin.TWENTY);

        vendingMachineState.chooseProduct(vendingMachine,102);

        displayInventory(vendingMachine);
    }

    private static void fillTheInventory(VendingMachine vendingMachine)
    {
       ItemShelf[] itemShelfSlots=vendingMachine.getInventory().getInventory();
       for(int i=0;i<itemShelfSlots.length;i++)
       {
         Item item=new Item();
         if(i==0 || i==8)
         {
            item.setItemType("OREO");
            item.setPrice(30);
         }
         else if(i==1 || i==9)
         {
            item.setItemType("JUICE");
            item.setPrice(40);
         }
         else if(i==2)
         {
            item.setItemType("COKE");
            item.setPrice(45);
         }
         else if(i==3)
         {
            item.setItemType("SODA");
            item.setPrice(20);
         }
         else if(i==4)
         {
            item.setItemType("CHIPS");
            item.setPrice(20);
         }
         else if(i==5)
         {
            item.setItemType("CHOCOLATE");
            item.setPrice(60);
         }
         else if(i==6)
         {
            item.setItemType("CANDY");
            item.setPrice(5);
         }
         else if(i==7)
         {
            item.setItemType("GUM");
            item.setPrice(5);
         }
       itemShelfSlots[i].setItem(item);
       itemShelfSlots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine)
    {
        ItemShelf[] itemShelfSlots=vendingMachine.getInventory().getInventory();
       for(ItemShelf shelf : itemShelfSlots)
      {
        System.out.println("Item Code : "+shelf.getItemCode()+"\t\tItem : "+shelf.getItem().getItemType()+"\tPrice : "+shelf.getItem().getPrice()+"\tisAvailable : "+!shelf.getSoldOut());
      }
    }
}
