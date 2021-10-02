Running the project starts a shell that allows the user to interact with an inventory system.\\

While running, the Admin class updates the inventory (UpdateInventory) and updates the order (UpdateOrder). This class interacts with Order and Inventory.

The Customer class generates an order (GenerateOrder) and can make a wish list (Wish_list). This class interacts with Order and Inventory. 

The Inventory class stores item and capacity. It updates the the number of items (Update_Item) in the item_list and processes the order. This class interacts with Customer, Order and Item. 

The Item class is an abstract class and contains the description and availibility of the item. 

The Order class is an abstract class which contains the order_id, item_list, date of the order (date_order) and customer_name. This class interacts with Customer and Inventory. 
