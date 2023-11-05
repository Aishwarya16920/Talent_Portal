import React from 'react';
import logout from '../actions/logoutaction';
import {useEffect, useState, useRef} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { Login } from './login';
import avatar from './jobseeker/avatar.jpg'

const Header = () => {
  let header =localStorage.getItem("header");
	let dispatcher = useDispatch();
    let navigate=useNavigate();
let authToken = localStorage.getItem("authToken");
const logoutFunc = async()=>{ //Closure
    let logoutResponse = dispatcher(logout(authToken));
    localStorage.setItem("header","login");
    if(logoutResponse.payload){
     navigate('/login')
    } else {   
        navigate('/login?logoutstatus=false')

    }
}
const login=async()=>{
  navigate("/login");
  localStorage.setItem("header","login");
}
const registration=async()=>{
  navigate("/registration");
  localStorage.setItem("header","login");
}
const myprofile=async()=>{
  navigate("/myprofile")
}

    
    return <div>
        {
         header==="login"?
        <nav class="navbar navbar-expand-lg header-navbar">
            <div class="container-fluid">
              <a class="navbar-brand" href="/">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100" align="left"/>
              </a>
            </div>
        </nav>
   

        :header==="logout"?
        <nav class="navbar navbar-expand-lg header-navbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="/">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/>
          </a>
            <div class="col-md-3 text-end">
            <img src={avatar} width="50" height="50" alt="Avatar" class="avatar" onClick={myprofile} style={{ borderRadius:"50%"}}/>
            {"                            "}
                <button type="button" class="btn btn-primary btn-sm" onClick={logoutFunc}>LOGOUT</button>
                
              </div>
        </div>
      </nav>
        
          :
          <nav class="navbar navbar-expand-lg header-navbar">
          <div class="container-fluid">
            <a class="navbar-brand" href="/">
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/>
            </a>
              <div class="col-md-3 text-end">
                  <button type="button" class="btn btn-primary btn-sm" onClick={login}>Login  </button>
                  
                  <button type="button" class="btn btn-primary btn-sm" onClick={registration}> Registration</button>
                </div>
          </div>
        </nav>
          
        }

</div>	
}
export {Header};
