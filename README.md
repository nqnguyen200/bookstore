# Generative AI Demo - bookstore app
This project is designed to help customers find the perfect book based on their interests.
Using the OpenAI API, we analyze the customer's input and match it to the most suitable books in our database.

It includes the following packages:

 - controller: Contains the classes that define the REST API endpoints to suggest suitable books.
 - dto: Contains the required dtos used to transfer data between the API and the service layer.
 - example: Contains the example how to call OpenAI API by using service layer.
 - repository: Contains the classes that handle the persistence layer.
 - service: Contains OpenAIService class which enables to call OpenAI API with WebClient.

# Getting Started
To get started with this project, you'll need to have the following installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
To run the project, simply navigate to the project directory and run the following command:

mvn spring-boot:run

This will start the application on http://localhost:8080.

# License
This project is licensed under the MIT License. See the LICENSE file for more information.