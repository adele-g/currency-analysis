package task.testTask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class Handler implements IHandler {

	@Autowired
	UserClientCurrency client;
	@Autowired
	UserClientGif gif;

	@Value("${app.feign.currency}")
	public String currency;

	@Override
	@SuppressWarnings("unchecked")
	public Double getDoubleToday() {
		HashMap<String, Double> object = (HashMap<String, Double>) client.getCurrencyToday().getOrDefault("rates", new HashMap<>());
		return object.get(currency);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Double getDoubleYesterday() {
		HashMap<String, Double> object = (HashMap<String, Double>) client.getCurrencyCertainDay
				(LocalDate.now().minusDays(1).toString()).get("rates");

		return object.get(currency);
	}

	@Override
	@SuppressWarnings("unchecked")
	public String getGif(String mood) {
		HashMap<String, String> ob = (HashMap<String, String>)gif.getGif("rich").get("data");
		return ob.get("url");
	}
}