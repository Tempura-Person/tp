package seedu.address.logic.commands;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;



public class GroupCommandTest {

    @Test
    public void constructorNullTagthrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GroupCommand(null));
    }

    @Test
    public void executeNullModelThrowsNullPointerException() {
        Tag tag = new Tag("hi");
        assertThrows(NullPointerException.class, () -> new GroupCommand(tag).execute(null));
    }

    @Test
    public void equals() {
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        GroupCommand groupHallCommand = new GroupCommand(new Tag("hall"));
        GroupCommand groupVarsityCommand = new GroupCommand(new Tag("Varsity"));

        // same object -> returns true
        assertTrue(groupHallCommand.equals(groupHallCommand));

        // same values -> returns true
        GroupCommand groupHallCommandCopy = new GroupCommand(new Tag("hall"));
        assertTrue(groupHallCommand.equals(groupHallCommandCopy));

        // different types -> returns false
        assertFalse(groupHallCommand.equals(1));

        // null -> returns false
        assertFalse(groupHallCommand.equals(null));

        // different person -> returns false
        assertFalse(groupHallCommand.equals(groupVarsityCommand));
    }
}
