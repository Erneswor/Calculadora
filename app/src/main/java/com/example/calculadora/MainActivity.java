package com.example.calculadora;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    /*
     * Comentario de linea
     * Declara los elementos
     * */


    private TextView textviewres;

    private ImageButton btn_ac;
    private ImageButton btn_porcentaje;
    private ImageButton btn_delete;
    private ImageButton btn_dividir;

    private ImageButton btn_siete;
    private ImageButton btn_ocho;
    private ImageButton btn_nueve;
    private ImageButton btn_multiplicar;

    private ImageButton btn_cuatro;
    private ImageButton btn_cinco;
    private ImageButton btn_seis;
    private ImageButton btn_resta;

    private ImageButton btn_uno;
    private ImageButton btn_dos;
    private ImageButton btn_tres;
    private ImageButton btn_suma;

    private ImageButton btn_doble_cero;
    private ImageButton btn_cero;
    private ImageButton btn_punto;
    private ImageButton btn_igual;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//declaracion de los botones de cada uno
        textviewres=findViewById(R.id.textviewres);

        btn_ac = findViewById(R.id.btn_ac);
        btn_porcentaje = findViewById(R.id.btn_porcentaje);
        btn_delete = findViewById(R.id.btn_delete);
        btn_dividir = findViewById(R.id.btn_dividir);

        btn_siete = findViewById(R.id.btn_siete);
        btn_ocho = findViewById(R.id.btn_ocho);
        btn_nueve = findViewById(R.id.btn_nueve);
        btn_multiplicar = findViewById(R.id.btn_multiplicar);

        btn_cuatro = findViewById(R.id.btn_cuatro);
        btn_cinco = findViewById(R.id.btn_cinco);
        btn_seis = findViewById(R.id.btn_seis);
        btn_resta = findViewById(R.id.btn_resta);

        btn_uno = findViewById(R.id.btn_uno);
        btn_dos = findViewById(R.id.btn_dos);
        btn_tres = findViewById(R.id.btn_tres);
        btn_suma = findViewById(R.id.btn_suma);

        btn_doble_cero = findViewById(R.id.btn_doble_cero);
        btn_cero = findViewById(R.id.btn_cero);
        btn_punto = findViewById(R.id.btn_punto);
        btn_igual = findViewById(R.id.btn_igual);

