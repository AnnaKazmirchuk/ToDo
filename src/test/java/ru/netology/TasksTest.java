package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindQueryInSimpleTask() {
        Task simpleTask = new SimpleTask(555, "sign a contract");

        boolean actual = simpleTask.matches("contract");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindQueryInSimpleTask() {
        Task simpleTask = new SimpleTask(555, "sign a contract");

        boolean actual = simpleTask.matches("agreement");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindQueryInEpic() {
        String subtasks[] = {"sign a contract", "schedule a meeting", "arrange a call"};
        Epic epic = new Epic(34, subtasks);

        boolean actual = epic.matches("contract");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindQueryInEpic() {
        String subtasks[] = {"sign a contract", "schedule a meeting", "arrange a call"};
        Epic epic = new Epic(34, subtasks);

        boolean actual = epic.matches("agreement");
        Assertions.assertFalse(actual);
    }


    @Test
    public void shouldFindQueryInMeetingProject() {
        Meeting meeting = new Meeting(
                78,
                "lease contract",
                "office renewal",
                "01 Sept 2023");

        boolean actual = meeting.matches("office");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindQueryInMeetingTopic() {
        Meeting meeting = new Meeting(
                78,
                "lease contract",
                "office renewal",
                "01 Sept 2023");

        boolean actual = meeting.matches("lease");
        Assertions.assertTrue(actual);
    }


    @Test
    public void shouldNotFindQueryInMeeting() {
        Meeting meeting = new Meeting(
                78,
                "lease contract",
                "office renewal",
                "01 Sept 2023");

        boolean actual = meeting.matches("agreement");
        Assertions.assertFalse(actual);
    }

}
