import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import getUserInfo from "../../actions/getUserInfo";
import React from 'react';
import avatar from './avatar.jpg'
import Listofjob from '../jobseeker/listofjobs.js';
import { Link, useNavigate } from 'react-router-dom';
import logout from "../../actions/logoutaction";

const UserInfo =(props)=>{

  let dispatcher=useDispatch();
  let navigate = useNavigate();
  let authToken = localStorage.getItem('authToken');
  const logoutFunc = async()=>{ //Closure

    let logoutResponse = dispatcher(logout(authToken));

    if(logoutResponse.payload){

     navigate('/login')

    } else {  

        navigate('/')



    }

}
  let userInfo=useSelector((state)=>state.userprofile);
  useEffect(
    ()=>{
      return()=>dispatcher(getUserInfo(authToken));
    },[]
  )

  if(userInfo === undefined){
    userInfo = {};
  }
return (<div>
   <header>

{

     authToken === "" ?

    <nav class="navbar navbar-expand-lg header-navbar">

        <div class="container-fluid">

          <a class="navbar-brand" href="/">

            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100" align="left"/>

          </a>

        </div>

    </nav>



    :

    <nav class="navbar navbar-expand-lg header-navbar">

            <div class="container-fluid">

              <a class="navbar-brand" href="/">

                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/>

              </a>
                <div class="col-md-3 text-end">
    
                    <button type="button" class="btn btn-primary btn-sm" onClick={logoutFunc}>LOGOUT</button>

                  </div>

            </div>

          </nav>

    }

</header>
 <img align="left" src={avatar} width="150" height="150" alt="Avatar" class="avatar"/>
        <div className="row mt-5 ">
             <div class="col-md-6 mx-auto">
             <h5 align="left">My Profile : </h5>
                 <div class="profilecard" style={{border:1}}>
                       <table class="table profil_details">
                         <tbody>
                         <tr className="tr1">
                           <td align="left">ID : </td>
                             <td align="left">{userInfo.id}</td>
                           </tr>
                           <tr className="tr2">
                           <td align="left">FirstName :</td>
                             <td align="left">{userInfo.firstName}</td>
                           </tr>
                           <tr className="tr3">
                             <td align="left">LastName :</td>
                             <td align="left">{userInfo.lastName}</td>
                           </tr>
                           <tr className="tr4">
                             <td align="left">Username :</td>
                             <td align="left">{userInfo.username}</td>
                           </tr>
                           <tr className="tr5">
                             <td align="left">Password :</td>
                             <td align="left">{userInfo.password}</td>
                           </tr>
                          <tr className="tr6">
                             <td align="left">Email ID :</td>
                             <td align="left">{userInfo.email}</td>
                           </tr>
                           <tr className="tr7">
                             <td align="left">Phone :</td>
                             <td align="left">{userInfo.phone}</td>
                           </tr>
                        </tbody>
                       </table>
                 </div>
             </div>
           
          </div>
         

           
         
      
        <Listofjob></Listofjob>
    
    </div>
    
);
    
}
export default UserInfo ;