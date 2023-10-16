package java.com.cheezycode.daggermvvm.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseModel<T> implements Parcelable {

    @SerializedName("data")
    private T data;


    @SerializedName("errors")
    private ArrayList<String> errorList;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("canSubmit")
    private boolean canSubmit;

    @SerializedName("errorCode")
    private int errorCode;

    private String errorDescription = "";


    public BaseModel() {

    }

    protected BaseModel(Parcel in) {
        errorList = in.createStringArrayList();
        errorMessage = in.readString();
        canSubmit = in.readByte() != 0;
        errorDescription = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(errorList);
        dest.writeString(errorMessage);
        dest.writeByte((byte) (canSubmit ? 1 : 0));
        dest.writeString(errorDescription);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<BaseModel> CREATOR = new Parcelable.Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isAPISuccess() {
        return (TextUtils.isEmpty(errorMessage) || (errorList == null || errorList.size() <= 0)) && (errorList != null || getData() != null);
    }

    public ArrayList<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(ArrayList<String> errorList) {
        this.errorList = errorList;
    }

    public boolean isValidError() {
        /*if (getErrorList() != null && getErrorList().size() > 0 && !TextUtils.isEmpty(getErrorList().get(0).getDetail())) {
            return true;
        } else {
            return false;
        }*/
        return TextUtils.isEmpty(errorMessage);
    }

    public String getErrorMessage() {
        /*if (getErrorList() != null && !getErrorList().isEmpty())
            return getErrorList().get(0).getDetail();
        else
            return "";*/
        return this.errorMessage;
    }


    public boolean isCanSubmit() {
        return canSubmit;
    }

    public void setCanSubmit(boolean canSubmit) {
        this.canSubmit = canSubmit;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    private void createErrorDescription() {
        if (errorList != null && !errorList.isEmpty()) {

            for (int i = 0; i < errorList.size(); i++) {
                if (!TextUtils.isEmpty(errorDescription)){
                    errorDescription=errorDescription+"\n";
                }
                errorDescription = errorDescription + errorList.get(i);
                if (errorCode!=-1){
                    errorDescription=errorDescription+" Error code: D"+errorCode;
                }
            }
        }
    }
}
