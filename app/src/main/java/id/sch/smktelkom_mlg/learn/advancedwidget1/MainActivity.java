package id.sch.smktelkom_mlg.learn.advancedwidget1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spjumlah;
    LinearLayout llAnak;
    TextView tvhasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spjumlah = (Spinner) findViewById(R.id.spinnerjumlahanak);
        Integer[] arJumlah = new Integer[10];
        for (int i = 0; i < 10; i++) {

            arJumlah[i] = i + 1;

        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arJumlah);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjumlah.setAdapter(adapter);

        llAnak = (LinearLayout) findViewById(R.id.linearlayoutanak);
        tvhasil = (TextView) findViewById(R.id.TextViewHasil);

        findViewById(R.id.proses).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doproses();
            }


        });

        spjumlah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                addedittext((int) spjumlah.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void addedittext(int jumlah) {

        llAnak.removeAllViews();
        for (int i = 1; i <= jumlah; i++) {

            View v = LayoutInflater.from(this).inflate(R.layout.layout_anak, llAnak, false);
            v.setTag("Anak" + i);
            llAnak.addView(v);

        }

    }


    private void doproses() {

        int jumlah = (int) spjumlah.getSelectedItem();
        String hasil = "";
        for (int i = 1; i <= jumlah; i++) {

            LinearLayout llnow = (LinearLayout) llAnak.findViewWithTag("Anak" + i);

            EditText etNama = (EditText) llnow.findViewById(R.id.editTextNama);
            EditText etUmur = (EditText) llnow.findViewById(R.id.editTextUmur);

            String nama = etNama.getText().toString().trim();
            String umur = etUmur.getText().toString();

            if (umur.isEmpty())
                umur = "0";
            if (!nama.isEmpty())
                hasil += "Anak ke-" + i + " Nama = " + nama + " Umur = " + umur + "tahun\n";

            tvhasil.setText(hasil);

        }


    }
}
