package sg.edu.rp.c346.id19045784.mydatabook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class AnniversaryFragment extends Fragment {

    Button btnEdit;
    TextView tvAnni;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);
        btnEdit = view.findViewById(R.id.btnEditAnni);
        tvAnni = view.findViewById(R.id.tvAnni);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());


                LinearLayout ll_alert_layout = new LinearLayout(getActivity());
                ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
                final EditText ed_input = new EditText(getActivity());
                ed_input.setText(tvAnni.getText().toString());
                ll_alert_layout.addView(ed_input);

                myBuilder.setTitle("Edit Anniversary");
                myBuilder.setView(ll_alert_layout);
                myBuilder.setCancelable(true);


                myBuilder.setNeutralButton("Cancel", null);

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String text = ed_input.getText().toString();
                        tvAnni.setText(text);
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        FloatingActionButton fab = view.findViewById(R.id.fabAnni);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action




            }
        });


        return view;
    }

    public void onPause(){
        super.onPause();
        String text = tvAnni.getText().toString();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor prefEdit = pref.edit();

        prefEdit.putString("textAnni", text);
        prefEdit.commit();
    }
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String text = prefs.getString("textAnni", "");
        tvAnni.setText(text);
    }

}