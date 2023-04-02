package space.rcmd.sshdeeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected Uri requested;
    private static final String STATE_SELECTED_URI = "selectedUri";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        if (state == null) {
            requested = getIntent().getData();
        } else {
            String uri = state.getString(STATE_SELECTED_URI);
            if (uri != null) {
                requested = Uri.parse(uri);
            }
        }

        if(requested != null){
            Intent intent = new Intent();
            intent.setAction("space.rcmd.sshforwarder.URL");
            intent.putExtra("space.rcmd.data.url", requested.toString());
            sendBroadcast(intent);
            finish();
        }

    }
}