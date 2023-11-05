package com.zensar.tp.dto;



public class ApplicantsDto {
    private int id;
    private int jobId;
    public int getJobId() {
        return jobId;
    }



   public void setJobId(int jobId) {
        this.jobId = jobId;
    }



   public ApplicantsDto(int id, int jobId, String skill, String status_id, String userName) {
        super();
        this.id = id;
        this.jobId = jobId;
        this.skill = skill;
        this.status_id = status_id;
        this.userName = userName;
    }





   private String skill;
    private String status_id;
    public String getStatus_id() {
        return status_id;
    }



  public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }



   public ApplicantsDto(int id, String skill, String status_id, String userName) {
        super();
        this.id = id;
        this.skill = skill;
        this.status_id = status_id;
        this.userName = userName;
    }



  public ApplicantsDto(int id, String status_id, String userName) {
        super();
        this.id = id;
        this.status_id = status_id;
        this.userName = userName;
    }



  public ApplicantsDto(int id) {
        super();
        this.id = id;
    }





  private String userName;
    public ApplicantsDto() {
        super();
    }
    
    public int getId() {
        return id;
    }





  public String getSkill() {
        return skill;
    }





  public void setSkill(String skill) {
        this.skill = skill;
    }





  public String getUser_name() {
        return userName;
    }





  public void setUser_name(String user_name) {
        this.userName = user_name;
    }





  
    
}