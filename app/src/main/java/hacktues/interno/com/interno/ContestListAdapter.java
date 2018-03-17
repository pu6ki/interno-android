package hacktues.interno.com.interno;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhubenov on 17.03.18.
 */

public class ContestListAdapter extends ArrayAdapter<Contest>{
    public ContestListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contest> objects) {
        super(context, resource, objects);
    }

}
