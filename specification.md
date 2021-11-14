## Specification

Our project is a program designed to provide an easy way to track the products, 
customers, as well as purchases and sales information. There are two basic types of users: administrator and customer. 
To create an account, users need to provide a personal email address, create their username and password, 
and choose the corresponding user’s type. All personal information will be stored in a hash table and linked with an auto-generated id. 
For instance, the first user of our program will be assigned an id of “001”; then, the second user will have “002” as his/her id. 
After logging in, the welcome message will show up for users. In the customer case, they can click the “new order” 
bottom to access all the available items in the system; then, create their wish list in the text field at the top of the page. 
A search bar will be displayed at the top of the page as well for searching efficiency. If all requirements in one wish list have been fulfilled, 
the purchase information including order ID, requested items’ name and quantity, date, and customer id will be forwarded to the inventory for further processing. 
Inventory can be stocked and restocked by Inventory Controller based on previous information. 
Finally, an auto-generated receipt containing purchase information will be delivered to customers in a pop-up window. 
If some requirements cannot be fulfilled, for instance, the requested item quantity exceeds the available item quantity or wish list includes an absent item’s name, 
an auto-generated text which shows “failure” will pop-up and be displayed in the GUI.
In our program, administrators can view the purchase information that is gathered during customers place a new order. 
Moreover, administrators and customers can communicate with each other through email by clicking the “Message” bottom. 
By having the communication function available in our program, customers can reach out to administrators for asking questions 
and raising other requirements about adding new items in inventory, etc.
