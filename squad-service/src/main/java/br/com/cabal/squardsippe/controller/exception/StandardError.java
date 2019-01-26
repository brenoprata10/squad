package br.com.cabal.squardsippe.controller.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StandardError {

    private String title;
    private Integer status;
    private Long timestamp;
    private String url;
    private String message;
}
