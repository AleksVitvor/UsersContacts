# UsersContacts   
# Task
You should find any issues in the provided project and fix them
# Business logic
This project is a simple contact storing project
 Business entities:
 User - describes an account of the person
 Contact - describes a contact
# Task definition 
1. You need to fork this repo
2. Change database connection string and add migration (User with admin role: admin/QWERTY)  
LINK to read about migration: https://docs.microsoft.com/en-us/ef/core/managing-schemas/migrations/?tabs=vs  
3. You need to understand the logic of the app:  
Describe what business goals are set for this application  
Description can be provided via redmine ticket or text file attached to redmine ticket  
4. Find any issues in the code (style, naming, etc.)  
5. Create a branch for fixes of one type  
Example: You shouldn't provide fixes for code style and validation in one branch  
6. Create MRs for each branch and provide them to the mentor for review.  
7. As the result, you should have a working project what has been written by Syberry guidelines and code style  
# Requirements
1. Use your own database  
You should change connection string  
Connection string should apply for this patter: Data Source=<Server Name>;Initial Catalog=<Database name>;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False;  
If database not exists, it'll be created by migration  
2. This project uses MS SQL Server as a database, please, don't change it   
3. Use LINQ (this will make your queries database independent)  
4. All new/updated queries should be provided via Notes for ticket in file with C# and SQL code  
You can find queries in Output window  
