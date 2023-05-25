package br.com.vansformat;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import android.content.Context;
import br.com.activity.R;

public class CustomFloatFormat {

	private static NumberFormat getCustomFormat() {
		NumberFormat f = NumberFormat.getNumberInstance(Locale.getDefault());
		f.setMaximumFractionDigits(2);
		f.setMinimumFractionDigits(2);
		return f;
	}

	public static String getSimpleFormatedValue(double value) {
		NumberFormat f = getCustomFormat();
		f.setGroupingUsed(false);
		return f.format(value);
	}

	public static String getMonetaryMaskedValue(Context context, double value) {
		NumberFormat f = getCustomFormat();
		return "RON" + " " + (f.format(value));
	}

	public static float parseFloat(String value) throws ParseException {
		NumberFormat f = getCustomFormat();

		try {
			return value.isEmpty() ? 0 : f.parse(value).floatValue();
		} catch (Exception e) {
			return value.isEmpty() ? 0 : f.parse(value.replace('.', ',')).floatValue();
		}
	}

}
