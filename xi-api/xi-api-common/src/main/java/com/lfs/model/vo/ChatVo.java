package com.lfs.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
}
