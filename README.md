# FFood - Food E-Commerce Website

FFood is a food e-commerce site that lets customers order food in a quick and convenient way.

[Optional: Include badges or shields to showcase the project's status or any important metrics such as build status, code coverage, or version.]

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [License](#license)

## Introduction

[Provide a detailed introduction to your food e-commerce website. Describe its purpose, target audience, and any unique selling points. Highlight the problems it solves or the benefits it offers to users.]

## Features

- Menu filtering and searching on home page
- Quick and convenient ordering process (Choose Food -> Proceed to Checkout -> Place Order)
- Order without logging in
- Order tracking and auto-fill checkout forms for logged in users
- Optimized UX for customers: forms are contained in modals (pop-ups), users do not have to be redirected to different pages for these actions:
	-	Logging in, signing up
	-	Viewing Carts
-	Food, User, Order management for Admins
-	Authorization system prevents unauthorized access to certain pages
	-	Non-logged in users cannot access User and Admin pages
	-	Logged-in Users can access User pages, but not Admin pages
	-	Admins can only access Admin pages, the rest is restricted from access to prevent security risks
-	Optimized UX for admins: CRUD actions are prompted using modals (pop-ups) instead of redirecting to specific pages

## Technologies

- Java SE 1.8
- JSTL 1.2
- Tomcat 10 (Java EE 7)
- JavaScript ES6
- Bootstrap 5.3.0
- jQuery 3.7.0
- jQuery Validation Plugin

### Dependencies

-   Jakarta Servlet API (5.0.0)
-   Microsoft JDBC Driver for SQL Server (10.2.0.jre8)
-   Jakarta Standard Tag Library Implementation (Glassfish)

## Installation


To install and set up the FFood website locally, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/your-repository.git
   ```

2. Open the project in your preferred integrated development environment (IDE) such as NetBeans 13 and later.

3. Ensure you have Java SE 1.8 installed on your system.

4. Set up the Tomcat server:
   - Download and install Tomcat 10 (Java EE 7) from the Apache Tomcat website.
   - Configure Tomcat in your IDE by specifying the installation directory.

5. Resolve dependencies:
   - Add the following dependencies to your project's build path:
     - Jakarta Servlet API (5.0.0)
     - Microsoft JDBC Driver for SQL Server (10.2.0.jre8)
     - Jakarta Standard Tag Library Implementation (Glassfish)
   - If you are using Maven, these dependencies can be added to the `pom.xml` file, however the `pom.xml`file included in the source code already has the necessary dependencies.

6. Configure the database:
   - Ensure you have a SQL Server database set up with the required schema for the food e-commerce website.
   - Update the database connection details by creating a `DBConnection.java` file in `DBConnection` package in `src/main/java/`. The resulting path should be `src/main/java/DBConnection/DBConnection.java`. The file should have the following content:
```bash
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                conn = DriverManager.getConnection("jdbc:sqlserver://"
                        + "ENTER-YOUR-DATABASE-NAME\\SQLEXPRESS:1433;"
                        + "databaseName=ffood;"
						            // Enter your SSMS login username
                        + "user=enter-your-username;"
                        // Enter your SSMS login password
                        + "password=enter-your-password;"
                        + "encrypt=true;"
                        + "trustServerCertificate= true;");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;   
    }
}
```
7. Build and deploy the project:
   - Build the project in your IDE to compile the source code and generate the necessary artifacts.
   - Deploy the project to the Tomcat server by either:
     - Manually copying the artifacts to the Tomcat deployment directory, typically `webapps/`.
     - Using the deployment features provided by your IDE.

8. Start the Tomcat server and access the food e-commerce website:
   - Start the Tomcat server either through your IDE or by running the appropriate startup script.
   - Open a web browser and visit `http://localhost:8080/your-web-app-context` to access the website. The web application context path can be configured in `src/main/webapp/META-INF/context.xml`.
	   - By default the context path is empty, so the website URL should be `http://localhost:8080`.

Now you should have FFood running locally on your machine.


## License

This project is licensed under the [MIT License](https://github.com/tien-thanh-hua/FFood/blob/main/LICENSE).
