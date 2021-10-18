
## Bug-Producer - Inventory System

![Bug-Producer](main/src/main/resources/banner.png)

> Note that this project requires `JDK16` 
> 
> Running the project starts a window using JFrame from swing package that allows the user to interact with an inventory control system.

## Sample Usage

Currently we have a pre-set account for you to try things out!
1. Run `GUI.java`. Try to log in our test account!
   - Username: `root`;
   - Password: `admin`.
2. After login you are logged in as an admin, so you can do various pactions with this account.
   - Create orders;
   - View past orders [WiP].
   - Create / View messages
   - Log off

## Class quick dive-in (description)

-class `admin` will update inventory;update order.It collabrates with order and inventory.

-class `inventory` contains capacity and item, it provides status of order and item list;updates item and process order.It collabrates with order and admin.

-class `item` contains avability and description.It collabrates with inventory.

-class `customer` could generate order and make wish list.It collabrates with order and admin.

-class `order` contains item-list, date of order,customer name.It collabrates with item,inventory,customer and admin.
