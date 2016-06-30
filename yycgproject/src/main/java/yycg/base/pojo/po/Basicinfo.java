package yycg.base.pojo.po;

public class Basicinfo {
    private String id;

    private String name;

    private String value;

    private String type;

    private String tag;

    private String isalive;

    private String vchar1;

    private String vchar3;

    private String vchar2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getIsalive() {
        return isalive;
    }

    public void setIsalive(String isalive) {
        this.isalive = isalive == null ? null : isalive.trim();
    }

    public String getVchar1() {
        return vchar1;
    }

    public void setVchar1(String vchar1) {
        this.vchar1 = vchar1 == null ? null : vchar1.trim();
    }

    public String getVchar3() {
        return vchar3;
    }

    public void setVchar3(String vchar3) {
        this.vchar3 = vchar3 == null ? null : vchar3.trim();
    }

    public String getVchar2() {
        return vchar2;
    }

    public void setVchar2(String vchar2) {
        this.vchar2 = vchar2 == null ? null : vchar2.trim();
    }
}