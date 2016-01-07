package sidespell.tech.solarsystem.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import sidespell.tech.solarsystem.R;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    ImageView imageView;
    private TypedArray planetsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planetsImage = getResources().obtainTypedArray(R.array.img_planets);
        imageView = (ImageView)findViewById(R.id.imageView);
        spinner = (Spinner)findViewById(R.id.planets_spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(planetsImage.getResourceId(position,-1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}