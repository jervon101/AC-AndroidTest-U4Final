package nyc.c4q.androidtest_unit4final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by justiceo on 1/9/18.
 */

public class InfoFragment extends Fragment {

    Button button;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.info_fragment, container, false);
        button=(Button) v.findViewById(R.id.button);
        textView = (TextView) v.findViewById(R.id.more_textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textView.getVisibility()==View.GONE){
                    textView.setVisibility(View.VISIBLE);
                    button.setText("Hide/Less");
                } else if (textView.getVisibility()!=View.GONE) {
                    textView.setVisibility(View.GONE);
                    button.setText("More");
                }
            }
        });


        return v;
    }
}
