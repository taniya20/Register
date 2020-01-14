I have created the three pages :
Register.html,
Register.java,
web.xml

WEB-INF folder contains web.xml file and WEB-INF/classes contains all the servlet classes and other class files.

Register.html  --> In this page,we are getting input from the user using text fields and combobox.The information entered by the user is forwarded to Register servlet, which is responsible to store the data into the database.

Register.java  --> This servlet class receives all the data entered by the user and stores it into the database. Here,we are performing the database logic.

web.xml file --> This is the configuration file, providing information about the servlet.
