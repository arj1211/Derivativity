package com.derivativity.arjun.derivativity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.derivativity.arjun.derivativity.R;

public class MainActivity extends AppCompatActivity
{

    Button deriButton;
    TextView polyTextView, deriTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Polynomial poly = new Polynomial();
        deriButton = (Button) findViewById(R.id.button);
        polyTextView = (TextView) findViewById(R.id.polyText);
        deriTextView = (TextView) findViewById(R.id.derivText);

        deriButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Testing code:
//                deriTextView.setText( polyTextView.getText().toString()  ) ;

                poly.parsePolynomial(polyTextView.getText().toString().trim());
                poly.setTerms(poly.getDerivative());
                //System.out.println(poly.toString());
                deriTextView.setText(poly.toString());

            }
        });

    }
}
