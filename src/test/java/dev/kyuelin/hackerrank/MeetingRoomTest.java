package dev.kyuelin.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomTest {

    @Test
    void maxEvents1() {
        List<Integer> arr = Arrays.asList(1, 1, 6);
        List<Integer> dur = Arrays.asList(4, 0, 3);
        assertEquals(2, MeetingRoom.maxEvents(arr, dur));
    }
    @Test
    void maxEvents2() {
        List<Integer> arr = Arrays.asList(1, 1, 6);
        List<Integer> dur = Arrays.asList(0, 0, 3);
        assertEquals(2, MeetingRoom.maxEvents(arr, dur));
    }
}