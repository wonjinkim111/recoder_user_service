	package com.yaas.recoderuserservice.model;

public class CreateMenteeResponseModel {
    private long menteeId;

    private long userId;

    public void setMenteeId(long menteeId) {
        this.menteeId = menteeId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.CreateMenteeResponseModel))
            return false;
        com.yaas.recoderuserservice.model.CreateMenteeResponseModel other = (com.yaas.recoderuserservice.model.CreateMenteeResponseModel)o;
        return !other.canEqual(this) ? false : ((getMenteeId() != other.getMenteeId()) ? false : (!(getUserId() != other.getUserId())));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.CreateMenteeResponseModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $menteeId = getMenteeId();
        result = result * 59 + (int)($menteeId >>> 32L ^ $menteeId);
        long $userId = getUserId();
        return result * 59 + (int)($userId >>> 32L ^ $userId);
    }

    public String toString() {
        return "CreateMenteeResponseModel(menteeId=" + getMenteeId() + ", userId=" + getUserId() + ")";
    }

    public long getMenteeId() {
        return this.menteeId;
    }

    public long getUserId() {
        return this.userId;
    }
}
