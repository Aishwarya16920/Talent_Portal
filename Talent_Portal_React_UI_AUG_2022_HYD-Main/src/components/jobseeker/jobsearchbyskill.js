import {useRef, useState,useEffect} from 'react';
import {useDispatch,useSelector} from "react-redux";
import getAllbyskill from "../../actions/jobsearchbyskill";

const SearchBySkill = (props) =>{
    let dispatcher=useDispatch();
    let SearchBySkills=useSelector((state)=>state.Searchjobs);
   
    
    if(SearchBySkills === undefined){
      SearchBySkills = {};
     
    }
    let SearchByskill=useRef();
    const key=()=>{
      if(SearchByskill.current.value=="")
      {
        setSearchByskillError("Please enter a skill to search");
      }
        
      else 
        {
          if(!SearchByskill.current.value.match(/[A-Z]/i))
          {
         
          setSearchByskillError("Please enter the correct skill to search");  
        }
      else{
      const skill=SearchByskill.current.value;
      
      let searchskill={
        "skills":skill
      }
      dispatcher(getAllbyskill(searchskill)); 
        setSearchByskillError("");
        SearchBySkills = {};
        console.log("Information:",SearchBySkills);
       }
      
      }

    }
    
       
    
    const[SearchByskillerror,setSearchByskillError]=useState("");

    const submit=()=>{
        setSearchByskillError(SearchByskill.current.value?"":"Please enter a skill to search");
       
    } 
    return(
        <section>
          <div class="row mt-5">
            <div class="col-md-6 mx-auto">
            <div className="input-group col-md-4">
                <input
                  className="form-control py-2"
                  type="search"
                  placeholder="search by skill"
                  id="example-search-input"
                  style={{height: "37px"}}
                  onChange={submit}
                  ref={SearchByskill}
                
                />
                <span class="input-group-append">
                  <button className="btn btn-primary" type='submit' onClick={key} onChange={submit}  >Search</button>
                </span>

              </div>
                  {SearchByskillerror && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{SearchByskillerror}</div>}

            </div>
            
          </div>
         
        </section>
    );
}
export{SearchBySkill};