<%-- 
    Document   : removebook
    Created on : 31 Aug, 2022, 9:56:57 PM
    Author     : o
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <style>
        .Add{
 border: 2px solid red;
 border-radius: 1em;
 height: 2rem;
 width: 20em;
 font-size: medium;
}

.btn{
    background-color: black;
    color: chartreuse;
    height: 45px;
    width: 150px;
    font-size: 20px;
    border-radius: 10px;
    margin-top: .55rem;
    margin-left: 12rem;
   cursor:pointer;
}
.btn:hover{
    background-color:red;
}

 .tab1{
            border:2px black solid;
		background-color: #FFE5CC;
		margin-left: 44%;
            text-align: center;
            font-size: 22px;
            padding:8px;
            border-radius: 10px;
             background-color: #ccffcc;
    color: blue;
    font-weight: bold;
    list-style: none;
        }
        
        .tab{
		border:5px black solid;
		background-color: #FFE5CC;
		margin-left: 32%;
		/*width:450px;*/
		color:green;
		font-weight: bold;
		font-style:normal;
		text-align:center;
		font-size: 1.5rem;
		margin-bottom:1rem;
		padding-top: 0;
                padding-bottom: 0;
                padding-left: 1rem;
                padding-right: 1rem;
                
	}

        .tab2{
		border:1px black solid;
		background-color: #FFE5CC;
		margin-left: 48%;
		width:450px;
		color:green;
		font-weight: bold;
		font-style:normal;
		text-align:center;
		font-size: 22px;
		margin-bottom:10px;
		padding:10px;
                   padding-top: 1rem; 
    margin-top: 1rem;
    margin-left: 30rem;
	}
        
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Book Page</title>
    </head>
    
    <body>
          <input type="hidden" id="status" value="<%= request.getAttribute("status") %>" >
        
        <table class="tab" border="0px" cellpadding="10" cellspacing="10" text-color="red">
		<tr>
			<td>
        <h3>Enter Book Code To Remove Book</h3>
        <form action="RemoveBook" method="post">
        Enter Book Code : <input type="text" class="Add" name="barcode"><br/><br/>
        <input type="submit" class="btn" name="Remove" value="Remove"><br/><br/>
        </form>
                        </td>
		</tr>  
	</table>
        <table class="tab1">
		<tr>
			<td><a href="Admin.jsp">Back To Home Page</a></td>
		</tr>
        </table>
        
        <script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"> </script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
        <script type="text/javascript">
            var status=document.getElementById("status").value;
            
            if(status=="success"){
                swal("Congrats","Book Remove Sucessfully","success");
            }
            
                        if(status=="error"){
                swal("Failed","Book was not Remove Sucessfully!!!","error");
            }
            </script>
	
    </body>
</html>
