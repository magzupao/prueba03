/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.controller;

import com.source.dto.DataDTO;
import com.source.service.Calculator;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author magz_
 */
@RestController
public class CalculatorController {
 
    @RequestMapping(value = {"/api/account"}, method = {RequestMethod.POST})
    public DataDTO add(@RequestBody DataDTO dataDTO,
                           HttpServletResponse httpResponse,
                           WebRequest request) {

        Calculator calculator = new Calculator(dataDTO.getNumber1(),
                dataDTO.getNumber2(),dataDTO.getOperator());

        dataDTO.setNumber1(dataDTO.getNumber1());
        dataDTO.setNumber2(dataDTO.getNumber2());
        dataDTO.setResult(calculator.getResult());

        httpResponse.setStatus(HttpStatus.CREATED.value());
        return dataDTO;
    }    
    
}
