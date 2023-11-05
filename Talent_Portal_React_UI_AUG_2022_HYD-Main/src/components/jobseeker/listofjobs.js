import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import GetListofjobs from "../../actions/listofjobs";

const Listofjob=()=>{
    let dispatcher=useDispatch();
    let authToken = localStorage.getItem('authToken');
    let jobList=useSelector((state)=>state.jobappliedintheprotal);
    useEffect(
        ()=>{
          return()=>dispatcher(GetListofjobs(authToken));
        },[]
      )

      if(jobList===undefined)
      jobList = [];
      let data =jobList.map(function(lis, index) {
        return (
<ul key={index}>
<div class="card mt-3 c-card" >
          <div class="card-body">
              <div class="row scroll-sm">
                  <div class="col-md-2 col-sm-2">
                      <div class="company-logo">
                          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/>
                      </div>
                      <span class="nav-link disabled"><h6>JobID : {lis.jobId}</h6></span>
                  </div>

                  <div class="col-md-8 col-sm-8">
                     <div class="job-role">
                       <h3> {lis.title}</h3>
                     </div>
                     
                     
                      <div class="job-info-head">
                          <ul class="nav">
                              <li class="nav-item">
                                <span class="nav-link disabled">Zensar Technology</span>
                              </li>
                              <li class="nav-item">
                              <sapn class="nav-link disabled"> <i className="fa fa-map-marker" style={{fontsize:"16px"}}></i> {lis.location}</sapn>
                              </li>
                            </ul>
                      </div>
                  </div>
                  <div class="col-md-2 col-sm-2">
                      <div class="job-apply">
                          <div class="btn btn-outline-primary c-btn disabled">{lis.status}</div>
                      </div>
                  </div>
  
              </div>
          </div>
      </div>
      

</ul>
        );

      })
      
return(
  <div>
           <div class="col-md-6 mx-auto">      
                   <h4 align="center">Jobs Applied</h4>
          </div>
          <div className="container">
     {data}   
  </div>    
  </div>
    
);
}
export default Listofjob;