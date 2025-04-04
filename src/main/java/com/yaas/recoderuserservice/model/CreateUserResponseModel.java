package com.yaas.recoderuserservice.model;

public class CreateUserResponseModel {
    private String name;

    private String email;

    private int type;

    private int gender;

    private String mentorNickname;

    private String menteeNickname;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setMentorNickname(String mentorNickname) {
        this.mentorNickname = mentorNickname;
    }

    public void setMenteeNickname(String menteeNickname) {
        this.menteeNickname = menteeNickname;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.CreateUserResponseModel))
            return false;
        com.yaas.recoderuserservice.model.CreateUserResponseModel other = (com.yaas.recoderuserservice.model.CreateUserResponseModel)o;
        if (!other.canEqual(this))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$email = getEmail(), other$email = other.getEmail();
        if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email))
            return false;
        if (getType() != other.getType())
            return false;
        if (getGender() != other.getGender())
            return false;
        Object this$mentorNickname = getMentorNickname(), other$mentorNickname = other.getMentorNickname();
        if ((this$mentorNickname == null) ? (other$mentorNickname != null) : !this$mentorNickname.equals(other$mentorNickname))
            return false;
        Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
        return !((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.CreateUserResponseModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $email = getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        result = result * 59 + getType();
        result = result * 59 + getGender();
        Object $mentorNickname = getMentorNickname();
        result = result * 59 + (($mentorNickname == null) ? 43 : $mentorNickname.hashCode());
        Object $menteeNickname = getMenteeNickname();
        return result * 59 + (($menteeNickname == null) ? 43 : $menteeNickname.hashCode());
    }

    public String toString() {
        return "CreateUserResponseModel(name=" + getName() + ", email=" + getEmail() + ", type=" + getType() + ", gender=" + getGender() + ", mentorNickname=" + getMentorNickname() + ", menteeNickname=" + getMenteeNickname() + ")";
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getType() {
        return this.type;
    }

    public int getGender() {
        return this.gender;
    }

    public String getMentorNickname() {
        return this.mentorNickname;
    }

    public String getMenteeNickname() {
        return this.menteeNickname;
    }
}
