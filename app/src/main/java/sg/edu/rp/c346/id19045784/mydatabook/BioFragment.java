package sg.edu.rp.c346.id19045784.mydatabook;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class BioFragment extends Fragment {

    Button btnEdit;
    TextView tvBio;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);
        btnEdit = view.findViewById(R.id.btnEdit);
        tvBio = view.findViewById(R.id.tvBioData);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());


                LinearLayout ll_alert_layout = new LinearLayout(getActivity());
                ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
                final EditText ed_input = new EditText(getActivity());
                ll_alert_layout.addView(ed_input);

                myBuilder.setTitle("Edit Bio");
                myBuilder.setView(ll_alert_layout);
                myBuilder.setCancelable(true);

//                EditText myEditText = new EditText(getActivity()); // Pass it an Activity or Context
//                // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
//                myEditText.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
//                myBuilder.setMessage(String.valueOf(myEditText));

                myBuilder.setNeutralButton("Cancel", null);
//                AlertDialog myDialog = myBuilder.create();
//                myDialog.show();

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String text = ed_input.getText().toString();
                        tvBio.setText(text);
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        return view;
    }
    public void onPause(){
        super.onPause();
        String text = tvBio.getText().toString();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor prefEdit = pref.edit();

        prefEdit.putString("textBio", text);
        prefEdit.commit();
    }
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String text = prefs.getString("textBio", "");
        tvBio.setText(text);
    }

}