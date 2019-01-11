package android.example.com.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE ="android.example.com.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText oTextoMensaje;
    private TextView oTextoRespuestaCabecera;
    private TextView oTextoRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oTextoMensaje = findViewById(R.id.editText_main);
        oTextoRespuestaCabecera = findViewById(R.id.text_header_reply);
        oTextoRespuesta = findViewById(R.id.text_message_reply);
    }

    /**
     * Método encargado de enviar a SecondActivity un mensaje ingresado por el usuario
     * para despues mostrarlo en la actividad receptora
     * @param view
     */
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Botón usado");
        Intent oIntencion = new Intent(this, SecondActivity.class);
        String message = oTextoMensaje.getText().toString();
        oIntencion.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(oIntencion, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String sRespuesta = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                oTextoRespuestaCabecera.setVisibility(View.VISIBLE);
                oTextoRespuesta.setText(sRespuesta);
                oTextoRespuesta.setVisibility(View.VISIBLE);
            }
        }
    }
}
