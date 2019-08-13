package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    enum story_state {
        T1_Story,
        T2_Story,
        T3_Story,
        T4_End,
        T5_End,
        T6_End,
    };

    enum push_button {
        Top,
        Bottom
    };

    // TODO: Steps 4 & 8 - Declare member variables here:
    public TextView tvStory;
    public Button bTop;
    public Button bBottom;

    private story_state state = story_state.T1_Story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        tvStory = (TextView)findViewById(R.id.storyTextView);
        bTop = (Button)findViewById(R.id.buttonTop);
        bBottom = (Button)findViewById(R.id.buttonBottom);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        View.OnClickListener topListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Top button pressed.");
                state = transition(push_button.Top);
            }
        };

        bTop.setOnClickListener(topListener);

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        View.OnClickListener bottomListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Bottom button pressed.");
                state = transition(push_button.Bottom);
            }
        };

        bBottom.setOnClickListener(bottomListener);

    }

    private story_state transition(push_button button) {
        story_state retval = state;
        switch (state) {
            case T1_Story:
                if (button == push_button.Top) {
                    retval = story_state.T3_Story;
                    // Change text
                    tvStory.setText(R.string.T3_Story);
                    bTop.setText(R.string.T3_Ans1);
                    bBottom.setText(R.string.T3_Ans2);
                } else {
                    retval = story_state.T2_Story;
                    // Change text
                    tvStory.setText(R.string.T2_Story);
                    bTop.setText(R.string.T2_Ans1);
                    bBottom.setText(R.string.T2_Ans2);
                }
                break;
            case T2_Story:
                if (button == push_button.Top) {
                    retval = story_state.T3_Story;
                    // Change text
                    tvStory.setText(R.string.T3_Story);
                    bTop.setText(R.string.T3_Ans1);
                    bBottom.setText(R.string.T3_Ans2);
                } else {
                    retval = story_state.T4_End;
                    // Change text
                    tvStory.setText(R.string.T4_End);
                    bTop.setVisibility(View.GONE);
                    bBottom.setVisibility(View.GONE);
                }
                break;
            case T3_Story:
                if (button == push_button.Top) {
                    retval = story_state.T6_End;
                    // Change text
                    tvStory.setText(R.string.T6_End);
                    bTop.setVisibility(View.GONE);
                    bBottom.setVisibility(View.GONE);
                } else {
                    retval = story_state.T5_End;
                    tvStory.setText(R.string.T5_End);
                    bTop.setVisibility(View.GONE);
                    bBottom.setVisibility(View.GONE);
                }
                break;
            case T4_End:
                break;
            case T5_End:
                break;
            case T6_End:
                break;
        }
        return retval;
    }
}
