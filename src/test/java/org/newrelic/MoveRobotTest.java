package org.newrelic;

import org.junit.Assert;
import org.junit.Test;
import org.newrelic.domain.IMoveRobot;
import org.newrelic.domain.MoveRobotService;
import org.newrelic.domain.Plateau;
import org.newrelic.domain.Response;

import java.util.List;


public class MoveRobotTest {

    private IMoveRobot moveRobotService;

    public MoveRobotTest(){
        moveRobotService = new MoveRobotService();
    }

    @Test(expected = Exception.class)
    public void fail_when_grid_has_negative_x_values() throws Exception {
        new Plateau(-1, 2);
    }

    @Test(expected = Exception.class)
    public void fail_when_grid_has_negative_y_values() throws Exception {
        new Plateau(3, -2);
    }

    @Test
    public void should_not_move_mars_rover_wrong_grid_character() {

        String input="X 5 1 2 N LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_move_one_mars_rover() {

        String input="5 5 1 2 N LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),1);
        Assert.assertEquals(response.get(0).toString().trim(),"1 3 N");
    }

    @Test
    public void should_not_move_robot_wrong_cardinal()  {

        String input="5 5 1 2 X LLMLMLMLMMMMMMMMMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_not_move_robot_without_operations()  {

        String input="5 5 1 2 N";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_not_move_robot_wrong_operation()  {

        String input="5 5 1 2 N XMLMLMLMMMMMMMMMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_move_more_mars_rover(){

        String input="5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 2 3 W LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),3);
        Assert.assertEquals(response.get(0).toString().trim(),"1 3 N");
        Assert.assertEquals(response.get(1).toString().trim(),"5 1 E");
        Assert.assertEquals(response.get(2).toString().trim(),"1 3 W");
    }

    @Test
    public void should_move_mars_rover_then_fail_next_one_and_stop_proces_when_robot_is_out_of_grid()  {

        String input="5 5 1 2 N LMLMLMLMM 3 3 S MMMMMMMMMMMMM 2 3 W LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),1);
        Assert.assertEquals(response.get(0).toString().trim(),"1 3 N");
    }

    @Test
    public void should_move_mars_rover__stop_proces_when_robot_is_out_of_grid_eastr() {

        String input="5 5 1 2 E MMMMMMMMMMMMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_move_mars_rover_stop_proces_when_robot_moves_out_of_grid()  {

        String input="5 5 1 2 W MMMMMMMMMMMMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),0);
    }

    @Test
    public void should_move_first_mars_rover_then_fail_next_one_and_stop_proces_when_robot_starting_out_of_grid() {

        String input="5 5 1 2 N LMLMLMLMM 8 3 E MMRMMRMRRM 2 3 W LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),1);
        Assert.assertEquals(response.get(0).toString().trim(),"1 3 N");
    }

    @Test
    public void should_move_first_mars_rover_then_fail_next_one_and_stop_proces_when_next_robot_moves_out_of_grid() {

        String input="5 5 1 2 N LMLMLMLMM 8 3 E MMRMMRMRRMMMMMMMMMM 2 3 W LMLMLMLMM";
        List<Response> response = moveRobotService.moveRobotsOverMars(input);
        Assert.assertEquals(response.size(),1);
        Assert.assertEquals(response.get(0).toString().trim(),"1 3 N");
    }

}
