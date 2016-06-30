package yycg.base.pojo.po;

import java.math.BigDecimal;

public class Dicttype {
    private String typecode;

    private String typename;

    private String remark;

    private BigDecimal typesort;

    private String codelength;

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getTypesort() {
        return typesort;
    }

    public void setTypesort(BigDecimal typesort) {
        this.typesort = typesort;
    }

    public String getCodelength() {
        return codelength;
    }

    public void setCodelength(String codelength) {
        this.codelength = codelength == null ? null : codelength.trim();
    }
}