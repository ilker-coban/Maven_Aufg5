package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentRepoStub implements ResidentRepository {

	Resident r1;
	Resident r2;
	Resident r3;
	DateFormat datum;

	public List<Resident> getResidents() {
		datum = new SimpleDateFormat("yyyy.mm.dd", Locale.GERMANY);

		try {
			r1 = new Resident("Vorname1", "Nachname1", "Straﬂe1", "Stadt1",
					datum.parse("2010.10.10"));
			r2 = new Resident("Vorname2", "Nachname2", "Straﬂe2", "Stadt2",
					datum.parse("2011.11.11"));
			r3 = new Resident("Vorname3", "Nachname3", "Straﬂe3", "Stadt3",
					datum.parse("2012.12.12"));
		} catch (ParseException e) {
		}

		List<Resident> ResiList = new ArrayList<Resident>();
		ResiList.add(r1);
		ResiList.add(r2);
		ResiList.add(r3);
		return ResiList;
	}

}
