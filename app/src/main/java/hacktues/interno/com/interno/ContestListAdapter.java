package hacktues.interno.com.interno;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rhubenov on 17.03.18.
 */

public class ContestListAdapter extends ArrayAdapter<Contest>{

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
        String company = getItem(position).getmCompany();
        String title = getItem(position).getmTitle();
        String description = getItem(position).getmDescription();
        Date deadline = getItem(position).getmDeadline();
        String techPosition = getItem(position).getmPosition();
        String technology = getItem(position).getmTechnology();
        Integer score = getItem(position).getmScore();

        //Create the contest
        Contest contest = new Contest(company,title, description, deadline, techPosition, technology, score);

        //Inflate the view inside the ListView

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        return null;
    }
}
