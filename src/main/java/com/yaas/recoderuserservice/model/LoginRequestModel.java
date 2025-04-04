package com.yaas.recoderuserservice.model;

public class LoginRequestModel {
    private String email;

    private String encryptedPassword;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof com.yaas.recoderuserservice.model.LoginRequestModel))
            return false;
        com.yaas.recoderuserservice.model.LoginRequestModel other = (com.yaas.recoderuserservice.model.LoginRequestModel)o;
        if (!other.canEqual(this))
            return false;
        Object this$email = getEmail(), other$email = other.getEmail();
        if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email))
            return false;
        Object this$encryptedPassword = getEncryptedPassword(), other$encryptedPassword = other.getEncryptedPassword();
        return !((this$encryptedPassword == null) ? (other$encryptedPassword != null) : !this$encryptedPassword.equals(other$encryptedPassword));
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.yaas.recoderuserservice.model.LoginRequestModel;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $email = getEmail();
        result = result * 59 + (($email == null) ? 43 : $email.hashCode());
        Object $encryptedPassword = getEncryptedPassword();
        return result * 59 + (($encryptedPassword == null) ? 43 : $encryptedPassword.hashCode());
    }

    public String toString() {
        return "LoginRequestModel(email=" + getEmail() + ", encryptedPassword=" + getEncryptedPassword() + ")";
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }
}
