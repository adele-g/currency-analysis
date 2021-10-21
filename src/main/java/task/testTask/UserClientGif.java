package task.testTask;

import net.minidev.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${app.feign.config.url_gif}", name="${app.feign.config.name_gif}")
public interface UserClientGif {

	@GetMapping("/random?api_key=${app.feign.config.api_key}&tag={mood}")
	JSONObject getGif(@PathVariable String mood);
}