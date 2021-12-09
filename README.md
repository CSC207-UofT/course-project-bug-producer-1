
## Bug-Producer - Inventory System

![Bug-Producer](src/main/resources/banner.png)

> Note that this project requires `JDK17` 
> 
> Running the project starts a window using JFrame from swing package that allows the user to interact with an inventory control system.

## First-time Usage
[IMPORTANT]
If you want to use Admin account instead of customer to Restock items and view all orders of all users, please enter `asd` as your secret code  when registering.

Currently, we have a pre-set account for you to try things out!
1. Run `GUI.java`. Try to log in our test account!
   - Username: `root`;
   - Password: `admin`.
2. After login, you are logged in as an admin, so you can do various actions with this account.
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
