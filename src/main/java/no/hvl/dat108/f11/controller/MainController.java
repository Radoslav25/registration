package no.hvl.dat108.f11.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import no.hvl.dat108.f11.Participant;
import no.hvl.dat108.f11.Registration;

@Controller
public class MainController {

	private final List<Participant> participants = new ArrayList<>();

	public MainController() {
		participants.add(new Participant("Anne", "Panne", "female", "234 56 789"));
		participants.add(new Participant("Arne", "Arnesen", "male", "901 23 456"));
		participants.add(new Participant("Lars-Petter", "Helland", "male", "123 45 679"));
		participants.add(new Participant("Per", "Viskelær", "male", "345 34 534"));
		participants.add(new Participant("Xx-x", "Xxx", "female", "123 21 378"));
	}

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("reg", new Registration());
		return "index";
	}

	@GetMapping("/registrasjon")
	public String visRegForm(Model model) {
		model.addAttribute("reg", new Registration());
		return "index";
	}

	@PostMapping("/registrasjon")
	public String regBruker(@Valid @ModelAttribute("reg") Registration reg,
			BindingResult result, Model model) {

		if (reg.getPassord() != null && reg.getRepetertPassord() != null
				&& !reg.getPassord().equals(reg.getRepetertPassord())) {
			result.rejectValue("repetertPassord", "error.reg", "Passwords don't match");
		}

		if (result.hasErrors()) {
			List<String> errorMessages = new ArrayList<>();
			for (ObjectError err : result.getAllErrors()) {
				if (err.getDefaultMessage() != null) {
					errorMessages.add(err.getDefaultMessage());
				}
			}
			model.addAttribute("hasErrors", true);
			model.addAttribute("errors", errorMessages);
			return "index";
		}

		participants.add(new Participant(
				reg.getFornavn(),
				reg.getEtternavn(),
				reg.getKjonn(),
				reg.getTel()
		));

		model.addAttribute("reg", reg);
		return "confirmation";
	}

	@GetMapping("/deltagerliste")
	public String showParticipantList(Model model) {
		Collections.sort(participants, new Comparator<Participant>() {
			public int compare(Participant p1, Participant p2) {
				int firstNameComparison = p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
				if (firstNameComparison == 0) {
					return p1.getLastName().compareToIgnoreCase(p2.getLastName());
				}
				return firstNameComparison;
			}
		});

		model.addAttribute("participants", participants);
		return "deltagerliste";
	}
}
