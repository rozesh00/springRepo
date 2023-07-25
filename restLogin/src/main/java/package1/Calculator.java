package package1;



import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;



@RestController
public class Calculator {
	
	//http://localhost/additionService/10/30
	//http://localhost - is a reference to the webservice project
	//additionService- reference to t	he method add()
	//int a-10, int b-30
	
	
	//	//http://localhost/additionService/10/30--> using path
	//requestMapping- connects/map http url to a java method
	@RequestMapping(value ="/additionService/{a}/{b}", method= RequestMethod.GET)
	public int add(@PathVariable int a, @PathVariable int b) {
		
		return a+b;
	}
	
	//using JSON, requestbody because the data is in a body in postman
	//Json Mapper Jackson converts JSON into Java object
	//consumers, convert json to java
	
	@RequestMapping(value ="/multService", method= RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public int multi(@RequestBody InputFile in) {
		int result = in.number1 * in.number2;
		
		return result;
	}
	
	//http://localhost/subService?num1=10&num2=20
	//sending in key-value pair
	@RequestMapping(value ="/subService", method= RequestMethod.GET)
	public int subt(@RequestParam int num1, @RequestParam int num2) {
		
		return num1-num2;
	}
	
	
	//prodeces json from java
	@RequestMapping(value ="/allMath/{a}/{b}", 
			method= RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Output addMath(@PathVariable int a, @PathVariable int b) {
		
		Output result = new Output();
		result.add = a+b; //a+b is stored in the variable add which is returned to the customer
		//by the getter method
		result.multi=a*b;
		result.subt= a-b;
		
		return result;
		
		
	}
	
	
	
	
		
		
		
	

}
