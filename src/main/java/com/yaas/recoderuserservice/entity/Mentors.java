package com.yaas.recoderuserservice.entity;

import java.util.Date;

public class Mentors {
    private long mentorId;

    private long userId;

    private String mentorNickname;

    private String introduction;

    private Date regDate;

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMentorNickname(String mentorNickname) {
        this.mentorNickname = mentorNickname;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.entity.Mentors))
            return false;
        com.yaas.recoderuserservice.entity.Mentors other = (com.yaas.recoderuserservice.entity.Mentors)o;
        if (!other.canEqual(this))
            return false;
        if (getMentorId() != other.getMentorId())
            return false;
        if (getUserId() != other.getUserId())
            return false;
        Object this$mentorNickname = getMentorNickname(), other$mentorNickname = other.getMentorNickname();
        if ((this$mentorNickname == null) ? (other$mentorNickname != null) : !this$mentorNickname.equals(other$mentorNickname))
            return false;
        Object this$introduction = getIntroduction(), other$introduction = other.getIntroduction();
        if ((this$introduction == null) ? (other$introduction != null) : !this$introduction.equals(other$introduction))
            return false;
        Object this$regDate = getRegDate(), other$regDate = other.getRegDate();
        return !((this$regDate == null) ? (other$regDate != null) : !this$regDate.equals(other$regDate));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.entity.Mentors;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $mentorId = getMentorId();
        result = result * 59 + (int)($mentorId >>> 32L ^ $mentorId);
        long $userId = getUserId();
        result = result * 59 + (int)($userId >>> 32L ^ $userId);
        Object $mentorNickname = getMentorNickname();
        result = result * 59 + (($mentorNickname == null) ? 43 : $mentorNickname.hashCode());
        Object $introduction = getIntroduction();
        result = result * 59 + (($introduction == null) ? 43 : $introduction.hashCode());
        Object $regDate = getRegDate();
        return result * 59 + (($regDate == null) ? 43 : $regDate.hashCode());
    }

    public String toString() {
        return "Mentors(mentorId=" + getMentorId() + ", userId=" + getUserId() + ", mentorNickname=" + getMentorNickname() + ", introduction=" + getIntroduction() + ", regDate=" + getRegDate() + ")";
    }

    public Mentors(long mentorId, long userId, String mentorNickname, String introduction, Date regDate) {
        this.mentorId = mentorId;
        this.userId = userId;
        this.mentorNickname = mentorNickname;
        this.introduction = introduction;
        this.regDate = regDate;
    }

    public Mentors() {}

    public long getMentorId() {
        return this.mentorId;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getMentorNickname() {
        return this.mentorNickname;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public Date getRegDate() {
        return this.regDate;
    }
}
