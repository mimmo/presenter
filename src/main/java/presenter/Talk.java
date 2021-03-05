package presenter;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Talk {
	private List<String> _participants;
	private List<String> _absents;
	private Function<List<String>, String> _selectStrategy;

	public Talk(List<String> partecipants, List<String> absents) {
		this(partecipants, absents, (list) -> list.get(new Random().nextInt(list.size())));
	}

	public Talk(List<String> partecipants, List<String> absents, Function<List<String>, String> selectStrategy) {
		_participants = partecipants.stream().collect(Collectors.toList());
		_absents = absents;
		_selectStrategy = selectStrategy;
	}

	public String getPresenter() {
		return _selectStrategy.apply(getParticipants());
	}

	public List<String> getParticipants() {
		return _participants
			.stream()
			.filter(p -> !_absents.contains(p))
			.collect(Collectors.toList());
	}

	public void addPerson(String name) {
		_participants.add(name);
	}


}
