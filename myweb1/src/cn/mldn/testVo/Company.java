package cn.mldn.testVo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Company implements Serializable {

private  String name;
private  String address;
private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
