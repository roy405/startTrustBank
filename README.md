# startTrustBank
 A web application developed using JAVA (Java Server Pages) and MySQL as Banking Portal for starTrustBank, a fictional Banking Institution. The application is considered to be a portal and consists of functionalities that are intended for 3 different audience classes (Customers, Managers and System Administrators) where the functionalities have been isolated using an authentication mechanism to allow specific intended parties to allow access to their intended operations. The application consists of full-fledged functionalities that are considered as fundamnetal day-to-day banking operations. 
 
 # Functionalities
 - Common Functionalties-
  - Authentication-
   - Login: All three users (Customers, Managers and System Administrators) are required to sign in into the system to use it. While Managers and Administrators are provided with their login information from within the organization, Customers can register using a supplied account number from the organization.
 - Customer Functionalities-
  - Authentication-
   - Registration: Users can register using a supplied account number from the organization.
  - Customer Dashboard: The landing page where certain immediate information regarding 
  - Messaging: Consists of a messaging function for the customers to communicate with banking officials (managers and admins) to relay any enquiries.
  - Fund Transfer: Customers can initiate a fund transfer from their account directly.
  - Open Accounts: Customer can open new bank accounts directly from their online customer portal
  - Bill Payments: Customers can pay bills directly from the banking portal
  - Standing Orders: Customers can create standing orders or subscriptions from their account to another directly from the webportal.
  - Manage Cards: Customers can manage all their cards (Debit, Credit) from within the application.
  -Transaction History: Customers can view their transaction history from the application.
 - Manager Functionalities-
  - Manager Inbox: All messages for the manager appear here where the manager can access view and reply to messages.
  - Card Requests: When a customer requests for a card, the request appears at the end of a manager and awaits the manager's decision to approve/reject the request.
 - Admin Functionalities-
  - Admin Inbox: All messages for the admin appear here where the manager can access view and reply to messages.
  - Create Account: Admin is capable of creating a accounts for manager and customers (supply account number).
  - Activity Log: Admin can view activity logs of users.
  - Approve new Account: Upon a customer creating an account using the supplied A/C number, the admin activates the account by approving it
 
 # Future Improvements:
 - Addition of Further Banking Operations
 - UI Improvements
 
 # How to Run
The JSP application requires a local web-server to run. Being a Java (JSP) application and contained as a single package (both frontend and backend packaged as one), an Apache Tomcat server is required to run the application. A easy way to do is to download Eclipse IDE and run the applcation on Eclipse. The database schema can be loaded from the sql query script.
