package com.yaas.recoderuserservice.dto;

public class NicknameDto {
    private String menteeNickname;

    public String toString() {
        return "NicknameDto(menteeNickname=" + getMenteeNickname() + ")";
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $menteeNickname = getMenteeNickname();
        return result * 59 + (($menteeNickname == null) ? 43 : $menteeNickname.hashCode());
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.dto.NicknameDto;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.dto.NicknameDto))
            return false;
        com.yaas.recoderuserservice.dto.NicknameDto other = (com.yaas.recoderuserservice.dto.NicknameDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
        return !((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname));
    }

    public void setMenteeNickname(String menteeNickname) {
        this.menteeNickname = menteeNickname;
    }

    public String getMenteeNickname() {
        return this.menteeNickname;
    }
}
