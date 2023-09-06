package com.liquors.file.shared.exception.message.file;

import com.liquors.file.shared.exception.base.BaseException;
import com.liquors.file.shared.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class ImageRequiredException extends BaseException {

  public ImageRequiredException(String message) {
    super(false, HttpStatus.BAD_REQUEST, message, ExceptionCode.IMAGE_REQUIRED);
  }
}
