package me.anwarshahriar.inversebinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;

@InverseBindingMethods(
        @InverseBindingMethod(type = RandomColor.class,
                              attribute = "color",
                              method = "getCurrentColor")
)
public class ColorBindingAdapter {

    @BindingAdapter("color")
    public static void setColor(RandomColor view, int color) {
        if (color != view.getCurrentColor()) {
            view.setColor(color);
        }
    }

    @BindingAdapter("colorAttrChanged")
    public static void setListeners(RandomColor view,
                                    final InverseBindingListener inverseBindingListener) {
        RandomColor.OnColorChangeListener newListener = new RandomColor.OnColorChangeListener() {
            @Override
            public void onColorChange(RandomColor view, int newColor) {
                inverseBindingListener.onChange();
            }
        };

        view.setOnColorChangeListener(newListener);
    }
}
