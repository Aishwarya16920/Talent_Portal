import { Button } from "bootstrap";
import { useRef, useState ,createContext} from "react";
import {useDispatch, useSelector} from 'react-redux';
import {Header} from './header';
import "../App.css";
import { useNavigate,Link } from 'react-router-dom';
import validator from 'validator';
import addNewUser from '../actions/add_user';
import React, { Component }  from 'react';
const Registration=()=>{
	let firstname=useRef();
	let lastname=useRef();
	let usernamein=useRef();
	let passwordin=useRef();
	let emailin=useRef();
	let phonein=useRef();
 const[firstnameError,setfirstnameError]=useState("");
 const[lastnameError,setlastnameError]=useState("");
 const[usernameError,setusernameError]=useState("");
 const[passwordError,setpasswordError]=useState("");
 const[emailError,setemailError]=useState("");
 const[phoneError,setphoneError]=useState("");
 const [temp,settemp]=useState(true);
 const[Success,setSuccess]=useState("Success");
 const[userexits,Setuserexits]=useState("");
 const[SuccessMessage,setSuccessMessage]=useState("");
 const[FailedMessage,setFailedMessage]=useState("");
 
  let disptacher=useDispatch();
 
 const Submit=async(event)=>{
	 setSuccessMessage("");
	 setFailedMessage("");
	 event.preventDefault();
	 let firstName=firstname.current.value;
	 let lastName=lastname.current.value;
	 let username=usernamein.current.value;
	 let password=passwordin.current.value;
	 let email=emailin.current.value;
	 let phone=phonein.current.value;
	 
	 if(firstName!=="" && lastName!=="" && username!=="" && password!=="" && email!=="" && phone!=="")
	 {
	 let newUser = {firstName,lastName,username,password,email,phone};
	 let registerUserResponse = await disptacher(addNewUser(newUser));
	   if(registerUserResponse.payload == "Username already exists"){
 
		 Setuserexits("Username already exist");
		 setSuccessMessage("Registered user not successfully");
 
	   }
 
	  else if(registerUserResponse.payload){
 
		 setSuccessMessage("Registered user successfully");
		 Setuserexits("");
	   }
 
	   else {
 
		 setFailedMessage("Service unavailable");
		 setSuccessMessage("");
		 Setuserexits("");
	   }
	 }
 
	 
 }
 let navigate=useNavigate();
 const Navigate=()=>{
	
	navigate("/login");
 }
 
 const firstname_error=()=>{
	if(firstname.current.value=="")
		{
		setfirstnameError( "Please enter firstname");
	setSuccessMessage("");
	Setuserexits("");
		}
		else{
			if(firstname.current.value.trim()==""){
				setfirstnameError("Firstname cannot be empty");
				setSuccessMessage("");
	Setuserexits("");
			}
			else{
				if(!firstname.current.value.match(/[A-Z]/i))
				{
					setfirstnameError("Firstname should be alphabet");
					setSuccessMessage("");
	Setuserexits("");
				}
				else{
				setfirstnameError("");
				setSuccessMessage("");
	Setuserexits("");
				}
			}
		}
 }
 const lastname_error=()=>{
	if(lastname.current.value==""){
		setlastnameError("Please enter lastname");
		setSuccessMessage("");
		Setuserexits("");
		}
		else{
			if(lastname.current.value.trim()=="")
			{
				setlastnameError("Lastname cannot be empty");
			}
			else{
				if(!lastname.current.value.match(/[A-Z]/i))
				{
					setlastnameError("Lastname should be alphabet");
				}
				else{
			setlastnameError("");
			setSuccessMessage("");
	Setuserexits("");
				}
		}
 }
 }
 const username_error=()=>{
	let ur=usernamein.current.value;
	if(usernamein.current.value=="")
	{
		setusernameError("Please enter username");
	setSuccessMessage("");
	Setuserexits("");
	}
	else if(!usernamein.current.value.match(/[A-Z]/i)){
		setusernameError("Username should be alphabet");
	}
	else{
		if(usernamein.current.value.trim()==""){
			setusernameError("Username cannot be empty");
		}
		else{
			
				if(!ur.match(/[A-Z]/i))
				{
					setusernameError("Username should be alphabet");
				}
				else{
			setusernameError("");
			setSuccessMessage("");
	Setuserexits("");
				}
		}
	}
 }
 const password_error=()=>{
	let p=passwordin.current.value;

	if(passwordin.current.value==""){
	setpasswordError("Please enter password");
	setSuccessMessage("");
	Setuserexits("");
	}
	
	else{
		if(passwordin.current.value.includes(" ")){
			setpasswordError("Password Can't be empty");
		}
		else if(p.length<10){
			setpasswordError("Password length should be more than 10")
		}
		else{
		setpasswordError("");
		setSuccessMessage("");
	Setuserexits("");
		}
	}
 }
 const email_error=()=>{
	if(emailin.current.value==""){
		setemailError("Please enter email");
		setSuccessMessage("");
		Setuserexits("");
	}
	else{
		if(!validator.isEmail(emailin.current.value)){
			setemailError("please valid email");
		}
		else{
			setemailError("");
			setSuccessMessage("");
	Setuserexits("");
		}
	}
 }
 const phone_error=()=>{
	let p=phonein.current.value;
	 setphoneError(phonein.current.value?"":"Please enter phone");
	 setSuccessMessage("");
	 Setuserexits("");
	 if(p.length<10){
		setphoneError("Please enter valid number");
	 }
	 else if(p.length>10){
		setphoneError("Number should be less than 10");
	 }
	 else{
		setphoneError("");
		setSuccessMessage("");
	Setuserexits("");
	 }
	 
 }
 const test=()=>{
	 let firstName=firstname.current.value;
		 let lastName=lastname.current.value;
		 let username=usernamein.current.value;
		 let password=passwordin.current.value;
		 let email=emailin.current.value;
		 let phone=phonein.current.value;
		 if(firstName!=="" && lastName!=="" && username!=="" && password!=="" && email!=="" && phone!=="" && phone.length==10 && password.length>=10){
			 settemp(false);
			 setSuccess("Success");
		 }
		 else{
			 settemp(true);
			 setSuccess("Not Success");
		 }
	 }
		 return(
			
			 <section class="h-100 bgimg">
				<nav class="navbar navbar-expand-lg header-navbar">

<div class="container-fluid">

	<a class="navbar-brand" href="#">

	<Link to = "/"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/></Link>

	</a>

</div>

</nav>

<br></br>
       
		 <div class="container h-100">
			 <div class="row justify-content-sm-center h-100">
				 <div class="col-xxl-5 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					 <div class="card shadow-lg">
						 <div class="card-body p-4">
							 <h1 class="fs-4 card-title fw-bold mb-4 text_heading">Register User</h1>
							 
							   
							 <form method="POST" class="needs-validation" novalidate="" autocomplete="off" >
								 <div class="row">
									 <div class="col-md-6 mb-3">
										 <fieldset>
										 <input id="name"ref={firstname} type="text" class="form-control form-control-sm" name="fname"  required="" placeholder="Enter First Name" autofocus="" onInput={firstname_error} onBlur={firstname_error} onChange={test}/>
										 {firstnameError && <div className="alert alert-danger" role="alert" style={{padding: "5px 5px"}}>{firstnameError}</div>}
 
										 </fieldset>
										 
									 </div>
									 <div class="col-md-6 mb-3">
										 <input id="name" ref={lastname}  type="text" class="form-control form-control-sm" name="fname"  required="" placeholder="Enter Last Name" autofocus="" onInput={lastname_error} onBlur={lastname_error} onChange={test}/>
										 {lastnameError && <div className="alert alert-danger" role="alert" style={{padding: "5px 5px"}}>{lastnameError}</div>}
								 
									 </div>
								   </div>
								 <div class="mb-3">
									 <input id="User" type="text" class="form-control form-control-sm" name="email"  placeholder="Enter User Name" required="" ref={usernamein} onInput={username_error} onBlur={username_error} onChange={test}/>
									 {usernameError && <div className="alert alert-danger" role="alert" style={{padding: "5px 15px", backgroundcolor:"red"}}>{usernameError}</div>}
									 {userexits && <div className="alert alert-danger" role="alert" style={{padding: "5px 15px", backgroundcolor:"red"}}>{userexits}</div>}
								
								 </div>
 
								 <div class="mb-3">
									 <input id="password" type="password" class="form-control form-control-sm" name="password" placeholder="Enter  Password" required="" ref={passwordin} onInput={password_error} onBlur={password_error} onChange={test}/>
									 {passwordError && <div className="alert alert-danger" role="alert" style={{padding: "5px 15px"}}>{passwordError}</div>}
								 </div>
								 <div class="mb-3">
									 <input id="email" type="email" class="form-control form-control-sm" name="email"  placeholder="Enter Email" required="@gmail.com" ref={emailin} onInput={email_error} onBlur={email_error} onChange={test}/>
									 {emailError && <div className="alert alert-danger" role="alert" style={{padding: "5px 15px"}} >{emailError}</div>}
								 </div>
								 <div class="mb-3">
									 <input id="number" type="number" class="form-control form-control-sm" name="email"  placeholder="Enter Phone" required="" ref={phonein} onInput={phone_error} onBlur={phone_error} onChange={test}/>
									 {phoneError && <div className="alert alert-danger" role="alert"  style={{padding: "5px 15px"}} >{phoneError}</div>}
								 </div>
								 <div class="align-items-center d-flex">
									 <input type="button"  className="btn btn-primary btn-sm ms-auto" name="Create Account" value="Create Account" onClick={Submit} disabled={temp} />
								 </div>
								 {SuccessMessage && <div className="alert alert-success" role="alert"  style={{padding: "5px 15px"}} >{SuccessMessage}</div>}
								{FailedMessage && <div className="alert alert-danger" role="alert"  style={{padding: "5px 15px"}} >{FailedMessage}</div>}
								
							 </form>
							 
						 </div>
						 <div class="card-footer py-3 border-0">
							 <div class="text-center">
								 Already have an account? <Link to="/login"><a href="login" class="text-dark">Login</a></Link>
							 </div>
						 </div>
					 </div>
				 </div>
			 </div>
		 </div>
	 </section>
	 );
			 
 }
 export {Registration};