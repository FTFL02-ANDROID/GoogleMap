package sam.limo.oopandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	EditText basicEditText;
	EditText houseEditText;
	EditText medicalEditText;
	
	TextView medicalTextView;
	TextView houseTextView;
	TextView totalTextView;
	
	Salary calculateSalary;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	}

	public void Calculate(View aView) {
		try {
			calculateSalary = new Salary();
			
			basicEditText = (EditText) findViewById(R.id.editTextBasicSalary);
			houseEditText = (EditText) findViewById(R.id.editTextPercentageHouse);
			medicalEditText = (EditText) findViewById(R.id.editTextPercentageMedical);
			
			medicalTextView = (TextView) findViewById(R.id.textViewMedical);
			houseTextView = (TextView) findViewById(R.id.textViewHouseRent);
			totalTextView = (TextView) findViewById(R.id.TextViewSalary);
			
			calculateSalary = new Salary();
			calculateSalary.setBasic(
					Double.parseDouble(basicEditText.getText().toString()));
			calculateSalary.setPercentHouse(
					Double.parseDouble(houseEditText.getText().toString()));
			calculateSalary.setPercentMedical(
					Double.parseDouble(medicalEditText.getText().toString()));
		
			medicalTextView.setText(""+calculateSalary.getMedicalAmount());
			houseTextView.setText(""+calculateSalary.getHouseRent());
			totalTextView.setText(""+calculateSalary.getTotalSalary());		
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Invalid Operation!", Toast.LENGTH_SHORT).show();
		}
	
	}
	
//	For Button Back Activity	
	public void Back(View aView) {
		try {
			Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
			startActivity(i);			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
		}finally{
			finish();			
		}
	
	}
}
