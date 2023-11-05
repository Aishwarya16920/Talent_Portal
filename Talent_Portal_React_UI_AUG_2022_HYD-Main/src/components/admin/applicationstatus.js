import {useDispatch,useSelector} from 'react-redux';
import {useEffect, useRef, useState} from 'react';
import applnstatus from '../../actions/applicationstatus';
import updateStatus from '../../actions/updatestatus';
import React from 'react';

const ApplnStatus=()=>{

    let dispatcher=useDispatch();
    let currentStatus=useSelector((state)=>state.appdetails);
    let select=useRef();
    let authToken = localStorage.getItem('authToken');
  useEffect(
    ()=>{
      return()=>dispatcher(applnstatus({authToken}));
    },[]
  )

    if(currentStatus==undefined){
        currentStatus=[];
    }
let handleChange = (statusId,id,jobId,userName) => {
  let updateUserStatus={id,userName,jobId,statusId,authToken}
  dispatcher(applnstatus({authToken}));
  dispatcher(updateStatus(updateUserStatus,authToken));
  dispatcher(applnstatus({authToken}));
}


    let applicationDetails = currentStatus.map((application,index) => {
      return <tr key={index} >
        
       <td>{application.jobId}</td>
      <td>{application.user_name}</td>
      <td>{application.skill}</td>
      <td>{application.status_id}</td>
     
      <td>
       <div class="btn-group">
                                        
<select ref={select} onChange={(e) => handleChange(e.target.value,application.id,application.jobId,application.user_name)} class="btn btn-primary dropdown-toggle  btn-sm"   data-bs-toggle="dropdown" style={{border: "2px solid #d3d2d2", padding: "15px 32px", margin: "5px"}}
aria-label="Default select example" className="form-select">
  <option selected>{application.status_id}</option>
  <option value={"1"}>Applied</option>
    <option value={"2"}>Under Processing</option>
     <option value={"3"}> Shortlisted for Technical round</option>
  <option value={"4"}>Shortlisted for HR</option>

  <option value={"5"}>Rejected</option>
  <option value={"6"}>Selected</option>


</select>            
                                      </div>
                                      </td>
      
      
    </tr>
    
    });
   

    return (<div>
    
        <section>
         

       
          <div className='container'>
          <ul class="nav nav-tabs" role="tablist">
      </ul>
    <div class="tab-content">
        <div id="job_Applicant" class="container tab-pane active"><br></br>
        <div class="job_ApplicantTab">
                <div class="mt-3 c-card" >
                    <div class="px-2 p-2">
                        <table class="table applicantTable">
                            <tbody>
                              <tr class="applicantgrid">
                                <td><b>JOB ID</b>
                                    <span class="nav-link p-0 disabled">{currentStatus.username}</span>
                                </td>
                                <td><b>USERNAME</b>
                                    
                                       {currentStatus.skill}
                                    
                                    
                                </td>
                                <td><b>SKILL</b>
                                    {currentStatus.jobId}
                                </td>

                                <td><b>Status Id</b>
                                    <span class="nav-link p-0 disabled">{currentStatus.status_id}</span>
                                </td>

                                <td>
                                <b>Status</b>
                                   
                                </td>
                              </tr> 
                              {
                                applicationDetails
                              }
                           
                             
                            </tbody>
                          </table>
                        
                             
                    </div>
                    
                </div>
                </div>
                
                
                
    
           
           

       
           </div>
            
            </div>
            </div>
       
          
      </section>
    </div>
    );
}
export default ApplnStatus;