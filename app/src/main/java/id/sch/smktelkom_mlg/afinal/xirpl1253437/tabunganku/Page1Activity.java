package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Page1Activity extends AppCompatActivity implements View.OnClickListener {

    Button buttonisiform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        buttonisiform = findViewById(R.id.buttonIsiForm);

        buttonisiform.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonisiform) {
            pindahKeForm();
        }


    }

    private void pindahKeForm() {
        startActivity(new Intent(Page1Activity.this, IsiRencana.class));
    }
}
