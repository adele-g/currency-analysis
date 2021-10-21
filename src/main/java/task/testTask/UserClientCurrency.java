package task.testTask;

import net.minidev.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${app.feign.config.url_currency}", name="${app.feign.config.name_currency}")
public interface UserClientCurrency {

	@GetMapping("/latest.json?app_id=${app.feign.app_id}&symbols=${app.feign.currency}")
	JSONObject getCurrencyToday();

	@GetMapping("/historical/{date}.json?app_id=${app.feign.app_id}&symbols=${app.feign.currency}")
	JSONObject getCurrencyCertainDay(@PathVariable String date);
}