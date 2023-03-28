package com.paytm.local.ServiceA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
  public BusinessException(String message){
    super(message);
  }
}
