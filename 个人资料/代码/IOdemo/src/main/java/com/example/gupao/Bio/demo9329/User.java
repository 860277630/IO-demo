package com.example.gupao.Bio.demo9329;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-06 20:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String name ;
    private int age;
}
