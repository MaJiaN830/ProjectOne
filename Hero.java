package ProjectOne;

public class Hero {
    private int id;
    private String name;
    private String career;
    private String intro;
    private String skill;
    private int UserID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "英雄的" +
                "id为" + id +
                ", 姓名为'" + name + '\'' +
                ", 英雄职业为'" + career + '\'' +
                ", 英雄介绍如下':" + intro + '\'' +
                ", 英雄技能为'" + skill + '\'' +
                ", 创建者的用户ID为'" + UserID + "'" +
                '\n';
    }
}
