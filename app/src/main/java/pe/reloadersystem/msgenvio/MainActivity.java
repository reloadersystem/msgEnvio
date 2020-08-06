package pe.reloadersystem.msgenvio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btnEnviarMSG);

        if (ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest
                        .permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]
                    {Manifest.permission.SEND_SMS,}, 1000);
        } else {

        }


        btnEnviar.setOnClickListener(this);

    }

    private void enviarMensaje(String numero, String mensaje) {

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero, null, mensaje, null, null);

            Toast.makeText(this, "Mensaje Enviado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Mensaje no Enviado" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

     String numero = "961162784";

     // "969355929","993430563"




        if (numero.length() == 9) {

            enviarMensaje(numero, "Envio Exitoso");
        } else {
            Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
        }

    }
}
