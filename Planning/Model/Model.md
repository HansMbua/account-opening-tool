## Examining the Requirements Document
Requirements
-[ ] The API will expose an endpoint which accepts the user information (customerID, initialCredit).
1) First, define a class that represents the user information, such as Customer or User. This class should have fields for the customerID and initialCredit
2) Next, create a method in this class that accepts the user information as arguments and sets the corresponding fields. This method could be called something like `setInfor()`.
3) Then, define another class that represents the API endpoint, such as API or Endpoint. This class should have a method that handles the request to the endpoint and processes the user information. This method could be called something like `OpenAccountRequest`.
4) In the `OpenAccountRequest` method, you can create an instance of the Customer class and call the `getCustomerId()` and `getInitialCredit()` method to set the customer's ID and initial credit. You can then perform any additional processing or logic that is required with this user information.


 -[ ] Once the endpoint is called, a new account will be opened connected to the user whose ID is
customerID.
1) First, define a class that represents the user, such as Customer or User. This class should have fields for the customerID and any other relevant information about the user
2) Next, define a class that represents the account, such as Account or BankAccount. This class should have fields for the account number, balance, and any other relevant information about the account.
3) In the Account class, create a method that accepts a Customer object as an argument and sets the customer ID field in the Account object to the customerID field of the Customer object. This method could be called something like setCustomer.
4) In the API class, create a method that handles the request to the endpoint and processes the user information. This method could be called something like processRequest
5) In the processRequest method, you can create a new instance of the Account class and call the setCustomer method to set the customer ID for the account. You can then perform any additional processing or logic that is required to open the account, such as setting the initial balance or connecting the account to the user's profile.

-[ ] Also, if initialCredit is not 0, a transaction will be sent to the new account.
<br> <br>
 -[ ] Another Endpoint will output the user information showing Name, Surname,
balance, and transactions of the accounts.
1) First, define a class that represents the user, such as Customer or User. This class should have fields for the user's name, surname, and any other relevant information about the user.
2) Next, define a class that represents the account, such as Account or BankAccount. This class should have fields for the account number, balance, and any transactions associated with the account.
3) In the Account class, create a method that returns the balance and transactions for the account. This method could be called something like getAccountInformation.
4) In the Customer class, create a method that returns the name, surname, and a list of the user's accounts. This method could be called something like getUserInformation.
5) In the API class, create a method that handles the request to the endpoint and processes the user information. This method could be called something like processRequest.
6) In the processRequest method, you can create an instance of the Customer class and call the getUserInformation method to get the user's name, surname, and a list of their accounts. You can then loop through the list of accounts and call the getAccountInformation method for each account to get the balance and transactions. 
