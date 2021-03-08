package presenter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Talk2Test {

	@Test
	public void selectThePresenter() {
		Talk2 talk = Talk2.builder()
			.participant("mario")
			.build();
		assertEquals(talk.getPresenter(), "mario");
	}

	@Test
	public void givenManyPresentersSelectThePresenter() {
		Talk2 talk = Talk2.builder()
			.participant("mario")
			.participant("luca")
			.participant("paperino")
			.selectStrategy(list -> list.get(1))
			.build();
		assertEquals(talk.getPresenter(), "luca");
	}

	@Test
	public void givenManyPresentersAndAbsentsSelectThePresenter() {
		Talk2 talk = Talk2.builder()
			.participant("mario")
			.participant("luca")
			.participant("paperino")
			.absent("luca")
			.selectStrategy(list -> list.get(1))
			.build();
		assertEquals(talk.getPresenter(), "paperino");
	}

}
