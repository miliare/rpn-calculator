import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorTest {

    private RpnCalculator rpn = new RpnCalculator();

    @Test
    public void should_return_number_when_compute_single_number_expression() {
        assertThat(rpn.compute("1")).isEqualTo(1);
    }

    @Test
    public void should_return_2_when_compute_expression_1_1_ADD() {
        assertThat(rpn.compute("1 1 +")).isEqualTo(2);
    }
}

