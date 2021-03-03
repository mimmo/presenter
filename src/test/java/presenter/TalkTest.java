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
	public void givenManyPresentersSelectThePresenter() {
		Talk talk = new Talk(List.of("mario", "luca", "paperino"), List.of(), (list) -> list.get(1));
		assertEquals(talk.getPresenter(), "luca");
	}

	@Test
	public void givenManyPresentersAndAbsentsSelectThePresenter() {
		Talk talk = new Talk(List.of("mario", "luca", "paperino"), List.of("luca"), (list) -> list.get(1));
		assertEquals(talk.getPresenter(), "paperino");
	}
}
