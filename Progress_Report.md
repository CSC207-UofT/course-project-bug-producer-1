A brief summary of your specification (Michelle): Running the project starts a GUI that allows the users to log in to interact with an initially setup 1 Storage, 1 items storage system. While running, if the logged-in user is a customer, the program will show a welcome message and display 4 options, such as editing the wish list and generating orders. If the logged-in user is an Admin, the program will show a welcome message and display 2 options, which are to write and send messages to customers and view order history. For any order placed, 5 pieces of information will be saved, for example, order ID and requested items name. After order creation, the order will be forwarded to Inventory by Order Controller and processed. After order processing, the update will be forwarded to the Admin by Inventory Controller. The order status will be changed, and a message will be returned to the Admin and the Customer.


In our core level, we have six classes which are order, admin, customer, inventory, item, and user. For the use case, we have OrderGenerateUseCase, SendMessageUseCase, InventoryStockinUseCase and InventoryStockoutUseCase. Also, there are four controllers which are OrderController, MessageController, InventoryController, and UserController. Finally, we have three GUI which are MainGUI, LoginGUI, and GUI. According to clean architecture, our four use cases (Application Business Rules) will control our classes at the core level (Enterprise Business Rules). And our four controllers (interface adapters) will control our use cases.


One particular scenario we choose was that an existing customer placing a new order. Two general actions would be performed via our program: login and generate a new order. In terms of login, customer entered the default id and password in the text field which would be stored in JFrame class which is in the LoginGUI. Then, after customer logged in, he clicked the “new order” bottom to list any item he wanted, in this case, is the default item “carrot”. At the end, the generate_new_order method was called to store “carrot” into the OrderController class. 


One problem we struggled with was the structure of Controllers and Use Cases. At first, we just define all the methods inside all entity classes and use the Controller class to instantiate the entity to call the methods. This does not follow the clean architecture requirements. After that, we looked up a lot of materials and figured out that Controllers need to be the mediator to receive requests from users and call methods to conduct action on the entities. All methods are defined in the Use Case classes. The Use Case classes are classes that define the specific method body. Therefore, entities actually will not have too many methods defined inside. We changed our CRC cards model and try to extract the methods from the entity classes to build Use Case classes. The confusion of the relationship between Controller classes and Use Case classes was the main problem that we struggled with.


So far, our design has a basic logical structure, and this is part which we work well. In this part we have a lot of brainstorms which means all of us join the discuss and our design brings together all of us good idea. We believe that our design has a reasonable framework. Although the other parts are just starting in phase 0, we still have some future plans. We believe that we can successfully complete our project under this excellent start.


Our program consists of two main folders: test folder and main folder under src root. Among those two folders we have java folder and resources folder for a better and clean file architecture.


Within the java folder in main has the following folders which also stands for the main Controllers in our program: Inventory, Item, Message, order, and user. Each folder contains all the file necessary to accomplish the features mentioned in specifications. The rest of the file are the GUI part. the main file to start the program is inside GUI.java.


In our group, we have a clear assignment of responsibilities. We divided our program into 6 parts. 5 members (haoli, chongjie sun, regen li, jamie, michelle) were responsible for writing 5 main parts of our program and their corresponding  controllers and use cases. Walter and Elva were writing for the GUI part. We have all done a qualified job and finished it in time, especially the GUI part, considering none of us have learnt it before.


Our program was in an early stage. A lot of functionalities have not been finished, our primary goal is to be able to add a shopping cart for customers, multi-inventory control, and display data by charts.

