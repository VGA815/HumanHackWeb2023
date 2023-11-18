package spring;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import email_code.SendEmailExample;

@RestController
@RequestMapping("/api")
public class RestControllers {

  public static class RestResponse { 

      private boolean status;
      private String authenticationKey;
      
      public RestResponse(boolean status,String authenticationKey) {
    	  this.authenticationKey = authenticationKey;
    	  this.status = status;
      }
      
      public void setTema(String authenticationKey) {
          this.authenticationKey = authenticationKey;
      }
      public String getTema() {
          return authenticationKey;
      }
      public void setUrl(boolean status) {
          this.status = status;
      }
      public boolean getUrl() {
          return status;
      }
  }
 
  
  @PostMapping(value = "/email-key", produces = MediaType.APPLICATION_JSON_VALUE )
  public RestResponse processData(String email) throws IOException {
	  SendEmailExample SendEmail = new SendEmailExample();
	  
	  String key = SendEmail.generateKey();
	  boolean status = SendEmail.getMessage(email, key);
	  
	  RestResponse RestResponse = new RestResponse(status,key);
	  
      return RestResponse;
  }
  
  }
