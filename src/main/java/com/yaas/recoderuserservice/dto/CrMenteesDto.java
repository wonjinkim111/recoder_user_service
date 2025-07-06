package com.yaas.recoderuserservice.dto;

public class CrMenteesDto {
	  private long menteeId;
	  
	  private long roomId;
	  
	  private String menteeNickname;
	  
	  private int reviewCount;
	  
	  private int reviewLanguage;
	  
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
	  
	  public boolean equals(Object o) {
	    if (o == this)
	      return true; 
	    if (!(o instanceof com.yaas.recoderuserservice.dto.CrMenteesDto))
	      return false; 
	    com.yaas.recoderuserservice.dto.CrMenteesDto other = (com.yaas.recoderuserservice.dto.CrMenteesDto)o;
	    if (!other.canEqual(this))
	      return false; 
	    if (getMenteeId() != other.getMenteeId())
	      return false; 
	    if (getRoomId() != other.getRoomId())
	      return false; 
	    Object this$menteeNickname = getMenteeNickname(), other$menteeNickname = other.getMenteeNickname();
	    return ((this$menteeNickname == null) ? (other$menteeNickname != null) : !this$menteeNickname.equals(other$menteeNickname)) ? false : ((getReviewCount() != other.getReviewCount()) ? false : (!(getReviewLanguage() != other.getReviewLanguage())));
	  }
	  
	  protected boolean canEqual(Object other) {
	    return other instanceof com.yaas.recoderuserservice.dto.CrMenteesDto;
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
	    return result * 59 + getReviewLanguage();
	  }
	  
	  public String toString() {
	    return "CrMenteesDto(menteeId=" + getMenteeId() + ", roomId=" + getRoomId() + ", menteeNickname=" + getMenteeNickname() + ", reviewCount=" + getReviewCount() + ", reviewLanguage=" + getReviewLanguage() + ")";
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
	  
	  public CrMenteesDto(long menteeId, long roomId, String menteeNickname) {
	    this.menteeId = menteeId;
	    this.roomId = roomId;
	    this.menteeNickname = menteeNickname;
	  }
	}