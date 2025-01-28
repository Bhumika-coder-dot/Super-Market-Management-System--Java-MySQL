
# Super Market Management System

## Description
The Super Market Management System is a Java-based application integrated with MySQL for database management. It provides functionalities to manage supermarket operations efficiently, including adding, removing, searching, updating products, and generating bills.

## Features
- **Add Product**: Add new products to the database with details like name, category, price, and stock.
- **Remove Product**: Remove outdated or unavailable products from the system.
- **Search Product**: Search for products using keywords or filters like category and price range.
- **Update Product**: Modify details of existing products, such as price or stock quantity.
- **Billing**: Generate and manage customer bills with details of purchased items, quantities, and total cost.

## Technologies Used
- **Programming Language**: Java (JDBC for database connectivity)
- **Database**: MySQL
- **IDE**: Eclipse IDE
- **Libraries**: MySQL Connector for Java

## Setup Instructions
1. **Prerequisites**:
   - Install Java Development Kit (JDK) version 8 or above.
   - Install MySQL Server and MySQL Workbench.
   - Configure MySQL Connector for Java.

2. **Database Configuration**:
   - Create a MySQL database named `ajp_prj`.
   - Use the following schema to create the required tables:
     ```sql
    CREATE TABLE details (
         p_id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         rate int,
         quantity int,
         Description VARCHAR(70)
     );

     CREATE TABLE bill_tbl (
         name VARCHAR(100) NOT NULL,
         Description VARCHAR(70)
         rate int,
         quantity int,
         total int
     );

     ```

3. **Run the Application**:
   - Clone the project repository or download the source code.
   - Import the project into your Java IDE.
   - Configure the database connection settings in the project.
   - Compile and run the application.

## Usage
- Navigate through the menu options to perform operations like adding or removing products.
- Use the search functionality to find products based on specific criteria.
- Generate customer bills by adding products to the cart and finalizing the purchase.

## Future E nhancements
- Add user authentication for secure access.
- Implement reporting features for sales and inventory analysis.
- Integrate barcode scanning for faster checkout.

## Author
Bhumika Shirish Kolekar
