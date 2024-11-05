package br.com.aula.aninhaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarPeso, seekBarAltura;
    private TextView tvPeso, tvAltura, tvResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarPeso = findViewById(R.id.seekBarPeso);
        seekBarAltura = findViewById(R.id.seekBarAltura);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        seekBarPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPeso.setText("Peso: " + progress + " kg");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        seekBarAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAltura.setText("Altura: " + progress + " cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int peso = seekBarPeso.getProgress();
                int altura = seekBarAltura.getProgress();

                if (altura > 0) {
                    double alturaEmMetros = altura / 100.0;
                    double imc = peso / (alturaEmMetros * alturaEmMetros);
                    tvResultado.setText(String.format("IMC: %.2f", imc));
                } else {
                    tvResultado.setText("Altura deve ser maior que 0.");
                }
            }
        });
    }
}

