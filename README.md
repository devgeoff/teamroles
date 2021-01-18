Welcome to the Team Roles Rest API

To view the API documentation, you can use the Swagger URL http://localhost:8080/swagger-ui/. If the endpoint is different you can replace the port number and ensure that the URL ends with /swagger-ui/

If using postman or want to access the Endpoints directly, here are the URL's

http://localhost:8080/api/assignRole
http://localhost:8080/api/lookupRole + {userID + teamID}
http://localhost:8080/api/addRole
http://localhost:8080/api/fetchMemberships + {roleID}


Assumptions
- The front end developer or API user also has access to the User and team endpoints as well as their ID. The Team role endpoints are therefore use id's most of the time.

- It is assumed that a user can only have one role 

The Application uses a SQL server
The three default roles - Developer, Tester and Product Owner are initially added to the database to ensure they are present by default
*Modify Password to your database password in application.properties file and create a database with the name 'teamroles' before starting the project. Tables will be automatically generated.
