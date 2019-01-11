package android.example.com.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "android.example.com.twoactivities.extra.REPLY";
    private TextView oTextoMensaje;
    private EditText oTextoRespuesta;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        oTextoMensaje = findViewById(R.id.text_message);
        oTextoRespuesta = findViewById(R.id.editText_second);
        
        Intent oIntencion = getIntent();
        String message = oIntencion.getStringExtra(MainActivity.EXTRA_MESSAGE);

        oTextoMensaje.setText(message);

    }

    /**
     * Método encargado de poder enviar un texto a MainActivity
     * como respuesta y mostrarlo
     * @param view
     */
    public void returnReply(View view) {
        String sRespuesta = oTextoRespuesta.getText().toString();
        Intent oItencion = new Intent();
        oItencion.putExtra(EXTRA_REPLY, sRespuesta);
        setResult(RESULT_OK, oItencion);
        finish();
    }
}