//se mandan a llamar los metodos de cada uno
        btn_uno.setOnClickListener(v -> getuno());
        btn_dos.setOnClickListener(v -> getdos());
        btn_tres.setOnClickListener(v -> gettres());
        btn_cuatro.setOnClickListener(v -> getcuatro());
        btn_cinco.setOnClickListener(v -> getcinco());
        btn_seis.setOnClickListener(v -> getseis());
        btn_siete.setOnClickListener(v -> getsiete());
        btn_ocho.setOnClickListener(v -> getocho());
        btn_nueve.setOnClickListener(v -> getnueve());
        btn_cero.setOnClickListener(v -> getcero());
        btn_doble_cero.setOnClickListener(v -> getdoblecero());
        btn_punto.setOnClickListener(v -> getpunto());
        btn_suma.setOnClickListener(v -> getsuma());
        btn_resta.setOnClickListener(v -> getresta());
        btn_multiplicar.setOnClickListener(v -> getmulti());
        btn_dividir.setOnClickListener(v -> getdiv());
        btn_porcentaje.setOnClickListener(v-> getporcentaje());
        btn_ac.setOnClickListener(v->getAC());
        btn_delete.setOnClickListener(v-> getdelete());

        btn_igual.setOnClickListener(V->calcular());

    }

    public String getAC(){
        textviewres.setText("");
        return "";
    }

    public String getuno(){
        textviewres.setText(textviewres.getText()+"1");
        return "";
    }

    public String getdos(){
        textviewres.setText(textviewres.getText()+"2");
        return "";
    }

    public String gettres(){
        textviewres.setText(textviewres.getText()+"3");
        return "";
    }

    public String getcuatro(){
        textviewres.setText(textviewres.getText()+"4");
        return "";
    }

    public String getcinco(){
        textviewres.setText(textviewres.getText()+"5");
        return "";
    }

    public String getseis(){
        textviewres.setText(textviewres.getText()+"6");
        return "";
    }

    public String getsiete(){
        textviewres.setText(textviewres.getText()+"7");
        return "";
    }

    public String getocho(){
        textviewres.setText(textviewres.getText()+"8");
        return "";
    }

    public String getnueve(){
        textviewres.setText(textviewres.getText()+"9");
        return "";
    }

    public String getcero(){
        textviewres.setText(textviewres.getText()+"0");
        return "";
    }

    public String getdoblecero(){
        textviewres.setText(textviewres.getText()+"00");
        return "";
    }

    public String getsuma(){
        textviewres.setText(textviewres.getText()+"+");
        return "";
    }

    public String getresta(){
        textviewres.setText(textviewres.getText()+"-");
        return "";
    }

    public String getmulti(){
        textviewres.setText(textviewres.getText()+"*");
        return "";
    }

    public String getdiv(){
        textviewres.setText(textviewres.getText()+"/");
        return "";
    }

    public String getpunto(){
        textviewres.setText(textviewres.getText()+".");
        return "";
    }

    public String getporcentaje(){
        textviewres.setText(textviewres.getText()+"%");
        return "";
    }

    public void getdelete() {
        String textoActual = textviewres.getText().toString();

        if (textoActual.length() > 1) {
            // Elimina el último carácter
            textoActual = textoActual.substring(0, textoActual.length() - 1);
            textviewres.setText(textoActual);
        } else {
            // Si solo queda un dígito o está vacío, poner "0"
            textviewres.setText("");
        }
    }


    public void calcular() {
        try {
            String operacion = textviewres.getText().toString();
            double resultado = evaluarExpresion(operacion);
            textviewres.setText(String.valueOf(resultado));
        } catch (Exception e) {
            textviewres.setText("Error");
        }
    }



    private double evaluarExpresion(String expresion) {
        try {

            // Creamos una lista de token de numero y signos
            java.util.List<Double> numeros = new java.util.ArrayList<>();
            java.util.List<Character> operadores = new java.util.ArrayList<>();

            StringBuilder numero = new StringBuilder();

            for (int i = 0; i < expresion.length(); i++) {
                char c = expresion.charAt(i);

                if (Character.isDigit(c) || c == '.') {
                    numero.append(c);
                } else {
                    if (numero.length() > 0) {
                        numeros.add(Double.parseDouble(numero.toString()));
                        numero.setLength(0);
                    }
                    operadores.add(c);
                }
            }

            if (numero.length() > 0) {
                numeros.add(Double.parseDouble(numero.toString()));
            }

            // Revisamos multiplicación y división
            for (int i = 0; i < operadores.size(); i++) {
                char op = operadores.get(i);
                if (op == '*' || op == '/') {
                    double a = numeros.get(i);
                    double b = numeros.get(i + 1);
                    double resultado = (op == '*') ? a * b : a / b;

                    numeros.set(i, resultado);
                    numeros.remove(i + 1);
                    operadores.remove(i);
                    i--;
                }
            }

            // Revisamos suma y resta
            double total = numeros.get(0);
            for (int i = 0; i < operadores.size(); i++) {
                char op = operadores.get(i);
                double b = numeros.get(i + 1);
                if (op == '+') {
                    total += b;
                } else if (op == '-') {
                    total -= b;
                }
            }


            for (int i = 0; i < operadores.size(); i++) {
                char op = operadores.get(i);
                if (op == '%') {
                    double a = numeros.get(i);
                    double resultado = a / 100.0;

                    numeros.set(i, resultado);
                    numeros.remove(i + 1);
                    operadores.remove(i);
                    i--;
                }
            }


            return total;
        } catch (Exception e) {
            return 0;
        }
    }

    /*
    public void sumar(View view){
        float operacion=Float.parseFloat(editTextNumberA.getText().toString()) +
              Float.parseFloat(editTextNumberB.getText().toString());
        textviewres.setText(operacion+"");
    }

    public void Resta(View view){
        float operacion=Float.parseFloat(editTextNumberA.getText().toString()) -
                Float.parseFloat(editTextNumberB.getText().toString());
        textviewres.setText(operacion+"");
    }

    public void Multiplicar(View view){
        float operacion=Float.parseFloat(editTextNumberA.getText().toString()) *
                Float.parseFloat(editTextNumberB.getText().toString());
        textviewres.setText(operacion+"");
    }

    public void Dividir(View view){
        float operacion=Float.parseFloat(editTextNumberA.getText().toString()) /
                Float.parseFloat(editTextNumberB.getText().toString());
        textviewres.setText(operacion+"");
    }


     */
}