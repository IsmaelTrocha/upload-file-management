package com.liquors.file.shared.exception.message.file;

import com.liquors.file.shared.exception.base.BaseException;
import com.liquors.file.shared.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class FileSizeOutBoundsException extends BaseException {

  public FileSizeOutBoundsException(String message) {
    super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.TEST);
  }
}
