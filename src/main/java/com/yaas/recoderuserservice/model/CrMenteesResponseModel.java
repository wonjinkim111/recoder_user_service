package com.yaas.recoderuserservice.model;

public class CrMenteesResponseModel {
    private int reviewCount;

    private int reviewLanguage;

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setReviewLanguage(int reviewLanguage) {
        this.reviewLanguage = reviewLanguage;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.CrMenteesResponseModel))
            return false;
        com.yaas.recoderuserservice.model.CrMenteesResponseModel other = (com.yaas.recoderuserservice.model.CrMenteesResponseModel)o;
        return !other.canEqual(this) ? false : ((getReviewCount() != other.getReviewCount()) ? false : (!(getReviewLanguage() != other.getReviewLanguage())));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.CrMenteesResponseModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + getReviewCount();
        return result * 59 + getReviewLanguage();
    }

    public String toString() {
        return "CrMenteesResponseModel(reviewCount=" + getReviewCount() + ", reviewLanguage=" + getReviewLanguage() + ")";
    }

    public int getReviewCount() {
        return this.reviewCount;
    }

    public int getReviewLanguage() {
        return this.reviewLanguage;
    }
}
