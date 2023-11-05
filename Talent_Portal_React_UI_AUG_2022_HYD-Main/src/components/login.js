import React from 'react';
//import { Button } from 'bootstrap';
import {useRef, useState} from 'react';
import {useDispatch} from 'react-redux';
import { useNavigate } from "react-router-dom";
import loginUser from '../actions/loginaction';
import { Link } from "react-router-dom";
import {useLocation} from 'react-router-dom';
import * as QueryString from 'query-string';
import "../App.css"
//import './style.css';
const Login =()=>{

    let usernamein=useRef();
    let passwordin=useRef();
  
   
localStorage.setItem("header","login");
const[usernameError,setUsernameError]=useState("");
const[passwordError,setPasswordError]=useState("");
const [invalidCredentialsError, setInvalidCredentialsError] = useState("");

const [temp,settemp]=useState(true);
   
let dispatcher=useDispatch();
 let navigate = useNavigate();
 let location = useLocation();

 const allParams = QueryString.parse(location.search);

 console.log("allParams ", allParams);

 let logoutStatusVal = allParams.logoutstatus;
 const submit=async(event)=>{
    event.preventDefault();
    let username=usernamein.current.value;
	let password=passwordin.current.value;
    if(username!=="" && password!=="")
    {
        let User={username,password};
        let loginStatus = await dispatcher(loginUser(User));
        if(loginStatus.payload){
        if(loginStatus.payload.role=="[ROLE_USER]"){
            localStorage.setItem("header","logout");
            navigate('/findjob/user');
           
        }
        else if(loginStatus.payload.role=="[ROLE_ADMIN]"){
            navigate('/admin');
           
        } 
        else {
            setInvalidCredentialsError("Invalid credentials");
            navigate("/login");
         
        }
    }
    else{
        setInvalidCredentialsError("Invalid credentials");
        navigate("/login");
    }
    }
    
}
const username_error=()=>{
    if(usernamein.current.value==""){
        setUsernameError("please enter username");
        setInvalidCredentialsError("");
    }
    else {
        if(usernamein.current.value.trim()==""){
        setUsernameError("username has space");
        setInvalidCredentialsError("")
    }
    else{
        setUsernameError("");
        setInvalidCredentialsError("");
    }
}
}
const password_error=()=>{
    setPasswordError(passwordin.current.value?"":"please enter password");
    if(passwordin.current.value==""){
        setPasswordError("please enter password");
        setInvalidCredentialsError("");
    }
    else {
    if(passwordin.current.value.includes(" ")){
        setPasswordError("password error");
        setInvalidCredentialsError("");

    }
    else{
        setPasswordError("");
        setInvalidCredentialsError("");
    }
}
}
const test=()=>{
    let usernamei= usernamein.current.value;
    let passwordi= passwordin.current.value;
    if(usernamei!=="" && passwordi!=="" && usernamei.trim()!==""){
          if(!passwordi.includes(" ")){
            settemp(false);
           
         }         
    else{
        settemp(true);
    }
}
else{
    settemp(true);
}
}
     return (
        
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
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg">
						<div class="card-body p-5">
                            
							<h1 class="fs-4 card-title fw-bold mb-4 text_heading">Login</h1>
                            <form method="POST" class="needs-validation" noValidate="" autoComplete="off">
                                <div class="mb-3">
                               
                                   
                                    <input id="text" type="text" class="form-control form-control-sm" name="text" placeholder="Enter Username" required ref={usernamein} autofocus  onSelect={username_error} onBlur={username_error} onMouseLeave={username_error} onInput={username_error} onChange={test}></input>
                                </div>
                                
                            
                                {usernameError && <div class="alert alert-danger" role="alert" style={{padding: "5px 10px"}}>{usernameError}</div>}
                            
                            <div class="mb-3">
                                <div class="mb-2 w-100">
                                  
                                </div>
                                <input id="password" type="password" class="form-control form-control-sm" name="password" placeholder="Enter Password" required ref={passwordin} onSelect={password_error} onBlur={password_error} onMouseLeave={password_error} onInput={password_error}  onChange={test} ></input>
                                
                            </div>
                            
                                {passwordError && <div class="alert alert-danger" role="alert" style={{padding: "5px 10px"}}>{passwordError}</div>}
                                <div class="d-flex align-items-center">
                                
                            </div>
                            <div class="d-flex align-items-center">
                            {invalidCredentialsError && <div className="alert alert-danger" role="alert" style={{padding: "5px 15px", width: "90%", margin: "0 auto"}}>{invalidCredentialsError}</div>}

                            <input type="button"  className="btn btn-primary btn-sm ms-auto" name="Login" value="Login"  onClick={submit} disabled={temp} />
                            
</div>
{logoutStatusVal==='false' &&

                    <div className="alert alert-danger" role="alert" style={{padding: "5px 15px", width: "100%", textAlign:"center"}}>Session already expired!!!</div>}
                        </form> 
                    </div>
                    <div class="card-footer py-3 border-0">
                        <div class="text-center">
                           
                            <Link to='/registration'>New user? Register</Link>
                            </div>
                    </div>
                </div>

            </div>
        </div>
  
    </div>
</section>
  

    );
}

export {Login};
