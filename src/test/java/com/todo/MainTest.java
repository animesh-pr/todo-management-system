package com.todo;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testMainFullFlow() {

        String input = """
1
1
1
Task
Desc
2
1
5
4
1
6
""";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void testInvalidOption() {

        String input = """
1
9
6
""";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
void testEmptyAndInvalidOperations() {

    String input = """
1
2
999
5
4
999
6
""";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    assertDoesNotThrow(() -> Main.main(new String[]{}));
}

@Test
void testUpdateInvalidTodo() {

    String input = """
1
3
999
5
6
""";

    System.setIn(new ByteArrayInputStream(input.getBytes()));

    assertDoesNotThrow(() -> Main.main(new String[]{}));
}
}