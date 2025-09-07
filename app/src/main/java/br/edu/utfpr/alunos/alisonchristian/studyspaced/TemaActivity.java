package br.edu.utfpr.alunos.alisonchristian.studyspaced;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemaActivity extends AppCompatActivity {

    private EditText editTextTema;
    private CheckBox checkBoxTema;
    private RadioGroup radioGroupPlano;
    private Spinner spinnerMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema);

        radioGroupPlano = findViewById(R.id.RadioGroupPlano);
        editTextTema = findViewById(R.id.editTextTema);
        checkBoxTema = findViewById(R.id.checkBoxTema);
        spinnerMateria = findViewById(R.id.spinnerMateria);
    }

    public void limparTema(View view) {
        editTextTema.setText(null);
        editTextTema.requestFocus();
        checkBoxTema.setChecked(false);
        radioGroupPlano.clearCheck();
        spinnerMateria.setSelection(0);

        Toast.makeText(
                this,
                R.string.tema_limpo,
                Toast.LENGTH_LONG).show();

    }
    public void salvarTema(View view) {
        String tema = editTextTema.getText().toString();
        if (tema.isEmpty() || tema.trim().isEmpty()) {
            editTextTema.setText(null);
            editTextTema.requestFocus();
            editTextTema.setError(getString(R.string.hint_tema));
            Toast.makeText(
                    this,
                    R.string.preencha_corretamente,
                    Toast.LENGTH_LONG).show();
            return;
        }

        int spinnerId = spinnerMateria.getSelectedItemPosition();

        if (spinnerId == 0) {
            Toast.makeText(
                    this,
                    R.string.vazio,
                    Toast.LENGTH_LONG).show();
            return;
        }

        int radioButtonId = radioGroupPlano.getCheckedRadioButtonId();

        String planoEstudo;

        if (radioButtonId == R.id.radioButtonCompleto) {
            planoEstudo = getString(R.string.planoCompleto);
        } else if (radioButtonId == R.id.radioButtonPersonalizado) {
            planoEstudo = getString(R.string.planoPersonalizado);
        } else {
        if (radioButtonId == R.id.radioButtonNull) {
            planoEstudo = getString(R.string.planoNenhum);
        } else {
            Toast.makeText(
                    this,
                    R.string.planoVazio,
                    Toast.LENGTH_LONG).show();
            return;
        }
        }

        Toast.makeText(
                this,
                R.string.tema_salvo,
                Toast.LENGTH_LONG).show();

        tema = tema.trim();
    }
}