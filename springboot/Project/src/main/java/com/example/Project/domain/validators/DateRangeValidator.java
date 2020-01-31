package com.example.Project.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        int diasMiliSec = 7 * 24 * 60 * 60 * 1000;
        Date dataAtual = new Date();
        long diaLimiteMenor = dataAtual.getTime() - diasMiliSec;
        long diaLimiteMaior = dataAtual.getTime() + diasMiliSec;

        Calendar dataRecebida = Calendar.getInstance();
        try {
            dataRecebida.setTime(value);
        } catch (Exception e) {
           
        }

        long dataRecebidaMilisec = dataRecebida.getTimeInMillis();
        return value != null && ((diaLimiteMaior >= dataRecebidaMilisec) && (diaLimiteMenor <= dataRecebidaMilisec));
    }
}