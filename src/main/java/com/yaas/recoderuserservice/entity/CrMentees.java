package com.yaas.recoderuserservice.entity;

import com.yaas.recoderuserservice.model.CrMenteesResponseModel;
import java.util.List;

public class CrMentees {
    private long menteeId;

    private long roomId;

    private String menteeNickname;

    private int reviewCount;

    private int reviewLanguage;

    private List<CrMenteesResponseModel> crMentees;

    public void setMenteeId(long menteeId) {
        this.menteeId = menteeId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public void setMenteeNickname(String menteeNickname) {
        this.menteeNickname = menteeNickname;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setReviewLanguage(int reviewLanguage) {
        this.reviewLanguage = reviewLanguage;
    }

    public void setCrMentees(List<CrMenteesResponseModel> crMentees) {
        this.crMentees = crMentees;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.entity.CrMentees))
            return false;
        com.yaas.recoderuserservice.entity.CrMentees other = (com.yaas.recoderuserservice.entity.CrMentees)o;
        if (!other.canEqual(this))
            return false;
        if (getMenteeId() != other.getMenteeId())
            return false;
        if (getRoomId() != other.getRoomId())
            return false;
        Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
        if ((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname))
            return false;
        if (getReviewCount() != other.getReviewCount())
            return false;
        if (getReviewLanguage() != other.getReviewLanguage())
            return false;
        List<CrMenteesResponseModel> this$crMentees = getCrMentees(), other$crMentees = other.getCrMentees();
        return !((this$crMentees == null) ? (other$crMentees != null) : !this$crMentees.equals(other$crMentees));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.entity.CrMentees;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $menteeId = getMenteeId();
        result = result * 59 + (int)($menteeId >>> 32L ^ $menteeId);
        long $roomId = getRoomId();
        result = result * 59 + (int)($roomId >>> 32L ^ $roomId);
        Object $menteeNickname = getMenteeNickname();
        result = result * 59 + (($menteeNickname == null) ? 43 : $menteeNickname.hashCode());
        result = result * 59 + getReviewCount();
        result = result * 59 + getReviewLanguage();
        List<CrMenteesResponseModel> $crMentees = getCrMentees();
        return result * 59 + (($crMentees == null) ? 43 : $crMentees.hashCode());
    }

    public String toString() {
        return "CrMentees(menteeId=" + getMenteeId() + ", roomId=" + getRoomId() + ", menteeNickname=" + getMenteeNickname() + ", reviewCount=" + getReviewCount() + ", reviewLanguage=" + getReviewLanguage() + ", crMentees=" + getCrMentees() + ")";
    }

    public long getMenteeId() {
        return this.menteeId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getMenteeNickname() {
        return this.menteeNickname;
    }

    public int getReviewCount() {
        return this.reviewCount;
    }

    public int getReviewLanguage() {
        return this.reviewLanguage;
    }

    public List<CrMenteesResponseModel> getCrMentees() {
        return this.crMentees;
    }
}
