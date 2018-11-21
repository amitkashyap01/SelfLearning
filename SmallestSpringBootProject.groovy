@Controller
class SmallestSpringBootProject{
	@RequestMapping("/")
	@ResponseBody
	String hello(){
		"Hello World"	
	}
}
