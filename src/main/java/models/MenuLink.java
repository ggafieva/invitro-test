package models;

import lombok.Getter;

@Getter
public class MenuLink {

  private String text;
  private String url;

  public MenuLink(String text, String url) {
    this.text = text;
    this.url = url;
  }
}
