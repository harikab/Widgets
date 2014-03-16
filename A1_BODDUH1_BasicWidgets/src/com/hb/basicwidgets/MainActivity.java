//Harika
package com.hb.basicwidgets;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	String pizzaSize="";
	int total=0;
	int topping_cost=1;
	int psmall_cost=5;
	int pmedium_cost=7;
	int plarge_cost=10;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pizzaText = new TextView(this);
        pizzaText = (TextView)findViewById(R.id.pizzaText); 
        pizzaText.setText("Select Pizza Size");
        Log.d("Pizza onCreate",pizzaText.getText().toString());
        
        
        RadioGroup group=(RadioGroup) findViewById(R.id.psradioGroup);

        group.setOnCheckedChangeListener(new OnCheckedChangeListener() 
           {

            public void onCheckedChanged(RadioGroup group, int checkedId) 
               {
            	                
                switch(checkedId) {
                    case R.id.pizzaSmallRadio:
                        
                            pizzaSize="Small";
                        break;
                    case R.id.pizzaMediumRadio:
                        
                            pizzaSize="Medium";
                        break;
                    case R.id.pizzaLargeRadio:
                        
                            pizzaSize="Large";
                        break;
                }
              
             }
        });
        
        
        Button bCalculate=(Button) findViewById(R.id.bCalculate);
        bCalculate.setOnClickListener(new OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                
            	if("Small".equalsIgnoreCase(pizzaSize))
            		total = total+psmall_cost;
            	if("Medium".equalsIgnoreCase(pizzaSize))
            		total = total+pmedium_cost;
            	if("Large".equalsIgnoreCase(pizzaSize))
            		total = total+plarge_cost;
            CheckBox ptop1 = (CheckBox) findViewById(R.id.ptop1);
            CheckBox ptop2 = (CheckBox) findViewById(R.id.ptop2);
            CheckBox ptop3 = (CheckBox) findViewById(R.id.ptop3);
            CheckBox ptop4 = (CheckBox) findViewById(R.id.ptop4);
                if(ptop1.isChecked())
                	total = total + topping_cost;
                if(ptop2.isChecked())
                	total = total + topping_cost;
                if(ptop3.isChecked())
                	total = total + topping_cost;
                if(ptop4.isChecked())
                	total = total + topping_cost;
                EditText pquantity = (EditText) findViewById(R.id.etquantity);
                int quantity = Integer.parseInt(pquantity.getText().toString());
                total = total * quantity;
                TextView totalDisplay = (TextView)findViewById(R.id.totalDisplay); 
                totalDisplay.setText("$"+String.valueOf(total));
                total=0;
            }
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
