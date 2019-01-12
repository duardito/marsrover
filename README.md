**Requirements**:

java 8

**How-to**:

To start up application go to org.newrelic.Main class and run it, 
there is an HttpServer running on port 15000, so the application is listening requests.

There is an html file to test easier the application, just go to resource directory
and you will find robots.html file.

There is a test class to validate some cases, not all possible cases are validated.

**Considerations**:
there are 2 classes (OperationToLeft and OperationToRight) wich include an ugly if-else, 
I didn't refactor as other places like OperationsRegister or CardinalRegister because 
I consider this operations can not be modified or added more, if we consider more operations like 
'NE', 'SE', etc... maybe we should think other approach. 

 