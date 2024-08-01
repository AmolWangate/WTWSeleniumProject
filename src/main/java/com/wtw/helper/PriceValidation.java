package com.wtw.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.wtw.extentreport.ExtentLogger;

public final class PriceValidation {

	private PriceValidation() {

	}

	public static boolean verifyPricesAreInAscendingOrder(List<WebElement> priceElements) {
		List<Double> prices = new ArrayList<>();
		for (WebElement priceElement : priceElements) {
			String priceText = priceElement.getText().replace("$", "");
			ExtentLogger.info("Price: " + priceText);
			prices.add(Double.parseDouble(priceText));
		}
		List<Double> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices);
		return prices.equals(sortedPrices);

	}

}
