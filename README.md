
## Bug-Producer - Inventory System

![Bug-Producer](src/main/resources/banner.png)

> Note that this project requires `JDK17` 
> 
> Running the project starts a window using JFrame from swing package that allows the user to interact with an inventory control system.

## First-time Usage
[IMPORTANT]

If you want to use Admin account instead of customer to Restock items and view all orders of all users, please enter `asd` as your secret code  when registering.

Procedure to use this App:
1. Register as Admin
2. Login
3. Stock in Items for sale (one-time) (Since admin cannot change inventory as he wish, only first-time is permitted.)
4. log out
5. Register as Customer
6. login
7. checks availability list
8. place order
9. view order history
10. send email
11. logout

After login, you are logged in as an admin, so you can do various actions with this account.
   - Create orders;
   - View past orders [WiP].
   - Create / View messages
   - Log off

## Class quick dive-in (description)

-class `admin` will update inventory;update order.It collaborates with order and inventory.

-class `inventory` contains capacity and item, it provides status of order and item list;updates item and process order.It collaborates with order and admin.

-class `item` contains availability and description.It collaborates with inventory.

-class `customer` could generate order and make wish list.It collaborates with order and admin.

-class `order` contains item-list, date of order,customer name.It collaborates with item,inventory,customer and admin.

## Requirements software

To use the function of sending email, `JavaMail 1.6.0` and `jaf 1.1.1` should be installed. 
The `activation.jar` and `javax.mail.jar` needed to be put in the library of this project library in order to be loaded correctly. 
The email used to send emails must have the access permission for low-security applications and must be authenticated (recommend Gmail). 
It also requires to enable the POP/IMAP function. JDK version 1.7 or later is required. `activation.jar` and `javax.mail.jar` have been included in the lib package.

## Security Update

Inventory security measures: admin can only set inventory once, after that, admin can't change the contents of inventory at will. (This is to ensure that the admin cannot change the inventory randomly.) If the admin has new goods and needs to be stored in the inventory, the database of the previous inventory needs to be cleared (equivalent to building the inventory, and put the previous item and the new item again ).
