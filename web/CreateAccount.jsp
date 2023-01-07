 <%@page import="Models.AccountSummaryModel"%>
<%@page import="Controller.AccountSummary"%>

<%@ page language="java" contentType="text/html; "pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
	<title> Star Trust</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--
</head>
<body>
    
         <%!
        String username;
        
     %>
              
             
               <%
		if (session != null) 
                {
			if (session.getAttribute("username") != null) 
                        {
				 username = (String) session.getAttribute("username");
				
			} else 
                        {
				response.sendRedirect("index.jsp");
			}
		}
               %> 
               
     


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

	<div class="container" >
			<div class="jumbotron">
                            <h3>Create Account</h3>
                            <label><strong>FirstName*</strong> <input name="FirstName" type="text" placeholder="First Name" required></label>
		<label><strong>Last Name*</strong> <input name="LastName"type="text" placeholder= "Last Name" required></label>
		<br>
		<label><strong>Gender:*<strong></label>
        <label><strong>Male</strong><input name="Gender" type="radio" value="Male"></label>
        <label><strong>Female</strong> <input name="Gender" type="radio" value="Female"></label>
        <label><strong>Other</strong> <input name="Gender" type="radio" value="Other"></label>
        <br>
        <label><strong>Emai*l</strong><input name="E-mail" type="email" placeholder="E-mail" required></label>
        <label><strong>Confirm E-maill*</strong><input name="Confirm E-mail" type="e-mail" placeholder="E-mail" required></label>
        <label><strong>Password*</strong><input name="Password" type="password" placeholder="Password" pattern=".{8,16}" required title="8-16 characters" required><label>
        <label><strong>Nationality*</strong><input name"Nationality" type="text" placeholder="Nationality" required></label>
        <br>
        <label>Birthday:*<label>
        <select name="Day">
        	<option value="Day">Day</option>
        	<option value="1">1</option>
        	<option value="2">2</option>
            <option value="3">3</option>
        	<option value="4">4</option>
        	<option value="5">5</option>
        	<option value="6">6</option>
        	<option value="7">7</option>
        	<option value="8">8</option>
        	<option value="9">9</option>
        	<option value="10">10</option>
        	<option value="11">11</option>
        	<option value="12">12</option>
        	<option value="13">13</option>
        	<option value="14">14</option>
        	<option value="15">15</option>
        	<option value="16">16</option>
        	<option value="17">17</option>
        	<option value="18">18</option>
        	<option value="19">19</option>
        	<option value="20">20</option>
        	<option value="21">21</option>
        	<option value="22">22</option>
        	<option value="23">23</option>
        	<option value="24">24</option>
        	<option value="25">25</option>
        	<option value="26">26</option>
        	<option value="27">27</option>
        	<option value="28">28</option>
        	<option value="29">29</option>
        	<option value="30">30</option>
        	<option value="31">31</option>
        	
        	
        </select>
        <select name="Month">
           <option value="Month">Month</option>
           <option value="January">January</option>
           <option value="February">February</option>
           <option value="Mars">Mars</option>
           <option value="April">April</option>
           <option value="May">May</option>
           <option value="June">June</option>
           <option value="July">July</option>
           <option value="September">September</option>
           <option value="October">October</option>
           <option value="November">November</option>
           <option value="December">December</option>
        </select>

        <select name="Year">
        	            <option value="Year">Year</option>
        	            <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                        <option value="1998">1998</option>
                        <option value="1997">1997</option>
                        <option value="1996">1996</option>
                        <option value="1995">1995</option>
                        <option value="1994">1994</option>
                        <option value="1993">1993</option>
                        <option value="1992">1992</option>
                        <option value="1991">1991</option>
                        <option value="1990">1990</option>
                        <option value="1989">1989</option>
                        <option value="1988">1988</option>
                        <option value="1987">1987</option>
                        <option value="1986">1986</option>
                        <option value="1985">1985</option>
                        <option value="1984">1984</option>
                        <option value="1983">1983</option>
                        <option value="1982">1982</option>
                        <option value="1981">1981</option>
                        <option value="1980">1980</option>
                        <option value="1979">1979</option>
                        <option value="1978">1978</option>
                        <option value="1977">1977</option>
                        <option value="1976">1976</option>
                        <option value="1975">1975</option>
                        <option value="1974">1974</option>
                        <option value="1973">1973</option>
                        <option value="1972">1972</option>
                        <option value="1971">1971</option>
                        <option value="1970">1970</option>
                        <option value="1969">1969</option>
                        <option value="1968">1968</option>
                        <option value="1967">1967</option>
                        <option value="1966">1966</option>
                        <option value="1965">1965</option>
                        <option value="1964">1964</option>
                        <option value="1963">1963</option>
                        <option value="1962">1962</option>
                        <option value="1961">1961</option>
                        <option value="1960">1960</option>
                        <option value="1959">1959</option>
                        <option value="1958">1958</option>
                        <option value="1957">1957</option>
                        <option value="1956">1956</option>
                        <option value="1955">1955</option>
                        <option value="1954">1954</option>
                        <option value="1953">1953</option>
                        <option value="1952">1952</option>
                        <option value="1951">1951</option>
                        <option value="1950">1950</option>
                        <option value="1949">1949</option>
                        <option value="1948">1948</option>
                        <option value="1947">1947</option>
                        <option value="1946">1946</option>
       </select>

         <label><strong>NIC/Passport No:*</strong><input name="Nic/pass" type="text" placeholder="NIC/Passport" required></label>
         <label><strong>Street 1:*</strong><input name="street1" type="text" placeholder="Street 1" required></label>
         <label><strong>Street 2:</strong><input name="street2" type="text" placeholder="Street 2"></label>
         <label><strong>City:*</strong><input name="city" type="text" placeholder="City" required></label>
         <label><strong>State:*</strong><input name="State" type="text" placeholder="State" required></label>
         <label><strong>Country:*</strong><input name="Country" type="text" placeholder="Country" required></label>
         <label><strong>Postal Code:*</strong><input name="Postal Code" type="text" placeholder="Postal Code"></label>
         <label><strong>Contact No:*</strong><input name="Contact" type="text" placeholder="Contact" required></label>
       <br>
       <label>I agree to the terms and conditions <input name="Obligation" type="checkbox"></label>
       <br>
       <label>Check for promotions <input name="promotions" type="checkbox"></label>
       <label><input name="submission" type="submit"></label>
     </div>
   </div>					
</div>

<script src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>