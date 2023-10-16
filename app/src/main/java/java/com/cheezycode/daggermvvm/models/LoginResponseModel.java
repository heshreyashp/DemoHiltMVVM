package java.com.cheezycode.daggermvvm.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginResponseModel implements Parcelable {

    @SerializedName("jwtToken")
    private String jwtToken;

    @SerializedName("tenant")
    private String tenant;

    @SerializedName("refreshToken")
    private String refreshToken;

    @SerializedName("success")
    private boolean success;
    @SerializedName("expired")
    private boolean expired;

    @SerializedName("message")
    private String errorMessage;
    @SerializedName("eventName")
    private String eventName;

    @SerializedName("socketId")
    private String socketId;

    public LoginResponseModel() {
    }

    protected LoginResponseModel(Parcel in) {
        jwtToken = in.readString();
        refreshToken = in.readString();
        success = in.readByte() != 0;
        expired = in.readByte() != 0;
        errorMessage = in.readString();
        tenant = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(jwtToken);
        dest.writeString(refreshToken);
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeByte((byte) (expired ? 1 : 0));
        dest.writeString(errorMessage);
        dest.writeString(tenant);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<LoginResponseModel> CREATOR = new Creator<LoginResponseModel>() {
        @Override
        public LoginResponseModel createFromParcel(Parcel in) {
            return new LoginResponseModel(in);
        }

        @Override
        public LoginResponseModel[] newArray(int size) {
            return new LoginResponseModel[size];
        }
    };

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
