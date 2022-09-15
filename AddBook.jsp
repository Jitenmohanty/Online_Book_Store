<%-- 
    Document   : AddBook
    Created on : 31 Aug, 2022, 8:48:34 AM
    Author     : o
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
        <title>Book Store</title>
        <link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
	<style>
	*{
		box-sizing: border-box;
	}	
	body
	{
		/*background-image: url("Photo.jpg");*/
                background-color:skyblue;
                
	}
	#topmid{
		border:0px solid black;
		/*color:#FFFFFF;*/
		text-align: center;
		font-weight: bold;
		margin-top: 0px;
		padding-left: 30%;
		font-style: oblique;
		font-size:38px;
	}
	a:hover{
		color:red;
	}
	a:link{
		color: green;
		text-decoration: none;
	}
	.tab{
		border:5px black solid;
		background-color: #FFE5CC;
		margin-left: 42%;
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
	.home{
		border:1px black solid;
		background-color: #ccffcc;
		margin-left: 1%;
		width:200px;
		color:blue;
		font-weight: bold;
		font-style:italic;
		text-align:center;
		font-size: 25px;
		margin-bottom:10px;
		padding:2rem;
		float:left;
		clear:both;
	}
	.yel{
	color:yellow;
	}
	.red{
		color:red;
	}
	.green{
		color:green;
	}
	.hd{
		font-size:25px;
	}
	.brown{
		color:brown;
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
        }
        .tab h3{
            color: red;
            /*margin-bottom: 1rem;*/
        }
        .btn{
    background-color: black;
    color: chartreuse;
    height: 45px;
    width: 150px;
    font-size: 20px;
    border-radius: 10px;
    margin-top: 10px;
    margin-left: 50px;
   cursor:pointer;
}
.btn:hover{
    background-color:grey;
}

.tab2{
		border:1px black solid;
		background-color: #FFE5CC;
		margin-left: 48%;
		width:450px;
		color:red;
		font-weight: bold;
		font-style:normal;
		text-align:center;
		font-size: 22px;
		margin-bottom:10px;
		padding:10px;
                   padding-top: 1rem; 
    margin-top: -32rem;
    margin-left: 0rem;
	}


.Add{
 border: 2px solid red;
 border-radius: 1em;
 height: 2rem;
 width: 20em;
 font-size: medium;
}

</style>
</head>
<body>
        <input type="hidden" id="status" value="<%= request.getAttribute("status") %>" >



	<table class="tab" border="0px" cellpadding="10" cellspacing="10" text-color="red">
		<tr>
			<td>
				<form action="addbook" method="post">
                                    <h3>Add Book Which You Want To Add......</h3>
                                    Book Code : <input type="text" class="Add" name="barcode"><br/><br/>
					Book Name : <input type="text" class="Add" name="name"><br/><br/>
					Book Author: <input type="text" class="Add" name="author"><br/><br/>
					Book Price: <input type="text" class="Add" name="price"><br/><br/>
					Book Quantity : <input type="text" class="Add" name="quantity"><br/><br/>
					Book id : <input type="text" class="Add" name="id"><br/><br/>
					
                                        <button type="submit" class="btn">Add Now</button>
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
                swal("Congrats","Book Added Sucessfully","success");
            }
            
                        if(status=="error"){
                swal("Failed","Book was not added!!!","error");
            }
            </script>
	

</body>
</html>
