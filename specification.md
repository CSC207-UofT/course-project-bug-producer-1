## Specification

* Running the project starts a GUI that allows the users to log in to interact with an initially-setup 1 Storage, 10 items storage system.
* While running, if the logged-in user is a customer, the program will show a welcome message and display the following options:
  * Edit Wish list
  * Place Order

* If logged-in user is an Admin, the program will show a welcome message and display the following options:
  * Update Inventory
  * Update Order
  * Approve order process request
  * Review Order if order failed to process due to lack of items


* For any orders placed, the order will include the following information:
  * Order ID
  * Requested items
  * Date order placed
  * Customer information

* After order creation, it will be forwarded to Inventory by Order Controller to process the order. There are two possible outcomes:
  * Order processed
    * Item count decrease in the inventory
    * Change order status and return it to both Admin and Customer.
  * Part or all of the order not processed
    * Item count decrease in those available items
    * Change order status and return it to both Admin and Customer.

