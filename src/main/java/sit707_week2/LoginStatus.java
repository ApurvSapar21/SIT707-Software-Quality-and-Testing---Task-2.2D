package sit707_week2;

/**
 * Encapsulates login status and error message.
 * @author Ahsan Habib
 */
public class LoginStatus {
    private boolean loginSuccess;
    private String errorMsg;

    public LoginStatus(boolean loginSuccess, String errorMsg) {
        this.loginSuccess = loginSuccess;
        this.errorMsg = errorMsg;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "LoginStatus [loginSuccess=" + loginSuccess + ", errorMsg=" + errorMsg + "]";
    }
}
