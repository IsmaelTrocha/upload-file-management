package com.liquors.file.shared.exception.code;

import lombok.Getter;

@Getter
public enum MessageCode {

  SUCCESSFUL("Message-01", "Message.SUCCESSFUL");

  private final String code;
  private final String type;

  MessageCode(String code, String type) {
    this.code = code;
    this.type = type;
  }


}