package droidmentor.tabwithviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

public class RaitingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting);

        final SmileRating smileRating = (SmileRating)findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                // reselected is false when user selects different smiley that previously selected one
                // true when the same smiley is selected.
                // Except if it first time, then the value will be false.
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(RaitingActivity.this,"bad",Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(RaitingActivity.this,"good",Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(RaitingActivity.this,"great",Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(RaitingActivity.this,"ok",Toast.LENGTH_LONG).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(RaitingActivity.this,"awesom",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

            }
        });

        int level = smileRating.getRating();
    }
}
