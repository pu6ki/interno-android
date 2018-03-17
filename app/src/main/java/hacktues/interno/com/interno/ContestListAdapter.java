package hacktues.interno.com.interno;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by rhubenov on 17.03.18.
 */

public class ContestListAdapter extends ArrayAdapter<Contest>{

    private static final String TAG = "ContestListAdapter";

    private Context mContext;
    private int mResource;

    public ContestListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contest> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get contest information
        Log.d(TAG, "getView started");
        String company = getItem(position).getmCompany();
        String title = getItem(position).getmTitle();
        String description = getItem(position).getmDescription();
        long deadline = getItem(position).getmDeadline();
        String techPosition = getItem(position).getmPosition();
        String technology = getItem(position).getmTechnology();
        Integer score = getItem(position).getmScore();

        //Create the contest
        Contest contest = new Contest(company,title, description, deadline, techPosition, technology, score);

        //Inflate the view inside the ListView

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_adapter_contest_title);
        TextView tvCompany = (TextView) convertView.findViewById(R.id.tv_adapter_company_name);
        TextView tvPosition = (TextView) convertView.findViewById(R.id.tv_adapter_position);
        TextView tvTechnologies = (TextView) convertView.findViewById(R.id.tv_adapter_technologies);
        CountdownView ctdnDeadline = (CountdownView) convertView.findViewById(R.id.ctdv_adapter_deadline);

        tvTitle.setText(title);
        tvCompany.setText(company);
        tvPosition.setText(techPosition);
        tvTechnologies.setText(technology);
        ctdnDeadline.updateShow(deadline);

        Log.d(TAG, "getView ended");

        return convertView;
    }
}
