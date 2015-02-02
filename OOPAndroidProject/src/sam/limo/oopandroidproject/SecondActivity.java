package sam.limo.oopandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	EditText numberEditText;
	EditText customerNameEditText;
	EditText amountEditText;
	
	TextView informationTextView;
	
	Account anAccount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	
	public void Create(View aView) {
		numberEditText = (EditText) findViewById(R.id.editTextNumber);
		customerNameEditText = (EditText)findViewById(R.id.editTextName);
		
		anAccount = new Account();
		anAccount.name = customerNameEditText.getText().toString();
		anAccount.number = numberEditText.getText().toString();
	}
	
	public void Deposit(View aView) {
		try {
			amountEditText = (EditText) findViewById(R.id.amount);
			double amount = Double.parseDouble(amountEditText.getText().toString());
			anAccount.deposit(amount);
			Toast.makeText(getApplicationContext(), "Successfully Deposited", Toast.LENGTH_SHORT).show();
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Invalid Operation!", Toast.LENGTH_SHORT).show();
		}
	}

	public void Withdraw(View aView) {
		try {
			amountEditText = (EditText) findViewById(R.id.amount);
			double amount = Double.parseDouble(amountEditText.getText().toString());
			anAccount.withdraw(amount);
			Toast.makeText(getApplicationContext(), "Successfully Withdrawed", Toast.LENGTH_SHORT).show();
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Invalid Operation!", Toast.LENGTH_SHORT).show();
		}
		
		
	}
	
	public void Show(View aView) {
		try {
			informationTextView = (TextView) findViewById(R.id.textViewShowInformation);
			String info = anAccount.number + " " + anAccount.name + " balance: " + anAccount.balance;
			informationTextView.setText(info);
			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Invalid Operation!", Toast.LENGTH_SHORT).show();
		}
		
	}

	
//	For Button Next Activity
	public void Next(View aView) {
		try {
			Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
			startActivity(i);			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
		}finally{
			finish();			
		}
		
	}
	
//	For Button Back Activity	
	public void Back(View aView) {
		try {
			Intent i = new Intent(SecondActivity.this, MainActivity.class);
			startActivity(i);			
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
		}finally{
			finish();			
		}
		
	}
	
	
}
