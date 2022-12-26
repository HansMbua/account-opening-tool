# account-opening-tool
## how to execute and test
This is an API application for opening a new current account for existing customers. Once the endpoint is called, a new account will be opened and connected to the user whose ID is customerID. Also, if the initialCredit is not 0, a transaction will be sent to the new account. Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts


## Requirements

1.  A development environment with the following software installed:
    - Java Development Kit (JDK)
    - An Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA
    - Apache Maven
2. The Spring Boot framework, which can be downloaded from the Spring Initializr (https://start.spring.io/) or added as a dependency in your project's Maven POM file.
3. A tool such as Postman for testing the application's endpoints.

## How to execute the application

1.  Start by setting up the development environment and creating the Spring Boot project as mentioned above.
2. Start the application and test the endpoints using Postman. To do this, you will need to send HTTP requests to the application and examine the responses.

This request sends a POST request to the `/api/customers`endpoint with a JSON body containing the `customerName` and `customerSurname` and customer current account. If the request is successful, a new Customer should be created and with he/she's current account

Here is a sample Postman request for saving on the Data Object class customer:
- Method: POST
- URL: http://localhost:8080/api/customers
- Headers: Content-Type: application/json
- Body:
```sh
{
    "customerId": 1,
    "customerName": "John",
    "customerSurname": "doe",
    "accounts": [
        {
            "accountNumber": "45",
            "balance": 200.0,
            "transaction": []
        }
    ]
}

```
OR
```sh
{
    "customerId": 1,
    "customerName": "John",
    "customerSurname": "doe"
}

```

Here is a sample Postman request for the endpoint that opens a new account for an existing customer with id of 1:
- Method: POST
- URL: http://localhost:8080/api/accounts
- Headers: Content-Type: application/json
- Body:
```sh
{
  "customerId": 1,
  "initialCredit": 100
}
```
This request sends a POST request to `http://localhost:8080/api/accounts` URL with `1` as `customerId` and `100`as`initialCredit`. If the request is successful, a new account should be opened and connected to the user with the specified customerID, and a transaction should be added to the new account if the initial credit is not 0.
In case the Customer is not found you will get the following Json error:

```sh
{
    "status": 0,
    "message": "Customer with Id  not found",
    "timeStamp": 1671825097208
}
```
Here is a sample Postman request for the endpoint that displays the user information with the name, surname, balance, and transactions of the accounts:

- Method: GET
- URL: http://localhost:8080/api/customers/{customerId}
- Headers: Content-Type: application/json
- Body:(empty)
 <br>
<br>
  This request sends a GET request to the `/api/customers/{customerId}` endpoint, where `{customerId}` is the ID of the customer whose information you want to retrieve. If the request is successful, the response should contain the customer's name, surname, balance, and transactions of the accounts.



 
