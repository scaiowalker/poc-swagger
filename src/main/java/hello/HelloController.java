package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@ResponseBody
    @RequestMapping(value="/api/hello", method=RequestMethod.GET)
    public ResponseEntity<String> hello() {
    	return new ResponseEntity<String>("Hello ROMA", HttpStatus.OK);
    }
	
    @ResponseBody
    @RequestMapping(value="/api/hello/{string}", method=RequestMethod.GET)
    public ResponseEntity<String> put(@PathVariable(value="string")String string) {
    	return new ResponseEntity<String>("Hello "+string, HttpStatus.OK);
    }
	
}
