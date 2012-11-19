package demo.vicshady.fvicshady;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class MainActivity extends Activity {

	EditText fusername,fpassword;
	Button flogin , fpost;
	private static String APP_ID = "402300436449184";
	private Facebook facebook=new Facebook(APP_ID);
    private AsyncFacebookRunner mAsyncRunner;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        fusername=(EditText)findViewById(R.id.fbusername);
        fpassword=(EditText)findViewById(R.id.fbpassword);
        flogin=(Button)findViewById(R.id.fblogin);
        fpost=(Button)findViewById(R.id.ffbpost);
        mAsyncRunner=new AsyncFacebookRunner(facebook);
        
        flogin.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 loginToFacebook();	
			}
		});
        
        fpost.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			postToFacebook();	
			}
		});
        
    }
	
	@SuppressWarnings("deprecation")
	protected void loginToFacebook() {
		// TODO Auto-generated method stub
	
		facebook.authorize(this,new DialogListener() {
			
			public void onFacebookError(final FacebookError e) {
				// TODO Auto-generated method stub
				
			}
			
			public void onError(final DialogError e) {
				// TODO Auto-generated method stub
				
			}
			
			public void onComplete(final Bundle values) {
				// TODO Auto-generated method stub
			flogin.setEnabled(false);
			fpost.setVisibility(1);
			}
			
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	protected void postToFacebook()
	{
		facebook.dialog(this, "feed", new DialogListener() {
			
			public void onFacebookError(FacebookError e) {
				// TODO Auto-generated method stub
				
			}
			
			public void onError(DialogError e) {
				// TODO Auto-generated method stub
				
			}
			
			public void onComplete(Bundle values) {
				// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "posted", Toast.LENGTH_SHORT).show();	
			}
			
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		checkState();
		
    }
	

 public void buttonEnable()
 {
	 boolean t=((fusername.getText().length()> 0) && (fpassword.getText().length()>0));
	 if(t)
		{
		 flogin.setVisibility(1);
		}
 }
  
   public void checkState()
   {
	   fpassword.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				buttonEnable();
			}
		});
   }
    
}