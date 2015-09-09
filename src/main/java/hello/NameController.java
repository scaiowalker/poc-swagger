package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
	
	List<String> names = new ArrayList<String>();
	
	@ResponseBody
    @RequestMapping(value="/api/names", method=RequestMethod.GET)
    public ResponseEntity<List<String>> get() {
    	return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
       
    @ResponseBody
    @RequestMapping(value="/api/name/{name}", method=RequestMethod.PUT)
    public ResponseEntity<List<String>> put(@PathVariable(value="name")String name) {
    	names.add(name);
    	return new ResponseEntity<List<String>>(names, HttpStatus.CREATED);
    }
    
    @ResponseBody
    @RequestMapping(value="/api/name/{name}", method=RequestMethod.DELETE)
    public ResponseEntity<List<String>> delete(@PathVariable(value="name")String name) {
    	names.remove(name);
    	return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
    
}
