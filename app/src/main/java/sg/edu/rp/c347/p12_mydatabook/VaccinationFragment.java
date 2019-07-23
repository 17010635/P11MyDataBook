package sg.edu.rp.c347.p12_mydatabook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VaccinationFragment extends Fragment {

    Button btnBio;
    TextView tv;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vaccinationfragment, container, false);

        btnBio = view.findViewById(R.id.btnFragVac);
        tv = view.findViewById(R.id.textView);

        SharedPreferences pref1 = getActivity().getPreferences(Context.MODE_PRIVATE);
        if(pref1.contains("vaccination")){
            String bio = pref1.getString("vaccination", "");
            tv.setText(bio);
        }

        btnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(VaccinationFragment.this.getContext());

                LayoutInflater inflate = VaccinationFragment.this.getLayoutInflater();
                View dialogView = inflate.inflate(R.layout.alert_label_editor, null);
                alert.setView(dialogView);
                editText = (EditText) dialogView.findViewById(R.id.label_field);
                editText.setText(tv.getText());

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        tv.setText(editText.getText());

                        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("vaccination", editText.getText().toString());
                        edit.commit();
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                alert.setTitle("Edit Vaccination");

                AlertDialog dialog = alert.create();
                dialog.show();


            }
        });

        return view;
    }
}
