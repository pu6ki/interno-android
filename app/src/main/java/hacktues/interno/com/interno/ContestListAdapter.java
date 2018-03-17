package hacktues.interno.com.interno;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

    static class ViewHolder {
        TextView title;
        TextView companyName;
        CountdownView deadline;
        TextView techPosition;
        TextView technology;
    }

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

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
        Company company = getItem(position).getmCompany();
        String title = getItem(position).getmTitle();
        String deadline = getItem(position).getmDeadline();
        String techPosition = getItem(position).getmPosition();
        String technology = getItem(position).getmTechnology();

        //Create the contest
        Contest contest = new Contest(0 ,company,title, null, deadline, techPosition, technology);


        //View for showing the final contest
        final View result;

        //Viewholder object
        ViewHolder holder;

        if(convertView == null){
            //Inflate the view inside the ListView
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.tv_adapter_contest_title);
            holder.companyName = (TextView) convertView.findViewById(R.id.tv_adapter_company_name);
            holder.techPosition = (TextView) convertView.findViewById(R.id.tv_adapter_position);
            holder.technology = (TextView) convertView.findViewById(R.id.tv_adapter_technologies);
            holder.deadline = (CountdownView) convertView.findViewById(R.id.ctdv_adapter_deadline);
            convertView.setTag(holder);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.title.setText(title);
//        holder.companyName.setText(company);
        holder.techPosition.setText(techPosition);
        holder.technology.setText(technology);
//        holder.deadline.updateShow(deadline);

        Log.d(TAG, "getView ended");

        return convertView;
    }
}
