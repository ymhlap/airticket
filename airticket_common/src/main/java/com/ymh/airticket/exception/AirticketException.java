package com.ymh.airticket.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1.extends Exception  编译期异常
 * 2.extends RuntimeException 运行期异常
 *
 * @author chemin
 * @since 2024/7/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirticketException extends  RuntimeException{

    private String message;

}
