package sam.limo.oopandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText firstNameEditText, middleNameEditText,lastNameEditText;
	TextView fullNameTextView,revNameTextView;
	Person personObject;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	

//		For Button Show Activity
	public void Show(View aView) {
			try {
				String fullName,revName;
				Person personObject = new Person();
				
				
				//	Declare ID's
			    firstNameEditText = (EditText) findViewById(R.id.EditTextFirstName);
			   	middleNameEditText = (EditText) findViewById(R.id.EditTextMiddleName);
		    	lastNameEditText = (EditText) findViewById(R.id.EditTextLastName);
			    	
		    	fullNameTextView = (TextView) findViewById(R.id.fullname);
		    	revNameTextView = (TextView) findViewById(R.id.reversename);
		    	
		    	
		    	//	Assigning EditText to Class's Object 
		    	personObject.firstName = firstNameEditText.getText().toString();
		    	personObject.middleName = middleNameEditText.getText().toString();
			   	personObject.lastName = lastNameEditText.getText().toString();
			   	
			   	//	Getting String from object & assign to another String Variable
			   	fullName = personObject.getFullName();
			   	revName = personObject.getReverseName();
		    	
			   	//	Set the Text View by assigning String
		    	fullNameTextView.setText(fullName);
		    	revNameTextView.setText(revName);
				
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
			}
			

	}

	
//	For Button Next Activity
	public void Next(View aView) {
		try {
			Intent i = new Intent(MainActivity.this, SecondActivity.class);
			startActivity(i);			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
		}finally{
			finish();			
		}	
		
			
	}
	
}
