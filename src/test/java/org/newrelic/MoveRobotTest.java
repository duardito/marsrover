package org.newrelic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.newrelic.domain.Plateau;

@RunWith(MockitoJUnitRunner.class)
public class MoveRobotTest {

    @Test(expected = Exception.class)
    public void fail_when_grid_has_negative_x_values() throws Exception {
        new Plateau(-1, 2);
    }

    @Test(expected = Exception.class)
    public void fail_when_grid_has_negative_y_values() throws Exception {
        new Plateau(3, -2);
    }



}
