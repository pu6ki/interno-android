package hacktues.interno.com.interno;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by rhubenov on 17.03.18.
 */

public class Contest {
    int mId;
    Company mCompany;
    String mTitle;
    String mDescription;
    String mDeadline;
    String mPosition;
    String mTechnology;

    public Contest(int id, Company mCompany,String mTitle, String mDescription, String mDeadline, String mPosition, String mTechnology) {
        this.mId = id;
        this.mCompany = mCompany;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mDeadline = mDeadline;
        this.mPosition = mPosition;
        this.mTechnology = mTechnology;
    }

    public Company getmCompany(){
        return mCompany;
    }

    public int getmId(){ return mId; }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmDeadline() {
        return mDeadline;
    }

    public String getmPosition() {
        return mPosition;
    }

    public String getmTechnology() {
        return mTechnology;
    }

    public void setmCompany(Company mCompany){
        this.mCompany = mCompany;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmDeadline(String mDeadline) {
        this.mDeadline = mDeadline;
    }

    public void setmPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public void setmTechnology(String mTechnology) {
        this.mTechnology = mTechnology;
    }

}
