package org.springframework.samples.petclinic.owner;

import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class VetFormatter implements Formatter<Vet> {
	private final VetRepository repository;

	public VetFormatter(VetRepository repository) {
		this.repository = repository;
	}

	@Override
	public Vet parse(String s, Locale locale) throws ParseException {
		Collection<Vet> findVet = this.repository.findAll();
		for (Vet vet : findVet) {
			if (vet.getFirstName().equals(s)) {
				return vet;
			}
		}
		throw new ParseException("type not found: " + s, 0);

	}

	@Override
	public String print(Vet vet, Locale locale) {
		return null;
	}
}
