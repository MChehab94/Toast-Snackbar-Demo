package mchehab.com.toastsnackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);

        findViewById(R.id.buttonShortToast).setOnClickListener(e -> {
            shortToast("This is a short toast");
        });

        findViewById(R.id.buttonLongToast).setOnClickListener(e -> {
            longToast("This is a long toast");
        });

        findViewById(R.id.buttonCustomToast).setOnClickListener(e -> {
            showCustomToast("This is a custom toast");
        });

        findViewById(R.id.buttonShortSnackbar).setOnClickListener(e -> {
            shortSnackbar("This is a short snack bar");
        });

        findViewById(R.id.buttonLongSnackbar).setOnClickListener(e -> {
            longSnackbar("This is a long snack bar");
        });

        findViewById(R.id.buttonIndefinite).setOnClickListener(e -> {
            indefiniteSnackbar("This is an indefinite snack bar");
        });
    }

    private void shortToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private void longToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void showCustomToast(String text){
        View layout = getLayoutInflater().inflate(R.layout.custom_toast, findViewById(R.id
                .custom_toast_container));

        TextView textView = layout.findViewById(R.id.textView);
        textView.setText(text);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private void shortSnackbar(String text){
        Snackbar.make(linearLayout, text, Snackbar.LENGTH_SHORT).show();
    }

    private void longSnackbar(String text){
        Snackbar.make(linearLayout, text, Snackbar.LENGTH_LONG).show();
    }

    private void indefiniteSnackbar(String text){
        final Snackbar snackbar = Snackbar.make(linearLayout, text, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Dismiss", view -> snackbar.dismiss());
        snackbar.show();
    }
}