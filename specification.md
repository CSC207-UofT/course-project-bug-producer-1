## Specification

* Running the project starts a GUI that allows the users to log in to interact with an initially-setup 1 Storage, 1 items (Admin users can add more) storage system.
* While running, if the logged-in user is a customer, the program will show a welcome message and display the following options:
  * Edit Wish list
  * Generate Order
  * View Message
  * view Item in Inventory

* If logged-in user is an Admin, the program will show a welcome message and display the following options:
  * Write and Send Message to Customer by entering customer ID
  * View Order History

* For any orders placed, the order will include the following information:
  * Order ID
  * Requested items name
  * Requested item quantity
  * Date order placed
  * Customer information

* After order creation, it will be forwarded to Inventory by Order Controller to process the order.
  * Order processed
    * Inventory stock_out based on item quantity * item capacity
  * Supply (Will be implemented in the future)
    * Inventory stock_in based on item quantity * item capacity

* After order processing, the update will be forwarded to Admin by Inventory Controller.
  * Change order status and return message to both Admin and Customer.

