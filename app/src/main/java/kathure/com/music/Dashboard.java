package kathure.com.music;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by kathure on 13/07/16.
 */
public class Dashboard extends AppCompatActivity {

    ProgressBar myprogressBar;
    ProgressBar theprogressBar;
    TextView progressingTextView;
    TextView progressiveTextView;
    Handler progressHandler = new Handler();
    Handler progressHandlerr = new Handler();

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        theprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressiveTextView = (TextView) findViewById(R.id.progress_circle_text);

        new Thread(new Runnable() {
            public void run() {
                while (i < 41) {
                    i += 2;
                    progressHandlerr.post(new Runnable() {
                        public void run() {
                            theprogressBar.setProgress(i);
                            progressiveTextView.setText("" + i );
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        myprogressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressingTextView = (TextView) findViewById(R.id.progress_circle_text1);

        new Thread(new Runnable() {
            public void run() {
                while (i < 17) {
                    i += 2;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            myprogressBar.setProgress(i);
                            progressingTextView.setText("" + i );
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
