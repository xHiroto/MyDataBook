package sg.edu.rp.c346.id19045784.mydatabook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class VaccinationFragment extends Fragment {

        Button editBtn;
        TextView tvVaccination;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);
        editBtn = view.findViewById(R.id.btnVacEdit);
        tvVaccination = view.findViewById(R.id.tvVacData);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());


                LinearLayout ll_alert_layout = new LinearLayout(getActivity());
                ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
                final EditText ed_input = new EditText(getActivity());
                ll_alert_layout.addView(ed_input);

                myBuilder.setTitle("Edit Vaccination");
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
                        tvVaccination.setText(text);
                    }
                });

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        return view;
    }
}