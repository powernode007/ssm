package com.bjpn.bean;

public class Emp {
    private Integer empNo;

    private String empName;

    private String empJob;

    private String empPhoto;

    private String empHiredate;

    private Double empSal;

    private Integer  deptNo;

    private String dname;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public String getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(String empHiredate) {
        this.empHiredate = empHiredate;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", empPhoto='" + empPhoto + '\'' +
                ", empHiredate='" + empHiredate + '\'' +
                ", empSal=" + empSal +
                ", deptNo=" + deptNo +
                ", dname='" + dname + '\'' +
                '}';
    }
}