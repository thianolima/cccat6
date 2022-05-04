package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class CPFTest {

    @Test
    public void shouldCreateCPF(){
        String digits = "085.227.570-62";
        CPF cpf = new CPF(digits);
        Assertions.assertEquals(cpf.getDigits(),digits);
    }

    @Test
    public void shouldValidateWrongDigits(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new CPF("111.111.111-11"));
        assertThat(exception).hasMessage("CPF inválido!");
    }

    @Test
    public void shouldValidateEmpty(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() -> new CPF(""));
        assertThat(exception).hasMessage("CPF inválido!");
    }
}
