# zss
ZSS Skills Test

1. Assumptions Made
   - the Category title is unique;

2. Additional Stuff I would have done
   - Create a CRUD Repository to manage all CRUD Operations.
   
3. Instructions to run the application
   - Edit the application.properties file. Add the server.port, database name, username and password;
   - http://localhost:{portNumber}/api/v1/books # FOR GET ALL; POST
   - http://localhost:{portNumber}/api/v1/books/{bookId} # FOR PATCH; DELETE
   - http://localhost:{portNumber}/api/v1/books/category/{categoryId} # FOR GET by categoryId
   - http://localhost:{portNumber}/api/v1/categories # FOR GET ALL; POST
   - http://localhost:{portNumber}/api/v1/categories/{categoryId} # FOR PATCH; DELETE

4. Things Not Completed
   - ability to purchase a book by integrating with a simple mock API
   - Not enough time to research on how its done as I am new to Java Spring [Mostly an Angular and Laravel Developer]
