package task.testTask;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class Controller {

	@Autowired
	Handler handler;

	@GetMapping
	public String getGif() {

		String mood;
		if (handler.getDoubleToday() >= handler.getDoubleYesterday())  {
			mood = "rich";
		} else {
			mood = "broke";
		}
		String gif = handler.getGif(mood);
		return "<a href="+ gif + ">" + gif +"</a>";
	}

	@GetMapping("/testing")
	public JSONObject getTestValue() {

		String mood;
		if (handler.getDoubleToday() >= handler.getDoubleYesterday())  {
			mood = "rich";
		} else {
			mood = "broke";
		}
		String gif = handler.getGif(mood);
		JSONObject ob = new JSONObject();

		ob.appendField("Today " + handler.currency.toString(), handler.getDoubleToday().toString());
		ob.appendField("Yesterday " + handler.currency.toString(), handler.getDoubleYesterday().toString());
		ob.appendField("gif",  gif);

		return ob;
	}

}
