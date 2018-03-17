package hacktues.interno.com.interno;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by rhubenov on 17.03.18.
 */

public class CompanyListAdapter extends ArrayAdapter<Company> {
    public CompanyListAdapter(@NonNull Context context, int resource, @NonNull List<Company> objects) {
        super(context, resource, objects);
    }
}
