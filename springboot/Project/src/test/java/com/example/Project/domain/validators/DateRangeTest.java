package com.example.Project.domain.validators;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * DateRangeTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DateRangeTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    DateRangeValidator dateRangeValidator;

    @Before
    public void setUp() {

        dateRangeValidator = new DateRangeValidator();

    }
    @Test
    public void should_NotBeValid_WhenNull() {
        assertFalse("Regra de não aceitar nulo está com problemas",
                dateRangeValidator.isValid(null, constraintValidatorContext));
    }
    @Test
    public void should_NotBeValid_When8DaysUp() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());        
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH) + 8);
        assertFalse("Regra de não validar um oito dias acima do dia atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_When8DaysDown() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH) - 8);
        assertFalse("Regra de não validar um oito dias abaixo do dia atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_OneMonthDownInDateRange() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH) - 1, dia.get(Calendar.DAY_OF_MONTH) + 1);
        assertFalse("Regra de não validar um mês abaixo do atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_OneMonthUpInDateRange() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH) + 1, dia.get(Calendar.DAY_OF_MONTH) + 1);
        assertFalse("Regra de não validar um mês acima do atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_DateInRangeSevenDaysAbove() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH) + 6);
        assertTrue("Regra de válido sete dias acima do dia atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_DateInRangeSevenDaysBelow() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH) - 6);
        assertTrue("Regra de válido sete dias abaixo do dia atual está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_Today() {
        Calendar cale = Calendar.getInstance();
        Calendar dia = Calendar.getInstance();
        dia.setTime(new Date());
        cale.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH));
        assertTrue("Regra de válido hoje está com problemas",
                dateRangeValidator.isValid(cale.getTime(), constraintValidatorContext));
    }

}