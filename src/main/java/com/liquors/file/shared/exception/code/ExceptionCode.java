package com.liquors.file.shared.exception.code;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  TEST("", ""),
  IMAGE_REQUIRED("", "");


  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}