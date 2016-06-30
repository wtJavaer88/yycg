package yycg.base.pojo.po;

public class UsergysareaKey {
    private String usergysid;

    private String areaid;

    public String getUsergysid() {
        return usergysid;
    }

    public void setUsergysid(String usergysid) {
        this.usergysid = usergysid == null ? null : usergysid.trim();
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }
}