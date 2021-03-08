package presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Talk2 {
	private List<String> participants;
	private List<String> absents;
	private Function<List<String>, String> selectStrategy = (list) -> list.get(new Random().nextInt(list.size()));

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private List<String> participants;
		private List<String> absents;
		private Function<List<String>, String> selectStrategy;

		public Talk2 build() {
			Talk2 res = new Talk2();
			res.participants = new ArrayList<>(participants);
			res.absents = new ArrayList<>(absents);
			res.selectStrategy = selectStrategy;
			return res;
		}

		public Builder participant(String value) {
			participants.add(value);
			return this;
		}

		public Builder absent(String value) {
			absents.add(value);
			return this;
		}

		public Builder selectStrategy(Function<List<String>, String> value) {
			selectStrategy = value;
			return this;
		}

		private Builder() {
			participants = new ArrayList<>();
			absents = new ArrayList<>();
			selectStrategy = (list) -> list.get(new Random().nextInt(list.size()));
		}

	}


	public String getPresenter() {
		return selectStrategy.apply(getParticipants());
	}

	private List<String> getParticipants() {
		return participants
			.stream()
			.filter(p -> !absents.contains(p))
			.collect(Collectors.toList());
	}

}
