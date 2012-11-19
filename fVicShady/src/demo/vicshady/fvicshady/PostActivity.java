package demo.vicshady.fvicshady;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends Activity {
	
	EditText status;
	Button fpost;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.post);
		status=(EditText)findViewById(R.id.fbstatus);
		fpost=(Button)findViewById(R.id.fbpost);
		
		fpost.setVisibility(1);
		fpost.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	facebook.dialog(getApplicationContext(), "feed", new PostDialogListener());
			}
		});
		
	}
	

}
