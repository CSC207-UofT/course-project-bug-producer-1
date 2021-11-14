
## Bug-Producer - Inventory System

![Bug-Producer](src/main/resources/banner.png)

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

## Requirements software

To use the function of sending email, JavaMail version 1.6.0 and jaf1.1.1 should be installed. 
The activation.jar and javax.mail.jar needed to be put in the lib of the project. 
The email used to send emails must have the access permission for low-security applications and must be authenticated (recommend Gmail). 
It also requires to enable the POP/IMAP function. JDK version 1.7 or later is required.