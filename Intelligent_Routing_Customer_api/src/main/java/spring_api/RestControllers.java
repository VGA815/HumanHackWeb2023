package spring_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RestControllers {

  public static class RestResponse { 

      private String category;
      private String importance;
      
      public void setTema(String importance) {
          this.importance = importance;
      }
      public String getTema() {
          return importance;
      }
      public void setUrl(String category) {
          this.category = category;
      }
      public String getUrl() {
          return category;
      }
  }
 
  
  

  @RequestMapping(value = "/check_url", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RestResponse> check_url(String url1) {
    
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  
  
  }
