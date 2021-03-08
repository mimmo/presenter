package presenter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TalkTest {

	@Test
	public void selectThePresenter() {
		Talk talk = new Talk(List.of("mario"), List.of());
		assertEquals(talk.getPresenter(), "mario");
	}

	@Test
	public void givenManyParticipantsSelectThePresenter() {
		Talk talk = new Talk(List.of("mario", "luca", "paperino"), List.of(), (list) -> list.get(1));
		assertEquals(talk.getPresenter(), "luca");
	}

	@Test
	public void givenManyParticipantsAndAbsentsSelectThePresenter() {
		Talk talk = new Talk(List.of("mario", "luca", "paperino"), List.of("luca"), (list) -> list.get(1));
		assertEquals(talk.getPresenter(), "paperino");
	}

	@Test
	public void addOneParticipant() {
		Talk talk = new Talk(List.of(), List.of());
		talk.addParticipant("gianni");
		assertEquals(talk.getPresenter(), "gianni");
	}

	@Test
	public void addManyParticipants() {
		Talk talk = new Talk(List.of(), List.of(), (list) -> list.get(1));
		talk.addParticipants("gianni", "luca");
		assertEquals(talk.getPresenter(), "gianni");
	}
}
