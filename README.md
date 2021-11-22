# Intership
During the Internship in [Irisa](www.irisaco.com), we decide to make a demo application to save, load, show waybills and all properties
In this project, we focus on 3 object:
*	Waybill
*	Driver
*	Mine

All data for 3 objects save and load from Database.
Architecture of the project is MVC:
*	Backend Framework: Spring (Controller)
*	Database: Oracle (Model)
*	Frontend Framework: HTML, CSS, JavaScript, Bootstrap (View)
*	Management Dependency: Maven

## Structure of Project:
1. Entity Class: these classes that save properties of entities and save in Database
  *	Driver: for Driver Class
  *	Mine: for Mine and Source 
  *	Waybill: for Way Billing 
2. DAO Class: Database Access Object class that implement Service layer and manage data to retrieve and save in the database.
  *	Driver-Service
  *	Mine-Service 
  *	Waybill-Service 
3. Controller Class: the class that executes processing like POST, GET  of URL that user inserts in web application and response to a request of the user.
  *	Driver - Controller
  *	Mine - Controller
  *	Waybill - Controller
4. Main Class: the class that execute web application and manage the Exception
5. Resource/templates: HTML file that combines with [Thymeleaf](https://www.thymeleaf.org/)
6. Resource/static: CSS, JavaScript, images and fonts.
7. Application.properties: this file includes all settings for the project such as port, driver database, user password, etc.

## Database
In Irisa company, use Oracle Database. Fortunately, I work with this and PLSQL for writing Trigger and Stored Procedure.

Tables :
*	WayBil
*	Mine
*	Driver 

Tables Triggers:
*	Insert, Update WayBil
*	Insert, Update Mine
*	Insert, Update Driver 

CRUD Operation: DDL Operation like SELECT, INSERT, UPDATE, DELETE
*	SQL Queries
*	Hibernate





