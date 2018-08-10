package info.androidhive.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MovieAddActivity extends AppCompatActivity {


    private EditText txtTitle;
    private EditText txtYear;
    private Spinner cmbGender;
    private Button btnAdd;

    private List<String> genderList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_add);

        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtYear = (EditText) findViewById(R.id.txtYear);
        cmbGender = (Spinner) findViewById(R.id.cmbGender);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setEnabled(false);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertMovie();
            }
        });

        txtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0 && txtYear.getText().length() > 0){
                    btnAdd.setEnabled(true);
                }else btnAdd.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0 && txtTitle.getText().length() > 0){
                    btnAdd.setEnabled(true);
                }else btnAdd.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        prepareGenderList();

    }

    private void insertMovie() {
        Movie movie = new Movie();
        movie.setGenre(cmbGender.getSelectedItem().toString());
        movie.setTitle(txtTitle.getText().toString());
        movie.setYear(txtYear.getText().toString());
        DataMovie.addMovie(movie);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    private void prepareGenderList(){

        genderList =  new ArrayList<String>();
        genderList.add("SYFY");
        genderList.add("Action");

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbGender.setAdapter(adapter);
    }
}
