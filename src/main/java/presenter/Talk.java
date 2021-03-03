package presenter;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Talk {
	private List<String> _partecipants;
	private List<String> _absents;
	private Function<List<String>, String> _selectStrategy;

	public Talk(List<String> partecipants, List<String> absents) {
		this(partecipants, absents, (list) -> list.get(new Random().nextInt(list.size())));
	}

	public Talk(List<String> partecipants, List<String> absents, Function<List<String>, String> selectStrategy) {
		_partecipants = partecipants;
		_absents = absents;
		_selectStrategy = selectStrategy;
	}

	public String getPresenter() {
		return _selectStrategy.apply(getParticipants());
	}

	private List<String> getParticipants() {
		return _partecipants
			.stream()
			.filter(p -> !_absents.contains(p))
			.collect(Collectors.toList());
	}


}
