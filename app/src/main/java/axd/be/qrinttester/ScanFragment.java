package axd.be.qrinttester;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by alex on 27/10/2016.
 */
public class ScanFragment extends Fragment {

    private static final String TAG = ScanFragment.class.getSimpleName();
    private static final int QR_SCANNER_REQUEST_CODE = 312;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment, container, false);

        button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(TAG, "onActivityResult: request: " + requestCode);

        switch (requestCode) {

            case IntentIntegrator.REQUEST_CODE: // XXX see also https://github.com/zxing/zxing/issues/291#issuecomment-256361115
            case QR_SCANNER_REQUEST_CODE:

                IntentResult scanResult = IntentIntegrator.parseActivityResult(IntentIntegrator.REQUEST_CODE, resultCode, data); // OMG...
                if (scanResult != null) {
                    // handle scan result
                    Log.d(TAG, "scan: "+scanResult.getContents());
                    button.setText(scanResult.getContents());
                    return;
                }
                Log.d(TAG, "scan: no scan");
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public ScanFragment() {}

    private void scan() {
        Log.d(TAG, "scan: start");

        IntentIntegrator integrator = new IntentIntegrator(getActivity()) //;

                // XXX see https://github.com/zxing/zxing/issues/291#issuecomment-70174215
        {

            @Override
            protected void startActivityForResult(Intent intent, int code) {
                ScanFragment.this.startActivityForResult(intent, QR_SCANNER_REQUEST_CODE); // REQUEST_CODE override
            }
        };

        integrator.initiateScan();
    }
}
