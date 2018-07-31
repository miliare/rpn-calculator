import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorTest {

    @Test
    public void should_return_number_when_compute_single_number_expression() {
        RpnCalculator rpn = new RpnCalculator();
        assertThat(rpn.compute("1")).isEqualTo(1);
    }

}

