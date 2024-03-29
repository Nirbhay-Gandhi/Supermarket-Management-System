# Supermarket-Management-System

<b>Problem statement: </b>

Supermarket consists of an inventory of products, managed by their local staff. Local staff have the authority to view the inventory and add/ delete the products from the inventory. Supermarket is run by the owner who is also the admin of the system. He can view the inventory, view staff details and the operations which they performed on the inventory (i.e which staff member added/ deleted which product). Now, comes the customer in the scenario. Customer can create a cart where the customer can put all the products he need. Cart is basically a small inventory which contains the subset of the products of main inventory. The system stores all the information related to the customer. A new customer can only be added the staff member only while generating the bill and also during this process of generating the bill the staff member can edit the details of customer if he/ she needs. The system stores the billing information related information which consists of the bill information of the customer and the information of the staff generating the bill.  Admin (i.e the owner) also have the right to view the information related to customer on how much bill each customer is generating.

<b>Nested Data Structures Used </b>

![image](https://github.com/Nirbhay-Gandhi/Supermarket-Management-System/assets/98534533/3844a23b-5ae4-41be-a8c8-e8bde5127283)

![image](https://github.com/Nirbhay-Gandhi/Supermarket-Management-System/assets/98534533/903eae60-88c6-4fce-8f6c-f42bdef4c22e)

![image](https://github.com/Nirbhay-Gandhi/Supermarket-Management-System/assets/98534533/93d4a55e-245d-41d7-8554-f1b676064334)

![image](https://github.com/Nirbhay-Gandhi/Supermarket-Management-System/assets/98534533/fff1f951-bc9a-4ba1-b814-4183175c9529)


<b>KTLO work</b>
- Check for bugs, for each api whether its working correctly. check for ebd-to-end flow for each api
- change the layout
- problem with product list(showInventory) not getting updated, include hasCode() function
  @Override
	public int hashCode() {
    	return product_name.hashCode();
  }
- HashCode()
  https://github.com/Nirbhay-Gandhi/Supermarket-Management-System/blob/main/Docs/About%20HashCode().md 


