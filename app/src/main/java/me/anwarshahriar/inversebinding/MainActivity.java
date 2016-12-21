package me.anwarshahriar.inversebinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import me.anwarshahriar.inversebinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new ViewModel();
        model.setColor(Color.RED);
        binding.setModel(model);
    }

    public void showColor(View view) {
        Toast.makeText(this, String.valueOf(model.getColor()), Toast.LENGTH_SHORT).show();
    }

    public class ViewModel extends BaseObservable {
        int color;

        public void setColor(int color) {
            this.color = color;
            notifyPropertyChanged(BR.color);
        }

        @Bindable
        public int getColor() {
            return color;
        }
    }
}
