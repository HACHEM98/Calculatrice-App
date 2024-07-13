package com.example.calculatriceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


     private Button btn0;
     private  Button btn1;
     private Button btn2;
     private Button btn3;
     private Button btn4;
     private Button btn5;
     private Button btn6;
     private  Button btn7;
     private Button btn8;
     private Button btn9;
     private Button activate;
     private  Button delete;
     private Button plus;
     private  Button moins;
     private  Button multip;
     private  Button div;
     private  Button dot;
     private Button egal;
     private TextView resultat;
     private TextView hist;

     String number=null;
     double firstNumber=0;
     double lastNumber;
     String status=null;
     Boolean operator;

     String history;
     String currentResult;
     boolean dott=true;
     boolean ACContr=true;
     Boolean btnEqualsControl=false;
     DecimalFormat d= new DecimalFormat("######.######");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.number0);
        btn1=findViewById(R.id.number1);
        btn2=findViewById(R.id.number2);
        btn3=findViewById(R.id.number3);
        btn4=findViewById(R.id.number4);
        btn5=findViewById(R.id.number5);
        btn6=findViewById(R.id.number6);
        btn7=findViewById(R.id.mul);
        btn8=findViewById(R.id.number8);
        btn9=findViewById(R.id.number9);
        activate=findViewById(R.id.ac);
        delete=findViewById(R.id.del);
        dot=findViewById(R.id.point);
        egal=findViewById(R.id.egal);
        resultat=findViewById(R.id.numberrrr);
        hist=findViewById(R.id.operationnnn);
        plus=findViewById(R.id.add);
        moins=findViewById(R.id.sous);
        div=findViewById(R.id.div);
        multip=findViewById(R.id.mult);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              numberClick("0");
            }
        });



        egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator){
                 if(status=="sum") {

                     plus();
                 }
                 else if(status=="minus") {
                     Minus();
                 }
                 else if (status=="multiplication") {
                     multiply();
                 }
                 else if (status=="division") {
                     divide();
                 }
                 else
                 {
                     firstNumber=Double.parseDouble(resultat.getText().toString());
                 }
                 operator=false;
                 btnEqualsControl=true;

                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dott) {

                    if (number == "null") {
                        number = ".0";
                    } else {
                        number = number + ".";
                    }
                }
                resultat.setText(number);
                dott=false;

            }});







        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        }));

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });





        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });



        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              number=null;
              status=null;
              resultat.setText("0");
              firstNumber=0;
              lastNumber=0;
              hist.setText("");
              dott=true;
              ACContr=true;
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ACContr) {
                    resultat.setText("0");
                } else {
                    number = number.substring(0, number.length() - 1);
                    if (number.length() == 0) {
                        delete.setClickable(false);
                    }
                    else if(number.contains(".")){dott=false;}
                    else {dott=true;}

                    resultat.setText(number);
                }
            }});
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history=hist.getText().toString();
                currentResult=resultat.getText().toString();
                hist.setText(history+currentResult+"+");

           if(operator){
               if(status=="multplication"){
                  multiply();
               }
               else if (status=="division"){
                   divide();
               }
               else if(status=="minus")
               {
                   Minus();
               }
               else {
                   plus();

               }
             status="sum";
               operator=false;
               number=null;

           }
            }
        });
       moins.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               history=hist.getText().toString();
               currentResult=resultat.getText().toString();
               hist.setText(history+currentResult+"-");

            if(operator){
               if(status=="sum")
               {plus();}
               else if(status=="multiplication"){multiply();}
               else if(status=="division"){divide();}
               else {
                   Minus();
               }

               status="minus";
               operator=false;
               number=null;
           }}
       });
       div.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              history=hist.getText().toString();
               currentResult=resultat.getText().toString();
               hist.setText(history+currentResult+"/");

               if(operator){
            if(status=="multiplication"){
                multiply();



            }
            else if(status=="sum"){
                plus();
            }
            else if (status=="minus"){
                Minus();
            }
            else {
                divide();
            }
            status="division";
            operator=false;
            number=null;
        }
           }
       });
       multip.setOnClickListener(new View.OnClickListener() {



           @Override
           public void onClick(View view) {
               history=hist.getText().toString();
               currentResult=resultat.getText().toString();
               hist.setText(history+currentResult+"*");
         if (operator){
             if(status=="division"){divide();}
             else if(status=="minus"){Minus();}
             else if(status=="sum"){plus();}
             else {

                 multiply();
             }
             status="multiplication";
             operator=false;
             number=null;

         }
           }
       });

    }

    public void numberClick(String view){
        if(number==null){
            number=view;
        }

        else if(btnEqualsControl) {
            firstNumber=0;
            lastNumber=0;
            number=view;
        }

        else
        {
         number=number+view;
        }
        resultat.setText(number);
        operator=true;
        ACContr=false;
        delete.setClickable(true);
        btnEqualsControl=false;
    }

    public void plus(){
        lastNumber=Double.parseDouble(resultat.getText().toString());;
         firstNumber=firstNumber+lastNumber;
         resultat.setText(d.format(firstNumber));
dott=true;
    }

    public void Minus (){

        if(firstNumber==0){
            firstNumber=Double.parseDouble(resultat.getText().toString());
        }
        else {
           lastNumber=Double.parseDouble(resultat.getText().toString());
           firstNumber=firstNumber-lastNumber;
           resultat.setText(d.format(firstNumber));
dott=true;
        }

    }

    public void multiply(){

        if (firstNumber==0)
        {
            firstNumber=1;
            lastNumber=Double.parseDouble(resultat.getText().toString());
            firstNumber=firstNumber*lastNumber;

        }
        else
        {
            lastNumber=Double.parseDouble(resultat.getText().toString());
            firstNumber=firstNumber*lastNumber;
        }
        resultat.setText(d.format(firstNumber));
        dott=true;
    }

    public void divide(){
        if(firstNumber==0){
            lastNumber=Double.parseDouble(resultat.getText().toString());
            firstNumber=lastNumber/1;
        }
        else{
            lastNumber=Double.parseDouble(resultat.getText().toString());
            firstNumber=firstNumber/lastNumber;
        }
  resultat.setText(d.format(firstNumber));
        dott=true;
    }

}
