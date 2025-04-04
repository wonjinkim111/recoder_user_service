package com.yaas.recoderuserservice.dto;

public class MentorNicknameDto {
    private String mentorNickname;

    public void setMentorNickname(String mentorNickname) {
        this.mentorNickname = mentorNickname;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.dto.MentorNicknameDto))
            return false;
        com.yaas.recoderuserservice.dto.MentorNicknameDto other = (com.yaas.recoderuserservice.dto.MentorNicknameDto)o;
        if (!other.canEqual(this))
            return false;
        Object this$mentorNickname = getMentorNickname(), other$mentorNickname = other.getMentorNickname();
        return !((this$mentorNickname == null) ? (other$mentorNickname != null) : !this$mentorNickname.equals(other$mentorNickname));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.dto.MentorNicknameDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $mentorNickname = getMentorNickname();
        return result * 59 + (($mentorNickname == null) ? 43 : $mentorNickname.hashCode());
    }

    public String toString() {
        return "MentorNicknameDto(mentorNickname=" + getMentorNickname() + ")";
    }

    public MentorNicknameDto(String mentorNickname) {
        this.mentorNickname = mentorNickname;
    }

    public MentorNicknameDto() {}

    public String getMentorNickname() {
        return this.mentorNickname;
    }
}
