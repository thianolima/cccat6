package br.com.cccat6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class})
public class DimensionTest {

    @Test
    public void shouldValidateWrongWidth(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Dimension(10.0, 0.0, 10.0));
        assertThat(exception).hasMessage("Largura inválida!");
    }

    @Test
    public void shouldValidateWrongHeight(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Dimension(0, 10.0, 10.0));
        assertThat(exception).hasMessage("Altura inválida!");
    }

    @Test
    public void shouldValidateWrongDepht(){
        Throwable exception = org.assertj.core.api.Assertions.catchThrowable(() ->
                new Dimension(10.0, 10.0, 0));
        assertThat(exception).hasMessage("Profundidade inválida!");
    }

    @Test
    public void shouldCreateDimension(){
        Dimension dimension = new Dimension(100, 30, 10);
        Assertions.assertEquals(dimension.getVolume(), 0.03);
    }
}
