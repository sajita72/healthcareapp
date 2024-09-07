package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.Date;


public class doctordetail extends AppCompatActivity {
Button btn;
    TextView textView,textView1,textView2,textView3,textView4;
    String date;
    CalendarView calendarView;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctordetail);

            textView = findViewById(R.id.tvProductName);
            textView1 = findViewById(R.id.tvProductSpeciality);
            textView2= findViewById(R.id.tvtext);
            textView3 = findViewById(R.id.tvprofile);
            calendarView = findViewById(R.id.calendar);
            btn = findViewById(R.id.btnappo);




            calendarView = findViewById(R.id.calendar);


            Intent intent = getIntent();
            textView.setText(intent.getStringExtra("name"));
            textView1.setText(intent.getStringExtra("specialist"));
            textView3.setText(intent.getStringExtra("degree"));





        Spinner spinner =findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String string= adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("10:00");
        arrayList.add("14:00");
        arrayList.add("16:00");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);



               calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    date = year + "-" + (month + 1) + "-" + dayOfMonth;
//                    Toast.makeText(doctordetail.this, "Selected Date: " + date , Toast.LENGTH_SHORT).show();

                }
            });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String id = intent.getStringExtra("id");
                String name = intent.getStringExtra("name");
                String specialist = intent.getStringExtra("specialist");
                String time = spinner.getSelectedItem().toString();
                Intent intent1 = new Intent(doctordetail.this, bookappo.class);
                intent1.putExtra("id",id);
                intent1.putExtra("name",name);
                intent1.putExtra("specialist",specialist);
                intent1.putExtra("date",date);
                intent1.putExtra("time",time);

                startActivity(intent1);
            }
        });


        }
    }
