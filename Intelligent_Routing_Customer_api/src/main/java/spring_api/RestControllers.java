package spring_api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
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
 
  
  @PostMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE )
  public RestResponse processData(@RequestBody RestResponse RestResponse) {
      
      return RestResponse;
  }
  
  }
