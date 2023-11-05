import {useEffect, useState, useRef} from 'react';
 import {useDispatch, useSelector} from 'react-redux';
import applyJob from '../../actions/apply_job';
 import { useNavigate } from "react-router-dom";
 import React from 'react'
import { Navigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import userpage from '../../actions/userpage';
import { SearchBySkill } from './jobsearchbyskill';
import logout from '../../actions/logoutaction';
import avatar from './avatar.jpg'

const UserAppliedJobs=(props)=>{
let skill=useRef();
let Title=useRef();
let Description=useRef();
let MinExp=useRef();
let Location=useRef();
let CreatedDate=useRef();
localStorage.setItem("header","logout");
    let dispatcher = useDispatch(); 
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
    let userName=localStorage.getItem('username');
    let jobs = useSelector((state)=>state.userjoblist);
    let jobslist = useSelector((state)=>state.Searchjobs);
    let joblist=useSelector((state)=>state.userjoblist);
    const [text,setText]=useState(0);
    useEffect (
      ()=> {
            return ()=> dispatcher(userpage(authToken));
        }, []) 
    
        const sumbit=async(jobId,userName,statusId)=>{  
          if(authToken===''){  
            navigate('/login');
          }  
          else{
          let postjob={jobId,userName,statusId}; 
        await dispatcher(applyJob(postjob));
        dispatcher(userpage(authToken));
          setText(jobId);
          }
        
        }
        if(jobslist===undefined) {
            jobslist = [];
            joblist=jobs;
          }
         
          if(jobslist.length>0) {
           
            joblist = jobslist;
            
                  } 
  
                  if(joblist===undefined)
                  {
                    joblist=[]
               }  
             let jobsData =  joblist.map(function(job, index) {              
                return (               
                            <ul class="nav" key={index} >
                     <div class="container">          
            <div class="card mt-3 c-card" >
                <div class="card-body">
                    <div class="row scroll-sm">                      
                        <div class="col-md-2 col-sm-2">
                        <div class="company-logo">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"></img>
                            </div>
                            </div>
                        <div class="col-md-8 col-sm-8">
                            <div class="job-info-head">
                            <h3 align="left" ref={Title}>{job.title}</h3> <br></br>
                  <h6 ref={Description}>{job.description}</h6>
                  <li class="nav-item" ref={skill}><span class="nav-link disabled"><i  style={{fontsize:"16px"}} ></i>Skill: {job.primarySkill}</span></li>
                  <li class="nav-item" ref={MinExp}><span class="nav-link disabled"><i  style={{fontsize:"16px"}}></i> Exp:  {job.minExp}-{job.maxExp} Yrs</span></li>
                  <li class="nav-item" ref={Location}><span class="nav-link disabled" ><i class="fa fa-map-marker" style={{fontsize:"16px"}}></i> {job.location}</span></li>
                  <li class="nav-item" ref={CreatedDate}><span class="nav-link disabled"><i class="fa-solid fa fa-calendar fa-2xl" style={{fontsize:"16px"}}></i> {job.createdDate}</span></li>
                                </div>
                            </div>
                            <div class="col-md-2 col-sm-2">
                            <div class="job-apply">
                                <div  >  
                                  
                                { job.isApplied ===true && authToken!='' ? 
                                   
                                 <button type="button"  class={`btn ${text==job.id ? 'btn-success' : 'btn-success'} c-btn`}   >{(text==job.id?'Applied':'Applied') }       </button>   
                                 :
                                <button type="button"  class={`btn ${text==job.id ? 'btn-success' : 'btn-primary'} c-btn`}  onClick={()=>{ sumbit(job.id,userName,1)}} >{(text==job.id?'Applied':'Apply') } </button>   


                                }
                                
                                
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
          </div>                                   
                  </ul>                 
                );
                  
             })  
    return(  <section>
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

              <div class="col-12 col-md-auto mb-2 justify-content-center  mb-md-0">

                <h5>Apply Jobs</h5>

              </div>

                <div class="col-md-3 text-end">
                <Link to = "/myprofile"><img src={avatar} width="40" height="40" alt="Avatar" class="avatar btn-sm m-2"/></Link>
                    <button type="button" class="btn btn-primary btn-sm" onClick={logoutFunc}>LOGOUT</button>

                  </div>

            </div>

          </nav>

    }

</header>
         
    
            <div class="container">
            <SearchBySkill></SearchBySkill>

                {jobsData}
            </div>
          
      </section>
    );
}

export default UserAppliedJobs;