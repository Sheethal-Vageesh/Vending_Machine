package item;

public class ItemShelf 
{
   private int itemCode;
   private Item item;
   private boolean soldOut;

   public int getItemCode()
   {
    return this.itemCode;
   }

   public void setItemCode(int itemCode)
   {
    this.itemCode=itemCode;
   }

   public Item getItem()
   {
    return this.item;
   }

   public void setItem(Item item)
   {
      this.item=item;
   }

   public boolean getSoldOut()
   {
    return this.soldOut;
   }

   public void setSoldOut(boolean soldOut)
   {
    this.soldOut=soldOut;
   }

}
