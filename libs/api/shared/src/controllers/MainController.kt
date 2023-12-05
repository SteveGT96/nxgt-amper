package controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController {
	@Value("\${server.port}")
	var port: Int = 8080

	@GetMapping("/sandbox")
	fun sandbox(
		model: Model
	): String {
		model.addAttribute("port", port)
		return "sandbox"
	}
}