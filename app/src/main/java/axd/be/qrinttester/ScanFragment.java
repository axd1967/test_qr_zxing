package axd.be.qrinttester;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by alex on 27/10/2016.
 */
public class ScanFragment extends Fragment {

    private static final String TAG = ScanFragment.class.getSimpleName(); 

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment, container, false);

        Button b = (Button) rootView.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scan();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public ScanFragment() {}

    private void scan() {
        Log.d(TAG, "scan: start");
    }
}
