package edu.remad.mastering_boot_mvc.bean;

public class WelcomeBean {
    private String message;

     public WelcomeBean(String message) {
       super();
       this.message = message;
     }

    public String getMessage() {
      return message;
    }
  }