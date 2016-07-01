package yycg.base.pojo.po;

public class Usergysarea extends UsergysareaKey {
    private String vchar1;

    private String vchar2;

    private String vchar3;

    public String getVchar1() {
        return vchar1;
    }

    public void setVchar1(String vchar1) {
        this.vchar1 = vchar1 == null ? null : vchar1.trim();
    }

    public String getVchar2() {
        return vchar2;
    }

    public void setVchar2(String vchar2) {
        this.vchar2 = vchar2 == null ? null : vchar2.trim();
    }

    public String getVchar3() {
        return vchar3;
    }

    public void setVchar3(String vchar3) {
        this.vchar3 = vchar3 == null ? null : vchar3.trim();
    }
}