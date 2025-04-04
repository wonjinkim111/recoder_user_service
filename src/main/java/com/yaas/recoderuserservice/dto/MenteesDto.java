package com.yaas.recoderuserservice.dto;

import java.util.Date;

public class MenteesDto {
    private long menteeId;

    private long userId;

    private String menteeNickname;

    private Date regDate;

    public void setMenteeId(long menteeId) {
        this.menteeId = menteeId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMenteeNickname(String menteeNickname) {
        this.menteeNickname = menteeNickname;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.dto.MenteesDto))
            return false;
        com.yaas.recoderuserservice.dto.MenteesDto other = (com.yaas.recoderuserservice.dto.MenteesDto)o;
        if (!other.canEqual(this))
            return false;
        if (getMenteeId() != other.getMenteeId())
            return false;
        if (getUserId() != other.getUserId())
            return false;
        Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
        if ((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname))
            return false;
        Object this$regDate = getRegDate(), other$regDate = other.getRegDate();
        return !((this$regDate == null) ? (other$regDate != null) : !this$regDate.equals(other$regDate));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.dto.MenteesDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $menteeId = getMenteeId();
        result = result * 59 + (int)($menteeId >>> 32L ^ $menteeId);
        long $userId = getUserId();
        result = result * 59 + (int)($userId >>> 32L ^ $userId);
        Object $menteeNickname = getMenteeNickname();
        result = result * 59 + (($menteeNickname == null) ? 43 : $menteeNickname.hashCode());
        Object $regDate = getRegDate();
        return result * 59 + (($regDate == null) ? 43 : $regDate.hashCode());
    }

    public String toString() {
        return "MenteesDto(menteeId=" + getMenteeId() + ", userId=" + getUserId() + ", menteeNickname=" + getMenteeNickname() + ", regDate=" + getRegDate() + ")";
    }

    public MenteesDto(long menteeId, long userId, String menteeNickname, Date regDate) {
        this.menteeId = menteeId;
        this.userId = userId;
        this.menteeNickname = menteeNickname;
        this.regDate = regDate;
    }

    public MenteesDto() {}

    public long getMenteeId() {
        return this.menteeId;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getMenteeNickname() {
        return this.menteeNickname;
    }

    public Date getRegDate() {
        return this.regDate;
    }

    public MenteesDto(long menteeId) {
        this.menteeId = menteeId;
    }

    public MenteesDto(long menteeId, String menteeNickname) {
        this.menteeId = menteeId;
        this.menteeNickname = menteeNickname;
    }
}
