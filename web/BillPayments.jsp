

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> Star Trust</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
			

			<a href="" class="navbar-brand" > Star Trust </a>
		</div>
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			
			<li><a href="AccountSummary">Account Summary</a></li>
			<li><a href="MessageCustomer">Messages</a></li>
			<li><a href="FundTransfer">Fund Transfer</a></li>
			<li><a href="OpenAccount">Open Accounts</a></li>
			<li><a href="TransactionHistory">Transaction History</a></li>
			<li><a href="BillPayments">Bill Payments</a></li>
			<li><a href="CardManagement">Cards</a></li>
			<li><a href="StandingOrder">Standing Orders</a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
		
			
                        	<li><a href="Index"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> <button  class="btn btn-default btn-sm">Sign Out</button> </a></li>
			


		</ul>

		</div>
		</div>

	</nav>


	<div class="container">
			
					
                                        <center><h3>Bills Payment</h3></center>
					<hr>

<form  method="POST" action="BillPayments">
    
    <center>
    <label><strong>Bill Type:</strong></label>
     		<select name="BillType">
     			<option value="Telephone">Telephone</option>
     			<option value="Electricity">Electricity</option>
     			<option value="Water">Water</option>
     			<option value="Internet">Internet</option>
     			<option value="TV Network">TV Network</option>
                </select>
    
     <br>
     <br>
     <label><strong>Company Name:(if applicable)</strong><input name="CompanyName" type="text" placeholder="Company Name"></label>
     <br>
     <br>
     <label><strong>Bill Account ID(for reference)</strong><input name="BillAccountID" type="text" placeholder="Bill Account ID" required></label>
     <br>
     <br>
     <label><strong>Bill Amount:</strong><input name="billAmount" type="text" placeholder="Amount" required></label>
     <br>
     <br>
     	<button type="submit" class="btn btn-success btn-lg">Send</button>
        </center>


</form>




					
</div>


<script src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>