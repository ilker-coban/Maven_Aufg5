package de.hs_furtwangen.informatik.meldeauskunft.repository;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;

public class ResidentServiceMockTest {
	private DateFormat datum = new SimpleDateFormat("yyyy.mm.dd",
			Locale.GERMANY);
	private Resident r1;
	private Resident r2;
	private Resident r3;
	List<Resident> ResiList;

	public ResidentServiceMockTest() {

		try {
			ResiList = new ArrayList<Resident>();
			r1 = new Resident("Vorname1", "Nachname1", "Straﬂe1", "Stadt1",
					datum.parse("2010.10.10"));
			r2 = new Resident("Vorname2", "Nachname2", "Straﬂe2", "Stadt2",
					datum.parse("2011.11.11"));
			r3 = new Resident("Vorname3", "Nachname3", "Straﬂe3", "Stadt3",
					datum.parse("2012.12.12"));
		} catch (ParseException e) {
		}
		ResiList.add(r1);
		ResiList.add(r2);
		ResiList.add(r3);

	}

	@Test
	public void test() throws ParseException {
		BaseResidentService baseResService = new BaseResidentService();
		DateFormat datum = new SimpleDateFormat("yyyy.MM.dd", Locale.GERMANY);

		ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

		expect(residentRepositoryMock.getResidents()).andReturn(ResiList);
		expect(residentRepositoryMock.getResidents()).andReturn(ResiList);
		expect(residentRepositoryMock.getResidents()).andReturn(ResiList);
		expect(residentRepositoryMock.getResidents()).andReturn(ResiList);

		replay(residentRepositoryMock);

		baseResService.setResidentRepository(residentRepositoryMock);

		List<Resident> expectedResidentList = new ArrayList<Resident>();
		expectedResidentList.add(ResiList.get(0));

		Resident resGesucht = new Resident("vor*", "*", "*", "stadt",
				datum.parse("2018.06.12"));

		resGesucht = new Resident("vor*", "*", "*", "stadt",
				datum.parse("2018.06.02"));
		assertEquals(0, baseResService.getFilteredResidentsList(resGesucht)
				.size());

		resGesucht = new Resident("*", "*", "*", "*", null);
		assertEquals(residentRepositoryMock.getResidents(),
				baseResService.getFilteredResidentsList(resGesucht));

	}

}

