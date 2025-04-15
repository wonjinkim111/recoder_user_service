package com.yaas.recoderuserservice.dto;

import java.util.Date;

public class UsersDto {
    private String userId;

    private String name;

    private String email;

    private String encryptedPassword;
    
    private String password;

    private int type;

    private int gender;

    private Date regDate;

    private String mentorId;

    private String menteeId;

    private String mentorNickname;

    private String menteeNickname;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public void setMenteeId(String menteeId) {
        this.menteeId = menteeId;
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
        if (!(o instanceof com.yaas.recoderuserservice.dto.UsersDto))
            return false;
        com.yaas.recoderuserservice.dto.UsersDto other = (com.yaas.recoderuserservice.dto.UsersDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$userId = getUserId(), other$userId = other.getUserId();
        if ((this$userId == null) ? (other$userId != null) : !this$userId.equals(other$userId))
            return false;
        Object this$name = getName(), other$name = other.getName();
        if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
            return false;
        Object this$email = getEmail(), other$email = other.getEmail();
        if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email))
            return false;
        Object this$encryptedPassword = getEncryptedPassword(), other$encryptedPassword = other.getEncryptedPassword();
        if ((this$encryptedPassword == null) ? (other$encryptedPassword != null) : !this$encryptedPassword.equals(other$encryptedPassword))
            return false;
        if (getType() != other.getType())
            return false;
        if (getGender() != other.getGender())
            return false;
        Object this$regDate = getRegDate(), other$regDate = other.getRegDate();
        if ((this$regDate == null) ? (other$regDate != null) : !this$regDate.equals(other$regDate))
            return false;
        Object this$mentorId = getMentorId(), other$mentorId = other.getMentorId();
        if ((this$mentorId == null) ? (other$mentorId != null) : !this$mentorId.equals(other$mentorId))
            return false;
        Object this$menteeId = getMenteeId(), other$menteeId = other.getMenteeId();
        if ((this$menteeId == null) ? (other$menteeId != null) : !this$menteeId.equals(other$menteeId))
            return false;
        Object this$mentorNickname = getMentorNickname(), other$mentorNickname = other.getMentorNickname();
        if ((this$mentorNickname == null) ? (other$mentorNickname != null) : !this$mentorNickname.equals(other$mentorNickname))
            return false;
        Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
        return !((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.dto.UsersDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $userId = getUserId();
        result = result * 59 + (($userId == null) ? 43 : $userId.hashCode());
        Object $name = getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        Object $email = getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        Object $encryptedPassword = getEncryptedPassword();
        result = result * 59 + (($encryptedPassword == null) ? 43 : $encryptedPassword.hashCode());
        result = result * 59 + getType();
        result = result * 59 + getGender();
        Object $regDate = getRegDate();
        result = result * 59 + (($regDate == null) ? 43 : $regDate.hashCode());
        Object $mentorId = getMentorId();
        result = result * 59 + (($mentorId == null) ? 43 : $mentorId.hashCode());
        Object $menteeId = getMenteeId();
        result = result * 59 + (($menteeId == null) ? 43 : $menteeId.hashCode());
        Object $mentorNickname = getMentorNickname();
        result = result * 59 + (($mentorNickname == null) ? 43 : $mentorNickname.hashCode());
        Object $menteeNickname = getMenteeNickname();
        return result * 59 + (($menteeNickname == null) ? 43 : $menteeNickname.hashCode());
    }

    public String toString() {
        return "UsersDto(userId=" + getUserId() + ", name=" + getName() + ", email=" + getEmail() + ", encryptedPassword=" + getEncryptedPassword() + ", type=" + getType() + ", gender=" + getGender() + ", regDate=" + getRegDate() + ", mentorId=" + getMentorId() + ", menteeId=" + getMenteeId() + ", mentorNickname=" + getMentorNickname() + ", menteeNickname=" + getMenteeNickname() + ")";
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public int getType() {
        return this.type;
    }

    public int getGender() {
        return this.gender;
    }

    public Date getRegDate() {
        return this.regDate;
    }

    public String getMentorId() {
        return this.mentorId;
    }

    public String getMenteeId() {
        return this.menteeId;
    }

    public String getMentorNickname() {
        return this.mentorNickname;
    }

    public String getMenteeNickname() {
        return this.menteeNickname;
    }
}
