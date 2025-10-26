package ec.edu.monster.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.R;
import ec.edu.monster.controller.AppController;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity{
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewMessage;
    private AppController controller;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewMessage = findViewById(R.id.textViewMessage);

        controller = new AppController();

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                textViewMessage.setText("Por favor, ingrese usuario y contraseña");
                return;
            }

            textViewMessage.setText("Conectando al servidor...");

            executor.execute(() -> {
                try {
                    boolean loginSuccess = controller.login(username, password);
                    mainHandler.post(() -> {
                        if (loginSuccess) {
                            textViewMessage.setText("Login exitoso");
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            textViewMessage.setText("Usuario o contraseña incorrectos");
                        }
                    });
                } catch (Exception e) {
                    String errorMsg = e.getMessage() != null ? e.getMessage() : "Error desconocido al conectar con el servidor";
                    mainHandler.post(() -> {
                        textViewMessage.setText("Error: " + errorMsg);
                        e.printStackTrace();
                    });
                }
            });
        });
    }
}
