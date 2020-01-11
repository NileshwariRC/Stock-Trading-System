1. Download eclipse
2. Download JRE 1.8 and Apache Tomcat 9.0
3. Check on File -> Import.. -> Existing Projects into Workspace --> Next -- > select root directory (You need to browes folder path for 3 project folders for 3 servers) -> Finish
4. If project has errors, Right click on project imported and go to Build Path -->Configure Build Path --> Libraries --> Delete the jars
5. Click on 'Add external JARs' and browse JAR files from project downloded the project. Files are present in WebContent --> WEB-INF folder. click on 'Apply and close'.
5. If the error persists, Add JAR files for Servlet API and Database driver used. for MySQL, you need mySQL connector Jar
6. In the 'Server' pane of eclipse, click on add server if not present. 
7. Modify port numbers : We need 3 different servers connected to 3 different ports. Modify port number accordingly.
8. Right click on server. Click on 'Add' to add specific project to that server. Finally you should have 3 projects and 3 different servers.
9. Modify webservice port number(Port Number of server2) in all servlet files of Server1 Files i.e Project StockClient
10. Download mySQL database and update username, Port No. and password details in src --> Service files(Java files) present on server2 (Project StockSample)
11. Create DB schema for User details, Bank Account, Stock infomation, User History. Queries are present in 'Database Configuration queries:' section of project report
10. Clean and Build the project
11. Start 3 web servers.
12. Check http://localhost:8080/StockClient/login.do on browser to check project execution. (Login Page)

server1: Stock brokerage website- client that contains html
server2: Stock brokerage web application- web service 1 that contains database connections 
server3: Stock exchange web application- web service 2 that contains API calls functionality

