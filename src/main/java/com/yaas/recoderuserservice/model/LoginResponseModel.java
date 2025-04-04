package com.yaas.recoderuserservice.model;

public class LoginResponseModel {
    private long userId;

    private long mentorId;

    private long menteeId;

    private String name;

    private String email;

    private int type;

    private int gender;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public void setMenteeId(long menteeId) {
        this.menteeId = menteeId;
    }

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

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.LoginResponseModel))
            return false;
        com.yaas.recoderuserservice.model.LoginResponseModel other = (com.yaas.recoderuserservice.model.LoginResponseModel)o;
        if (!other.canEqual(this))
            return false;
        if (getUserId() != other.getUserId())
            return false;
        if (getMentorId() != other.getMentorId())
            return false;
        if (getMenteeId() != other.getMenteeId())
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$email = getEmail(), other$email = other.getEmail();
        return ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) ? false : ((getType() != other.getType()) ? false : (!(getGender() != other.getGender())));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.LoginResponseModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $userId = getUserId();
        result = result * 59 + (int)($userId >>> 32L ^ $userId);
        long $mentorId = getMentorId();
        result = result * 59 + (int)($mentorId >>> 32L ^ $mentorId);
        long $menteeId = getMenteeId();
        result = result * 59 + (int)($menteeId >>> 32L ^ $menteeId);
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $email = getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        result = result * 59 + getType();
        return result * 59 + getGender();
    }

    public String toString() {
        return "LoginResponseModel(userId=" + getUserId() + ", mentorId=" + getMentorId() + ", menteeId=" + getMenteeId() + ", name=" + getName() + ", email=" + getEmail() + ", type=" + getType() + ", gender=" + getGender() + ")";
    }

    public long getUserId() {
        return this.userId;
    }

    public long getMentorId() {
        return this.mentorId;
    }

    public long getMenteeId() {
        return this.menteeId;
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
}
