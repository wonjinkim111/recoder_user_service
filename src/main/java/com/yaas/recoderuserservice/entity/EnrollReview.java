package com.yaas.recoderuserservice.entity;

public class EnrollReview {
    private long enrollId;

    private long menteeId;

    private long roomId;

    public void setEnrollId(long enrollId) {
        this.enrollId = enrollId;
    }

    public void setMenteeId(long menteeId) {
        this.menteeId = menteeId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.entity.EnrollReview))
            return false;
        com.yaas.recoderuserservice.entity.EnrollReview other = (com.yaas.recoderuserservice.entity.EnrollReview)o;
        return !other.canEqual(this) ? false : ((getEnrollId() != other.getEnrollId()) ? false : ((getMenteeId() != other.getMenteeId()) ? false : (!(getRoomId() != other.getRoomId()))));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.entity.EnrollReview;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $enrollId = getEnrollId();
        result = result * 59 + (int)($enrollId >>> 32L ^ $enrollId);
        long $menteeId = getMenteeId();
        result = result * 59 + (int)($menteeId >>> 32L ^ $menteeId);
        long $roomId = getRoomId();
        return result * 59 + (int)($roomId >>> 32L ^ $roomId);
    }

    public String toString() {
        return "EnrollReview(enrollId=" + getEnrollId() + ", menteeId=" + getMenteeId() + ", roomId=" + getRoomId() + ")";
    }

    public EnrollReview(long enrollId, long menteeId, long roomId) {
        this.enrollId = enrollId;
        this.menteeId = menteeId;
        this.roomId = roomId;
    }

    public EnrollReview() {}

    public long getEnrollId() {
        return this.enrollId;
    }

    public long getMenteeId() {
        return this.menteeId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public EnrollReview(long menteeId, long roomId) {
        this.menteeId = menteeId;
        this.roomId = roomId;
    }
}
