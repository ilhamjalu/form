package id.sch.smktelkom_mlg.xirpl2011tugas01.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spPaket;
    TextView tvHasil;
    RadioButton rb, rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPaket = (Spinner) findViewById(R.id.spinnerPaket);
        tvHasil = (TextView) findViewById(R.id.Hasil);
        rb = (RadioButton) findViewById()
    }

    @Override
    public void onClick(View view) {
        doClick();
    }

    private void doClick() {
        tvHasil.setText("Transportasi yang di Pilih " + spPaket.getSelectedItem().toString());
    }
}
