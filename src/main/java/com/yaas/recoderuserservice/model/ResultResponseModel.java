package com.yaas.recoderuserservice.model;

public class ResultResponseModel {
    private long returnCode;

    public String toString() {
        return "ResultResponseModel(returnCode=" + getReturnCode() + ")";
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $returnCode = getReturnCode();
        return result * 59 + (int)($returnCode >>> 32L ^ $returnCode);
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.ResultResponseModel;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.ResultResponseModel))
            return false;
        com.yaas.recoderuserservice.model.ResultResponseModel other = (com.yaas.recoderuserservice.model.ResultResponseModel)o;
        return !other.canEqual(this) ? false : (!(getReturnCode() != other.getReturnCode()));
    }

    public void setReturnCode(long returnCode) {
        this.returnCode = returnCode;
    }

    public long getReturnCode() {
        return this.returnCode;
    }
}
