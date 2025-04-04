package com.yaas.recoderuserservice.model;

public class CreateMentorResponseModel {
    private long mentorId;

    private long userId;

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.CreateMentorResponseModel))
            return false;
        com.yaas.recoderuserservice.model.CreateMentorResponseModel other = (com.yaas.recoderuserservice.model.CreateMentorResponseModel)o;
        return !other.canEqual(this) ? false : ((getMentorId() != other.getMentorId()) ? false : (!(getUserId() != other.getUserId())));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.CreateMentorResponseModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $mentorId = getMentorId();
        result = result * 59 + (int)($mentorId >>> 32L ^ $mentorId);
        long $userId = getUserId();
        return result * 59 + (int)($userId >>> 32L ^ $userId);
    }

    public String toString() {
        return "CreateMentorResponseModel(mentorId=" + getMentorId() + ", userId=" + getUserId() + ")";
    }

    public long getMentorId() {
        return this.mentorId;
    }

    public long getUserId() {
        return this.userId;
    }
}
