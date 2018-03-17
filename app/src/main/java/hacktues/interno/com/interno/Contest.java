package hacktues.interno.com.interno;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by rhubenov on 17.03.18.
 */

public class Contest {
    String mCompany;
    String mTitle;
    String mDescription;
    long mDeadline;
    String mPosition;
    String mTechnology;
    Integer mScore;

    public Contest(String mCompany,String mTitle, String mDescription, long mDeadline, String mPosition, String mTechnology, Integer mScore) {
        this.mCompany = mCompany;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mDeadline = mDeadline;
        this.mPosition = mPosition;
        this.mTechnology = mTechnology;
        this.mScore = mScore;
    }

    public String getmCompany(){
        return mCompany;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public long getmDeadline() {
        return mDeadline;
    }

    public String getmPosition() {
        return mPosition;
    }

    public String getmTechnology() {
        return mTechnology;
    }

    public Integer getmScore() {
        return mScore;
    }

    public void setmCompany(String mCompany){
        this.mCompany = mCompany;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmDeadline(long mDeadline) {
        this.mDeadline = mDeadline;
    }

    public void setmPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public void setmTechnology(String mTechnology) {
        this.mTechnology = mTechnology;
    }

    public void setmScore(Integer mScore) {
        this.mScore = mScore;
    }

}
