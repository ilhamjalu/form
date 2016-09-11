package id.sch.smktelkom_mlg.xirpl2011tugas01.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNomor;
    //  RadioButton rbLK,rbPR;
    RadioGroup rgLR;
    Spinner spPaket;
    TextView tvHasil;
    Button bOK;
    CheckBox cbTM, cbYN, cbAF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        spPaket = (Spinner) findViewById(R.id.spinnerPaket);
        tvHasil = (TextView) findViewById(R.id.Hasil);
//        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
//      rbPR = (RadioButton) findViewById(R.id.radioButtonPR);
        rgLR = (RadioGroup) findViewById(R.id.radioGroupLR);
        bOK = (Button) findViewById(R.id.OK);
        cbTM = (CheckBox) findViewById(R.id.checkBoxTM);
        cbYN = (CheckBox) findViewById(R.id.checkBoxYN);
        cbAF = (CheckBox) findViewById(R.id.checkBoxAF);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
        int nTrip;
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();
        String hasil = null;
        String trip = "\nPerjalanan ke  ";
        int startlen = trip.length();

        if (cbTM.isChecked()) trip += cbTM.getText() + "\n";
        if (cbYN.isChecked()) trip += cbYN.getText() + "\n";
        if (cbAF.isChecked()) trip += cbAF.getText() + "\n";
        if (trip.length() == startlen) trip += "Tidak ada Pada Pilihan";
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum di Isi");
        } else {
            etNama.setError(null);
        }

        if (nomor.isEmpty()) {
            etNomor.setError("Isi Nomor Identitas");
        } else if (nomor.length() < 8) {
            etNomor.setError("Minimal 8 Angka");
        } else {
            etNomor.setError(null);
        }
        if (rgLR.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgLR.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
//        if(rbLK.isChecked()){
//            hasil = rbLK.getText().toString();
//        }
//        else if(rbPR.isChecked()){
//            hasil = rbPR.getText().toString();
//        }
        if (hasil == null) {
            tvHasil.setText("Apa Jenis Kelamin Anda ?");
        } else {
            tvHasil.setText("\nJenis Kelamin      : " + hasil);
        }

        tvHasil.setText("Nama           : " + nama + "\nNomor Identitas     : " + nomor + "\nJenis Kelamin    :" + "\nTransportasi yang di Pilih " + spPaket.getSelectedItem().toString());
    }
}
