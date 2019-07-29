package cn.mldn.testVo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String ioc;
    private Company company = new Company();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getIoc() {
        return ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
